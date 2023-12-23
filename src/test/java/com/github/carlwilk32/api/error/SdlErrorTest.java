package com.github.carlwilk32.api.error;

import com.github.carlwilk32.api.error.SdlError;
import org.junit.jupiter.api.Test;

public final class SdlErrorTest {

    @Test
    public void control() {
        SdlError.SDL_ClearError();
    }
}
