package com.github.carlwilk32.sdl.core.jna;

import com.sun.jna.Pointer;

public interface PojoStructure {

    long size();

    void write(Pointer buffer, long offset);
}
