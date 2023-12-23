package com.github.carlwilk32.api.event.events;

import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.joystick.SDL_JoystickID;
import com.github.carlwilk32.api.joystick.SdlJoystickConst;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.api.event.SDL_EventType.SDL_JOYHATMOTION;

/**
 * Joystick hat position change event structure (event.jhat.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "hat",
        "value",
        "padding1",
        "padding2"
})
public final class SDL_JoyHatEvent extends Structure {

    /** {@link SDL_EventType#SDL_JOYHATMOTION SDL_JOYHATMOTION} */
    @MagicConstant(intValues = SDL_JOYHATMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick hat index */
    public byte hat;

    /**
     * The hat position value.
     *
     * @see SdlJoystickConst#SDL_HAT_LEFTUP
     * @see SdlJoystickConst#SDL_HAT_UP
     * @see SdlJoystickConst#SDL_HAT_RIGHTUP
     * @see SdlJoystickConst#SDL_HAT_LEFT
     * @see SdlJoystickConst#SDL_HAT_CENTERED
     * @see SdlJoystickConst#SDL_HAT_RIGHT
     * @see SdlJoystickConst#SDL_HAT_LEFTDOWN
     * @see SdlJoystickConst#SDL_HAT_DOWN
     * @see SdlJoystickConst#SDL_HAT_RIGHTDOWN
     *
     * <p>Note that zero means the POV is centered.</p>
     */
    @MagicConstant(intValues = {
            SdlJoystickConst.SDL_HAT_CENTERED,
            SdlJoystickConst.SDL_HAT_UP,
            SdlJoystickConst.SDL_HAT_RIGHT,
            SdlJoystickConst.SDL_HAT_DOWN,
            SdlJoystickConst.SDL_HAT_LEFT,
            SdlJoystickConst.SDL_HAT_RIGHTUP,
            SdlJoystickConst.SDL_HAT_RIGHTDOWN,
            SdlJoystickConst.SDL_HAT_LEFTUP,
            SdlJoystickConst.SDL_HAT_LEFTDOWN})
    public byte value;

    public byte padding1;
    public byte padding2;

    public SDL_JoyHatEvent() {
    }

    public SDL_JoyHatEvent(Pointer p) {
        super(p);
    }
}
