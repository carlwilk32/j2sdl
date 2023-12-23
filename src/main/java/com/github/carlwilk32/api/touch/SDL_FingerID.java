package com.github.carlwilk32.api.touch;

import com.sun.jna.IntegerType;

public final class SDL_FingerID extends IntegerType {

    public SDL_FingerID() {
        this(0L);
    }

    public SDL_FingerID(long value) {
        super(8, value, false);
    }
}
