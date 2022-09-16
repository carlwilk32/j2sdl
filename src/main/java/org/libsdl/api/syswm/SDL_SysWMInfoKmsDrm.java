package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "devIndex",
        "drmFd",
        "gbmDev"
})
public class SDL_SysWMInfoKmsDrm extends Structure {

    /** Device index (ex: the X in /dev/dri/cardX) */
    public int devIndex;

    /** DRM FD (unavailable on Vulkan windows) */
    public int drmFd;

    /** GBM device (unavailable on Vulkan windows) */
    public Pointer gbmDev;

    public SDL_SysWMInfoKmsDrm() {
    }

    public SDL_SysWMInfoKmsDrm(Pointer p) {
        super(p);
    }
}
