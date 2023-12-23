package com.github.carlwilk32.api.event.events;

import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.gesture.SDL_GestureID;
import com.github.carlwilk32.api.touch.SDL_TouchID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.api.event.SDL_EventType.SDL_DOLLARGESTURE;
import static com.github.carlwilk32.api.event.SDL_EventType.SDL_DOLLARRECORD;

/**
 * Dollar Gesture Event (event.dgesture.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "gestureId",
        "numFingers",
        "error",
        "x",
        "y"
})
public final class SDL_DollarGestureEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_DOLLARGESTURE SDL_DOLLARGESTURE}
     * or {@link SDL_EventType#SDL_DOLLARRECORD SDL_DOLLARRECORD}
     */
    @MagicConstant(intValues = {SDL_DOLLARGESTURE, SDL_DOLLARRECORD})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The touch device id */
    public SDL_TouchID touchId;

    public SDL_GestureID gestureId;

    public int numFingers;

    public float error;

    /** Normalized center of gesture */
    public float x;

    /** Normalized center of gesture */
    public float y;

    public SDL_DollarGestureEvent() {
    }

    public SDL_DollarGestureEvent(Pointer p) {
        super(p);
    }
}
