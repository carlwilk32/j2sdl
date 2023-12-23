package com.github.carlwilk32.api.clipboard;

import com.github.carlwilk32.api.Sdl;
import com.github.carlwilk32.api.clipboard.SdlClipboard;
import org.junit.jupiter.api.Test;

public final class SdlClipboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlClipboard.SDL_HasClipboardText();
        Sdl.SDL_Quit();
    }
}
