package com.github.carlwilk32.api.event.events;

import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.joystick.SDL_JoystickID;
import com.github.carlwilk32.api.sensor.SDL_SensorType;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.api.event.SDL_EventType.SDL_CONTROLLERSENSORUPDATE;

/**
 * Game controller sensor event structure (event.csensor.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "sensor",
        "data",
        "timestampUs"
})
public final class SDL_ControllerSensorEvent extends Structure {

    /** {@link SDL_EventType#SDL_CONTROLLERSENSORUPDATE SDL_CONTROLLERSENSORUPDATE} */
    @MagicConstant(intValues = SDL_CONTROLLERSENSORUPDATE)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The type of the sensor, one of the values of {@link SDL_SensorType} */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public int sensor;

    /** Up to 3 values from the sensor, as defined in SDL_sensor.h */
    public float[] data = new float[3];

    /** The timestamp of the sensor reading in microseconds, if the hardware provides this information. */
    public long timestampUs;

    public SDL_ControllerSensorEvent() {
    }

    public SDL_ControllerSensorEvent(Pointer p) {
        super(p);
    }
}
