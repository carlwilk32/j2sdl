package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.touch.SDL_FingerID;
import com.github.carlwilk32.sdl.core.api.touch.SDL_TouchID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Touch finger event structure (event.tfinger.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "fingerId",
        "x",
        "y",
        "dx",
        "dy",
        "pressure",
        "windowID"
})
public final class SDL_TouchFingerEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_FINGERMOTION SDL_FINGERMOTION}
     * or {@link SDL_EventType#SDL_FINGERDOWN SDL_FINGERDOWN}
     * or {@link SDL_EventType#SDL_FINGERUP SDL_FINGERUP}
     */
    @MagicConstant(intValues = {SDL_EventType.SDL_FINGERDOWN, SDL_EventType.SDL_FINGERUP, SDL_EventType.SDL_FINGERMOTION})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The touch device id */
    public SDL_TouchID touchId;

    public SDL_FingerID fingerId;

    /** Normalized in the range 0...1 */
    public float x;

    /** Normalized in the range 0...1 */
    public float y;

    /** Normalized in the range -1...1 */
    public float dx;

    /** Normalized in the range -1...1 */
    public float dy;

    /** Normalized in the range 0...1 */
    public float pressure;

    /** The window underneath the finger, if any */
    public int windowID;

    public SDL_TouchFingerEvent() {
    }

    public SDL_TouchFingerEvent(Pointer p) {
        super(p);
    }
}
