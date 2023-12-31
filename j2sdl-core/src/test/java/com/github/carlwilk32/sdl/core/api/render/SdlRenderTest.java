package com.github.carlwilk32.sdl.core.api.render;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_InitSubSystem;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_QuitSubSystem;
import static com.github.carlwilk32.sdl.core.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static com.github.carlwilk32.sdl.core.api.error.SdlError.SDL_GetError;
import static com.github.carlwilk32.sdl.core.api.pixels.SDL_PixelFormatEnum.SDL_PIXELFORMAT_RGBA8888;
import static com.github.carlwilk32.sdl.core.api.render.SDL_RendererFlags.SDL_RENDERER_ACCELERATED;
import static com.github.carlwilk32.sdl.core.api.render.SDL_TextureAccess.SDL_TEXTUREACCESS_STREAMING;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_CreateRenderer;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_CreateTexture;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_DestroyRenderer;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_GetNumRenderDrivers;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_LockTextureToSurface;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_RenderCopy;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_RenderGetViewport;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_RenderPresent;
import static com.github.carlwilk32.sdl.core.api.render.SdlRender.SDL_UnlockTexture;
import static com.github.carlwilk32.sdl.core.api.surface.SdlSurface.SDL_FillRect;
import static com.github.carlwilk32.sdl.core.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static com.github.carlwilk32.sdl.core.api.video.SdlVideo.SDL_CreateWindow;
import static com.github.carlwilk32.sdl.core.api.video.SdlVideo.SDL_DestroyWindow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.carlwilk32.sdl.core.api.rect.SDL_Rect;
import com.github.carlwilk32.sdl.core.api.surface.SDL_Surface;
import com.github.carlwilk32.sdl.core.api.video.SDL_Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class SdlRenderTest {

  @BeforeEach
  public void setUp() {
    SDL_InitSubSystem(SDL_INIT_EVERYTHING);
  }

  @Test
  public void control() {
    int renderDriversCount = SDL_GetNumRenderDrivers();
    assertTrue(renderDriversCount > 0);
  }

  @Test
  public void registerLogCallback() {
    SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
    if (window == null) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }
    SDL_Renderer renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
    if (renderer == null) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }

    SDL_Rect rect = new SDL_Rect();
    SDL_RenderGetViewport(renderer, rect);
    System.out.println(rect.x + ", " + rect.y + ", " + rect.w + " x " + rect.h);
    assertEquals(400, rect.w);
    assertEquals(300, rect.h);

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
  }

  @Test
  public void lockTextureToSurfaceShouldChangePixelsInTheTexture() throws InterruptedException {
    SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
    if (window == null) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }
    SDL_Renderer renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
    if (renderer == null) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }

    SDL_Texture texture =
        SDL_CreateTexture(renderer, SDL_PIXELFORMAT_RGBA8888, SDL_TEXTUREACCESS_STREAMING, 48, 48);
    SDL_Surface.Ref surfaceRef = new SDL_Surface.Ref();
    if (SDL_LockTextureToSurface(texture, null, surfaceRef) != 0) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }
    SDL_Surface surface = surfaceRef.getSurface();
    SDL_Rect rect = new SDL_Rect();
    rect.x = 0;
    rect.y = 0;
    rect.w = 48;
    rect.h = 48;
    if (SDL_FillRect(surface, rect, 0xFFFFFF00) != 0) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }
    SDL_Rect innerRect = new SDL_Rect();
    innerRect.x = 10;
    innerRect.y = 10;
    innerRect.w = 28;
    innerRect.h = 28;
    if (SDL_FillRect(surface, innerRect, 0xFFFF0000) != 0) {
      throw new AssertionError("SDL Failure: " + SDL_GetError());
    }
    SDL_UnlockTexture(texture);
    SDL_RenderCopy(renderer, texture, null, rect);
    SDL_RenderPresent(renderer);

    Thread.sleep(5000L);

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
  }

  @AfterEach
  public void tearDown() {
    SDL_QuitSubSystem(SDL_INIT_EVERYTHING);
  }
}
