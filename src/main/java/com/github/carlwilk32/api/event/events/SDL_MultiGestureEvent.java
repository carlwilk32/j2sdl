package com.github.carlwilk32.api.event.events;

import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.touch.SDL_TouchID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.api.event.SDL_EventType.SDL_MULTIGESTURE;

/**
 * Multiple Finger Gesture Event (event.mgesture.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "dTheta",
        "dDist",
        "x",
        "y",
        "numFingers",
        "padding"
})
public final class SDL_MultiGestureEvent extends Structure {

    /** {@link SDL_EventType#SDL_MULTIGESTURE SDL_MULTIGESTURE} */
    @MagicConstant(intValues = SDL_MULTIGESTURE)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The touch device id */
    public SDL_TouchID touchId;

    public float dTheta;

    public float dDist;

    public float x;

    public float y;

    public short numFingers;

    public short padding;

    public SDL_MultiGestureEvent() {
    }

    public SDL_MultiGestureEvent(Pointer p) {
        super(p);
    }
}
