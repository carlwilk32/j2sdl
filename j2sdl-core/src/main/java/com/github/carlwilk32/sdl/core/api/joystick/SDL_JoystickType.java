package com.github.carlwilk32.sdl.core.api.joystick;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

public final class SDL_JoystickType implements JnaEnum {

    public static final int SDL_JOYSTICK_TYPE_UNKNOWN = 0;
    public static final int SDL_JOYSTICK_TYPE_GAMECONTROLLER = 1;
    public static final int SDL_JOYSTICK_TYPE_WHEEL = 2;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_STICK = 3;
    public static final int SDL_JOYSTICK_TYPE_FLIGHT_STICK = 4;
    public static final int SDL_JOYSTICK_TYPE_DANCE_PAD = 5;
    public static final int SDL_JOYSTICK_TYPE_GUITAR = 6;
    public static final int SDL_JOYSTICK_TYPE_DRUM_KIT = 7;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_PAD = 8;
    public static final int SDL_JOYSTICK_TYPE_THROTTLE = 9;

    // TODO: Generate public static String toString(int value)

    private SDL_JoystickType() {
    }
}
