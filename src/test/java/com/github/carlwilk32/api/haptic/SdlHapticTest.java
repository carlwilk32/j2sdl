package com.github.carlwilk32.api.haptic;

import com.github.carlwilk32.api.Sdl;
import com.github.carlwilk32.api.haptic.SdlHaptic;
import org.junit.jupiter.api.Test;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
