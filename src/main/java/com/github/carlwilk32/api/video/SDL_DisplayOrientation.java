package com.github.carlwilk32.api.video;

import com.github.carlwilk32.jna.JnaEnum;

/**
 * Display orientation
 */
public final class SDL_DisplayOrientation implements JnaEnum {

    /** The display orientation can't be determined */
    public static final int SDL_ORIENTATION_UNKNOWN = 0;

    /** The display is in landscape mode, with the right side up, relative to portrait mode */
    public static final int SDL_ORIENTATION_LANDSCAPE = 1;

    /** The display is in landscape mode, with the left side up, relative to portrait mode */
    public static final int SDL_ORIENTATION_LANDSCAPE_FLIPPED = 2;

    /** The display is in portrait mode */
    public static final int SDL_ORIENTATION_PORTRAIT = 3;

    /** The display is in portrait mode, upside down */
    public static final int SDL_ORIENTATION_PORTRAIT_FLIPPED = 4;

    // TODO: Generate public static String toString(int value)

    private SDL_DisplayOrientation() {
    }
}
