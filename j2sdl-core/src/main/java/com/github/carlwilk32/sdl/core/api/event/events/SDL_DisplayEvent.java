package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.video.SDL_DisplayEventID;
import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.sdl.core.api.event.SDL_EventType.SDL_DISPLAYEVENT;

/**
 * Display state change event data (event.display.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "display",
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1"
})
public final class SDL_DisplayEvent extends Structure {

    /** {@link SDL_EventType#SDL_DISPLAYEVENT SDL_DISPLAYEVENT} */
    @MagicConstant(intValues = SDL_DISPLAYEVENT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The associated display index */
    public int display;

    /** {@link SDL_DisplayEventID} */
    @MagicConstant(valuesFromClass = SDL_DisplayEventID.class)
    public byte event;

    public byte padding1;
    public byte padding2;
    public byte padding3;

    /** event dependent data */
    public int data1;

    public SDL_DisplayEvent() {
    }

    public SDL_DisplayEvent(Pointer p) {
        super(p);
    }
}
