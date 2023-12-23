package com.github.carlwilk32.api.event.events;

import com.github.carlwilk32.api.event.SDL_EventType;
import com.github.carlwilk32.api.syswm.event.SDL_SysWMmsg;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static com.github.carlwilk32.api.event.SDL_EventType.SDL_SYSWMEVENT;

/**
 * A video driver dependent system event (event.syswm.*)
 * This event is disabled by default, you can enable it with SDL_EventState()
 *
 * <p><b>Note:</b> If you want to use this event, you should include SDL_syswm.h.</p>
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "msg"
})
public final class SDL_SysWMEvent extends Structure {

    /** {@link SDL_EventType#SDL_SYSWMEVENT SDL_SYSWMEVENT} */
    @MagicConstant(intValues = SDL_SYSWMEVENT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** driver dependent data, defined in SDL_syswm.h */
    public SDL_SysWMmsg msg;

    public SDL_SysWMEvent() {
    }

    public SDL_SysWMEvent(Pointer p) {
        super(p);
    }
}
