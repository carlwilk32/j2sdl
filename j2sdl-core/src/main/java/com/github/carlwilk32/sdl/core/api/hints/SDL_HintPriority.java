package com.github.carlwilk32.sdl.core.api.hints;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

/**
 * An enumeration of hint priorities
 */
public final class SDL_HintPriority implements JnaEnum {

    public static final int SDL_HINT_DEFAULT = 0;
    public static final int SDL_HINT_NORMAL = 1;
    public static final int SDL_HINT_OVERRIDE = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_HintPriority() {
    }
}
