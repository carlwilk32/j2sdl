package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.joystick.SDL_JoystickID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.sdl.core.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADDOWN;
import static com.github.carlwilk32.sdl.core.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADMOTION;
import static com.github.carlwilk32.sdl.core.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADUP;

/**
 * Game controller touchpad event structure (event.ctouchpad.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "touchpad",
        "finger",
        "x",
        "y",
        "pressure"
})
public final class SDL_ControllerTouchpadEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_CONTROLLERTOUCHPADDOWN SDL_CONTROLLERTOUCHPADDOWN}
     * or {@link SDL_EventType#SDL_CONTROLLERTOUCHPADMOTION SDL_CONTROLLERTOUCHPADMOTION}
     * or {@link SDL_EventType#SDL_CONTROLLERTOUCHPADUP SDL_CONTROLLERTOUCHPADUP}
     */
    @MagicConstant(intValues = {SDL_CONTROLLERTOUCHPADDOWN, SDL_CONTROLLERTOUCHPADMOTION, SDL_CONTROLLERTOUCHPADUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The index of the touchpad */
    public int touchpad;

    /** The index of the finger on the touchpad */
    public int finger;

    /** Normalized in the range 0...1 with 0 being on the left */
    public float x;

    /** Normalized in the range 0...1 with 0 being at the top */
    public float y;

    /** Normalized in the range 0...1 */
    public float pressure;

    public SDL_ControllerTouchpadEvent() {
    }

    public SDL_ControllerTouchpadEvent(Pointer p) {
        super(p);
    }
}
