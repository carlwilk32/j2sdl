package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.github.carlwilk32.sdl.core.api.event.SdlEventsConst;
import com.github.carlwilk32.sdl.core.api.gamecontroller.SDL_GameControllerButton;
import com.github.carlwilk32.sdl.core.api.joystick.SDL_JoystickID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Game controller button event structure (event.cbutton.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "button",
        "state",
        "padding1",
        "padding2"
})
public final class SDL_ControllerButtonEvent extends Structure {

    /**
     * {@link SDL_EventType#SDL_CONTROLLERBUTTONDOWN SDL_CONTROLLERBUTTONDOWN}
     * or {@link SDL_EventType#SDL_CONTROLLERBUTTONUP SDL_CONTROLLERBUTTONUP}
     */
    @MagicConstant(intValues = {SDL_EventType.SDL_CONTROLLERBUTTONDOWN, SDL_EventType.SDL_CONTROLLERBUTTONUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The controller button (SDL_GameControllerButton) */
    @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
    public byte button;

    /**
     * {@link SdlEventsConst#SDL_PRESSED SDL_PRESSED}
     * or {@link SdlEventsConst#SDL_RELEASED SDL_RELEASED}
     */
    @MagicConstant(intValues = {SdlEventsConst.SDL_PRESSED, SdlEventsConst.SDL_RELEASED})
    public byte state;

    public byte padding1;
    public byte padding2;

    public SDL_ControllerButtonEvent() {
    }

    public SDL_ControllerButtonEvent(Pointer p) {
        super(p);
    }
}
