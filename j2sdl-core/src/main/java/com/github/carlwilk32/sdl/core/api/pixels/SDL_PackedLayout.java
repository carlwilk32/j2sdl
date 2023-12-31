package com.github.carlwilk32.sdl.core.api.pixels;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

/** Packed component layout. */
public final class SDL_PackedLayout implements JnaEnum {

    public static final int SDL_PACKEDLAYOUT_NONE = 0;
    public static final int SDL_PACKEDLAYOUT_332 = 1;
    public static final int SDL_PACKEDLAYOUT_4444 = 2;
    public static final int SDL_PACKEDLAYOUT_1555 = 3;
    public static final int SDL_PACKEDLAYOUT_5551 = 4;
    public static final int SDL_PACKEDLAYOUT_565 = 5;
    public static final int SDL_PACKEDLAYOUT_8888 = 6;
    public static final int SDL_PACKEDLAYOUT_2101010 = 7;
    public static final int SDL_PACKEDLAYOUT_1010102 = 8;

    // TODO: Generate public static String toString(int value)

    private SDL_PackedLayout() {
    }
}
