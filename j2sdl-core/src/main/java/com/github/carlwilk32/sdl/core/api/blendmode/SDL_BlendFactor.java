package com.github.carlwilk32.sdl.core.api.blendmode;

import com.github.carlwilk32.sdl.core.jna.JnaEnum;

/**
 * The normalized factor used to multiply pixel components
 */
public final class SDL_BlendFactor implements JnaEnum {

    /** 0, 0, 0, 0 */
    public static final int SDL_BLENDFACTOR_ZERO = 0x1;

    /** 1, 1, 1, 1 */
    public static final int SDL_BLENDFACTOR_ONE = 0x2;

    /** srcR, srcG, srcB, srcA */
    public static final int SDL_BLENDFACTOR_SRC_COLOR = 0x3;

    /** 1-srcR, 1-srcG, 1-srcB, 1-srcA */
    public static final int SDL_BLENDFACTOR_ONE_MINUS_SRC_COLOR = 0x4;

    /** srcA, srcA, srcA, srcA */
    public static final int SDL_BLENDFACTOR_SRC_ALPHA = 0x5;

    /** 1-srcA, 1-srcA, 1-srcA, 1-srcA */
    public static final int SDL_BLENDFACTOR_ONE_MINUS_SRC_ALPHA = 0x6;

    /** dstR, dstG, dstB, dstA */
    public static final int SDL_BLENDFACTOR_DST_COLOR = 0x7;

    /** 1-dstR, 1-dstG, 1-dstB, 1-dstA */
    public static final int SDL_BLENDFACTOR_ONE_MINUS_DST_COLOR = 0x8;

    /** dstA, dstA, dstA, dstA */
    public static final int SDL_BLENDFACTOR_DST_ALPHA = 0x9;

    /** 1-dstA, 1-dstA, 1-dstA, 1-dstA */
    public static final int SDL_BLENDFACTOR_ONE_MINUS_DST_ALPHA = 0xA;

    // TODO: Generate public static String toString(int value)

    private SDL_BlendFactor() {
    }
}
