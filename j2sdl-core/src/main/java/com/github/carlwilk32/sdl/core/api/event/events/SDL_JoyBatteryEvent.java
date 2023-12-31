package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.joystick.SDL_JoystickID;
import com.github.carlwilk32.sdl.core.api.joystick.SDL_JoystickPowerLevel;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.sdl.core.api.event.SDL_EventType.SDL_JOYBATTERYUPDATED;

/**
 * Joysick battery level change event structure (event.jbattery.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "level"
})
public final class SDL_JoyBatteryEvent extends Structure {

    /** {@link SDL_EventType#SDL_JOYBATTERYUPDATED SDL_JOYBATTERYUPDATED} */
    @MagicConstant(intValues = SDL_JOYBATTERYUPDATED)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick battery level */
    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public int level;

    public SDL_JoyBatteryEvent() {
    }

    public SDL_JoyBatteryEvent(Pointer p) {
        super(p);
    }
}
