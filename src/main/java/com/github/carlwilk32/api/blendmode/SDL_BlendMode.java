package com.github.carlwilk32.api.blendmode;

import com.sun.jna.ptr.IntByReference;
import com.github.carlwilk32.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

/**
 * The blend mode used in SDL_RenderCopy() and drawing operations.
 */
public final class SDL_BlendMode implements JnaEnum {

    /**
     * no blending
     * <pre>dstRGBA = srcRGBA</pre>
     */
    public static final int SDL_BLENDMODE_NONE = 0x00000000;

    /**
     * alpha blending
     * <pre>
     * dstRGB = (srcRGB * srcA) + (dstRGB * (1-srcA))
     * dstA = srcA + (dstA * (1-srcA))
     * </pre>
     */
    public static final int SDL_BLENDMODE_BLEND = 0x00000001;

    /**
     * additive blending
     * <pre>
     * dstRGB = (srcRGB * srcA) + dstRGB
     * dstA = dstA
     * </pre>
     */
    public static final int SDL_BLENDMODE_ADD = 0x00000002;

    /**
     * color modulate
     * <pre>
     * dstRGB = srcRGB * dstRGB
     * dstA = dstA
     * </pre>
     */
    public static final int SDL_BLENDMODE_MOD = 0x00000004;

    /**
     * color multiply
     * <pre>
     * dstRGB = (srcRGB * dstRGB) + (dstRGB * (1-srcA))
     * dstA = dstA
     * </pre>
     */
    public static final int SDL_BLENDMODE_MUL = 0x00000008;

    public static final int SDL_BLENDMODE_INVALID = 0x7FFFFFFF;

    // TODO: Generate public static String toString(int value)

    private SDL_BlendMode() {
    }

    public static final class Ref extends IntByReference {

        public Ref() {
            super();
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(
                @MagicConstant(valuesFromClass = SDL_BlendMode.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_BlendMode.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
