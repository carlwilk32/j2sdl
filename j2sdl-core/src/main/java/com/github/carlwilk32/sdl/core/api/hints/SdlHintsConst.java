package com.github.carlwilk32.sdl.core.api.hints;

public final class SdlHintsConst {

    /**
     * A variable controlling whether the Android / iOS built-in
     * accelerometer should be listed as a joystick device.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - The accelerometer is not listed as a joystick
     * "1"       - The accelerometer is available as a 3 axis joystick (the default).
     * </pre>
     */
    public static final String SDL_HINT_ACCELEROMETER_AS_JOYSTICK = "SDL_ACCELEROMETER_AS_JOYSTICK";

    /**
     * Specify the behavior of Alt+Tab while the keyboard is grabbed.
     *
     * <p>By default, SDL emulates Alt+Tab functionality while the keyboard is grabbed
     * and your window is full-screen. This prevents the user from getting stuck in
     * your application if you've enabled keyboard grab.</p>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL will not handle Alt+Tab. Your application is responsible
     *             for handling Alt+Tab while the keyboard is grabbed.
     * "1"       - SDL will minimize your window when Alt+Tab is pressed (default)
     * </pre>
     */
    public static final String SDL_HINT_ALLOW_ALT_TAB_WHILE_GRABBED = "SDL_ALLOW_ALT_TAB_WHILE_GRABBED";

    /**
     * If set to "0" then never set the top most bit on a SDL Window, even if the video mode expects it.
     * This is a debugging aid for developers and not expected to be used by end users. The default is "1"
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - don't allow topmost
     * "1"       - allow topmost
     * </pre>
     */
    public static final String SDL_HINT_ALLOW_TOPMOST = "SDL_ALLOW_TOPMOST";

    /**
     * Android APK expansion main file version. Should be a string number like "1", "2" etc.
     *
     * <p>Must be set together with SDL_HINT_ANDROID_APK_EXPANSION_PATCH_FILE_VERSION.</p>
     *
     * <p>If both hints were set then SDL_RWFromFile() will look into expansion files
     * after a given relative path was not found in the internal storage and assets.</p>
     *
     * <p>By default this hint is not set and the APK expansion files are not searched.</p>
     */
    public static final String SDL_HINT_ANDROID_APK_EXPANSION_MAIN_FILE_VERSION = "SDL_ANDROID_APK_EXPANSION_MAIN_FILE_VERSION";

    /**
     * Android APK expansion patch file version. Should be a string number like "1", "2" etc.
     *
     * <p>Must be set together with SDL_HINT_ANDROID_APK_EXPANSION_MAIN_FILE_VERSION.</p>
     *
     * <p>If both hints were set then SDL_RWFromFile() will look into expansion files
     * after a given relative path was not found in the internal storage and assets.</p>
     *
     * <p>By default this hint is not set and the APK expansion files are not searched.</p>
     */
    public static final String SDL_HINT_ANDROID_APK_EXPANSION_PATCH_FILE_VERSION = "SDL_ANDROID_APK_EXPANSION_PATCH_FILE_VERSION";

    /**
     * A variable to control whether the event loop will block itself when the app is paused.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Non blocking.
     * "1"       - Blocking. (default)
     * </pre>
     *
     * <p>The value should be set before SDL is initialized.</p>
     */
    public static final String SDL_HINT_ANDROID_BLOCK_ON_PAUSE = "SDL_ANDROID_BLOCK_ON_PAUSE";

    /**
     * A variable to control whether SDL will pause audio in background
     * (Requires SDL_ANDROID_BLOCK_ON_PAUSE as "Non blocking")
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Non paused.
     * "1"       - Paused. (default)
     * </pre>
     *
     * <p>The value should be set before SDL is initialized.</p>
     */
    public static final String SDL_HINT_ANDROID_BLOCK_ON_PAUSE_PAUSEAUDIO = "SDL_ANDROID_BLOCK_ON_PAUSE_PAUSEAUDIO";

    /**
     * A variable to control whether we trap the Android back button to handle it manually.
     * This is necessary for the right mouse button to work on some Android devices, or
     * to be able to trap the back button for use in your code reliably.  If set to true,
     * the back button will show up as an SDL_KEYDOWN / SDL_KEYUP pair with a keycode of
     * SDL_SCANCODE_AC_BACK.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Back button will be handled as usual for system. (default)
     * "1"       - Back button will be trapped, allowing you to handle the key press
     *             manually.  (This will also let right mouse click work on systems
     *             where the right mouse button functions as back.)
     * </pre>
     *
     * <p>The value of this hint is used at runtime, so it can be changed at any time.</p>
     */
    public static final String SDL_HINT_ANDROID_TRAP_BACK_BUTTON = "SDL_ANDROID_TRAP_BACK_BUTTON";

    /**
     * Specify an application name.
     *
     * <p>This hint lets you specify the application name sent to the OS when
     * required. For example, this will often appear in volume control applets for
     * audio streams, and in lists of applications which are inhibiting the
     * screensaver.  You should use a string that describes your program ("My Game
     * 2: The Revenge")</p>
     *
     * <p>Setting this to "" or leaving it unset will have SDL use a reasonable
     * default: probably the application's name or "SDL Application" if SDL
     * doesn't have any better information.</p>
     *
     * <p>Note that, for audio streams, this can be overridden with
     * SDL_HINT_AUDIO_DEVICE_APP_NAME.</p>
     *
     * <p>On targets where this is not supported, this hint does nothing.</p>
     */
    public static final String SDL_HINT_APP_NAME = "SDL_APP_NAME";

    /**
     * A variable controlling whether controllers used with the Apple TV
     * generate UI events.
     *
     * <p>When UI events are generated by controller input, the app will be
     * backgrounded when the Apple TV remote's menu button is pressed, and when the
     * pause or B buttons on gamepads are pressed.</p>
     *
     * <p>More information about properly making use of controllers for the Apple TV
     * can be found here:
     * https://developer.apple.com/tvos/human-interface-guidelines/remote-and-controllers/</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Controller input does not generate UI events (the default).
     * "1"       - Controller input generates UI events.
     * </pre>
     */
    public static final String SDL_HINT_APPLE_TV_CONTROLLER_UI_EVENTS = "SDL_APPLE_TV_CONTROLLER_UI_EVENTS";

    /**
     * A variable controlling whether the Apple TV remote's joystick axes
     * will automatically match the rotation of the remote.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Remote orientation does not affect joystick axes (the default).
     * "1"       - Joystick axes are based on the orientation of the remote.
     * </pre>
     */
    public static final String SDL_HINT_APPLE_TV_REMOTE_ALLOW_ROTATION = "SDL_APPLE_TV_REMOTE_ALLOW_ROTATION";

    /**
     * A variable controlling the audio category on iOS and Mac OS X
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "ambient"     - Use the AVAudioSessionCategoryAmbient audio category, will be muted by the phone mute switch (default)
     * "playback"    - Use the AVAudioSessionCategoryPlayback category
     * </pre>
     *
     * <p>For more information, see Apple's documentation:
     * https://developer.apple.com/library/content/documentation/Audio/Conceptual/AudioSessionProgrammingGuide/AudioSessionCategoriesandModes/AudioSessionCategoriesandModes.html</p>
     */
    public static final String SDL_HINT_AUDIO_CATEGORY = "SDL_AUDIO_CATEGORY";

    /**
     * Specify an application name for an audio device.
     *
     * <p>Some audio backends (such as PulseAudio) allow you to describe your audio
     * stream. Among other things, this description might show up in a system
     * control panel that lets the user adjust the volume on specific audio
     * streams instead of using one giant master volume slider.</p>
     *
     * <p>This hints lets you transmit that information to the OS. The contents of
     * this hint are used while opening an audio device. You should use a string
     * that describes your program ("My Game 2: The Revenge")</p>
     *
     * <p>Setting this to "" or leaving it unset will have SDL use a reasonable
     * default: this will be the name set with SDL_HINT_APP_NAME, if that hint is
     * set. Otherwise, it'll probably the application's name or "SDL Application"
     * if SDL doesn't have any better information.</p>
     *
     * <p>On targets where this is not supported, this hint does nothing.</p>
     */
    public static final String SDL_HINT_AUDIO_DEVICE_APP_NAME = "SDL_AUDIO_DEVICE_APP_NAME";

    /**
     * Specify an application name for an audio device.
     *
     * <p>Some audio backends (such as PulseAudio) allow you to describe your audio
     * stream. Among other things, this description might show up in a system
     * control panel that lets the user adjust the volume on specific audio
     * streams instead of using one giant master volume slider.</p>
     *
     * <p>This hints lets you transmit that information to the OS. The contents of
     * this hint are used while opening an audio device. You should use a string
     * that describes your what your program is playing ("audio stream" is
     * probably sufficient in many cases, but this could be useful for something
     * like "team chat" if you have a headset playing VoIP audio separately).</p>
     *
     * <p>Setting this to "" or leaving it unset will have SDL use a reasonable
     * default: "audio stream" or something similar.</p>
     *
     * <p>On targets where this is not supported, this hint does nothing.</p>
     */
    public static final String SDL_HINT_AUDIO_DEVICE_STREAM_NAME = "SDL_AUDIO_DEVICE_STREAM_NAME";

    /**
     * Specify an application role for an audio device.
     *
     * <p>Some audio backends (such as Pipewire) allow you to describe the role of
     * your audio stream. Among other things, this description might show up in
     * a system control panel or software for displaying and manipulating media
     * playback/capture graphs.</p>
     *
     * <p>This hints lets you transmit that information to the OS. The contents of
     * this hint are used while opening an audio device. You should use a string
     * that describes your what your program is playing (Game, Music, Movie,
     * etc...).</p>
     *
     * <p>Setting this to "" or leaving it unset will have SDL use a reasonable
     * default: "Game" or something similar.</p>
     *
     * <p>On targets where this is not supported, this hint does nothing.</p>
     */
    public static final String SDL_HINT_AUDIO_DEVICE_STREAM_ROLE = "SDL_AUDIO_DEVICE_STREAM_ROLE";

    /**
     * A variable controlling speed/quality tradeoff of audio resampling.
     *
     * <p>If available, SDL can use libsamplerate ( http://www.mega-nerd.com/SRC/ )
     * to handle audio resampling. There are different resampling modes available
     * that produce different levels of quality, using more CPU.</p>
     *
     * <p>If this hint isn't specified to a valid setting, or libsamplerate isn't
     * available, SDL will use the default, internal resampling algorithm.</p>
     *
     * <p>As of SDL 2.26, SDL_ConvertAudio() respects this hint when libsamplerate is available.</p>
     *
     * <p>This hint is currently only checked at audio subsystem initialization.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" or "default" - Use SDL's internal resampling (Default when not set - low quality, fast)
     * "1" or "fast"    - Use fast, slightly higher quality resampling, if available
     * "2" or "medium"  - Use medium quality resampling, if available
     * "3" or "best"    - Use high quality resampling, if available
     * </pre>
     */
    public static final String SDL_HINT_AUDIO_RESAMPLING_MODE = "SDL_AUDIO_RESAMPLING_MODE";

    /**
     * A variable controlling whether SDL updates joystick state when getting input events
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"     - You'll call SDL_JoystickUpdate() manually
     * "1"     - SDL will automatically call SDL_JoystickUpdate() (default)
     * </pre>
     *
     * <p>This hint can be toggled on and off at runtime.</p>
     */
    public static final String SDL_HINT_AUTO_UPDATE_JOYSTICKS = "SDL_AUTO_UPDATE_JOYSTICKS";

    /**
     * A variable controlling whether SDL updates sensor state when getting input events
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"     - You'll call SDL_SensorUpdate() manually
     * "1"     - SDL will automatically call SDL_SensorUpdate() (default)
     * </pre>
     *
     * <p>This hint can be toggled on and off at runtime.</p>
     */
    public static final String SDL_HINT_AUTO_UPDATE_SENSORS = "SDL_AUTO_UPDATE_SENSORS";

    /**
     * Prevent SDL from using version 4 of the bitmap header when saving BMPs.
     *
     * <p>The bitmap header version 4 is required for proper alpha channel support and
     * SDL will use it when required. Should this not be desired, this hint can
     * force the use of the 40 byte header version which is supported everywhere.</p>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Surfaces with a colorkey or an alpha channel are saved to a
     *             32-bit BMP file with an alpha mask. SDL will use the bitmap
     *             header version 4 and set the alpha mask accordingly.
     * "1"       - Surfaces with a colorkey or an alpha channel are saved to a
     *             32-bit BMP file without an alpha mask. The alpha channel data
     *             will be in the file, but applications are going to ignore it.
     * </pre>
     *
     * <p>The default value is "0".</p>
     */
    public static final String SDL_HINT_BMP_SAVE_LEGACY_FORMAT = "SDL_BMP_SAVE_LEGACY_FORMAT";

    /**
     * Override for SDL_GetDisplayUsableBounds()
     *
     * <p>If set, this hint will override the expected results for
     * SDL_GetDisplayUsableBounds() for display index 0. Generally you don't want
     * to do this, but this allows an embedded system to request that some of the
     * screen be reserved for other uses when paired with a well-behaved
     * application.</p>
     *
     * <p>The contents of this hint must be 4 comma-separated integers, the first
     * is the bounds x, then y, width and height, in that order.</p>
     */
    public static final String SDL_HINT_DISPLAY_USABLE_BOUNDS = "SDL_DISPLAY_USABLE_BOUNDS";

    /**
     * Disable giving back control to the browser automatically
     * when running with asyncify
     *
     * <p>With -s ASYNCIFY, SDL2 calls emscripten_sleep during operations
     * such as refreshing the screen or polling events.</p>
     *
     * <p>This hint only applies to the emscripten platform</p>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable emscripten_sleep calls (if you give back browser control manually or use asyncify for other purposes)
     * "1"       - Enable emscripten_sleep calls (the default)
     * </pre>
     */
    public static final String SDL_HINT_EMSCRIPTEN_ASYNCIFY = "SDL_EMSCRIPTEN_ASYNCIFY";

    /**
     * override the binding element for keyboard inputs for Emscripten builds
     *
     * <p>This hint only applies to the emscripten platform</p>
     *
     * <p>The variable can be one of:</p>
     * <pre>
     * "#window"      - The javascript window object (this is the default)
     * "#document"    - The javascript document object
     * "#screen"      - the javascript window.screen object
     * "#canvas"      - the WebGL canvas element
     * any other string without a leading # sign applies to the element on the page with that ID.
     * </pre>
     */
    public static final String SDL_HINT_EMSCRIPTEN_KEYBOARD_ELEMENT = "SDL_EMSCRIPTEN_KEYBOARD_ELEMENT";

    /**
     * A variable that controls whether the on-screen keyboard should be shown when text input is active
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Do not show the on-screen keyboard
     * "1"       - Show the on-screen keyboard
     * </pre>
     *
     * <p>The default value is "1". This hint must be set before text input is activated.</p>
     */
    public static final String SDL_HINT_ENABLE_SCREEN_KEYBOARD = "SDL_ENABLE_SCREEN_KEYBOARD";

    /**
     * A variable that controls whether Steam Controllers should be exposed using the SDL joystick and game controller APIs
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Do not scan for Steam Controllers
     * "1"       - Scan for Steam Controllers (the default)
     * </pre>
     *
     * <p>The default value is "1".  This hint must be set before initializing the joystick subsystem.</p>
     */
    public static final String SDL_HINT_ENABLE_STEAM_CONTROLLERS = "SDL_ENABLE_STEAM_CONTROLLERS";

    /**
     * A variable controlling verbosity of the logging of SDL events pushed onto the internal queue.
     *
     * <p>This variable can be set to the following values, from least to most verbose:</p>
     * <pre>
     * "0"     - Don't log any events (default)
     * "1"     - Log most events (other than the really spammy ones).
     * "2"     - Include mouse and finger motion events.
     * "3"     - Include SDL_SysWMEvent events.
     * </pre>
     *
     * <p>This is generally meant to be used to debug SDL itself, but can be useful
     * for application developers that need better visibility into what is going
     * on in the event queue. Logged events are sent through SDL_Log(), which
     * means by default they appear on stdout on most platforms or maybe
     * OutputDebugString() on Windows, and can be funneled by the app with
     * SDL_LogSetOutputFunction(), etc.</p>
     *
     * <p>This hint can be toggled on and off at runtime, if you only need to log
     * events for a small subset of program execution.</p>
     */
    public static final String SDL_HINT_EVENT_LOGGING = "SDL_EVENT_LOGGING";

    /**
     * A variable controlling whether raising the window should be done more forcefully
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - No forcing (the default)
     * "1"       - Extra level of forcing
     * </pre>
     *
     * <p>At present, this is only an issue under MS Windows, which makes it nearly impossible to
     * programmatically move a window to the foreground, for "security" reasons. See
     * http://stackoverflow.com/a/34414846 for a discussion.</p>
     */
    public static final String SDL_HINT_FORCE_RAISEWINDOW = "SDL_HINT_FORCE_RAISEWINDOW";

    /**
     * A variable controlling how 3D acceleration is used to accelerate the SDL screen surface.
     *
     * <p>SDL can try to accelerate the SDL screen surface by using streaming
     * textures with a 3D rendering engine.  This variable controls whether and
     * how this is done.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable 3D acceleration
     * "1"       - Enable 3D acceleration, using the default renderer.
     * "X"       - Enable 3D acceleration, using X where X is one of the valid rendering drivers.  (e.g. "direct3d", "opengl", etc.)
     * </pre>
     *
     * <p>By default SDL tries to make a best guess for each platform whether
     * to use acceleration or not.</p>
     */
    public static final String SDL_HINT_FRAMEBUFFER_ACCELERATION = "SDL_FRAMEBUFFER_ACCELERATION";

    /**
     * A variable that lets you manually hint extra gamecontroller db entries.
     *
     * <p>The variable should be newline delimited rows of gamecontroller config data, see SDL_gamecontroller.h</p>
     *
     * <p>This hint must be set before calling SDL_Init(SDL_INIT_GAMECONTROLLER)</p>
     *
     * <p>You can update mappings after the system is initialized with SDL_GameControllerMappingForGUID() and SDL_GameControllerAddMapping()</p>
     */
    public static final String SDL_HINT_GAMECONTROLLERCONFIG = "SDL_GAMECONTROLLERCONFIG";

    /**
     * A variable that lets you provide a file with extra gamecontroller db entries.
     *
     * <p>The file should contain lines of gamecontroller config data, see SDL_gamecontroller.h</p>
     *
     * <p>This hint must be set before calling SDL_Init(SDL_INIT_GAMECONTROLLER)</p>
     *
     * <p>You can update mappings after the system is initialized with SDL_GameControllerMappingForGUID() and SDL_GameControllerAddMapping()</p>
     */
    public static final String SDL_HINT_GAMECONTROLLERCONFIG_FILE = "SDL_GAMECONTROLLERCONFIG_FILE";

    /**
     * A variable that overrides the automatic controller type detection
     *
     * <p>The variable should be comma separated entries, in the form: VID/PID=type</p>
     *
     * <p>The VID and PID should be hexadecimal with exactly 4 digits, e.g. 0x00fd</p>
     *
     * <p>The type should be one of:</p>
     * <pre>
     * Xbox360
     * XboxOne
     * PS3
     * PS4
     * PS5
     * SwitchPro
     * </pre>
     *
     * <p>This hint affects what driver is used, and must be set before calling SDL_Init(SDL_INIT_GAMECONTROLLER)</p>
     */
    public static final String SDL_HINT_GAMECONTROLLERTYPE = "SDL_GAMECONTROLLERTYPE";

    /**
     * A variable containing a list of devices to skip when scanning for game controllers.
     *
     * <p>The format of the string is a comma separated list of USB VID/PID pairs
     * in hexadecimal form, e.g.</p>
     * <pre>
     * 0xAAAA/0xBBBB,0xCCCC/0xDDDD
     * </pre>
     *
     * <p>The variable can also take the form of @file, in which case the named
     * file will be loaded and interpreted as the value of the variable.</p>
     */
    public static final String SDL_HINT_GAMECONTROLLER_IGNORE_DEVICES = "SDL_GAMECONTROLLER_IGNORE_DEVICES";

    /**
     * If set, all devices will be skipped when scanning for game controllers except for the ones listed in this variable.
     *
     * <p>The format of the string is a comma separated list of USB VID/PID pairs
     * in hexadecimal form, e.g.</p>
     * <pre>
     * 0xAAAA/0xBBBB,0xCCCC/0xDDDD
     * </pre>
     *
     * <p>The variable can also take the form of @file, in which case the named
     * file will be loaded and interpreted as the value of the variable.</p>
     */
    public static final String SDL_HINT_GAMECONTROLLER_IGNORE_DEVICES_EXCEPT = "SDL_GAMECONTROLLER_IGNORE_DEVICES_EXCEPT";

    /**
     * If set, game controller face buttons report their values according to their labels instead of their positional layout.
     *
     * <p>For example, on Nintendo Switch controllers, normally you'd get:</p>
     * <pre>
     *      (Y)
     *  (X)     (B)
     *      (A)
     * </pre>
     *
     * <p>but if this hint is set, you'll get:</p>
     * <pre>
     *      (X)
     *  (Y)     (A)
     *      (B)
     * </pre>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Report the face buttons by position, as though they were on an Xbox controller.
     * "1"       - Report the face buttons by label instead of position
     * </pre>
     *
     * <p>The default value is "1".  This hint may be set at any time.</p>
     */
    public static final String SDL_HINT_GAMECONTROLLER_USE_BUTTON_LABELS = "SDL_GAMECONTROLLER_USE_BUTTON_LABELS";

    /**
     * A variable controlling whether grabbing input grabs the keyboard
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Grab will affect only the mouse
     * "1"       - Grab will affect mouse and keyboard
     * </pre>
     *
     * <p>By default SDL will not grab the keyboard so system shortcuts still work.</p>
     */
    public static final String SDL_HINT_GRAB_KEYBOARD = "SDL_GRAB_KEYBOARD";

    /**
     * A variable containing a list of devices to ignore in SDL_hid_enumerate()
     *
     * <p>For example, to ignore the Shanwan DS3 controller and any Valve controller, you might
     * have the string "0x2563/0x0523,0x28de/0x0000"</p>
     */
    public static final String SDL_HINT_HIDAPI_IGNORE_DEVICES = "SDL_HIDAPI_IGNORE_DEVICES";

    /**
     * A variable controlling whether the idle timer is disabled on iOS.
     *
     * <p>When an iOS app does not receive touches for some time, the screen is
     * dimmed automatically. For games where the accelerometer is the only input
     * this is problematic. This functionality can be disabled by setting this
     * hint.</p>
     *
     * <p>As of SDL 2.0.4, SDL_EnableScreenSaver() and SDL_DisableScreenSaver()
     * accomplish the same thing on iOS. They should be preferred over this hint.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Enable idle timer
     * "1"       - Disable idle timer
     * </pre>
     */
    public static final String SDL_HINT_IDLE_TIMER_DISABLED = "SDL_IOS_IDLE_TIMER_DISABLED";

    /**
     * A variable to control whether certain IMEs should handle text editing internally instead of sending SDL_TEXTEDITING events.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL_TEXTEDITING events are sent, and it is the application's
     *               responsibility to render the text from these events and
     *               differentiate it somehow from committed text. (default)
     *   "1"       - If supported by the IME then SDL_TEXTEDITING events are not sent,
     *               and text that is being composed will be rendered in its own UI.
     * </pre>
     */
    public static final String SDL_HINT_IME_INTERNAL_EDITING = "SDL_IME_INTERNAL_EDITING";

    /**
     * A variable to control whether certain IMEs should show native UI components (such as the Candidate List) instead of suppressing them.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Native UI components are not display. (default)
     * "1"       - Native UI components are displayed.
     * </pre>
     */
    public static final String SDL_HINT_IME_SHOW_UI = "SDL_IME_SHOW_UI";

    /**
     * A variable to control if extended IME text support is enabled.
     * If enabled then SDL_TextEditingExtEvent will be issued if the text would be truncated otherwise.
     * Additionally SDL_TextInputEvent will be dispatched multiple times so that it is not truncated.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Legacy behavior. Text can be truncated, no heap allocations. (default)
     * "1"       - Modern behavior.
     * </pre>
     */
    public static final String SDL_HINT_IME_SUPPORT_EXTENDED_TEXT = "SDL_IME_SUPPORT_EXTENDED_TEXT";

    /**
     * A variable controlling whether the home indicator bar on iPhone X
     * should be hidden.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - The indicator bar is not hidden (default for windowed applications)
     * "1"       - The indicator bar is hidden and is shown when the screen is touched (useful for movie playback applications)
     * "2"       - The indicator bar is dim and the first swipe makes it visible and the second swipe performs the "home" action (default for fullscreen applications)
     * </pre>
     */
    public static final String SDL_HINT_IOS_HIDE_HOME_INDICATOR = "SDL_IOS_HIDE_HOME_INDICATOR";

    /**
     * A variable that lets you enable joystick (and gamecontroller) events even when your app is in the background.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable joystick and gamecontroller input events when the
     *             application is in the background.
     * "1"       - Enable joystick and gamecontroller input events when the
     *             application is in the background.
     * </pre>
     *
     * <p>The default value is "0".  This hint may be set at any time.</p>
     */
    public static final String SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS = "SDL_JOYSTICK_ALLOW_BACKGROUND_EVENTS";

    /**
     * A variable controlling whether the HIDAPI joystick drivers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI drivers are not used
     * "1"       - HIDAPI drivers are used (the default)
     * </pre>
     *
     * <p>This variable is the default for all drivers, but can be overridden by the hints for specific drivers below.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI = "SDL_JOYSTICK_HIDAPI";

    /**
     * A variable controlling whether the HIDAPI driver for Nintendo GameCube controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_GAMECUBE = "SDL_JOYSTICK_HIDAPI_GAMECUBE";

    /**
     * A variable controlling whether "lowFrequencyRumble" and "highFrequencyRumble" is used to implement
     * the GameCube controller's 3 rumble modes, Stop(0), Rumble(1), and StopHard(2).
     *
     * <p>This is useful for applications that need full compatibility for things like ADSR envelopes.</p>
     *
     * <p><b>Stop</b> is implemented by setting "lowFrequencyRumble" to "0" and "highFrequencyRumble" to "greater than 0",</p>
     * <p><b>Rumble</b> is both at any arbitrary value,</p>
     * <p><b>StopHard</b> is implemented by setting both "lowFrequencyRumble" and "highFrequencyRumble" to "0"</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Normal rumble behavior is behavior is used (default)
     * "1"       - Proper GameCube controller rumble behavior is used
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_GAMECUBE_RUMBLE_BRAKE = "SDL_JOYSTICK_GAMECUBE_RUMBLE_BRAKE";

    /**
     * A variable controlling whether the HIDAPI driver for Nintendo Switch Joy-Cons should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_JOY_CONS = "SDL_JOYSTICK_HIDAPI_JOY_CONS";

    /**
     * A variable controlling whether Nintendo Switch Joy-Con controllers will be combined into a single Pro-like controller when using the HIDAPI driver
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Left and right Joy-Con controllers will not be combined and each will be a mini-gamepad
     * "1"       - Left and right Joy-Con controllers will be combined into a single controller (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_COMBINE_JOY_CONS = "SDL_JOYSTICK_HIDAPI_COMBINE_JOY_CONS";

    /**
     * A variable controlling whether Nintendo Switch Joy-Con controllers will be in vertical mode when using the HIDAPI driver
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Left and right Joy-Con controllers will not be in vertical mode (the default)
     * "1"       - Left and right Joy-Con controllers will be in vertical mode
     * </pre>
     *
     * <p>This hint must be set before calling SDL_Init(SDL_INIT_GAMECONTROLLER)</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_VERTICAL_JOY_CONS = "SDL_JOYSTICK_HIDAPI_VERTICAL_JOY_CONS";

    /**
     * A variable controlling whether the HIDAPI driver for Amazon Luna controllers connected via Bluetooth should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_LUNA = "SDL_JOYSTICK_HIDAPI_LUNA";

    /**
     * A variable controlling whether the HIDAPI driver for Nintendo Online classic controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_NINTENDO_CLASSIC = "SDL_JOYSTICK_HIDAPI_NINTENDO_CLASSIC";

    /**
     * A variable controlling whether the HIDAPI driver for NVIDIA SHIELD controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_SHIELD = "SDL_JOYSTICK_HIDAPI_SHIELD";

    /**
     * A variable controlling whether the HIDAPI driver for PS3 controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI on macOS, and "0" on other platforms.</p>
     *
     * <p>It is not possible to use this driver on Windows, due to limitations in the default drivers
     * installed. See https://github.com/ViGEm/DsHidMini for an alternative driver on Windows.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS3 = "SDL_JOYSTICK_HIDAPI_PS3";

    /**
     * A variable controlling whether the HIDAPI driver for PS4 controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS4 = "SDL_JOYSTICK_HIDAPI_PS4";

    /**
     * A variable controlling whether extended input reports should be used for PS4 controllers when using the HIDAPI driver.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - extended reports are not enabled (the default)
     * "1"       - extended reports
     * </pre>
     *
     * <p>Extended input reports allow rumble on Bluetooth PS4 controllers, but
     * break DirectInput handling for applications that don't use SDL.</p>
     *
     * <p>Once extended reports are enabled, they can not be disabled without
     * power cycling the controller.</p>
     *
     * <p>For compatibility with applications written for versions of SDL prior
     * to the introduction of PS5 controller support, this value will also
     * control the state of extended reports on PS5 controllers when the
     * SDL_HINT_JOYSTICK_HIDAPI_PS5_RUMBLE hint is not explicitly set.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS4_RUMBLE = "SDL_JOYSTICK_HIDAPI_PS4_RUMBLE";

    /**
     * A variable controlling whether the HIDAPI driver for PS5 controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS5 = "SDL_JOYSTICK_HIDAPI_PS5";

    /**
     * A variable controlling whether the player LEDs should be lit to indicate which player is associated with a PS5 controller.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - player LEDs are not enabled
     * "1"       - player LEDs are enabled (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS5_PLAYER_LED = "SDL_JOYSTICK_HIDAPI_PS5_PLAYER_LED";

    /**
     * A variable controlling whether extended input reports should be used for PS5 controllers when using the HIDAPI driver.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - extended reports are not enabled (the default)
     * "1"       - extended reports
     * </pre>
     *
     * <p>Extended input reports allow rumble on Bluetooth PS5 controllers, but
     * break DirectInput handling for applications that don't use SDL.</p>
     *
     * <p>Once extended reports are enabled, they can not be disabled without
     * power cycling the controller.</p>
     *
     * <p>For compatibility with applications written for versions of SDL prior
     * to the introduction of PS5 controller support, this value defaults to
     * the value of SDL_HINT_JOYSTICK_HIDAPI_PS4_RUMBLE.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_PS5_RUMBLE = "SDL_JOYSTICK_HIDAPI_PS5_RUMBLE";

    /**
     * A variable controlling whether the HIDAPI driver for Google Stadia controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_STADIA = "SDL_JOYSTICK_HIDAPI_STADIA";

    /**
     * A variable controlling whether the HIDAPI driver for Bluetooth Steam Controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used for Steam Controllers, which requires Bluetooth access
     *             and may prompt the user for permission on iOS and Android.
     * </pre>
     *
     * <p>The default is "0"</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_STEAM = "SDL_JOYSTICK_HIDAPI_STEAM";

    /**
     * A variable controlling whether the HIDAPI driver for Nintendo Switch controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_SWITCH = "SDL_JOYSTICK_HIDAPI_SWITCH";

    /**
     * A variable controlling whether the Home button LED should be turned on when a Nintendo Switch Pro controller is opened
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - home button LED is turned off
     * "1"       - home button LED is turned on
     * </pre>
     *
     * <p>By default the Home button LED state is not changed. This hint can also be set to a floating point value between 0.0 and 1.0 which controls the brightness of the Home button LED.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_SWITCH_HOME_LED = "SDL_JOYSTICK_HIDAPI_SWITCH_HOME_LED";

    /**
     * A variable controlling whether the Home button LED should be turned on when a Nintendo Switch Joy-Con controller is opened
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - home button LED is turned off
     * "1"       - home button LED is turned on
     * </pre>
     *
     * <p>By default the Home button LED state is not changed. This hint can also be set to a floating point value between 0.0 and 1.0 which controls the brightness of the Home button LED.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_JOYCON_HOME_LED = "SDL_JOYSTICK_HIDAPI_JOYCON_HOME_LED";

    /**
     * A variable controlling whether the player LEDs should be lit to indicate which player is associated with a Nintendo Switch controller.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - player LEDs are not enabled
     * "1"       - player LEDs are enabled (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_SWITCH_PLAYER_LED = "SDL_JOYSTICK_HIDAPI_SWITCH_PLAYER_LED";

    /**
     * A variable controlling whether the HIDAPI driver for Nintendo Wii and Wii U controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>This driver doesn't work with the dolphinbar, so the default is SDL_FALSE for now.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_WII = "SDL_JOYSTICK_HIDAPI_WII";

    /**
     * A variable controlling whether the player LEDs should be lit to indicate which player is associated with a Wii controller.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - player LEDs are not enabled
     * "1"       - player LEDs are enabled (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_WII_PLAYER_LED = "SDL_JOYSTICK_HIDAPI_WII_PLAYER_LED";

    /**
     * A variable controlling whether the HIDAPI driver for XBox controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is "0" on Windows, otherwise the value of SDL_HINT_JOYSTICK_HIDAPI</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX = "SDL_JOYSTICK_HIDAPI_XBOX";

    /**
     * A variable controlling whether the HIDAPI driver for XBox 360 controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI_XBOX</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX_360 = "SDL_JOYSTICK_HIDAPI_XBOX_360";

    /**
     * A variable controlling whether the player LEDs should be lit to indicate which player is associated with an Xbox 360 controller.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - player LEDs are not enabled
     * "1"       - player LEDs are enabled (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX_360_PLAYER_LED = "SDL_JOYSTICK_HIDAPI_XBOX_360_PLAYER_LED";

    /**
     * A variable controlling whether the HIDAPI driver for XBox 360 wireless controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI_XBOX_360</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX_360_WIRELESS = "SDL_JOYSTICK_HIDAPI_XBOX_360_WIRELESS";

    /**
     * A variable controlling whether the HIDAPI driver for XBox One controllers should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - HIDAPI driver is not used
     * "1"       - HIDAPI driver is used
     * </pre>
     *
     * <p>The default is the value of SDL_HINT_JOYSTICK_HIDAPI_XBOX</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX_ONE = "SDL_JOYSTICK_HIDAPI_XBOX_ONE";

    /**
     * A variable controlling whether the Home button LED should be turned on when an Xbox One controller is opened.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - home button LED is turned off
     * "1"       - home button LED is turned on
     * </pre>
     *
     * <p>By default the Home button LED state is not changed. This hint can also be set to a floating point value between 0.0 and 1.0 which controls the brightness of the Home button LED. The default brightness is 0.4.</p>
     */
    public static final String SDL_HINT_JOYSTICK_HIDAPI_XBOX_ONE_HOME_LED = "SDL_JOYSTICK_HIDAPI_XBOX_ONE_HOME_LED";

    /**
     * A variable controlling whether the RAWINPUT joystick drivers should be used for better handling XInput-capable devices.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - RAWINPUT drivers are not used
     * "1"       - RAWINPUT drivers are used (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_RAWINPUT = "SDL_JOYSTICK_RAWINPUT";

    /**
     * A variable controlling whether the RAWINPUT driver should pull correlated data from XInput.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - RAWINPUT driver will only use data from raw input APIs
     * "1"       - RAWINPUT driver will also pull data from XInput, providing
     *             better trigger axes, guide button presses, and rumble support
     *             for Xbox controllers
     * </pre>
     *
     * <p>The default is "1".  This hint applies to any joysticks opened after setting the hint.</p>
     */
    public static final String SDL_HINT_JOYSTICK_RAWINPUT_CORRELATE_XINPUT = "SDL_JOYSTICK_RAWINPUT_CORRELATE_XINPUT";

    /**
     * A variable controlling whether the ROG Chakram mice should show up as joysticks
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - ROG Chakram mice do not show up as joysticks (the default)
     * "1"       - ROG Chakram mice show up as joysticks
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_ROG_CHAKRAM = "SDL_JOYSTICK_ROG_CHAKRAM";

    /**
     * A variable controlling whether a separate thread should be used
     * for handling joystick detection and raw input messages on Windows
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - A separate thread is not used (the default)
     * "1"       - A separate thread is used for handling raw input messages
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_THREAD = "SDL_JOYSTICK_THREAD";

    /**
     * A variable controlling whether Windows.Gaming.Input should be used for controller handling.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - WGI is not used
     * "1"       - WGI is used (the default)
     * </pre>
     */
    public static final String SDL_HINT_JOYSTICK_WGI = "SDL_JOYSTICK_WGI";

    /**
     * Determines whether SDL enforces that DRM master is required in order
     * to initialize the KMSDRM video backend.
     *
     * <p>The DRM subsystem has a concept of a "DRM master" which is a DRM client that
     * has the ability to set planes, set cursor, etc. When SDL is DRM master, it
     * can draw to the screen using the SDL rendering APIs. Without DRM master, SDL
     * is still able to process input and query attributes of attached displays,
     * but it cannot change display state or draw to the screen directly.</p>
     *
     * <p>In some cases, it can be useful to have the KMSDRM backend even if it cannot
     * be used for rendering. An app may want to use SDL for input processing while
     * using another rendering API (such as an MMAL overlay on Raspberry Pi) or
     * using its own code to render to DRM overlays that SDL doesn't support.</p>
     *
     * <p>This hint must be set before initializing the video subsystem.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL will allow usage of the KMSDRM backend without DRM master
     * "1"       - SDL Will require DRM master to use the KMSDRM backend (default)
     * </pre>
     */
    public static final String SDL_HINT_KMSDRM_REQUIRE_DRM_MASTER = "SDL_KMSDRM_REQUIRE_DRM_MASTER";

    /**
     * A comma separated list of devices to open as joysticks
     *
     * <p>This variable is currently only used by the Linux joystick driver.</p>
     */
    public static final String SDL_HINT_JOYSTICK_DEVICE = "SDL_JOYSTICK_DEVICE";

    /**
     * A variable controlling whether joysticks on Linux will always treat 'hat' axis inputs (ABS_HAT0X - ABS_HAT3Y) as 8-way digital hats without checking whether they may be analog.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Only map hat axis inputs to digital hat outputs if the input axes appear to actually be digital (the default)
     * "1"       - Always handle the input axes numbered ABS_HAT0X to ABS_HAT3Y as digital hats
     * </pre>
     */
    public static final String SDL_HINT_LINUX_DIGITAL_HATS = "SDL_LINUX_DIGITAL_HATS";

    /**
     * A variable controlling whether digital hats on Linux will apply deadzones to their underlying input axes or use unfiltered values.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Return digital hat values based on unfiltered input axis values
     * "1"       - Return digital hat values with deadzones on the input axes taken into account (the default)
     * </pre>
     */
    public static final String SDL_HINT_LINUX_HAT_DEADZONES = "SDL_LINUX_HAT_DEADZONES";

    /**
     * A variable controlling whether to use the classic /dev/input/js* joystick interface or the newer /dev/input/event* joystick interface on Linux
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use /dev/input/event*
     * "1"       - Use /dev/input/js*
     * </pre>
     *
     * <p>By default the /dev/input/event* interfaces are used</p>
     */
    public static final String SDL_HINT_LINUX_JOYSTICK_CLASSIC = "SDL_LINUX_JOYSTICK_CLASSIC";

    /**
     * A variable controlling whether joysticks on Linux adhere to their HID-defined deadzones or return unfiltered values.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Return unfiltered joystick axis values (the default)
     * "1"       - Return axis values with deadzones taken into account
     * </pre>
     */
    public static final String SDL_HINT_LINUX_JOYSTICK_DEADZONES = "SDL_LINUX_JOYSTICK_DEADZONES";

    /**
     * When set don't force the SDL app to become a foreground process
     *
     * <p>This hint only applies to Mac OS X.</p>
     */
    public static final String SDL_HINT_MAC_BACKGROUND_APP = "SDL_MAC_BACKGROUND_APP";

    /**
     * A variable that determines whether ctrl+click should generate a right-click event on Mac
     *
     * <p>If present, holding ctrl while left clicking will generate a right click
     * event when on Mac.</p>
     */
    public static final String SDL_HINT_MAC_CTRL_CLICK_EMULATE_RIGHT_CLICK = "SDL_MAC_CTRL_CLICK_EMULATE_RIGHT_CLICK";

    /**
     * A variable controlling whether dispatching OpenGL context updates should block the dispatching thread until the main thread finishes processing
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Dispatching OpenGL context updates will block the dispatching thread until the main thread finishes processing (default).
     * "1"       - Dispatching OpenGL context updates will allow the dispatching thread to continue execution.
     * </pre>
     *
     * <p>Generally you want the default, but if you have OpenGL code in a background thread on a Mac, and the main thread
     * hangs because it's waiting for that background thread, but that background thread is also hanging because it's
     * waiting for the main thread to do an update, this might fix your issue.</p>
     *
     * <p>This hint only applies to macOS.</p>
     *
     * <p>This hint is available since SDL 2.24.0.</p>
     */
    public static final String SDL_HINT_MAC_OPENGL_ASYNC_DISPATCH = "SDL_MAC_OPENGL_ASYNC_DISPATCH";

    /**
     * A variable setting the double click radius, in pixels.
     */
    public static final String SDL_HINT_MOUSE_DOUBLE_CLICK_RADIUS = "SDL_MOUSE_DOUBLE_CLICK_RADIUS";

    /**
     * A variable setting the double click time, in milliseconds.
     */
    public static final String SDL_HINT_MOUSE_DOUBLE_CLICK_TIME = "SDL_MOUSE_DOUBLE_CLICK_TIME";

    /**
     * Allow mouse click events when clicking to focus an SDL window
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Ignore mouse clicks that activate a window
     * "1"       - Generate events for mouse clicks that activate a window
     * </pre>
     *
     * <p>By default SDL will ignore mouse clicks that activate a window</p>
     */
    public static final String SDL_HINT_MOUSE_FOCUS_CLICKTHROUGH = "SDL_MOUSE_FOCUS_CLICKTHROUGH";

    /**
     * A variable setting the speed scale for mouse motion, in floating point, when the mouse is not in relative mode
     */
    public static final String SDL_HINT_MOUSE_NORMAL_SPEED_SCALE = "SDL_MOUSE_NORMAL_SPEED_SCALE";

    /**
     * A variable controlling whether relative mouse mode constrains the mouse to the center of the window
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Relative mouse mode constrains the mouse to the window
     * "1"       - Relative mouse mode constrains the mouse to the center of the window
     * </pre>
     *
     * <p>Constraining to the center of the window works better for FPS games and when the
     * application is running over RDP. Constraining to the whole window works better
     * for 2D games and increases the chance that the mouse will be in the correct
     * position when using high DPI mice.</p>
     *
     * <p>By default SDL will constrain the mouse to the center of the window</p>
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_MODE_CENTER = "SDL_MOUSE_RELATIVE_MODE_CENTER";

    /**
     * A variable controlling whether relative mouse mode is implemented using mouse warping
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Relative mouse mode uses raw input
     * "1"       - Relative mouse mode uses mouse warping
     * </pre>
     *
     * <p>By default SDL will use raw input for relative mouse mode</p>
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_MODE_WARP = "SDL_MOUSE_RELATIVE_MODE_WARP";

    /**
     * A variable controlling whether relative mouse motion is affected by renderer scaling
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Relative motion is unaffected by DPI or renderer's logical size
     * "1"       - Relative motion is scaled according to DPI scaling and logical size
     * </pre>
     *
     * <p>By default relative mouse deltas are affected by DPI and renderer scaling</p>
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_SCALING = "SDL_MOUSE_RELATIVE_SCALING";

    /**
     * A variable setting the scale for mouse motion, in floating point, when the mouse is in relative mode
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_SPEED_SCALE = "SDL_MOUSE_RELATIVE_SPEED_SCALE";

    /**
     * A variable controlling whether the system mouse acceleration curve is used for relative mouse motion.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Relative mouse motion will be unscaled (the default)
     * "1"       - Relative mouse motion will be scaled using the system mouse acceleration curve.
     * </pre>
     *
     * <p>If SDL_HINT_MOUSE_RELATIVE_SPEED_SCALE is set, that will override the system speed scale.</p>
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_SYSTEM_SCALE = "SDL_MOUSE_RELATIVE_SYSTEM_SCALE";

    /**
     * A variable controlling whether a motion event should be generated for mouse warping in relative mode.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Warping the mouse will not generate a motion event in relative mode
     * "1"       - Warping the mouse will generate a motion event in relative mode
     * </pre>
     *
     * <p>By default warping the mouse will not generate motion events in relative mode. This avoids the application having to filter out large relative motion due to warping.</p>
     */
    public static final String SDL_HINT_MOUSE_RELATIVE_WARP_MOTION = "SDL_MOUSE_RELATIVE_WARP_MOTION";

    /**
     * A variable controlling whether mouse events should generate synthetic touch events
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Mouse events will not generate touch events (default for desktop platforms)
     * "1"       - Mouse events will generate touch events (default for mobile platforms, such as Android and iOS)
     * </pre>
     */
    public static final String SDL_HINT_MOUSE_TOUCH_EVENTS = "SDL_MOUSE_TOUCH_EVENTS";

    /**
     * A variable controlling whether the mouse is captured while mouse buttons are pressed
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - The mouse is not captured while mouse buttons are pressed
     * "1"       - The mouse is captured while mouse buttons are pressed
     * </pre>
     *
     * <p>By default the mouse is captured while mouse buttons are pressed so if the mouse is dragged
     * outside the window, the application continues to receive mouse events until the button is
     * released.</p>
     */
    public static final String SDL_HINT_MOUSE_AUTO_CAPTURE = "SDL_MOUSE_AUTO_CAPTURE";

    /**
     * Tell SDL not to catch the SIGINT or SIGTERM signals.
     *
     * <p>This hint only applies to Unix-like platforms, and should set before
     * any calls to SDL_Init()</p>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL will install a SIGINT and SIGTERM handler, and when it
     * catches a signal, convert it into an SDL_QUIT event.
     *   "1"       - SDL will not install a signal handler at all.
     * </pre>
     */
    public static final String SDL_HINT_NO_SIGNAL_HANDLERS = "SDL_NO_SIGNAL_HANDLERS";

    /**
     * A variable controlling what driver to use for OpenGL ES contexts.
     *
     * <p>On some platforms, currently Windows and X11, OpenGL drivers may support
     * creating contexts with an OpenGL ES profile. By default SDL uses these
     * profiles, when available, otherwise it attempts to load an OpenGL ES
     * library, e.g. that provided by the ANGLE project. This variable controls
     * whether SDL follows this default behaviour or will always load an
     * OpenGL ES library.</p>
     *
     * <p>Circumstances where this is useful include
     * - Testing an app with a particular OpenGL ES implementation, e.g ANGLE,
     * or emulator, e.g. those from ARM, Imagination or Qualcomm.
     * - Resolving OpenGL ES function addresses at link time by linking with
     * the OpenGL ES library instead of querying them at run time with
     * SDL_GL_GetProcAddress().</p>
     *
     * <p>Caution: for an application to work with the default behaviour across
     * different OpenGL drivers it must query the OpenGL ES function
     * addresses at run time using SDL_GL_GetProcAddress().</p>
     *
     * <p>This variable is ignored on most platforms because OpenGL ES is native
     * or not supported.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use ES profile of OpenGL, if available. (Default when not set.)
     * "1"       - Load OpenGL ES library using the default library names.
     * </pre>
     */
    public static final String SDL_HINT_OPENGL_ES_DRIVER = "SDL_OPENGL_ES_DRIVER";

    /**
     * A variable controlling which orientations are allowed on iOS/Android.
     *
     * <p>In some circumstances it is necessary to be able to explicitly control
     * which UI orientations are allowed.</p>
     *
     * <p>This variable is a space delimited list of the following values:</p>
     * <pre>
     * "LandscapeLeft"
     * "LandscapeRight"
     * "Portrait"
     * "PortraitUpsideDown"
     * </pre>
     */
    public static final String SDL_HINT_ORIENTATIONS = "SDL_IOS_ORIENTATIONS";

    /**
     * A variable controlling the use of a sentinel event when polling the event queue
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable poll sentinels
     * "1"       - Enable poll sentinels
     * </pre>
     *
     * <p>When polling for events, SDL_PumpEvents is used to gather new events from devices.
     * If a device keeps producing new events between calls to SDL_PumpEvents, a poll loop will
     * become stuck until the new events stop.
     * This is most noticeable when moving a high frequency mouse.</p>
     *
     * <p>By default, poll sentinels are enabled.</p>
     */
    public static final String SDL_HINT_POLL_SENTINEL = "SDL_POLL_SENTINEL";

    /**
     * Override for SDL_GetPreferredLocales()
     *
     * <p>If set, this will be favored over anything the OS might report for the
     * user's preferred locales. Changing this hint at runtime will not generate
     * a SDL_LOCALECHANGED event (but if you can change the hint, you can push
     * your own event, if you want).</p>
     *
     * <p>The format of this hint is a comma-separated list of language and locale,
     * combined with an underscore, as is a common format: "en_GB". Locale is
     * optional: "en". So you might have a list like this: "en_GB,jp,es_PT"</p>
     */
    public static final String SDL_HINT_PREFERRED_LOCALES = "SDL_PREFERRED_LOCALES";

    /**
     * A variable describing the content orientation on QtWayland-based platforms.
     *
     * <p>On QtWayland platforms, windows are rotated client-side to allow for custom
     * transitions. In order to correctly position overlays (e.g. volume bar) and
     * gestures (e.g. events view, close/minimize gestures), the system needs to
     * know in which orientation the application is currently drawing its contents.</p>
     *
     * <p>This does not cause the window to be rotated or resized, the application
     * needs to take care of drawing the content in the right orientation (the
     * framebuffer is always in portrait mode).</p>
     *
     * <p>This variable can be one of the following values:</p>
     * <pre>
     * "primary" (default)
     * "portrait"
     * "landscape"
     * "inverted-portrait"
     * "inverted-landscape"
     * </pre>
     *
     * <p>Since SDL 2.0.22 this variable accepts a comma-separated list of values above.</p>
     */
    public static final String SDL_HINT_QTWAYLAND_CONTENT_ORIENTATION = "SDL_QTWAYLAND_CONTENT_ORIENTATION";

    /**
     * Flags to set on QtWayland windows to integrate with the native window manager.
     *
     * <p>On QtWayland platforms, this hint controls the flags to set on the windows.
     * For example, on Sailfish OS "OverridesSystemGestures" disables swipe gestures.</p>
     *
     * <p>This variable is a space-separated list of the following values (empty = no flags):</p>
     * <pre>
     * "OverridesSystemGestures"
     * "StaysOnTop"
     * "BypassWindowManager"
     * </pre>
     */
    public static final String SDL_HINT_QTWAYLAND_WINDOW_FLAGS = "SDL_QTWAYLAND_WINDOW_FLAGS";

    /**
     * A variable controlling whether the 2D render API is compatible or efficient.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"     - Don't use batching to make rendering more efficient.
     * "1"     - Use batching, but might cause problems if app makes its own direct OpenGL calls.
     * </pre>
     *
     * <p>Up to SDL 2.0.9, the render API would draw immediately when requested. Now
     * it batches up draw requests and sends them all to the GPU only when forced
     * to (during SDL_RenderPresent, when changing render targets, by updating a
     * texture that the batch needs, etc). This is significantly more efficient,
     * but it can cause problems for apps that expect to render on top of the
     * render API's output. As such, SDL will disable batching if a specific
     * render backend is requested (since this might indicate that the app is
     * planning to use the underlying graphics API directly). This hint can
     * be used to explicitly request batching in this instance. It is a contract
     * that you will either never use the underlying graphics API directly, or
     * if you do, you will call SDL_RenderFlush() before you do so any current
     * batch goes to the GPU before your work begins. Not following this contract
     * will result in undefined behavior.</p>
     */
    public static final String SDL_HINT_RENDER_BATCHING = "SDL_RENDER_BATCHING";

    /**
     * A variable controlling how the 2D render API renders lines
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"     - Use the default line drawing method (Bresenham's line algorithm as of SDL 2.0.20)
     * "1"     - Use the driver point API using Bresenham's line algorithm (correct, draws many points)
     * "2"     - Use the driver line API (occasionally misses line endpoints based on hardware driver quirks, was the default before 2.0.20)
     * "3"     - Use the driver geometry API (correct, draws thicker diagonal lines)
     * </pre>
     *
     * <p>This variable should be set when the renderer is created.</p>
     */
    public static final String SDL_HINT_RENDER_LINE_METHOD = "SDL_RENDER_LINE_METHOD";

    /**
     * A variable controlling whether to enable Direct3D 11+'s Debug Layer.
     *
     * <p>This variable does not have any effect on the Direct3D 9 based renderer.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable Debug Layer use
     * "1"       - Enable Debug Layer use
     * </pre>
     *
     * <p>By default, SDL does not use Direct3D Debug Layer.</p>
     */
    public static final String SDL_HINT_RENDER_DIRECT3D11_DEBUG = "SDL_RENDER_DIRECT3D11_DEBUG";

    /**
     * A variable controlling whether the Direct3D device is initialized for thread-safe operations.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Thread-safety is not enabled (faster)
     * "1"       - Thread-safety is enabled
     * </pre>
     *
     * <p>By default the Direct3D device is created with thread-safety disabled.</p>
     */
    public static final String SDL_HINT_RENDER_DIRECT3D_THREADSAFE = "SDL_RENDER_DIRECT3D_THREADSAFE";

    /**
     * A variable specifying which render driver to use.
     *
     * <p>If the application doesn't pick a specific renderer to use, this variable
     * specifies the name of the preferred renderer.  If the preferred renderer
     * can't be initialized, the normal default renderer is used.</p>
     *
     * <p>This variable is case insensitive and can be set to the following values:</p>
     * <pre>
     * "direct3d"
     * "direct3d11"
     * "direct3d12"
     * "opengl"
     * "opengles2"
     * "opengles"
     * "metal"
     * "software"
     * </pre>
     *
     * <p>The default varies by platform, but it's the first one in the list that
     * is available on the current platform.</p>
     */
    public static final String SDL_HINT_RENDER_DRIVER = "SDL_RENDER_DRIVER";

    /**
     * A variable controlling the scaling policy for SDL_RenderSetLogicalSize.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" or "letterbox" - Uses letterbox/sidebars to fit the entire rendering on screen
     * "1" or "overscan"  - Will zoom the rendering so it fills the entire screen, allowing edges to be drawn offscreen
     * </pre>
     *
     * <p>By default letterbox is used</p>
     */
    public static final String SDL_HINT_RENDER_LOGICAL_SIZE_MODE = "SDL_RENDER_LOGICAL_SIZE_MODE";

    /**
     * A variable controlling whether the OpenGL render driver uses shaders if they are available.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable shaders
     * "1"       - Enable shaders
     * </pre>
     *
     * <p>By default shaders are used if OpenGL supports them.</p>
     */
    public static final String SDL_HINT_RENDER_OPENGL_SHADERS = "SDL_RENDER_OPENGL_SHADERS";

    /**
     * A variable controlling the scaling quality
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" or "nearest" - Nearest pixel sampling
     * "1" or "linear"  - Linear filtering (supported by OpenGL and Direct3D)
     * "2" or "best"    - Currently this is the same as "linear"
     * </pre>
     *
     * <p>By default nearest pixel sampling is used</p>
     */
    public static final String SDL_HINT_RENDER_SCALE_QUALITY = "SDL_RENDER_SCALE_QUALITY";

    /**
     * A variable controlling whether updates to the SDL screen surface should be synchronized with the vertical refresh, to avoid tearing.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable vsync
     * "1"       - Enable vsync
     * </pre>
     *
     * <p>By default SDL does not sync screen surface updates with vertical refresh.</p>
     */
    public static final String SDL_HINT_RENDER_VSYNC = "SDL_RENDER_VSYNC";

    /**
     * A variable controlling whether the Metal render driver select low power device over default one
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use the prefered OS device
     * "1"       - Select a low power one
     * </pre>
     *
     * <p>By default the preferred OS device is used.</p>
     */
    public static final String SDL_HINT_RENDER_METAL_PREFER_LOW_POWER_DEVICE = "SDL_RENDER_METAL_PREFER_LOW_POWER_DEVICE";

    /**
     * A variable controlling if VSYNC is automatically disable if doesn't reach the enough FPS
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - It will be using VSYNC as defined in the main flag. Default
     * "1"       - If VSYNC was previously enabled, then it will disable VSYNC if doesn't reach enough speed
     * </pre>
     *
     * <p>By default SDL does not enable the automatic VSYNC</p>
     */
    public static final String SDL_HINT_PS2_DYNAMIC_VSYNC = "SDL_PS2_DYNAMIC_VSYNC";

    /**
     * A variable to control whether the return key on the soft keyboard
     * should hide the soft keyboard on Android and iOS.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - The return key will be handled as a key event.
     *             This is the behaviour of SDL 2.0.3 and older. (default)
     * "1"       - The return key will hide the keyboard.
     * </pre>
     *
     * <p>The value of this hint is used at runtime, so it can be changed at any time.</p>
     */
    public static final String SDL_HINT_RETURN_KEY_HIDES_IME = "SDL_RETURN_KEY_HIDES_IME";

    /**
     * Tell SDL which Dispmanx layer to use on a Raspberry PI
     *
     * <p>Also known as Z-order. The variable can take a negative or positive value.
     * The default is 10000.</p>
     */
    public static final String SDL_HINT_RPI_VIDEO_LAYER = "SDL_RPI_VIDEO_LAYER";

    /**
     * Specify an "activity name" for screensaver inhibition.
     *
     * <p>Some platforms, notably Linux desktops, list the applications which are
     * inhibiting the screensaver or other power-saving features.</p>
     *
     * <p>This hint lets you specify the "activity name" sent to the OS when
     * SDL_DisableScreenSaver() is used (or the screensaver is automatically
     * disabled). The contents of this hint are used when the screensaver is
     * disabled. You should use a string that describes what your program is doing
     * (and, therefore, why the screensaver is disabled).  For example, "Playing a
     * game" or "Watching a video".</p>
     *
     * <p>Setting this to "" or leaving it unset will have SDL use a reasonable
     * default: "Playing a game" or something similar.</p>
     *
     * <p>On targets where this is not supported, this hint does nothing.</p>
     */
    public static final String SDL_HINT_SCREENSAVER_INHIBIT_ACTIVITY_NAME = "SDL_SCREENSAVER_INHIBIT_ACTIVITY_NAME";

    /**
     * Specifies whether SDL_THREAD_PRIORITY_TIME_CRITICAL should be treated as realtime.
     *
     * <p>On some platforms, like Linux, a realtime priority thread may be subject to restrictions
     * that require special handling by the application. This hint exists to let SDL know that
     * the app is prepared to handle said restrictions.</p>
     *
     * <p>On Linux, SDL will apply the following configuration to any thread that becomes realtime:
     * <ul>
     *     <li>The SCHED_RESET_ON_FORK bit will be set on the scheduling policy,</li>
     *     <li>An RLIMIT_RTTIME budget will be configured to the rtkit specified limit.
     *         Exceeding this limit will result in the kernel sending SIGKILL to the app.
     *         Refer to the man pages for more information.</li>
     * </ul>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - default platform specific behaviour
     * "1"       - Force SDL_THREAD_PRIORITY_TIME_CRITICAL to a realtime scheduling policy
     * </pre>
     */
    public static final String SDL_HINT_THREAD_FORCE_REALTIME_TIME_CRITICAL = "SDL_THREAD_FORCE_REALTIME_TIME_CRITICAL";

    /**
     * A string specifying additional information to use with SDL_SetThreadPriority.
     *
     * <p>By default SDL_SetThreadPriority will make appropriate system changes in order to
     * apply a thread priority.  For example on systems using pthreads the scheduler policy
     * is changed automatically to a policy that works well with a given priority.
     * Code which has specific requirements can override SDL's default behavior with this hint.</p>
     *
     * pthread hint values are "current", "other", "fifo" and "rr".
     * Currently no other platform hint values are defined but may be in the future.
     *
     * <p><b>Note:</b> On Linux, the kernel may send SIGKILL to realtime tasks which exceed the distro
     * configured execution budget for rtkit. This budget can be queried through RLIMIT_RTTIME
     * after calling SDL_SetThreadPriority().</p>
     */
    public static final String SDL_HINT_THREAD_PRIORITY_POLICY = "SDL_THREAD_PRIORITY_POLICY";

    /**
     * A string specifying SDL's threads stack size in bytes or "0" for the backend's default size
     *
     * <p>Use this hint in case you need to set SDL's threads stack size to other than the default.
     * This is specially useful if you build SDL against a non glibc libc library (such as musl) which
     * provides a relatively small default thread stack size (a few kilobytes versus the default 8MB glibc uses).
     * Support for this hint is currently available only in the pthread, Windows, and PSP backend.</p>
     *
     * Instead of this hint, in 2.0.9 and later, you can use
     * SDL_CreateThreadWithStackSize(). This hint only works with the classic
     * SDL_CreateThread().
     */
    public static final String SDL_HINT_THREAD_STACK_SIZE = "SDL_THREAD_STACK_SIZE";

    /**
     * A variable that controls the timer resolution, in milliseconds.
     *
     * <p>The higher resolution the timer, the more frequently the CPU services
     * timer interrupts, and the more precise delays are, but this takes up
     * power and CPU time.  This hint is only used on Windows.</p>
     *
     * <p>See this blog post for more information:
     * http://randomascii.wordpress.com/2013/07/08/windows-timer-resolution-megawatts-wasted/</p>
     *
     * <p>If this variable is set to "0", the system timer resolution is not set.</p>
     *
     * <p>The default value is "1". This hint may be set at any time.</p>
     */
    public static final String SDL_HINT_TIMER_RESOLUTION = "SDL_TIMER_RESOLUTION";

    /**
     * A variable controlling whether touch events should generate synthetic mouse events
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Touch events will not generate mouse events
     * "1"       - Touch events will generate mouse events
     * </pre>
     *
     * <p>By default SDL will generate mouse events for touch events</p>
     */
    public static final String SDL_HINT_TOUCH_MOUSE_EVENTS = "SDL_TOUCH_MOUSE_EVENTS";

    /**
     * A variable controlling which touchpad should generate synthetic mouse events
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Only front touchpad should generate mouse events. Default
     * "1"       - Only back touchpad should generate mouse events.
     * "2"       - Both touchpads should generate mouse events.
     * </pre>
     *
     * <p>By default SDL will generate mouse events for all touch devices</p>
     */
    public static final String SDL_HINT_VITA_TOUCH_MOUSE_DEVICE = "SDL_HINT_VITA_TOUCH_MOUSE_DEVICE";

    /**
     * A variable controlling whether the Android / tvOS remotes
     * should be listed as joystick devices, instead of sending keyboard events.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Remotes send enter/escape/arrow key events
     * "1"       - Remotes are available as 2 axis, 2 button joysticks (the default).
     * </pre>
     */
    public static final String SDL_HINT_TV_REMOTE_AS_JOYSTICK = "SDL_TV_REMOTE_AS_JOYSTICK";

    /**
     * A variable controlling whether the screensaver is enabled.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable screensaver
     * "1"       - Enable screensaver
     * </pre>
     *
     * <p>By default SDL will disable the screensaver.</p>
     */
    public static final String SDL_HINT_VIDEO_ALLOW_SCREENSAVER = "SDL_VIDEO_ALLOW_SCREENSAVER";

    /**
     * Tell the video driver that we only want a double buffer.
     *
     * <p>By default, most lowlevel 2D APIs will use a triple buffer scheme that
     * wastes no CPU time on waiting for vsync after issuing a flip, but
     * introduces a frame of latency. On the other hand, using a double buffer
     * scheme instead is recommended for cases where low latency is an important
     * factor because we save a whole frame of latency.
     * We do so by waiting for vsync immediately after issuing a flip, usually just
     * after eglSwapBuffers call in the backend's *_SwapWindow function.</p>
     *
     * <p>Since it's driver-specific, it's only supported where possible and
     * implemented. Currently supported the following drivers:</p>
     * <ul>
     *     <li>KMS/DRM (kmsdrm)</li>
     *     <li>Raspberry Pi (raspberrypi)</li>
     * </ul>
     */
    public static final String SDL_HINT_VIDEO_DOUBLE_BUFFER = "SDL_VIDEO_DOUBLE_BUFFER";

    /**
     * A variable controlling whether the EGL window is allowed to be
     * composited as transparent, rather than opaque.
     *
     * <p>Most window systems will always render windows opaque, even if the surface
     * format has an alpha channel. This is not always true, however, so by default
     * SDL will try to enforce opaque composition. To override this behavior, you
     * can set this hint to "1".</p>
     */
    public static final String SDL_HINT_VIDEO_EGL_ALLOW_TRANSPARENCY = "SDL_VIDEO_EGL_ALLOW_TRANSPARENCY";

    /**
     * A variable controlling whether the graphics context is externally managed.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"         - SDL will manage graphics contexts that are attached to windows.
     * "1"         - Disable graphics context management on windows.
     * </pre>
     *
     * <p>By default SDL will manage OpenGL contexts in certain situations. For example, on Android the
     * context will be automatically saved and restored when pausing the application. Additionally, some
     * platforms will assume usage of OpenGL if Vulkan isn't used. Setting this to "1" will prevent this
     * behavior, which is desireable when the application manages the graphics context, such as
     * an externally managed OpenGL context or attaching a Vulkan surface to the window.</p>
     */
    public static final String SDL_HINT_VIDEO_EXTERNAL_CONTEXT = "SDL_VIDEO_EXTERNAL_CONTEXT";

    /**
     * If set to 1, then do not allow high-DPI windows. ("Retina" on Mac and iOS)
     */
    public static final String SDL_HINT_VIDEO_HIGHDPI_DISABLED = "SDL_VIDEO_HIGHDPI_DISABLED";

    /**
     * A variable that dictates policy for fullscreen Spaces on Mac OS X.
     *
     * <p>This hint only applies to Mac OS X.</p>
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable Spaces support (FULLSCREEN_DESKTOP won't use them and
     *             SDL_WINDOW_RESIZABLE windows won't offer the "fullscreen"
     *             button on their titlebars).
     * "1"       - Enable Spaces support (FULLSCREEN_DESKTOP will use them and
     *             SDL_WINDOW_RESIZABLE windows will offer the "fullscreen"
     *             button on their titlebars).
     * </pre>
     *
     * <p>The default value is "1". This hint must be set before any windows are created.</p>
     */
    public static final String SDL_HINT_VIDEO_MAC_FULLSCREEN_SPACES = "SDL_VIDEO_MAC_FULLSCREEN_SPACES";

    /**
     * Minimize your SDL_Window if it loses key focus when in fullscreen mode. Defaults to false.
     *
     * <strong>Warning: Before SDL 2.0.14, this defaulted to true! In 2.0.14, we're
     * seeing if "true" causes more problems than it solves in modern times.</strong>
     */
    public static final String SDL_HINT_VIDEO_MINIMIZE_ON_FOCUS_LOSS = "SDL_VIDEO_MINIMIZE_ON_FOCUS_LOSS";

    /**
     * A variable controlling whether the libdecor Wayland backend is allowed to be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - libdecor use is disabled.
     * "1"       - libdecor use is enabled (default).
     * </pre>
     *
     * <p>libdecor is used over xdg-shell when xdg-decoration protocol is unavailable.</p>
     */
    public static final String SDL_HINT_VIDEO_WAYLAND_ALLOW_LIBDECOR = "SDL_VIDEO_WAYLAND_ALLOW_LIBDECOR";

    /**
     * A variable controlling whether the libdecor Wayland backend is preferred over native decrations.
     *
     * <p>When this hint is set, libdecor will be used to provide window decorations, even if xdg-decoration is
     * available. (Note that, by default, libdecor will use xdg-decoration itself if available).</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - libdecor is enabled only if server-side decorations are unavailable.
     * "1"       - libdecor is always enabled if available.
     * </pre>
     *
     * <p>libdecor is used over xdg-shell when xdg-decoration protocol is unavailable.</p>
     */
    public static final String SDL_HINT_VIDEO_WAYLAND_PREFER_LIBDECOR = "SDL_VIDEO_WAYLAND_PREFER_LIBDECOR";

    /**
     * A variable controlling whether video mode emulation is enabled under Wayland.
     *
     * <p>When this hint is set, a standard set of emulated CVT video modes will be exposed for use by the application.
     * If it is disabled, the only modes exposed will be the logical desktop size and, in the case of a scaled
     * desktop, the native display resolution.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Video mode emulation is disabled.
     * "1"       - Video mode emulation is enabled.
     * </pre>
     *
     * <p>By default video mode emulation is enabled.</p>
     */
    public static final String SDL_HINT_VIDEO_WAYLAND_MODE_EMULATION = "SDL_VIDEO_WAYLAND_MODE_EMULATION";

    /**
     * Enable or disable mouse pointer warp emulation, needed by some older games.
     *
     * <p>When this hint is set, any SDL will emulate mouse warps using relative mouse mode.
     * This is required for some older games (such as Source engine games), which warp the
     * mouse to the centre of the screen rather than using relative mouse motion. Note that
     * relative mouse mode may have different mouse acceleration behaviour than pointer warps.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - All mouse warps fail, as mouse warping is not available under wayland.
     * "1"       - Some mouse warps will be emulated by forcing relative mouse mode.
     * </pre>
     *
     * <p>If not set, this is automatically enabled unless an application uses relative mouse
     * mode directly.</p>
     */
    public static final String SDL_HINT_VIDEO_WAYLAND_EMULATE_MOUSE_WARP = "SDL_VIDEO_WAYLAND_EMULATE_MOUSE_WARP";

    /**
     * A variable that is the address of another SDL_Window* (as a hex string formatted with "%p").
     *
     * <p>If this hint is set before SDL_CreateWindowFrom() and the SDL_Window* it is set to has
     * SDL_WINDOW_OPENGL set (and running on WGL only, currently), then two things will occur on the newly
     * created SDL_Window:</p>
     *
     * <ol>
     *    <li>Its pixel format will be set to the same pixel format as this SDL_Window.  This is
     *        needed for example when sharing an OpenGL context across multiple windows.</li>
     *    <li>The flag SDL_WINDOW_OPENGL will be set on the new window so it can be used for
     *        OpenGL rendering.</li>
     * </ol>
     *
     * <p>This variable can be set to the following values:</p>
     * <p>The address (as a string "%p") of the SDL_Window* that new windows created with SDL_CreateWindowFrom() should
     *    share a pixel format with.</p>
     */
    public static final String SDL_HINT_VIDEO_WINDOW_SHARE_PIXEL_FORMAT = "SDL_VIDEO_WINDOW_SHARE_PIXEL_FORMAT";

    /**
     * When calling SDL_CreateWindowFrom(), make the window compatible with OpenGL.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" - Don't add any graphics flags to the SDL_WindowFlags
     * "1" - Add SDL_WINDOW_OPENGL to the SDL_WindowFlags
     * </pre>
     *
     * <p>By default SDL will not make the foreign window compatible with OpenGL.</p>
     */
    public static final String SDL_HINT_VIDEO_FOREIGN_WINDOW_OPENGL = "SDL_VIDEO_FOREIGN_WINDOW_OPENGL";

    /**
     * When calling SDL_CreateWindowFrom(), make the window compatible with Vulkan.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" - Don't add any graphics flags to the SDL_WindowFlags
     * "1" - Add SDL_WINDOW_VULKAN to the SDL_WindowFlags
     * </pre>
     *
     * <p>By default SDL will not make the foreign window compatible with Vulkan.</p>
     */
    public static final String SDL_HINT_VIDEO_FOREIGN_WINDOW_VULKAN = "SDL_VIDEO_FOREIGN_WINDOW_VULKAN";

    /**
     * A variable specifying which shader compiler to preload when using the Chrome ANGLE binaries
     *
     * <p>SDL has EGL and OpenGL ES2 support on Windows via the ANGLE project. It
     * can use two different sets of binaries, those compiled by the user from source
     * or those provided by the Chrome browser. In the later case, these binaries require
     * that SDL loads a DLL providing the shader compiler.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "d3dcompiler_46.dll" - default, best for Vista or later.
     * "d3dcompiler_43.dll" - for XP support.
     * "none" - do not load any library, useful if you compiled ANGLE from source and included the compiler in your binaries.
     * </pre>
     */
    public static final String SDL_HINT_VIDEO_WIN_D3DCOMPILER = "SDL_VIDEO_WIN_D3DCOMPILER";

    /**
     * A variable controlling whether X11 should use GLX or EGL by default
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" - Use GLX
     * "1" - Use EGL
     * </pre>
     *
     * <p>By default SDL will use GLX when both are present.</p>
     */
    public static final String SDL_HINT_VIDEO_X11_FORCE_EGL = "SDL_VIDEO_X11_FORCE_EGL";

    /**
     * A variable controlling whether the X11 _NET_WM_BYPASS_COMPOSITOR hint should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0" - Disable _NET_WM_BYPASS_COMPOSITOR
     * "1" - Enable _NET_WM_BYPASS_COMPOSITOR
     * </pre>
     *
     * <p>By default SDL will use _NET_WM_BYPASS_COMPOSITOR</p>
     */
    public static final String SDL_HINT_VIDEO_X11_NET_WM_BYPASS_COMPOSITOR = "SDL_VIDEO_X11_NET_WM_BYPASS_COMPOSITOR";

    /**
     * A variable controlling whether the X11 _NET_WM_PING protocol should be supported.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable _NET_WM_PING
     * "1"       - Enable _NET_WM_PING
     * </pre>
     *
     * <p>By default SDL will use _NET_WM_PING, but for applications that know they
     * will not always be able to respond to ping requests in a timely manner they can
     * turn it off to avoid the window manager thinking the app is hung.
     * The hint is checked in CreateWindow.</p>
     */
    public static final String SDL_HINT_VIDEO_X11_NET_WM_PING = "SDL_VIDEO_X11_NET_WM_PING";

    /**
     * A variable forcing the visual ID chosen for new X11 windows
     */
    public static final String SDL_HINT_VIDEO_X11_WINDOW_VISUALID = "SDL_VIDEO_X11_WINDOW_VISUALID";

    /**
     * A no-longer-used variable controlling whether the X11 Xinerama extension should be used.
     *
     * <p>Before SDL 2.0.24, this would let apps and users disable Xinerama support on X11.
     * Now SDL never uses Xinerama, and does not check for this hint at all.
     * The preprocessor define is left here for source compatibility.</p>
     */
    public static final String SDL_HINT_VIDEO_X11_XINERAMA = "SDL_VIDEO_X11_XINERAMA";

    /**
     * A variable controlling whether the X11 XRandR extension should be used.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable XRandR
     * "1"       - Enable XRandR
     * </pre>
     *
     * <p>By default SDL will use XRandR.</p>
     */
    public static final String SDL_HINT_VIDEO_X11_XRANDR = "SDL_VIDEO_X11_XRANDR";

    /**
     * A no-longer-used variable controlling whether the X11 VidMode extension should be used.
     *
     * <p>Before SDL 2.0.24, this would let apps and users disable XVidMode support on X11.
     * Now SDL never uses XVidMode, and does not check for this hint at all.
     * The preprocessor define is left here for source compatibility.</p>
     */
    public static final String SDL_HINT_VIDEO_X11_XVIDMODE = "SDL_VIDEO_X11_XVIDMODE";

    /**
     * Controls how the fact chunk affects the loading of a WAVE file.
     *
     * <p>The fact chunk stores information about the number of samples of a WAVE
     * file. The Standards Update from Microsoft notes that this value can be used
     * to 'determine the length of the data in seconds'. This is especially useful
     * for compressed formats (for which this is a mandatory chunk) if they produce
     * multiple sample frames per block and truncating the block is not allowed.
     * The fact chunk can exactly specify how many sample frames there should be
     * in this case.</p>
     *
     * <p>Unfortunately, most application seem to ignore the fact chunk and so SDL
     * ignores it by default as well.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "truncate"    - Use the number of samples to truncate the wave data if
     *                 the fact chunk is present and valid
     * "strict"      - Like "truncate", but raise an error if the fact chunk
     *                 is invalid, not present for non-PCM formats, or if the
     *                 data chunk doesn't have that many samples
     * "ignorezero"  - Like "truncate", but ignore fact chunk if the number of
     *                 samples is zero
     * "ignore"      - Ignore fact chunk entirely (default)
     * </pre>
     */
    public static final String SDL_HINT_WAVE_FACT_CHUNK = "SDL_WAVE_FACT_CHUNK";

    /**
     * Controls how the size of the RIFF chunk affects the loading of a WAVE file.
     *
     * <p>The size of the RIFF chunk (which includes all the sub-chunks of the WAVE
     * file) is not always reliable. In case the size is wrong, it's possible to
     * just ignore it and step through the chunks until a fixed limit is reached.</p>
     *
     * <p>Note that files that have trailing data unrelated to the WAVE file or
     * corrupt files may slow down the loading process without a reliable boundary.
     * By default, SDL stops after 10000 chunks to prevent wasting time. Use the
     * environment variable SDL_WAVE_CHUNK_LIMIT to adjust this value.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "force"        - Always use the RIFF chunk size as a boundary for the chunk search
     * "ignorezero"   - Like "force", but a zero size searches up to 4 GiB (default)
     * "ignore"       - Ignore the RIFF chunk size and always search up to 4 GiB
     * "maximum"      - Search for chunks until the end of file (not recommended)
     * </pre>
     */
    public static final String SDL_HINT_WAVE_RIFF_CHUNK_SIZE = "SDL_WAVE_RIFF_CHUNK_SIZE";

    /**
     * Controls how a truncated WAVE file is handled.
     *
     * <p>A WAVE file is considered truncated if any of the chunks are incomplete or
     * the data chunk size is not a multiple of the block size. By default, SDL
     * decodes until the first incomplete block, as most applications seem to do.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "verystrict" - Raise an error if the file is truncated
     * "strict"     - Like "verystrict", but the size of the RIFF chunk is ignored
     * "dropframe"  - Decode until the first incomplete sample frame
     * "dropblock"  - Decode until the first incomplete block (default)
     * </pre>
     */
    public static final String SDL_HINT_WAVE_TRUNCATION = "SDL_WAVE_TRUNCATION";

    /**
     * Tell SDL not to name threads on Windows with the 0x406D1388 Exception.
     * The 0x406D1388 Exception is a trick used to inform Visual Studio of a
     * thread's name, but it tends to cause problems with other debuggers,
     * and the .NET runtime. Note that SDL 2.0.6 and later will still use
     * the (safer) SetThreadDescription API, introduced in the Windows 10
     * Creators Update, if available.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL will raise the 0x406D1388 Exception to name threads.
     *             This is the default behavior of SDL 2.0.4 and older.
     * "1"       - SDL will not raise this exception, and threads will be unnamed. (default)
     *             This is necessary with .NET languages or debuggers that aren't Visual Studio.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_DISABLE_THREAD_NAMING = "SDL_WINDOWS_DISABLE_THREAD_NAMING";

    /**
     * Controls whether menus can be opened with their keyboard shortcut (Alt+mnemonic).
     *
     * <p>If the mnemonics are enabled, then menus can be opened by pressing the Alt
     * key and the corresponding mnemonic (for example, Alt+F opens the File menu).
     * However, in case an invalid mnemonic is pressed, Windows makes an audible
     * beep to convey that nothing happened. This is true even if the window has
     * no menu at all!</p>
     *
     * <p>Because most SDL applications don't have menus, and some want to use the Alt
     * key for other purposes, SDL disables mnemonics (and the beeping) by default.</p>
     *
     * <p>Note: This also affects keyboard events: with mnemonics enabled, when a
     * menu is opened from the keyboard, you will not receive a KEYUP event for
     * the mnemonic key, and *might* not receive one for Alt.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Alt+mnemonic does nothing, no beeping. (default)
     * "1"       - Alt+mnemonic opens menus, invalid mnemonics produce a beep.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_ENABLE_MENU_MNEMONICS = "SDL_WINDOWS_ENABLE_MENU_MNEMONICS";

    /**
     * A variable controlling whether the windows message loop is processed by SDL
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - The window message loop is not run
     * "1"       - The window message loop is processed in SDL_PumpEvents()
     * </pre>
     *
     * <p>By default SDL will process the windows message loop</p>
     */
    public static final String SDL_HINT_WINDOWS_ENABLE_MESSAGELOOP = "SDL_WINDOWS_ENABLE_MESSAGELOOP";

    /**
     * Force SDL to use Critical Sections for mutexes on Windows.
     * On Windows 7 and newer, Slim Reader/Writer Locks are available.
     * They offer better performance, allocate no kernel ressources and
     * use less memory. SDL will fall back to Critical Sections on older
     * OS versions or if forced to by this hint.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use SRW Locks when available. If not, fall back to Critical Sections. (default)
     * "1"       - Force the use of Critical Sections in all cases.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_FORCE_MUTEX_CRITICAL_SECTIONS = "SDL_WINDOWS_FORCE_MUTEX_CRITICAL_SECTIONS";

    /**
     * Force SDL to use Kernel Semaphores on Windows.
     * Kernel Semaphores are inter-process and require a context
     * switch on every interaction. On Windows 8 and newer, the
     * WaitOnAddress API is available. Using that and atomics to
     * implement semaphores increases performance.
     * SDL will fall back to Kernel Objects on older OS versions
     * or if forced to by this hint.
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use Atomics and WaitOnAddress API when available. If not, fall back to Kernel Objects. (default)
     * "1"       - Force the use of Kernel Objects in all cases.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_FORCE_SEMAPHORE_KERNEL = "SDL_WINDOWS_FORCE_SEMAPHORE_KERNEL";

    /**
     * A variable to specify custom icon resource id from RC file on Windows platform
     */
    public static final String SDL_HINT_WINDOWS_INTRESOURCE_ICON = "SDL_WINDOWS_INTRESOURCE_ICON";
    public static final String SDL_HINT_WINDOWS_INTRESOURCE_ICON_SMALL = "SDL_WINDOWS_INTRESOURCE_ICON_SMALL";

    /**
     * Tell SDL not to generate window-close events for Alt+F4 on Windows.
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL will generate a window-close event when it sees Alt+F4.
     * "1"       - SDL will only do normal key handling for Alt+F4.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_NO_CLOSE_ON_ALT_F4 = "SDL_WINDOWS_NO_CLOSE_ON_ALT_F4";

    /**
     * Use the D3D9Ex API introduced in Windows Vista, instead of normal D3D9.
     * Direct3D 9Ex contains changes to state management that can eliminate device
     * loss errors during scenarios like Alt+Tab or UAC prompts. D3D9Ex may require
     * some changes to your application to cope with the new behavior, so this
     * is disabled by default.
     *
     * <p>This hint must be set before initializing the video subsystem.</p>
     *
     * <p>For more information on Direct3D 9Ex, see:
     * - https://docs.microsoft.com/en-us/windows/win32/direct3darticles/graphics-apis-in-windows-vista#direct3d-9ex
     * - https://docs.microsoft.com/en-us/windows/win32/direct3darticles/direct3d-9ex-improvements</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - Use the original Direct3D 9 API (default)
     * "1"       - Use the Direct3D 9Ex API on Vista and later (and fall back if D3D9Ex is unavailable)
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_USE_D3D9EX = "SDL_WINDOWS_USE_D3D9EX";

    /**
     * Controls whether SDL will declare the process to be DPI aware.
     *
     * <p>This hint must be set before initializing the video subsystem.</p>
     *
     * <p>The main purpose of declaring DPI awareness is to disable OS bitmap scaling of SDL windows on monitors with
     * a DPI scale factor.</p>
     *
     * <p>This hint is equivalent to requesting DPI awareness via external means (e.g. calling SetProcessDpiAwarenessContext)
     * and does not cause SDL to use a virtualized coordinate system, so it will generally give you 1 SDL coordinate = 1 pixel
     * even on high-DPI displays.</p>
     *
     * <p>For more information, see:
     * https://docs.microsoft.com/en-us/windows/win32/hidpi/high-dpi-desktop-application-development-on-windows</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * ""             - Do not change the DPI awareness (default).
     * "unaware"      - Declare the process as DPI unaware. (Windows 8.1 and later).
     * "system"       - Request system DPI awareness. (Vista and later).
     * "permonitor"   - Request per-monitor DPI awareness. (Windows 8.1 and later).
     * "permonitorv2" - Request per-monitor V2 DPI awareness. (Windows 10, version 1607 and later).
     *                  The most visible difference from "permonitor" is that window title bar will be scaled
     *                  to the visually correct size when dragging between monitors with different scale factors.
     *                  This is the preferred DPI awareness level.
     * </pre>
     *
     * <p>If the requested DPI awareness is not available on the currently running OS, SDL will try to request the best
     * available match.</p>
     */
    public static final String SDL_HINT_WINDOWS_DPI_AWARENESS = "SDL_WINDOWS_DPI_AWARENESS";

    /**
     * Uses DPI-scaled points as the SDL coordinate system on Windows.
     *
     * <p>This changes the SDL coordinate system units to be DPI-scaled points, rather than pixels everywhere.
     * This means windows will be appropriately sized, even when created on high-DPI displays with scaling.</p>
     *
     * <p>e.g. requesting a 640x480 window from SDL, on a display with 125% scaling in Windows display settings,
     * will create a window with an 800x600 client area (in pixels).</p>
     *
     * <p>Setting this to "1" implicitly requests process DPI awareness (setting SDL_WINDOWS_DPI_AWARENESS is unnecessary),
     * and forces SDL_WINDOW_ALLOW_HIGHDPI on all windows.</p>
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - SDL coordinates equal Windows coordinates. No automatic window resizing when dragging
     *             between monitors with different scale factors (unless this is performed by
     *             Windows itself, which is the case when the process is DPI unaware).
     * "1"       - SDL coordinates are in DPI-scaled points. Automatically resize windows as needed on
     *             displays with non-100% scale factors.
     * </pre>
     */
    public static final String SDL_HINT_WINDOWS_DPI_SCALING = "SDL_WINDOWS_DPI_SCALING";

    /**
     * A variable controlling whether the window frame and title bar are interactive when the cursor is hidden
     *
     * <p>This variable can be set to the following values:</p>
     * <pre>
     * "0"       - The window frame is not interactive when the cursor is hidden (no move, resize, etc)
     * "1"       - The window frame is interactive when the cursor is hidden
     * </pre>
     *
     * <p>By default SDL will allow interaction with the window frame when the cursor is hidden</p>
     */
    public static final String SDL_HINT_WINDOW_FRAME_USABLE_WHILE_CURSOR_HIDDEN = "SDL_WINDOW_FRAME_USABLE_WHILE_CURSOR_HIDDEN";

    /**
     * A variable controlling whether the window is activated when the SDL_ShowWindow function is called
     *
     * <p>This variable can be set to the following values:
     * <pre>
     * "0"       - The window is activated when the SDL_ShowWindow function is called
     * "1"       - The window is not activated when the SDL_ShowWindow function is called
     * </pre>
     *
     * By default SDL will activate the window when the SDL_ShowWindow function is called
     */
    public static final String SDL_HINT_WINDOW_NO_ACTIVATION_WHEN_SHOWN = "SDL_WINDOW_NO_ACTIVATION_WHEN_SHOWN";

    /**
     * Allows back-button-press events on Windows Phone to be marked as handled
     *
     * <p>Windows Phone devices typically feature a Back button.  When pressed,
     * the OS will emit back-button-press events, which apps are expected to
     * handle in an appropriate manner.  If apps do not explicitly mark these
     * events as 'Handled', then the OS will invoke its default behavior for
     * unhandled back-button-press events, which on Windows Phone 8 and 8.1 is to
     * terminate the app (and attempt to switch to the previous app, or to the
     * device's home screen).</p>
     *
     * <p>Setting the SDL_HINT_WINRT_HANDLE_BACK_BUTTON hint to "1" will cause SDL
     * to mark back-button-press events as Handled, if and when one is sent to
     * the app.</p>
     *
     * <p>Internally, Windows Phone sends back button events as parameters to
     * special back-button-press callback functions.  Apps that need to respond
     * to back-button-press events are expected to register one or more
     * callback functions for such, shortly after being launched (during the
     * app's initialization phase).  After the back button is pressed, the OS
     * will invoke these callbacks.  If the app's callback(s) do not explicitly
     * mark the event as handled by the time they return, or if the app never
     * registers one of these callback, the OS will consider the event
     * un-handled, and it will apply its default back button behavior (terminate
     * the app).</p>
     *
     * <p>SDL registers its own back-button-press callback with the Windows Phone
     * OS.  This callback will emit a pair of SDL key-press events (SDL_KEYDOWN
     * and SDL_KEYUP), each with a scancode of SDL_SCANCODE_AC_BACK, after which
     * it will check the contents of the hint, SDL_HINT_WINRT_HANDLE_BACK_BUTTON.
     * If the hint's value is set to "1", the back button event's Handled
     * property will get set to 'true'.  If the hint's value is set to something
     * else, or if it is unset, SDL will leave the event's Handled property
     * alone.  (By default, the OS sets this property to 'false', to note.)</p>
     *
     * <p>SDL apps can either set SDL_HINT_WINRT_HANDLE_BACK_BUTTON well before a
     * back button is pressed, or can set it in direct-response to a back button
     * being pressed.</p>
     *
     * <p>In order to get notified when a back button is pressed, SDL apps should
     * register a callback function with SDL_AddEventWatch(), and have it listen
     * for SDL_KEYDOWN events that have a scancode of SDL_SCANCODE_AC_BACK.
     * (Alternatively, SDL_KEYUP events can be listened-for.  Listening for
     * either event type is suitable.)  Any value of SDL_HINT_WINRT_HANDLE_BACK_BUTTON
     * set by such a callback, will be applied to the OS' current
     * back-button-press event.</p>
     *
     * <p>More details on back button behavior in Windows Phone apps can be found
     * at the following page, on Microsoft's developer site:
     * http://msdn.microsoft.com/en-us/library/windowsphone/develop/jj247550(v=vs.105).aspx</p>
     */
    public static final String SDL_HINT_WINRT_HANDLE_BACK_BUTTON = "SDL_WINRT_HANDLE_BACK_BUTTON";

    /**
     * Label text for a WinRT app's privacy policy link
     *
     * <p>Network-enabled WinRT apps must include a privacy policy.  On Windows 8, 8.1, and RT,
     * Microsoft mandates that this policy be available via the Windows Settings charm.
     * SDL provides code to add a link there, with its label text being set via the
     * optional hint, SDL_HINT_WINRT_PRIVACY_POLICY_LABEL.</p>
     *
     * <p>Please note that a privacy policy's contents are not set via this hint.  A separate
     * hint, SDL_HINT_WINRT_PRIVACY_POLICY_URL, is used to link to the actual text of the
     * policy.</p>
     *
     * <p>The contents of this hint should be encoded as a UTF8 string.</p>
     *
     * <p>The default value is "Privacy Policy".  This hint should only be set during app
     * initialization, preferably before any calls to SDL_Init().</p>
     *
     * <p>For additional information on linking to a privacy policy, see the documentation for
     * SDL_HINT_WINRT_PRIVACY_POLICY_URL.</p>
     */
    public static final String SDL_HINT_WINRT_PRIVACY_POLICY_LABEL = "SDL_WINRT_PRIVACY_POLICY_LABEL";

    /**
     * A URL to a WinRT app's privacy policy
     *
     * <p>All network-enabled WinRT apps must make a privacy policy available to its
     * users.  On Windows 8, 8.1, and RT, Microsoft mandates that this policy be
     * be available in the Windows Settings charm, as accessed from within the app.
     * SDL provides code to add a URL-based link there, which can point to the app's
     * privacy policy.</p>
     *
     * <p>To setup a URL to an app's privacy policy, set SDL_HINT_WINRT_PRIVACY_POLICY_URL
     * before calling any SDL_Init() functions.  The contents of the hint should
     * be a valid URL.  For example, "http://www.example.com".</p>
     *
     * <p>The default value is "", which will prevent SDL from adding a privacy policy
     * link to the Settings charm.  This hint should only be set during app init.</p>
     *
     * <p>The label text of an app's "Privacy Policy" link may be customized via another
     * hint, SDL_HINT_WINRT_PRIVACY_POLICY_LABEL.</p>
     *
     * <p>Please note that on Windows Phone, Microsoft does not provide standard UI
     * for displaying a privacy policy link, and as such, SDL_HINT_WINRT_PRIVACY_POLICY_URL
     * will not get used on that platform.  Network-enabled phone apps should display
     * their privacy policy through some other, in-app means.</p>
     */
    public static final String SDL_HINT_WINRT_PRIVACY_POLICY_URL = "SDL_WINRT_PRIVACY_POLICY_URL";

    /**
     * Mark X11 windows as override-redirect.
     *
     * <p>If set, this _might_ increase framerate at the expense of the desktop
     * not working as expected. Override-redirect windows aren't noticed by the
     * window manager at all.</p>
     *
     * <p>You should probably only use this for fullscreen windows, and you probably
     * shouldn't even use it for that. But it's here if you want to try!</p>
     */
    public static final String SDL_HINT_X11_FORCE_OVERRIDE_REDIRECT = "SDL_X11_FORCE_OVERRIDE_REDIRECT";

    /**
     * A variable that lets you disable the detection and use of Xinput gamepad devices
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable XInput detection (only uses direct input)
     * "1"       - Enable XInput detection (the default)
     * </pre>
     */
    public static final String SDL_HINT_XINPUT_ENABLED = "SDL_XINPUT_ENABLED";

    /**
     * A variable that lets you disable the detection and use of DirectInput gamepad devices
     *
     * <p>The variable can be set to the following values:</p>
     * <pre>
     * "0"       - Disable DirectInput detection (only uses XInput)
     * "1"       - Enable DirectInput detection (the default)
     * </pre>
     */
    public static final String SDL_HINT_DIRECTINPUT_ENABLED = "SDL_DIRECTINPUT_ENABLED";

    /**
     * A variable that causes SDL to use the old axis and button mapping for XInput devices.
     *
     * <p>This hint is for backwards compatibility only and will be removed in SDL 2.1</p>
     *
     * <p>The default value is "0".  This hint must be set before SDL_Init()</p>
     */
    public static final String SDL_HINT_XINPUT_USE_OLD_JOYSTICK_MAPPING = "SDL_XINPUT_USE_OLD_JOYSTICK_MAPPING";

    /**
     * A variable that causes SDL to not ignore audio "monitors"
     *
     * <p>This is currently only used for PulseAudio and ignored elsewhere.</p>
     *
     * <p>By default, SDL ignores audio devices that aren't associated with physical
     * hardware. Changing this hint to "1" will expose anything SDL sees that
     * appears to be an audio source or sink. This will add "devices" to the list
     * that the user probably doesn't want or need, but it can be useful in
     * scenarios where you want to hook up SDL to some sort of virtual device,
     * etc.</p>
     *
     * <p>The default value is "0".  This hint must be set before SDL_Init().</p>
     *
     * <p>This hint is available since SDL 2.0.16. Before then, virtual devices are
     * always ignored.</p>
     */
    public static final String SDL_HINT_AUDIO_INCLUDE_MONITORS = "SDL_AUDIO_INCLUDE_MONITORS";

    /**
     * A variable that forces X11 windows to create as a custom type.
     *
     * <p>This is currently only used for X11 and ignored elsewhere.</p>
     *
     * <p>During SDL_CreateWindow, SDL uses the _NET_WM_WINDOW_TYPE X11 property
     * to report to the window manager the type of window it wants to create.
     * This might be set to various things if SDL_WINDOW_TOOLTIP or
     * SDL_WINDOW_POPUP_MENU, etc, were specified. For "normal" windows that
     * haven't set a specific type, this hint can be used to specify a custom
     * type. For example, a dock window might set this to
     * "_NET_WM_WINDOW_TYPE_DOCK".</p>
     *
     * <p>If not set or set to "", this hint is ignored. This hint must be set
     * before the SDL_CreateWindow() call that it is intended to affect.</p>
     *
     * <p>This hint is available since SDL 2.0.22.</p>
     */
    public static final String SDL_HINT_X11_WINDOW_TYPE = "SDL_X11_WINDOW_TYPE";

    /**
     * A variable that decides whether to send SDL_QUIT when closing the final window.
     *
     * <p>By default, SDL sends an SDL_QUIT event when there is only one window
     * and it receives an SDL_WINDOWEVENT_CLOSE event, under the assumption most
     * apps would also take the loss of this window as a signal to terminate the
     * program.</p>
     *
     * <p>However, it's not unreasonable in some cases to have the program continue
     * to live on, perhaps to create new windows later.</p>
     *
     * <p>Changing this hint to "0" will cause SDL to not send an SDL_QUIT event
     * when the final window is requesting to close. Note that in this case,
     * there are still other legitimate reasons one might get an SDL_QUIT
     * event: choosing "Quit" from the macOS menu bar, sending a SIGINT (ctrl-c)
     * on Unix, etc.</p>
     *
     * <p>The default value is "1".  This hint can be changed at any time.</p>
     *
     * <p>This hint is available since SDL 2.0.22. Before then, you always get
     * an SDL_QUIT event when closing the final window.</p>
     */
    public static final String SDL_HINT_QUIT_ON_LAST_WINDOW_CLOSE = "SDL_QUIT_ON_LAST_WINDOW_CLOSE";

    /**
     * A variable that decides what video backend to use.
     *
     * <p>By default, SDL will try all available video backends in a reasonable
     * order until it finds one that can work, but this hint allows the app
     * or user to force a specific target, such as "x11" if, say, you are
     * on Wayland but want to try talking to the X server instead.</p>
     *
     * <p>This functionality has existed since SDL 2.0.0 (indeed, before that)
     * but before 2.0.22 this was an environment variable only. In 2.0.22,
     * it was upgraded to a full SDL hint, so you can set the environment
     * variable as usual or programatically set the hint with SDL_SetHint,
     * which won't propagate to child processes.</p>
     *
     * <p>The default value is unset, in which case SDL will try to figure out
     * the best video backend on your behalf. This hint needs to be set
     * before SDL_Init() is called to be useful.</p>
     *
     * <p>This hint is available since SDL 2.0.22. Before then, you could set
     * the environment variable to get the same effect.</p>
     */
    public static final String SDL_HINT_VIDEODRIVER = "SDL_VIDEODRIVER";

    /**
     * A variable that decides what audio backend to use.
     *
     * <p>By default, SDL will try all available audio backends in a reasonable
     * order until it finds one that can work, but this hint allows the app
     * or user to force a specific target, such as "alsa" if, say, you are
     * on PulseAudio but want to try talking to the lower level instead.</p>
     *
     * <p>This functionality has existed since SDL 2.0.0 (indeed, before that)
     * but before 2.0.22 this was an environment variable only. In 2.0.22,
     * it was upgraded to a full SDL hint, so you can set the environment
     * variable as usual or programatically set the hint with SDL_SetHint,
     * which won't propagate to child processes.</p>
     *
     * <p>The default value is unset, in which case SDL will try to figure out
     * the best audio backend on your behalf. This hint needs to be set
     * before SDL_Init() is called to be useful.</p>
     *
     * <p>This hint is available since SDL 2.0.22. Before then, you could set
     * the environment variable to get the same effect.</p>
     */
    public static final String SDL_HINT_AUDIODRIVER = "SDL_AUDIODRIVER";

    /**
     * A variable that decides what KMSDRM device to use.
     *
     * <p>Internally, SDL might open something like "/dev/dri/cardNN" to
     * access KMSDRM functionality, where "NN" is a device index number.</p>
     *
     * <p>SDL makes a guess at the best index to use (usually zero), but the
     * app or user can set this hint to a number between 0 and 99 to
     * force selection.</p>
     *
     * <p>This hint is available since SDL 2.24.0.</p>
     */
    public static final String SDL_HINT_KMSDRM_DEVICE_INDEX = "SDL_KMSDRM_DEVICE_INDEX";

    /**
     * A variable that treats trackpads as touch devices.
     *
     * <p>On macOS (and possibly other platforms in the future), SDL will report
     * touches on a trackpad as mouse input, which is generally what users
     * expect from this device; however, these are often actually full
     * multitouch-capable touch devices, so it might be preferable to some apps
     * to treat them as such.</p>
     *
     * <p>Setting this hint to true will make the trackpad input report as a
     * multitouch device instead of a mouse. The default is false.</p>
     *
     * <p>Note that most platforms don't support this hint. As of 2.24.0, it
     * only supports MacBooks' trackpads on macOS. Others may follow later.</p>
     *
     * <p>This hint is checked during SDL_Init and can not be changed after.</p>
     *
     * <p>This hint is available since SDL 2.24.0.</p>
     */
    public static final String SDL_HINT_TRACKPAD_IS_TOUCH_ONLY = "SDL_TRACKPAD_IS_TOUCH_ONLY";

    private SdlHintsConst() {
    }
}
