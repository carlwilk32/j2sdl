package com.github.carlwilk32.sdl.core.api.rect;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Init;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.sdl.core.api.rect.SdlRect.SDL_RectEmpty;

import org.junit.jupiter.api.Test;

public final class SdlRectTest {

  @Test
  public void control() {
    SDL_Init(0);
    SDL_RectEmpty(new SDL_Rect());
    SDL_Quit();
  }
}
