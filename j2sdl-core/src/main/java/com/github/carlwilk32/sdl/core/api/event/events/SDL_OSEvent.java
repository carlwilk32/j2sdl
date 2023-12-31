package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * OS Specific event
 */
@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_OSEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_APP_TERMINATING SDL_APP_TERMINATING}
     * or {@link SDL_EventType#SDL_APP_LOWMEMORY SDL_APP_LOWMEMORY}
     * or {@link SDL_EventType#SDL_APP_WILLENTERBACKGROUND SDL_APP_WILLENTERBACKGROUND}
     * or {@link SDL_EventType#SDL_APP_DIDENTERBACKGROUND SDL_APP_DIDENTERBACKGROUND}
     * or {@link SDL_EventType#SDL_APP_WILLENTERFOREGROUND SDL_APP_WILLENTERFOREGROUND}
     * or {@link SDL_EventType#SDL_APP_DIDENTERFOREGROUND SDL_APP_DIDENTERFOREGROUND}
     */
    @MagicConstant(intValues = {
            SDL_EventType.SDL_APP_TERMINATING,
            SDL_EventType.SDL_APP_LOWMEMORY,
            SDL_EventType.SDL_APP_WILLENTERBACKGROUND,
            SDL_EventType.SDL_APP_DIDENTERBACKGROUND,
            SDL_EventType.SDL_APP_WILLENTERFOREGROUND,
            SDL_EventType.SDL_APP_DIDENTERFOREGROUND
    })
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    public SDL_OSEvent() {
    }

    public SDL_OSEvent(Pointer p) {
        super(p);
    }
}
