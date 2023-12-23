package com.github.carlwilk32.api.syswm.event;

import com.github.carlwilk32.api.syswm.SDL_SYSWM_TYPE;
import com.github.carlwilk32.api.version.SDL_version;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * The custom window manager information structure.
 *
 * When this structure is returned, it holds information about which
 * low level system it is using, and will be one of SDL_SYSWM_TYPE.
 */
@Structure.FieldOrder({
        "version",
        "subsystem",
        "msg"
})
public final class SDL_SysWMmsg extends Structure implements Structure.ByReference {

    public SDL_version version;
    @MagicConstant(valuesFromClass = SDL_SYSWM_TYPE.class)
    public int subsystem;
    public SDL_SysWMmsgPlatformSpecific msg;

    public SDL_SysWMmsg() {
    }

    public SDL_SysWMmsg(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("subsystem");
        switch (subsystem) {
            case SDL_SYSWM_TYPE.SDL_SYSWM_WINDOWS:
                msg.setType(SDL_SysWMmsgWindows.class);
                break;
            case SDL_SYSWM_TYPE.SDL_SYSWM_X11:
                msg.setType(SDL_SysWMmsgX11.class);
                break;
            default:
                msg.setType(SDL_SysWMmsgDummy.class);
                break;
        }
        super.read();
    }
}
