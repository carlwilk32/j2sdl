package com.github.carlwilk32.sdl.core.api.joystick;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

public final class SDL_JoystickPowerLevel implements JnaEnum {

    public static final int SDL_JOYSTICK_POWER_UNKNOWN = -1;
    public static final int SDL_JOYSTICK_POWER_EMPTY = 0;
    public static final int SDL_JOYSTICK_POWER_LOW = 1;
    public static final int SDL_JOYSTICK_POWER_MEDIUM = 2;
    public static final int SDL_JOYSTICK_POWER_FULL = 3;
    public static final int SDL_JOYSTICK_POWER_WIRED = 4;
    public static final int SDL_JOYSTICK_POWER_MAX = 5;

    // TODO: Generate public static String toString(int value)

    private SDL_JoystickPowerLevel() {
    }
}
