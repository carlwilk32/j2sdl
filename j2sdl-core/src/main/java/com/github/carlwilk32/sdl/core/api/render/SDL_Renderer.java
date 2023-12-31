package com.github.carlwilk32.sdl.core.api.render;

import com.github.carlwilk32.sdl.core.api.video.SDL_Window;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;

/**
 * A structure holding state and settings for rendering operations.
 *
 * <p>It is tied to an {@link SDL_Window SDL_Window} so it can only render within that {@code SDL_Window}.</p>
 */
public final class SDL_Renderer extends PointerType {

    public SDL_Renderer() {
    }

    public SDL_Renderer(Pointer p) {
        super(p);
    }

    public static final class Ref extends PointerByReference {

        public Ref() {
        }

        public Ref(Pointer value) {
            super(value);
        }

        public SDL_Renderer getRenderer() {
            return new SDL_Renderer(getValue());
        }
    }
}
