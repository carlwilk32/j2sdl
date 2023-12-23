package com.github.carlwilk32.api.keyboard;

import com.github.carlwilk32.api.scancode.SDL_Scancode;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.keycode.SDL_Keycode;
import org.intellij.lang.annotations.MagicConstant;

/**
 * The SDL keysym structure, used in key events.
 *
 * <p><b>Note:</b> If you are looking for translated character input, see the
 * {@link SDL_EventType#SDL_TEXTINPUT} event.</p>
 */
@Structure.FieldOrder({
        "scancode",
        "sym",
        "mod",
        "unused"
})
public final class SDL_Keysym extends Structure {

    /** SDL physical key code - see {@link SDL_Scancode} for details */
    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public int scancode;

    /** SDL virtual key code - see {@link SDL_Keycode} for details */
    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public int sym;

    /** current key modifiers */
    public short mod;

    public int unused;

    public SDL_Keysym() {
    }

    public SDL_Keysym(Pointer p) {
        super(p);
    }
}
