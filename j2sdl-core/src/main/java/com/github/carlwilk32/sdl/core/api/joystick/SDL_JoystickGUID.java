package com.github.carlwilk32.sdl.core.api.joystick;

import com.github.carlwilk32.sdl.core.api.guid.SDL_GUID;
import com.sun.jna.Pointer;

/**
 * A structure that encodes the stable unique id for a joystick device
 */
public final class SDL_JoystickGUID extends SDL_GUID {

    public SDL_JoystickGUID() {
    }

    public SDL_JoystickGUID(Pointer p) {
        super(p);
    }
}
