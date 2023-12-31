package com.github.carlwilk32.sdl.core.api.event;

import com.github.carlwilk32.sdl.core.api.event.SdlEvents;
import org.junit.jupiter.api.Test;

public final class SdlEventsTest {

    @Test
    public void control() {
        SdlEvents.SDL_PumpEvents();
    }
}
