package com.github.carlwilk32.sdl.core.api.gamecontroller;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

/**
 * The list of axes available from a controller
 *
 * <p>Thumbstick axis values range from SDL_JOYSTICK_AXIS_MIN to SDL_JOYSTICK_AXIS_MAX,
 * and are centered within ~8000 of zero, though advanced UI will allow users to set
 * or autodetect the dead zone, which varies between controllers.</p>
 *
 * <p>Trigger axis values range from 0 to SDL_JOYSTICK_AXIS_MAX.</p>
 */
public final class SDL_GameControllerAxis implements JnaEnum {

    public static final int SDL_CONTROLLER_AXIS_INVALID = -1;
    public static final int SDL_CONTROLLER_AXIS_LEFTX = 0;
    public static final int SDL_CONTROLLER_AXIS_LEFTY = 1;
    public static final int SDL_CONTROLLER_AXIS_RIGHTX = 2;
    public static final int SDL_CONTROLLER_AXIS_RIGHTY = 3;
    public static final int SDL_CONTROLLER_AXIS_TRIGGERLEFT = 4;
    public static final int SDL_CONTROLLER_AXIS_TRIGGERRIGHT = 5;
    public static final int SDL_CONTROLLER_AXIS_MAX = 6;

    // TODO: Generate public static String toString(int value)

    private SDL_GameControllerAxis() {
    }
}
