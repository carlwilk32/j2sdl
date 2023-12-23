package com.github.carlwilk32.api.event;

import com.github.carlwilk32.api.event.SdlEvents;
import org.junit.jupiter.api.Test;

public final class SdlEventsTest {

    @Test
    public void control() {
        SdlEvents.SDL_PumpEvents();
    }
}
