package com.github.carlwilk32.sdl.core.api.haptic;

import com.github.carlwilk32.sdl.core.api.Sdl;
import com.github.carlwilk32.sdl.core.api.haptic.SdlHaptic;
import org.junit.jupiter.api.Test;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
