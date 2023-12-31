package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.touch.SdlTouchConst;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Mouse motion event structure (event.motion.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "state",
        "x",
        "y",
        "xrel",
        "yrel"
})
public final class SDL_MouseMotionEvent extends Structure {

    /** {@link SDL_EventType#SDL_MOUSEMOTION SDL_MOUSEMOTION} */
    @MagicConstant(intValues = SDL_EventType.SDL_MOUSEMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /**
     * The mouse instance id, or
     * {@link SdlTouchConst#SDL_TOUCH_MOUSEID SDL_TOUCH_MOUSEID}
     */
    @MagicConstant(intValues = SdlTouchConst.SDL_TOUCH_MOUSEID)
    public int which;

    /** The current button state */
    public int state;

    /** X coordinate, relative to window */
    public int x;

    /** Y coordinate, relative to window */
    public int y;

    /** The relative motion in the X direction */
    public int xrel;

    /** The relative motion in the Y direction */
    public int yrel;

    public SDL_MouseMotionEvent() {
    }

    public SDL_MouseMotionEvent(Pointer p) {
        super(p);
    }
}
