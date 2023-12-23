package com.github.carlwilk32.api.rect;

import com.github.carlwilk32.api.rect.SDL_Rect;
import org.junit.jupiter.api.Test;

import static com.github.carlwilk32.api.Sdl.SDL_Init;
import static com.github.carlwilk32.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.api.rect.SdlRect.SDL_RectEmpty;

public final class SdlRectTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_RectEmpty(new SDL_Rect());
        SDL_Quit();
    }
}
