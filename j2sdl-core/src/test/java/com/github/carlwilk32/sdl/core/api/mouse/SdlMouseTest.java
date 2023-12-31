package com.github.carlwilk32.sdl.core.api.mouse;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Init;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.sdl.core.api.mouse.SdlMouse.SDL_GetCursor;

import org.junit.jupiter.api.Test;

public final class SdlMouseTest {

  @Test
  public void control() {
    SDL_Init(0);
    SDL_GetCursor();
    SDL_Quit();
  }
}
