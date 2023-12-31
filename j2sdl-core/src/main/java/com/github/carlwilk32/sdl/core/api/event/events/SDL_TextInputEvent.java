package com.github.carlwilk32.sdl.core.api.event.events;

import com.github.carlwilk32.sdl.core.api.event.SDL_EventType;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Keyboard text input event structure (event.text.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text"
})
public final class SDL_TextInputEvent extends Structure {

    private static final int SDL_TEXTINPUTEVENT_TEXT_SIZE = 32;

    /** {@link SDL_EventType#SDL_TEXTINPUT SDL_TEXTINPUT} */
    @MagicConstant(intValues = SDL_EventType.SDL_TEXTINPUT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    // TODO: byte, char or String?
    /** The input text */
    public byte[] text = new byte[SDL_TEXTINPUTEVENT_TEXT_SIZE];

    public SDL_TextInputEvent() {
    }

    public SDL_TextInputEvent(Pointer p) {
        super(p);
    }
}
