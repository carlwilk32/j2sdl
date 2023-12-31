package com.github.carlwilk32.sdl.core.api.hidapi;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * A handle representing an open HID device.
 *
 * <p>Opaque hidapi structure.</p>
 */
public final class SDL_hid_device extends PointerType {

    public SDL_hid_device() {
        super();
    }

    public SDL_hid_device(Pointer p) {
        super(p);
    }
}
