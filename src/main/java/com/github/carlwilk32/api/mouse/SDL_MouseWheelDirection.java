package com.github.carlwilk32.api.mouse;

import com.github.carlwilk32.jna.JnaEnum;

/**
 * Scroll direction types for the Scroll event
 */
public final class SDL_MouseWheelDirection implements JnaEnum {

    /** The scroll direction is normal */
    public static final int SDL_MOUSEWHEEL_NORMAL = 0;

    /** The scroll direction is flipped / natural */
    public static final int SDL_MOUSEWHEEL_FLIPPED = 1;

    // TODO: Generate public static String toString(int value)

    private SDL_MouseWheelDirection() {
    }
}
