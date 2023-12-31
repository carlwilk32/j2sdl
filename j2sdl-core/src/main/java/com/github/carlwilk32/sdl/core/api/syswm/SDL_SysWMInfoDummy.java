package com.github.carlwilk32.sdl.core.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;


@Structure.FieldOrder({
        "dummy"
})
public final class SDL_SysWMInfoDummy extends Structure {

    public byte[] dummy = new byte[64];

    public SDL_SysWMInfoDummy() {
    }

    public SDL_SysWMInfoDummy(Pointer p) {
        super(p);
    }
}
