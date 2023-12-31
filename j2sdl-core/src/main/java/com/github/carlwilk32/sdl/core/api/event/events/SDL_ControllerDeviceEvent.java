package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Controller device event structure (event.cdevice.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which"
})
public final class SDL_ControllerDeviceEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_CONTROLLERDEVICEADDED SDL_CONTROLLERDEVICEADDED},
     * {@link SDL_EventType#SDL_CONTROLLERDEVICEREMOVED SDL_CONTROLLERDEVICEREMOVED}, or
     * {@link SDL_EventType#SDL_CONTROLLERDEVICEREMAPPED SDL_CONTROLLERDEVICEREMAPPED}
     */
    @MagicConstant(intValues = {SDL_EventType.SDL_CONTROLLERDEVICEADDED, SDL_EventType.SDL_CONTROLLERDEVICEREMOVED, SDL_EventType.SDL_CONTROLLERDEVICEREMAPPED})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    // TODO: Shouldn't it be SDL_JoystickID?
    /** The joystick device index for the ADDED event, instance id for the REMOVED or REMAPPED event */
    public int which;

    public SDL_ControllerDeviceEvent() {
    }

    public SDL_ControllerDeviceEvent(Pointer p) {
        super(p);
    }
}
