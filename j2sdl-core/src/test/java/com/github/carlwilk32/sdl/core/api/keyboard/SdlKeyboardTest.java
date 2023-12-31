package com.github.carlwilk32.sdl.core.api.keyboard;

import com.github.carlwilk32.sdl.core.api.Sdl;
import com.github.carlwilk32.sdl.core.api.keyboard.SdlKeyboard;
import org.junit.jupiter.api.Test;

public final class SdlKeyboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlKeyboard.SDL_GetModState();
        Sdl.SDL_Quit();
    }
}
