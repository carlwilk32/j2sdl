package com.github.carlwilk32.sdl.core.api.pixels;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

/**
 * Array component order, low byte to high byte.
 */
public final class SDL_ArrayOrder implements JnaEnum {

    public static final int SDL_ARRAYORDER_NONE = 0;
    public static final int SDL_ARRAYORDER_RGB = 1;
    public static final int SDL_ARRAYORDER_RGBA = 2;
    public static final int SDL_ARRAYORDER_ARGB = 3;
    public static final int SDL_ARRAYORDER_BGR = 4;
    public static final int SDL_ARRAYORDER_BGRA = 5;
    public static final int SDL_ARRAYORDER_ABGR = 6;

    // TODO: Generate public static String toString(int value)

    private SDL_ArrayOrder() {
    }
}
