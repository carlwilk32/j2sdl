package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.event.SdlEventsConst;
import com.github.carlwilk32.sdl.core.api.touch.SdlTouchConst;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Mouse button event structure (event.button.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "button",
        "state",
        "clicks",
        "padding1",
        "x",
        "y"
})
public final class SDL_MouseButtonEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_MOUSEBUTTONDOWN SDL_MOUSEBUTTONDOWN}
     * or {@link SDL_EventType#SDL_MOUSEBUTTONUP SDL_MOUSEBUTTONUP}
     */
    @MagicConstant(intValues = {SDL_EventType.SDL_MOUSEBUTTONDOWN, SDL_EventType.SDL_MOUSEBUTTONUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /** The mouse instance id, or SDL_TOUCH_MOUSEID */
    @MagicConstant(intValues = SdlTouchConst.SDL_TOUCH_MOUSEID)
    public int which;

    /** The mouse button index */
    public byte button;

    /**
     * {@link SdlEventsConst#SDL_PRESSED SDL_PRESSED}
     * or {@link SdlEventsConst#SDL_RELEASED SDL_RELEASED}
     */
    @MagicConstant(intValues = {SdlEventsConst.SDL_PRESSED, SdlEventsConst.SDL_RELEASED})
    public byte state;

    /** 1 for single-click, 2 for double-click, etc. */
    public byte clicks;

    public byte padding1;

    /** X coordinate, relative to window */
    public int x;

    /** Y coordinate, relative to window */
    public int y;

    public SDL_MouseButtonEvent() {
    }

    public SDL_MouseButtonEvent(Pointer p) {
        super(p);
    }
}
