package com.github.carlwilk32.api.mouse;

import org.junit.jupiter.api.Test;

import static com.github.carlwilk32.api.Sdl.SDL_Init;
import static com.github.carlwilk32.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.api.mouse.SdlMouse.SDL_GetCursor;

public final class SdlMouseTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_GetCursor();
        SDL_Quit();
    }
}
