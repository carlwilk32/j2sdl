package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.mouse.SDL_MouseWheelDirection;
import com.github.carlwilk32.sdl.core.api.touch.SdlTouchConst;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Mouse wheel event structure (event.wheel.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "x",
        "y",
        "direction",
        "preciseX",
        "preciseY",
        "mouseX",
        "mouseY"
})
public final class SDL_MouseWheelEvent extends Structure {

    /** {@link SDL_EventType#SDL_MOUSEWHEEL SDL_MOUSEWHEEL} */
    @MagicConstant(intValues = SDL_EventType.SDL_MOUSEWHEEL)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /** The mouse instance id, or {@link SdlTouchConst#SDL_TOUCH_MOUSEID SDL_TOUCH_MOUSEID} */
    @MagicConstant(intValues = SdlTouchConst.SDL_TOUCH_MOUSEID)
    public int which;

    /** The amount scrolled horizontally, positive to the right and negative to the left */
    public int x;

    /** The amount scrolled vertically, positive away from the user and negative toward the user */
    public int y;

    /**
     * Set to either {@link SDL_MouseWheelDirection#SDL_MOUSEWHEEL_NORMAL SDL_MOUSEWHEEL_NORMAL}
     * or {@link SDL_MouseWheelDirection#SDL_MOUSEWHEEL_FLIPPED SDL_MOUSEWHEEL_FLIPPED}.
     * When {@code SDL_MOUSEWHEEL_FLIPPED} the values in {@code X} and {@code Y} will be opposite.
     * Multiply by -1 to change them back
     */
    @MagicConstant(intValues = {SDL_MouseWheelDirection.SDL_MOUSEWHEEL_NORMAL, SDL_MouseWheelDirection.SDL_MOUSEWHEEL_FLIPPED})
    public int direction;

    /** The amount scrolled horizontally, positive to the right and negative to the left, with float precision (added in 2.0.18) */
    public float preciseX;

    /** The amount scrolled vertically, positive away from the user and negative toward the user, with float precision (added in 2.0.18) */
    public float preciseY;

    /** X coordinate, relative to window (added in 2.26.0) */
    public int mouseX;

    /** Y coordinate, relative to window (added in 2.26.0) */
    public int mouseY;

    public SDL_MouseWheelEvent() {
    }

    public SDL_MouseWheelEvent(Pointer p) {
        super(p);
    }
}
