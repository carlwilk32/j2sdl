package com.github.carlwilk32.sdl.core.api.event;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_AudioDeviceEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_CommonEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_ControllerAxisEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_ControllerButtonEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_ControllerDeviceEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_ControllerSensorEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_ControllerTouchpadEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_DisplayEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_DollarGestureEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_DropEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyAxisEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyBallEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyBatteryEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyButtonEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyDeviceEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_JoyHatEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_KeyboardEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_MouseButtonEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_MouseMotionEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_MouseWheelEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_MultiGestureEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_OSEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_QuitEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_SensorEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_SysWMEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_TextEditingEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_TextEditingExtEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_TextInputEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_TouchFingerEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_UserEvent;
import com.github.carlwilk32.sdl.core.api.event.events.SDL_WindowEvent;

/**
 * General event class.
 *
 * <p>This class is a union of all event info objects from SDL.
 * You can pass an empty instance to methods such as {@link SdlEvents#SDL_PollEvent(SDL_Event)}
 * and have it populated with event info.</p>
 *
 * <p>Although it is as close a mapping of a C union as possible, Java does not really support that kind of thing.
 * Therefore, unlike in C where you can read from any union member and use it as a view to the raw data,
 * in JNA union, it must be selected which union member is the active field.
 * When the object is populated in a native method, it is done automatically (by {@link #read()})
 * If you populate the object in Java, always remember to select the active member field
 * using {@link #setType(Class)}.</p>
 */
public final class SDL_Event extends Union {

    /** Event type, shared with all events */
    public int type;

    /** Common event data */
    public SDL_CommonEvent common;

    /** Display event data */
    public SDL_DisplayEvent display;

    /** Window event data */
    public SDL_WindowEvent window;

    /** Keyboard event data */
    public SDL_KeyboardEvent key;

    /** Text editing event data */
    public SDL_TextEditingEvent edit;

    /** Text input event data */
    public SDL_TextInputEvent text;

    /** Extended text editing event data */
    public SDL_TextEditingExtEvent editExt;

    /** Mouse motion event data */
    public SDL_MouseMotionEvent motion;

    /** Mouse button event data */
    public SDL_MouseButtonEvent button;

    /** Mouse wheel event data */
    public SDL_MouseWheelEvent wheel;

    /** Joystick axis event data */
    public SDL_JoyAxisEvent jaxis;

    /** Joystick ball event data */
    public SDL_JoyBallEvent jball;

    /** Joystick hat event data */
    public SDL_JoyHatEvent jhat;

    /** Joystick button event data */
    public SDL_JoyButtonEvent jbutton;

    /** Joystick device change event data */
    public SDL_JoyDeviceEvent jdevice;

    /** Joystick battery event data */
    public SDL_JoyBatteryEvent jbattery;

    /** Game Controller axis event data */
    public SDL_ControllerAxisEvent caxis;

    /** Game Controller button event data */
    public SDL_ControllerButtonEvent cbutton;

    /** Game Controller device event data */
    public SDL_ControllerDeviceEvent cdevice;

    /** Game Controller touchpad event data */
    public SDL_ControllerTouchpadEvent ctouchpad;

    /** Game Controller sensor event data */
    public SDL_ControllerSensorEvent csensor;

    /** Audio device event data */
    public SDL_AudioDeviceEvent adevice;

    /** Touch finger event data */
    public SDL_TouchFingerEvent tfinger;

    /** Gesture event data */
    public SDL_MultiGestureEvent mgesture;

    /** Gesture event data */
    public SDL_DollarGestureEvent dgesture;

    /** Drag and drop event data */
    public SDL_DropEvent drop;

    /** Sensor event data */
    public SDL_SensorEvent sensor;

    /** Quit request event data */
    public SDL_QuitEvent quit;

    public SDL_OSEvent os;

    /** Custom event data */
    public SDL_UserEvent user;

    /** System dependent window event data */
    public SDL_SysWMEvent syswm;

    public SDL_Event() {
    }

    public SDL_Event(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("type");
        switch (type) {
            case SDL_EventType.SDL_QUIT:
                setType(SDL_QuitEvent.class);
                break;
            case SDL_EventType.SDL_APP_TERMINATING:
            case SDL_EventType.SDL_APP_LOWMEMORY:
            case SDL_EventType.SDL_APP_WILLENTERBACKGROUND:
            case SDL_EventType.SDL_APP_DIDENTERBACKGROUND:
            case SDL_EventType.SDL_APP_WILLENTERFOREGROUND:
            case SDL_EventType.SDL_APP_DIDENTERFOREGROUND:
                setType(SDL_OSEvent.class);
                break;
            case SDL_EventType.SDL_LOCALECHANGED:
                setType(SDL_CommonEvent.class);
                break;
            case SDL_EventType.SDL_DISPLAYEVENT:
                setType(SDL_DisplayEvent.class);
                break;
            case SDL_EventType.SDL_WINDOWEVENT:
                setType(SDL_WindowEvent.class);
                break;
            case SDL_EventType.SDL_SYSWMEVENT:
                setType(SDL_SysWMEvent.class);
                break;
            case SDL_EventType.SDL_KEYDOWN:
            case SDL_EventType.SDL_KEYUP:
                setType(SDL_KeyboardEvent.class);
                break;
            case SDL_EventType.SDL_TEXTEDITING:
                setType(SDL_TextEditingEvent.class);
                break;
            case SDL_EventType.SDL_TEXTINPUT:
                setType(SDL_TextInputEvent.class);
                break;
            case SDL_EventType.SDL_KEYMAPCHANGED:
                setType(SDL_CommonEvent.class);
                break;
            case SDL_EventType.SDL_TEXTEDITING_EXT:
                setType(SDL_TextEditingExtEvent.class);
                break;
            case SDL_EventType.SDL_MOUSEMOTION:
                setType(SDL_MouseMotionEvent.class);
                break;
            case SDL_EventType.SDL_MOUSEBUTTONDOWN:
            case SDL_EventType.SDL_MOUSEBUTTONUP:
                setType(SDL_MouseButtonEvent.class);
                break;
            case SDL_EventType.SDL_MOUSEWHEEL:
                setType(SDL_MouseWheelEvent.class);
                break;
            case SDL_EventType.SDL_JOYAXISMOTION:
                setType(SDL_JoyAxisEvent.class);
                break;
            case SDL_EventType.SDL_JOYBALLMOTION:
                setType(SDL_JoyBallEvent.class);
                break;
            case SDL_EventType.SDL_JOYHATMOTION:
                setType(SDL_JoyHatEvent.class);
                break;
            case SDL_EventType.SDL_JOYBUTTONDOWN:
            case SDL_EventType.SDL_JOYBUTTONUP:
                setType(SDL_JoyButtonEvent.class);
                break;
            case SDL_EventType.SDL_JOYDEVICEADDED:
            case SDL_EventType.SDL_JOYDEVICEREMOVED:
                setType(SDL_JoyDeviceEvent.class);
                break;
            case SDL_EventType.SDL_JOYBATTERYUPDATED:
                setType(SDL_JoyBatteryEvent.class);
                break;
            case SDL_EventType.SDL_CONTROLLERAXISMOTION:
                setType(SDL_ControllerAxisEvent.class);
                break;
            case SDL_EventType.SDL_CONTROLLERBUTTONDOWN:
            case SDL_EventType.SDL_CONTROLLERBUTTONUP:
                setType(SDL_ControllerButtonEvent.class);
                break;
            case SDL_EventType.SDL_CONTROLLERDEVICEADDED:
            case SDL_EventType.SDL_CONTROLLERDEVICEREMOVED:
            case SDL_EventType.SDL_CONTROLLERDEVICEREMAPPED:
                setType(SDL_ControllerDeviceEvent.class);
                break;
            case SDL_EventType.SDL_CONTROLLERTOUCHPADDOWN:
            case SDL_EventType.SDL_CONTROLLERTOUCHPADMOTION:
            case SDL_EventType.SDL_CONTROLLERTOUCHPADUP:
                setType(SDL_ControllerTouchpadEvent.class);
                break;
            case SDL_EventType.SDL_CONTROLLERSENSORUPDATE:
                setType(SDL_ControllerSensorEvent.class);
                break;
            case SDL_EventType.SDL_FINGERDOWN:
            case SDL_EventType.SDL_FINGERUP:
            case SDL_EventType.SDL_FINGERMOTION:
                setType(SDL_TouchFingerEvent.class);
                break;
            case SDL_EventType.SDL_DOLLARGESTURE:
            case SDL_EventType.SDL_DOLLARRECORD:
                setType(SDL_DollarGestureEvent.class);
                break;
            case SDL_EventType.SDL_MULTIGESTURE:
                setType(SDL_MultiGestureEvent.class);
                break;
            case SDL_EventType.SDL_CLIPBOARDUPDATE:
                setType(SDL_CommonEvent.class);
                break;
            case SDL_EventType.SDL_DROPFILE:
            case SDL_EventType.SDL_DROPTEXT:
            case SDL_EventType.SDL_DROPBEGIN:
            case SDL_EventType.SDL_DROPCOMPLETE:
                setType(SDL_DropEvent.class);
                break;
            case SDL_EventType.SDL_AUDIODEVICEADDED:
            case SDL_EventType.SDL_AUDIODEVICEREMOVED:
                setType(SDL_AudioDeviceEvent.class);
                break;
            case SDL_EventType.SDL_SENSORUPDATE:
                setType(SDL_SensorEvent.class);
                break;
            case SDL_EventType.SDL_RENDER_TARGETS_RESET:
            case SDL_EventType.SDL_RENDER_DEVICE_RESET:
                setType(SDL_CommonEvent.class);
                break;
            default:
                if (type >= SDL_EventType.SDL_USEREVENT && type < SDL_EventType.SDL_LASTEVENT) {
                    setType(SDL_UserEvent.class);
                } else {
                    setType(SDL_CommonEvent.class);
                }
                break;
        }
        super.read();
    }
}
