package com.github.carlwilk32.sdl.mixer;

import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;
import java.nio.IntBuffer;

/**
 * JNA Wrapper for library <b>SDL_mixer</b><br>
 */
public interface SDL_mixerLibrary extends Library {
    String JNA_LIBRARY_NAME = "SDL2_mixer";
    NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(SDL_mixerLibrary.JNA_LIBRARY_NAME);
    SDL_mixerLibrary INSTANCE = Native.loadLibrary(SDL_mixerLibrary.JNA_LIBRARY_NAME, SDL_mixerLibrary.class);

    int SDL_MIXER_MAJOR_VERSION = 2;
    int SDL_MIXER_MINOR_VERSION = 7;
    int SDL_MIXER_PATCHLEVEL = 1;
    int MIX_MAJOR_VERSION = 2;
    int MIX_MINOR_VERSION = 7;
    int MIX_PATCHLEVEL = 1;
    int MIX_CHANNELS = 8;
    int MIX_DEFAULT_FREQUENCY = 44100;
    int MIX_DEFAULT_CHANNELS = 2;
    int MIX_DEFAULT_FORMAT = 0x8010;
    int MIX_CHANNEL_POST = -2;
    String MIX_EFFECTSMAXSPEED = "MIX_EFFECTSMAXSPEED";

    /**
     * Query the version of SDL_mixer that the program is linked against.<br>
     * This function gets the version of the dynamically linked SDL_mixer library.<br>
     * This is separate from the SDL_MIXER_VERSION() macro, which tells you what<br>
     * version of the SDL_mixer headers you compiled against.<br>
     * This returns static internal data; do not free or modify it!<br>
     * \returns a pointer to the version information.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>SDL_version* Mix_Linked_Version()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:10</i>
     */
    SDL_version Mix_Linked_Version();

    /**
     * Initialize SDL_mixer.<br>
     * This function loads dynamic libraries that SDL_mixer needs, and prepares<br>
     * them for use.<br>
     * Note that, unlike other SDL libraries, this call is optional! If you load a<br>
     * music file, SDL_mixer will handle initialization on the fly. This function<br>
     * will let you know, up front, whether a specific format will be available<br>
     * for use.<br>
     * Flags should be one or more flags from MIX_InitFlags OR'd together. It<br>
     * returns the flags successfully initialized, or 0 on failure.<br>
     * Currently, these flags are:<br>
     * - `MIX_INIT_FLAC`<br>
     * - `MIX_INIT_MOD`<br>
     * - `MIX_INIT_MP3`<br>
     * - `MIX_INIT_OGG`<br>
     * - `MIX_INIT_MID`<br>
     * - `MIX_INIT_OPUS`<br>
     * - `MIX_INIT_WAVPACK`<br>
     * More flags may be added in a future SDL_mixer release.<br>
     * This function may need to load external shared libraries to support various<br>
     * codecs, which means this function can fail to initialize that support on an<br>
     * otherwise-reasonable system if the library isn't available; this is not<br>
     * just a question of exceptional circumstances like running out of memory at<br>
     * startup!<br>
     * Note that you may call this function more than once to initialize with<br>
     * additional flags. The return value will reflect both new flags that<br>
     * successfully initialized, and also include flags that had previously been<br>
     * initialized as well.<br>
     * As this will return previously-initialized flags, it's legal to call this<br>
     * with zero (no flags set). This is a safe no-op that can be used to query<br>
     * the current initialization state without changing it at all.<br>
     * Since this returns previously-initialized flags as well as new ones, and<br>
     * you can call this with zero, you should not check for a zero return value<br>
     * to determine an error condition. Instead, you should check to make sure all<br>
     * the flags you require are set in the return value. If you have a game with<br>
     * data in a specific format, this might be a fatal error. If you're a generic<br>
     * media player, perhaps you are fine with only having WAV and MP3 support and<br>
     * can live without Opus playback, even if you request support for everything.<br>
     * Unlike other SDL satellite libraries, calls to Mix_Init do not stack; a<br>
     * single call to Mix_Quit() will deinitialize everything and does not have to<br>
     * be paired with a matching Mix_Init call. For that reason, it's considered<br>
     * best practices to have a single Mix_Init and Mix_Quit call in your program.<br>
     * While this isn't required, be aware of the risks of deviating from that<br>
     * behavior.<br>
     * After initializing SDL_mixer, the next step is to open an audio device to<br>
     * prepare to play sound (with Mix_OpenAudio() or Mix_OpenAudioDevice()), and<br>
     * load audio data to play with that device.<br>
     * \param flags initialization flags, OR'd together.<br>
     * \returns all currently initialized flags.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_Quit<br>
     * Original signature : <code>int Mix_Init(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:74</i>
     */
    int Mix_Init(int flags);

    /**
     * Deinitialize SDL_mixer.<br>
     * This should be the last function you call in SDL_mixer, after freeing all<br>
     * other resources and closing all audio devices. This will unload any shared<br>
     * libraries it is using for various codecs.<br>
     * After this call, a call to Mix_Init(0) will return 0 (no codecs loaded).<br>
     * You can safely call Mix_Init() to reload various codec support after this<br>
     * call.<br>
     * Unlike other SDL satellite libraries, calls to Mix_Init do not stack; a<br>
     * single call to Mix_Quit() will deinitialize everything and does not have to<br>
     * be paired with a matching Mix_Init call. For that reason, it's considered<br>
     * best practices to have a single Mix_Init and Mix_Quit call in your program.<br>
     * While this isn't required, be aware of the risks of deviating from that<br>
     * behavior.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_Init<br>
     * Original signature : <code>void Mix_Quit()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:93</i>
     */
    void Mix_Quit();

    /**
     * Open the default audio device for playback.<br>
     * An audio device is what generates sound, so the app must open one to make<br>
     * noise.<br>
     * This function will check if SDL's audio system is initialized, and if not,<br>
     * it will initialize it by calling `SDL_Init(SDL_INIT_AUDIO)` on your behalf.<br>
     * You are free to (and encouraged to!) initialize it yourself before calling<br>
     * this function, as this gives your program more control over the process.<br>
     * This function might cover all of an application's needs, but for those that<br>
     * need more flexibility, the more powerful version of this function is<br>
     * Mix_OpenAudioDevice(). This function is equivalent to calling:<br>
     * ```c<br>
     * Mix_OpenAudioDevice(frequency, format, nchannels, chunksize, NULL,<br>
     *                     SDL_AUDIO_ALLOW_FREQUENCY_CHANGE |<br>
     *                     SDL_AUDIO_ALLOW_CHANNELS_CHANGE);<br>
     * ```<br>
     * If you aren't particularly concerned with the specifics of the audio<br>
     * device, and your data isn't in a specific format, the values you use here<br>
     * can just be reasonable defaults. SDL_mixer will convert audio data you feed<br>
     * it to the correct format on demand.<br>
     * That being said, if you have control of your audio data and you know its<br>
     * format ahead of time, you may save CPU time by opening the audio device in<br>
     * that exact format so SDL_mixer does not have to spend time converting<br>
     * anything behind the scenes, and can just pass the data straight through to<br>
     * the hardware. On some platforms, where the hardware only supports specific<br>
     * settings, you might have to be careful to make everything match, but your<br>
     * own data is often easier to control, so aim to open the device for what you<br>
     * need.<br>
     * The other reason to care about specific formats: if you plan to touch the<br>
     * mix buffer directly (with Mix_SetPostMix, a registered effect, or<br>
     * Mix_HookMusic), you might have code that expects it to be in a specific<br>
     * format, and you should specify that here.<br>
     * The audio device frequency is specified in Hz; in modern times, 48000 is<br>
     * often a reasonable default.<br>
     * The audio device format is one of SDL's AUDIO_* constants. AUDIO_S16SYS<br>
     * (16-bit audio) is probably a safe default. More modern systems may prefer<br>
     * AUDIO_F32SYS (32-bit floating point audio).<br>
     * The audio device channels are generally 1 for mono output, or 2 for stereo,<br>
     * but the brave can try surround sound configs with 4 (quad), 6 (5.1), 7<br>
     * (6.1) or 8 (7.1).<br>
     * The audio device's chunk size is the number of sample frames (one sample<br>
     * per frame for mono output, two samples per frame in a stereo setup, etc)<br>
     * that are fed to the device at once. The lower the number, the lower the<br>
     * latency, but you risk dropouts if it gets too low. 2048 is often a<br>
     * reasonable default, but your app might want to experiment with 1024 or<br>
     * 4096.<br>
     * You may only have one audio device open at a time; if you want to change a<br>
     * setting, you must close the device and reopen it, which is not something<br>
     * you can do seamlessly during playback.<br>
     * This function does not allow you to select a specific audio device on the<br>
     * system, it always chooses the best default it can on your behalf (which, in<br>
     * many cases, is exactly what you want anyhow). If you must choose a specific<br>
     * device, you can do so with Mix_OpenAudioDevice() instead.<br>
     * If this function reports success, you are ready to start making noise! Load<br>
     * some audio data and start playing!<br>
     * The app can use Mix_QuerySpec() to determine the final device settings.<br>
     * When done with an audio device, probably at the end of the program, the app<br>
     * should dispose of the device with Mix_CloseAudio().<br>
     * \param frequency the frequency to playback audio at (in Hz).<br>
     * \param format audio format, one of SDL's AUDIO_* values.<br>
     * \param channels number of channels (1 is mono, 2 is stereo, etc).<br>
     * \param chunksize audio buffer size in sample FRAMES (total samples divided<br>
     *                  by channel count).<br>
     * \returns 0 if successful, -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_OpenAudioDevice<br>
     * \sa Mix_CloseAudio<br>
     * Original signature : <code>int Mix_OpenAudio(int, Uint16, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:194</i>
     */
    int Mix_OpenAudio(int frequency, int format, int channels, int chunksize);

    /**
     * Open a specific audio device for playback.<br>
     * (A slightly simpler version of this function is available in<br>
     * Mix_OpenAudio(), which still might meet most applications' needs.)<br>
     * An audio device is what generates sound, so the app must open one to make<br>
     * noise.<br>
     * This function will check if SDL's audio system is initialized, and if not,<br>
     * it will initialize it by calling `SDL_Init(SDL_INIT_AUDIO)` on your behalf.<br>
     * You are free to (and encouraged to!) initialize it yourself before calling<br>
     * this function, as this gives your program more control over the process.<br>
     * If you aren't particularly concerned with the specifics of the audio<br>
     * device, and your data isn't in a specific format, the values you use here<br>
     * can just be reasonable defaults. SDL_mixer will convert audio data you feed<br>
     * it to the correct format on demand.<br>
     * That being said, if you have control of your audio data and you know its<br>
     * format ahead of time, you can save CPU time by opening the audio device in<br>
     * that exact format so SDL_mixer does not have to spend time converting<br>
     * anything behind the scenes, and can just pass the data straight through to<br>
     * the hardware. On some platforms, where the hardware only supports specific<br>
     * settings, you might have to be careful to make everything match, but your<br>
     * own data is often easier to control, so aim to open the device for what you<br>
     * need.<br>
     * The other reason to care about specific formats: if you plan to touch the<br>
     * mix buffer directly (with Mix_SetPostMix, a registered effect, or<br>
     * Mix_HookMusic), you might have code that expects it to be in a specific<br>
     * format, and you should specify that here.<br>
     * The audio device frequency is specified in Hz; in modern times, 48000 is<br>
     * often a reasonable default.<br>
     * The audio device format is one of SDL's AUDIO_* constants. AUDIO_S16SYS<br>
     * (16-bit audio) is probably a safe default. More modern systems may prefer<br>
     * AUDIO_F32SYS (32-bit floating point audio).<br>
     * The audio device channels are generally 1 for mono output, or 2 for stereo,<br>
     * but the brave can try surround sound configs with 4 (quad), 6 (5.1), 7<br>
     * (6.1) or 8 (7.1).<br>
     * The audio device's chunk size is the number of sample frames (one sample<br>
     * per frame for mono output, two samples per frame in a stereo setup, etc)<br>
     * that are fed to the device at once. The lower the number, the lower the<br>
     * latency, but you risk dropouts if it gets too low. 2048 is often a<br>
     * reasonable default, but your app might want to experiment with 1024 or<br>
     * 4096.<br>
     * You may only have one audio device open at a time; if you want to change a<br>
     * setting, you must close the device and reopen it, which is not something<br>
     * you can do seamlessly during playback.<br>
     * This function allows you to select specific audio hardware on the system<br>
     * with the `device` parameter. If you specify NULL, SDL_mixer will choose the<br>
     * best default it can on your behalf (which, in many cases, is exactly what<br>
     * you want anyhow). SDL_mixer does not offer a mechanism to determine device<br>
     * names to open, but you can use SDL_GetNumAudioDevices() to get a count of<br>
     * available devices and then SDL_GetAudioDeviceName() in a loop to obtain a<br>
     * list. If you do this, be sure to call `SDL_Init(SDL_INIT_AUDIO)` first to<br>
     * initialize SDL's audio system!<br>
     * The `allowed_changes` parameter specifies what settings are flexible. These<br>
     * are the `SDL_AUDIO_ALLOW_*` flags from SDL. These tell SDL_mixer that the<br>
     * app doesn't mind if a specific setting changes. For example, the app might<br>
     * need stereo data in Sint16 format, but if the sample rate or chunk size<br>
     * changes, the app can handle that. In that case, the app would specify<br>
     * `SDL_AUDIO_ALLOW_FORMAT_CHANGE|SDL_AUDIO_ALLOW_SAMPLES_CHANGE`. In this<br>
     * case, if the system's hardware requires something other than the requested<br>
     * format, SDL_mixer can select what the hardware demands instead of the app.<br>
     * If the `SDL_AUDIO_ALLOW_` flag is not specified, SDL_mixer must convert<br>
     * data behind the scenes between what the app demands and what the hardware<br>
     * requires. If your app needs precisely what is requested, specify zero for<br>
     * `allowed_changes`.<br>
     * If changes were allowed, the app can use Mix_QuerySpec() to determine the<br>
     * final device settings.<br>
     * If this function reports success, you are ready to start making noise! Load<br>
     * some audio data and start playing!<br>
     * When done with an audio device, probably at the end of the program, the app<br>
     * should dispose of the device with Mix_CloseDevice().<br>
     * \param frequency the frequency to playback audio at (in Hz).<br>
     * \param format audio format, one of SDL's AUDIO_* values.<br>
     * \param channels number of channels (1 is mono, 2 is stereo, etc).<br>
     * \param chunksize audio buffer size in sample FRAMES (total samples divided<br>
     *                  by channel count).<br>
     * \param device the device name to open, or NULL to choose a reasonable<br>
     *               default.<br>
     * \param allowed_changes Allow change flags (see SDL_AUDIO_ALLOW_* flags)<br>
     * \returns 0 if successful, -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.2.<br>
     * \sa Mix_OpenAudio<br>
     * \sa Mix_CloseDevice<br>
     * \sa Mix_QuerySpec<br>
     * Original signature : <code>int Mix_OpenAudioDevice(int, Uint16, int, int, const char*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:279</i>
     */
    int Mix_OpenAudioDevice(int frequency, int format, int channels, int chunksize, String device, int allowed_changes);

    /**
     * Suspend or resume the whole audio output.<br>
     * \param pause_on 1 to pause audio output, or 0 to resume.<br>
     * \since This function is available since SDL_mixer 2.8.0.<br>
     * Original signature : <code>void Mix_PauseAudio(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:286</i>
     */
    void Mix_PauseAudio(int pause_on);

    /**
     * Find out what the actual audio device parameters are.<br>
     * If Mix_OpenAudioDevice() was called with `allowed_changes` set to anything<br>
     * but zero, or Mix_OpenAudio() was used, some audio device settings may be<br>
     * different from the application's request. This function will report what<br>
     * the device is actually running at.<br>
     * Note this is only important if the app intends to touch the audio buffers<br>
     * being sent to the hardware directly. If an app just wants to play audio<br>
     * files and let SDL_mixer handle the low-level details, this function can<br>
     * probably be ignored.<br>
     * If the audio device is not opened, this function will return 0.<br>
     * \param frequency On return, will be filled with the audio device's<br>
     *                  frequency in Hz.<br>
     * \param format On return, will be filled with the audio device's format.<br>
     * \param channels On return, will be filled with the audio device's channel<br>
     *                 count.<br>
     * \returns 1 if the audio device has been opened, 0 otherwise.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_OpenAudio<br>
     * \sa Mix_OpenAudioDevice<br>
     * Original signature : <code>int Mix_QuerySpec(int*, Uint16*, int*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:309</i>
     */
    int Mix_QuerySpec(IntBuffer frequency, int format, IntBuffer channels);

    /**
     * Dynamically change the number of channels managed by the mixer.<br>
     * SDL_mixer deals with "channels," which is not the same thing as the<br>
     * mono/stereo channels; they might be better described as "tracks," as each<br>
     * one corresponds to a separate source of audio data. Three different WAV<br>
     * files playing at the same time would be three separate SDL_mixer channels,<br>
     * for example.<br>
     * An app needs as many channels as it has audio data it wants to play<br>
     * simultaneously, mixing them into a single stream to send to the audio<br>
     * device.<br>
     * SDL_mixer allocates `MIX_CHANNELS` (currently 8) channels when you open an<br>
     * audio device, which may be more than an app needs, but if the app needs<br>
     * more or wants less, this function can change it.<br>
     * If decreasing the number of channels, any upper channels currently playing<br>
     * are stopped. This will deregister all effects on those channels and call<br>
     * any callback specified by Mix_ChannelFinished() for each removed channel.<br>
     * If `numchans` is less than zero, this will return the current number of<br>
     * channels without changing anything.<br>
     * \param numchans the new number of channels, or < 0 to query current channel<br>
     *                 count.<br>
     * \returns the new number of allocated channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_AllocateChannels(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:334</i>
     */
    int Mix_AllocateChannels(int numchans);

    /**
     * Load a supported audio format into a chunk.<br>
     * SDL_mixer has two separate data structures for audio data. One it calls a<br>
     * "chunk," which is meant to be a file completely decoded into memory up<br>
     * front, and the other it calls "music" which is a file intended to be<br>
     * decoded on demand. Originally, simple formats like uncompressed WAV files<br>
     * were meant to be chunks and compressed things, like MP3s, were meant to be<br>
     * music, and you would stream one thing for a game's music and make repeating<br>
     * sound effects with the chunks.<br>
     * In modern times, this isn't split by format anymore, and most are<br>
     * interchangeable, so the question is what the app thinks is worth<br>
     * predecoding or not. Chunks might take more memory, but once they are loaded<br>
     * won't need to decode again, whereas music always needs to be decoded on the<br>
     * fly. Also, crucially, there are as many channels for chunks as the app can<br>
     * allocate, but SDL_mixer only offers a single "music" channel.<br>
     * If `freesrc` is non-zero, the RWops will be closed before returning,<br>
     * whether this function succeeds or not. SDL_mixer reads everything it needs<br>
     * from the RWops during this call in any case.<br>
     * There is a separate function (a macro, before SDL_mixer 2.6.0) to read<br>
     * files from disk without having to deal with SDL_RWops:<br>
     * `Mix_LoadWAV("filename.wav")` will call this function and manage those<br>
     * details for you.<br>
     * When done with a chunk, the app should dispose of it with a call to<br>
     * Mix_FreeChunk().<br>
     * \param src an SDL_RWops that data will be read from.<br>
     * \param freesrc non-zero to close/free the SDL_RWops before returning, zero<br>
     *                to leave it open.<br>
     * \returns a new chunk, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.6.0 (and as a macro<br>
     *        since 2.0.0).<br>
     * \sa Mix_LoadWAV<br>
     * \sa Mix_FreeChunk<br>
     * Original signature : <code>Mix_Chunk* Mix_LoadWAV_RW(SDL_RWops*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:369</i>
     */
    Mix_Chunk Mix_LoadWAV_RW(SDL_RWops src, int freesrc);

    /**
     * Load a supported audio format into a chunk.<br>
     * SDL_mixer has two separate data structures for audio data. One it calls a<br>
     * "chunk," which is meant to be a file completely decoded into memory up<br>
     * front, and the other it calls "music" which is a file intended to be<br>
     * decoded on demand. Originally, simple formats like uncompressed WAV files<br>
     * were meant to be chunks and compressed things, like MP3s, were meant to be<br>
     * music, and you would stream one thing for a game's music and make repeating<br>
     * sound effects with the chunks.<br>
     * In modern times, this isn't split by format anymore, and most are<br>
     * interchangeable, so the question is what the app thinks is worth<br>
     * predecoding or not. Chunks might take more memory, but once they are loaded<br>
     * won't need to decode again, whereas music always needs to be decoded on the<br>
     * fly. Also, crucially, there are as many channels for chunks as the app can<br>
     * allocate, but SDL_mixer only offers a single "music" channel.<br>
     * If you would rather use the abstract SDL_RWops interface to load data from<br>
     * somewhere other than the filesystem, you can use Mix_LoadWAV_RW() instead.<br>
     * When done with a chunk, the app should dispose of it with a call to<br>
     * Mix_FreeChunk().<br>
     * Note that before SDL_mixer 2.6.0, this function was a macro that called<br>
     * Mix_LoadWAV_RW(), creating a RWops and setting `freesrc` to 1. This macro<br>
     * has since been promoted to a proper API function. Older binaries linked<br>
     * against a newer SDL_mixer will still call Mix_LoadWAV_RW directly, as they<br>
     * are using the macro, which was available since the dawn of time.<br>
     * \param file the filesystem path to load data from.<br>
     * \returns a new chunk, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.6.0 (and as a macro<br>
     *        since 2.0.0).<br>
     * \sa Mix_LoadWAV_RW<br>
     * \sa Mix_FreeChunk<br>
     * Original signature : <code>Mix_Chunk* Mix_LoadWAV(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:402</i>
     */
    Mix_Chunk Mix_LoadWAV(String file);

    /**
     * Load a supported audio format into a music object.<br>
     * SDL_mixer has two separate data structures for audio data. One it calls a<br>
     * "chunk," which is meant to be a file completely decoded into memory up<br>
     * front, and the other it calls "music" which is a file intended to be<br>
     * decoded on demand. Originally, simple formats like uncompressed WAV files<br>
     * were meant to be chunks and compressed things, like MP3s, were meant to be<br>
     * music, and you would stream one thing for a game's music and make repeating<br>
     * sound effects with the chunks.<br>
     * In modern times, this isn't split by format anymore, and most are<br>
     * interchangeable, so the question is what the app thinks is worth<br>
     * predecoding or not. Chunks might take more memory, but once they are loaded<br>
     * won't need to decode again, whereas music always needs to be decoded on the<br>
     * fly. Also, crucially, there are as many channels for chunks as the app can<br>
     * allocate, but SDL_mixer only offers a single "music" channel.<br>
     * When done with this music, the app should dispose of it with a call to<br>
     * Mix_FreeMusic().<br>
     * \param file a file path from where to load music data.<br>
     * \returns a new music object, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_FreeMusic<br>
     * Original signature : <code>Mix_Music* Mix_LoadMUS(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:426</i>
     */
    PointerByReference Mix_LoadMUS(String file);

    /**
     * Load a supported audio format into a music object.<br>
     * SDL_mixer has two separate data structures for audio data. One it calls a<br>
     * "chunk," which is meant to be a file completely decoded into memory up<br>
     * front, and the other it calls "music" which is a file intended to be<br>
     * decoded on demand. Originally, simple formats like uncompressed WAV files<br>
     * were meant to be chunks and compressed things, like MP3s, were meant to be<br>
     * music, and you would stream one thing for a game's music and make repeating<br>
     * sound effects with the chunks.<br>
     * In modern times, this isn't split by format anymore, and most are<br>
     * interchangeable, so the question is what the app thinks is worth<br>
     * predecoding or not. Chunks might take more memory, but once they are loaded<br>
     * won't need to decode again, whereas music always needs to be decoded on the<br>
     * fly. Also, crucially, there are as many channels for chunks as the app can<br>
     * allocate, but SDL_mixer only offers a single "music" channel.<br>
     * If `freesrc` is non-zero, the RWops will be closed before returning,<br>
     * whether this function succeeds or not. SDL_mixer reads everything it needs<br>
     * from the RWops during this call in any case.<br>
     * As a convenience, there is a function to read files from disk without<br>
     * having to deal with SDL_RWops: `Mix_LoadMUS("filename.mp3")` will manage<br>
     * those details for you.<br>
     * This function attempts to guess the file format from incoming data. If the<br>
     * caller knows the format, or wants to force it, it should use<br>
     * Mix_LoadMUSType_RW() instead.<br>
     * When done with this music, the app should dispose of it with a call to<br>
     * Mix_FreeMusic().<br>
     * \param src an SDL_RWops that data will be read from.<br>
     * \param freesrc non-zero to close/free the SDL_RWops before returning, zero<br>
     *                to leave it open.<br>
     * \returns a new music object, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_FreeMusic<br>
     * Original signature : <code>Mix_Music* Mix_LoadMUS_RW(SDL_RWops*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:461</i>
     */
    PointerByReference Mix_LoadMUS_RW(SDL_RWops src, int freesrc);

    /**
     * Load an audio format into a music object, assuming a specific format.<br>
     * SDL_mixer has two separate data structures for audio data. One it calls a<br>
     * "chunk," which is meant to be a file completely decoded into memory up<br>
     * front, and the other it calls "music" which is a file intended to be<br>
     * decoded on demand. Originally, simple formats like uncompressed WAV files<br>
     * were meant to be chunks and compressed things, like MP3s, were meant to be<br>
     * music, and you would stream one thing for a game's music and make repeating<br>
     * sound effects with the chunks.<br>
     * In modern times, this isn't split by format anymore, and most are<br>
     * interchangeable, so the question is what the app thinks is worth<br>
     * predecoding or not. Chunks might take more memory, but once they are loaded<br>
     * won't need to decode again, whereas music always needs to be decoded on the<br>
     * fly. Also, crucially, there are as many channels for chunks as the app can<br>
     * allocate, but SDL_mixer only offers a single "music" channel.<br>
     * This function loads music data, and lets the application specify the type<br>
     * of music being loaded, which might be useful if SDL_mixer cannot figure it<br>
     * out from the data stream itself.<br>
     * Currently, the following types are supported:<br>
     * - `MUS_NONE` (SDL_mixer should guess, based on the data)<br>
     * - `MUS_WAV` (Microsoft WAV files)<br>
     * - `MUS_MOD` (Various tracker formats)<br>
     * - `MUS_MID` (MIDI files)<br>
     * - `MUS_OGG` (Ogg Vorbis files)<br>
     * - `MUS_MP3` (MP3 files)<br>
     * - `MUS_FLAC` (FLAC files)<br>
     * - `MUS_OPUS` (Opus files)<br>
     * - `MUS_WAVPACK` (WavPack files)<br>
     * If `freesrc` is non-zero, the RWops will be closed before returning,<br>
     * whether this function succeeds or not. SDL_mixer reads everything it needs<br>
     * from the RWops during this call in any case.<br>
     * As a convenience, there is a function to read files from disk without<br>
     * having to deal with SDL_RWops: `Mix_LoadMUS("filename.mp3")` will manage<br>
     * those details for you (but not let you specify the music type explicitly)..<br>
     * When done with this music, the app should dispose of it with a call to<br>
     * Mix_FreeMusic().<br>
     * \param src an SDL_RWops that data will be read from.<br>
     * \param type the type of audio data provided by `src`.<br>
     * \param freesrc non-zero to close/free the SDL_RWops before returning, zero<br>
     *                to leave it open.<br>
     * \returns a new music object, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_FreeMusic<br>
     * Original signature : <code>Mix_Music* Mix_LoadMUSType_RW(SDL_RWops*, Mix_MusicType, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:507</i>
     */
    PointerByReference Mix_LoadMUSType_RW(SDL_RWops src, int type, int freesrc);

    /**
     * Load a WAV file from memory as quickly as possible.<br>
     * Unlike Mix_LoadWAV_RW, this function has several requirements, and unless<br>
     * you control all your audio data and know what you're doing, you should<br>
     * consider this function unsafe and not use it.<br>
     * - The provided audio data MUST be in Microsoft WAV format.<br>
     * - The provided audio data shouldn't use any strange WAV extensions.<br>
     * - The audio data MUST be in the exact same format as the audio device. This<br>
     *   function will not attempt to convert it, or even verify it's in the right<br>
     *   format.<br>
     * - The audio data must be valid; this function does not know the size of the<br>
     *   memory buffer, so if the WAV data is corrupted, it can read past the end<br>
     *   of the buffer, causing a crash.<br>
     * - The audio data must live at least as long as the returned Mix_Chunk,<br>
     *   because SDL_mixer will use that data directly and not make a copy of it.<br>
     * This function will do NO error checking! Be extremely careful here!<br>
     * (Seriously, use Mix_LoadWAV_RW instead.)<br>
     * If this function is successful, the provided memory buffer must remain<br>
     * available until Mix_FreeChunk() is called on the returned chunk.<br>
     * \param mem memory buffer containing of a WAV file.<br>
     * \returns a new chunk, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_LoadWAV_RW<br>
     * \sa Mix_FreeChunk<br>
     * Original signature : <code>Mix_Chunk* Mix_QuickLoad_WAV(Uint8*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:534</i>
     */
    Mix_Chunk Mix_QuickLoad_WAV(short mem);

    /**
     * Load a raw audio data from memory as quickly as possible.<br>
     * The audio data MUST be in the exact same format as the audio device. This<br>
     * function will not attempt to convert it, or even verify it's in the right<br>
     * format.<br>
     * If this function is successful, the provided memory buffer must remain<br>
     * available until Mix_FreeChunk() is called on the returned chunk.<br>
     * \param mem memory buffer containing raw PCM data.<br>
     * \param len length of buffer pointed to by `mem`, in bytes.<br>
     * \returns a new chunk, or NULL on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_FreeChunk<br>
     * Original signature : <code>Mix_Chunk* Mix_QuickLoad_RAW(Uint8*, Uint32)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:549</i>
     */
    Mix_Chunk Mix_QuickLoad_RAW(short mem, long len);

    /**
     * Free an audio chunk.<br>
     * An app should call this function when it is done with a Mix_Chunk and wants<br>
     * to dispose of its resources.<br>
     * SDL_mixer will stop any channels this chunk is currently playing on. This<br>
     * will deregister all effects on those channels and call any callback<br>
     * specified by Mix_ChannelFinished() for each removed channel.<br>
     * \param chunk the chunk to free.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_LoadWAV<br>
     * \sa Mix_LoadWAV_RW<br>
     * \sa Mix_QuickLoad_WAV<br>
     * \sa Mix_QuickLoad_RAW<br>
     * Original signature : <code>void Mix_FreeChunk(Mix_Chunk*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:565</i>
     */
    void Mix_FreeChunk(Mix_Chunk chunk);

    /**
     * Free a music object.<br>
     * If this music is currently playing, it will be stopped.<br>
     * If this music is in the process of fading out (via Mix_FadeOutMusic()),<br>
     * this function will *block* until the fade completes. If you need to avoid<br>
     * this, be sure to call Mix_HaltMusic() before freeing the music.<br>
     * \param music the music object to free.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_LoadMUS<br>
     * \sa Mix_LoadMUS_RW<br>
     * \sa Mix_LoadMUSType_RW<br>
     * Original signature : <code>void Mix_FreeMusic(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:579</i>
     */
    void Mix_FreeMusic(PointerByReference music);

    /**
     * Get a list of chunk decoders that this build of SDL_mixer provides.<br>
     * This list can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * Appearing in this list doesn't promise your specific audio file will<br>
     * decode...but it's handy to know if you have, say, a functioning Ogg Vorbis<br>
     * install.<br>
     * These return values are static, read-only data; do not modify or free it.<br>
     * The pointers remain valid until you call Mix_CloseAudio().<br>
     * \returns number of chunk decoders available.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GetChunkDecoder<br>
     * \sa Mix_HasChunkDecoder<br>
     * Original signature : <code>int Mix_GetNumChunkDecoders()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:597</i>
     */
    int Mix_GetNumChunkDecoders();

    /**
     * Get a chunk decoder's name.<br>
     * The requested decoder's index must be between zero and<br>
     * Mix_GetNumChunkDecoders()-1. It's safe to call this with an invalid index;<br>
     * this function will return NULL in that case.<br>
     * This list can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * \param index index of the chunk decoder.<br>
     * \returns the chunk decoder's name.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GetNumChunkDecoders<br>
     * Original signature : <code>char* Mix_GetChunkDecoder(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:613</i>
     */
    String Mix_GetChunkDecoder(int index);

    /**
     * Check if a chunk decoder is available by name.<br>
     * This result can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * Decoder names are arbitrary but also obvious, so you have to know what<br>
     * you're looking for ahead of time, but usually it's the file extension in<br>
     * capital letters (some example names are "AIFF", "VOC", "WAV").<br>
     * \param name the decoder name to query.<br>
     * \returns SDL_TRUE if a decoder by that name is available, SDL_FALSE<br>
     *          otherwise.<br>
     * \since This function is available since SDL_mixer 2.0.2.<br>
     * \sa Mix_GetNumChunkDecoders<br>
     * \sa Mix_GetChunkDecoder<br>
     * Original signature : <code>SDL_bool Mix_HasChunkDecoder(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:631</i>
     */
    SDL_bool Mix_HasChunkDecoder(String name);

    /**
     * Get a list of music decoders that this build of SDL_mixer provides.<br>
     * This list can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * Appearing in this list doesn't promise your specific audio file will<br>
     * decode...but it's handy to know if you have, say, a functioning Ogg Vorbis<br>
     * install.<br>
     * These return values are static, read-only data; do not modify or free it.<br>
     * The pointers remain valid until you call Mix_CloseAudio().<br>
     * \returns number of music decoders available.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GetMusicDecoder<br>
     * \sa Mix_HasMusicDecoder<br>
     * Original signature : <code>int Mix_GetNumMusicDecoders()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:649</i>
     */
    int Mix_GetNumMusicDecoders();

    /**
     * Get a music decoder's name.<br>
     * The requested decoder's index must be between zero and<br>
     * Mix_GetNumMusicDecoders()-1. It's safe to call this with an invalid index;<br>
     * this function will return NULL in that case.<br>
     * This list can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * \param index index of the music decoder.<br>
     * \returns the music decoder's name.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GetNumMusicDecoders<br>
     * Original signature : <code>char* Mix_GetMusicDecoder(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:665</i>
     */
    String Mix_GetMusicDecoder(int index);

    /**
     * Check if a music decoder is available by name.<br>
     * This result can change between builds AND runs of the program, if external<br>
     * libraries that add functionality become available. You must successfully<br>
     * call Mix_OpenAudio() or Mix_OpenAudioDevice() before calling this function,<br>
     * as decoders are activated at device open time.<br>
     * Decoder names are arbitrary but also obvious, so you have to know what<br>
     * you're looking for ahead of time, but usually it's the file extension in<br>
     * capital letters (some example names are "MOD", "MP3", "FLAC").<br>
     * \param name the decoder name to query.<br>
     * \returns SDL_TRUE if a decoder by that name is available, SDL_FALSE<br>
     *          otherwise.<br>
     * \since This function is available since SDL_mixer 2.6.0<br>
     * \sa Mix_GetNumMusicDecoders<br>
     * \sa Mix_GetMusicDecoder<br>
     * Original signature : <code>SDL_bool Mix_HasMusicDecoder(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:683</i>
     */
    SDL_bool Mix_HasMusicDecoder(String name);

    /**
     * Find out the format of a mixer music.<br>
     * If `music` is NULL, this will query the currently playing music (and return<br>
     * MUS_NONE if nothing is currently playing).<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the Mix_MusicType for the music object.<br>
     * \since This function is available since SDL_mixer 2.0.0<br>
     * Original signature : <code>Mix_MusicType Mix_GetMusicType(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:694</i>
     */
    int Mix_GetMusicType(PointerByReference music);

    /**
     * Get the title for a music object, or its filename.<br>
     * This returns format-specific metadata. Not all file formats supply this!<br>
     * If `music` is NULL, this will query the currently-playing music.<br>
     * If music's title tag is missing or empty, the filename will be returned. If<br>
     * you'd rather have the actual metadata or nothing, use<br>
     * Mix_GetMusicTitleTag() instead.<br>
     * Please note that if the music was loaded from an SDL_RWops instead of a<br>
     * filename, the filename returned will be an empty string ("").<br>
     * This function never returns NULL! If no data is available, it will return<br>
     * an empty string ("").<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the music's title if available, or the filename if not, or "".<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_GetMusicTitleTag<br>
     * \sa Mix_GetMusicArtistTag<br>
     * \sa Mix_GetMusicAlbumTag<br>
     * \sa Mix_GetMusicCopyrightTag<br>
     * Original signature : <code>char* Mix_GetMusicTitle(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:716</i>
     */
    String Mix_GetMusicTitle(PointerByReference music);

    /**
     * Get the title for a music object.<br>
     * This returns format-specific metadata. Not all file formats supply this!<br>
     * If `music` is NULL, this will query the currently-playing music.<br>
     * Unlike this function, Mix_GetMusicTitle() produce a string with the music's<br>
     * filename if a title isn't available, which might be preferable for some<br>
     * applications.<br>
     * This function never returns NULL! If no data is available, it will return<br>
     * an empty string ("").<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the music's title if available, or "".<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_GetMusicTitle<br>
     * \sa Mix_GetMusicArtistTag<br>
     * \sa Mix_GetMusicAlbumTag<br>
     * \sa Mix_GetMusicCopyrightTag<br>
     * Original signature : <code>char* Mix_GetMusicTitleTag(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:736</i>
     */
    String Mix_GetMusicTitleTag(PointerByReference music);

    /**
     * Get the artist name for a music object.<br>
     * This returns format-specific metadata. Not all file formats supply this!<br>
     * If `music` is NULL, this will query the currently-playing music.<br>
     * This function never returns NULL! If no data is available, it will return<br>
     * an empty string ("").<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the music's artist name if available, or "".<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_GetMusicTitleTag<br>
     * \sa Mix_GetMusicAlbumTag<br>
     * \sa Mix_GetMusicCopyrightTag<br>
     * Original signature : <code>char* Mix_GetMusicArtistTag(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:752</i>
     */
    String Mix_GetMusicArtistTag(PointerByReference music);

    /**
     * Get the album name for a music object.<br>
     * This returns format-specific metadata. Not all file formats supply this!<br>
     * If `music` is NULL, this will query the currently-playing music.<br>
     * This function never returns NULL! If no data is available, it will return<br>
     * an empty string ("").<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the music's album name if available, or "".<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_GetMusicTitleTag<br>
     * \sa Mix_GetMusicArtistTag<br>
     * \sa Mix_GetMusicCopyrightTag<br>
     * Original signature : <code>char* Mix_GetMusicAlbumTag(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:768</i>
     */
    String Mix_GetMusicAlbumTag(PointerByReference music);

    /**
     * Get the copyright text for a music object.<br>
     * This returns format-specific metadata. Not all file formats supply this!<br>
     * If `music` is NULL, this will query the currently-playing music.<br>
     * This function never returns NULL! If no data is available, it will return<br>
     * an empty string ("").<br>
     * \param music the music object to query, or NULL for the currently-playing<br>
     *              music.<br>
     * \returns the music's copyright text if available, or "".<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_GetMusicTitleTag<br>
     * \sa Mix_GetMusicArtistTag<br>
     * \sa Mix_GetMusicAlbumTag<br>
     * Original signature : <code>char* Mix_GetMusicCopyrightTag(const Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:784</i>
     */
    String Mix_GetMusicCopyrightTag(PointerByReference music);

    /**
     * Set a function that is called after all mixing is performed.<br>
     * This can be used to provide real-time visual display of the audio stream or<br>
     * add a custom mixer filter for the stream data.<br>
     * The callback will fire every time SDL_mixer is ready to supply more data to<br>
     * the audio device, after it has finished all its mixing work. This runs<br>
     * inside an SDL audio callback, so it's important that the callback return<br>
     * quickly, or there could be problems in the audio playback.<br>
     * The data provided to the callback is in the format that the audio device<br>
     * was opened in, and it represents the exact waveform SDL_mixer has mixed<br>
     * from all playing chunks and music for playback. You are allowed to modify<br>
     * the data, but it cannot be resized (so you can't add a reverb effect that<br>
     * goes past the end of the buffer without saving some state between runs to<br>
     * add it into the next callback, or resample the buffer to a smaller size to<br>
     * speed it up, etc).<br>
     * The `arg` pointer supplied here is passed to the callback as-is, for<br>
     * whatever the callback might want to do with it (keep track of some ongoing<br>
     * state, settings, etc).<br>
     * Passing a NULL callback disables the post-mix callback until such a time as<br>
     * a new one callback is set.<br>
     * There is only one callback available. If you need to mix multiple inputs,<br>
     * be prepared to handle them from a single function.<br>
     * \param mix_func the callback function to become the new post-mix callback.<br>
     * \param arg a pointer that is passed, untouched, to the callback.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_HookMusic<br>
     * Original signature : <code>void Mix_SetPostMix(Mix_SetPostMix_mix_func_callback*, void*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:813</i>
     */
    void Mix_SetPostMix(Mix_SetPostMix_mix_func_callback mix_func, Pointer arg);

    /**
     * Add your own music player or additional mixer function.<br>
     * This works something like Mix_SetPostMix(), but it has some crucial<br>
     * differences. Note that an app can use this _and_ Mix_SetPostMix() at the<br>
     * same time. This allows an app to replace the built-in music playback,<br>
     * either with it's own music decoder or with some sort of<br>
     * procedurally-generated audio output.<br>
     * The supplied callback will fire every time SDL_mixer is preparing to supply<br>
     * more data to the audio device. This runs inside an SDL audio callback, so<br>
     * it's important that the callback return quickly, or there could be problems<br>
     * in the audio playback.<br>
     * Running this callback is the first thing SDL_mixer will do when starting to<br>
     * mix more audio. The buffer will contain silence upon entry, so the callback<br>
     * does not need to mix into existing data or initialize the buffer.<br>
     * Note that while a callback is set through this function, SDL_mixer will not<br>
     * mix any playing music; this callback is used instead. To disable this<br>
     * callback (and thus reenable built-in music playback) call this function<br>
     * with a NULL callback.<br>
     * The data written to by the callback is in the format that the audio device<br>
     * was opened in, and upon return from the callback, SDL_mixer will mix any<br>
     * playing chunks (but not music!) into the buffer. The callback cannot resize<br>
     * the buffer (so you must be prepared to provide exactly the amount of data<br>
     * demanded or leave it as silence).<br>
     * The `arg` pointer supplied here is passed to the callback as-is, for<br>
     * whatever the callback might want to do with it (keep track of some ongoing<br>
     * state, settings, etc).<br>
     * As there is only one music "channel" mixed, there is only one callback<br>
     * available. If you need to mix multiple inputs, be prepared to handle them<br>
     * from a single function.<br>
     * \param mix_func the callback function to become the new post-mix callback.<br>
     * \param arg a pointer that is passed, untouched, to the callback.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_SetPostMix<br>
     * Original signature : <code>void Mix_HookMusic(Mix_HookMusic_mix_func_callback*, void*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:849</i>
     */
    void Mix_HookMusic(Mix_HookMusic_mix_func_callback mix_func, Pointer arg);

    /**
     * Set a callback that runs when a music object has stopped playing.<br>
     * This callback will fire when the currently-playing music has completed, or<br>
     * when it has been explicitly stopped from a call to Mix_HaltMusic. As such,<br>
     * this callback might fire from an arbitrary background thread at almost any<br>
     * time; try to limit what you do here.<br>
     * It is legal to start a new music object playing in this callback (or<br>
     * restart the one that just stopped). If the music finished normally, this<br>
     * can be used to loop the music without a gap in the audio playback.<br>
     * Do not call SDL_LockAudio() from this callback; you will either be inside<br>
     * the audio callback, or SDL_mixer will explicitly lock the audio before<br>
     * calling your callback.<br>
     * A NULL pointer will disable the callback.<br>
     * \param music_finished the callback function to become the new notification<br>
     *                       mechanism.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_HookMusicFinished(Mix_HookMusicFinished_music_finished_callback*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:868</i>
     */
    void Mix_HookMusicFinished(Mix_HookMusicFinished_music_finished_callback music_finished);

    /**
     * Get a pointer to the user data for the current music hook.<br>
     * This returns the `arg` pointer last passed to Mix_HookMusic(), or NULL if<br>
     * that function has never been called.<br>
     * \returns pointer to the user data previously passed to Mix_HookMusic.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void* Mix_GetMusicHookData()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:877</i>
     */
    Pointer Mix_GetMusicHookData();

    /**
     * Set a callback that runs when a channel has finished playing.<br>
     * The callback may be called from the mixer's audio callback or it could be<br>
     * called as a result of Mix_HaltChannel(), etc.<br>
     * The callback has a single parameter, `channel`, which says what mixer<br>
     * channel has just stopped.<br>
     * Do not call SDL_LockAudio() from this callback; you will either be inside<br>
     * the audio callback, or SDL_mixer will explicitly lock the audio before<br>
     * calling your callback.<br>
     * A NULL pointer will disable the callback.<br>
     * \param channel_finished the callback function to become the new<br>
     *                         notification mechanism.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_ChannelFinished(Mix_ChannelFinished_channel_finished_callback*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:893</i>
     */
    void Mix_ChannelFinished(Mix_ChannelFinished_channel_finished_callback channel_finished);

    /**
     * Register a special effect function.<br>
     * At mixing time, the channel data is copied into a buffer and passed through<br>
     * each registered effect function. After it passes through all the functions,<br>
     * it is mixed into the final output stream. The copy to buffer is performed<br>
     * once, then each effect function performs on the output of the previous<br>
     * effect. Understand that this extra copy to a buffer is not performed if<br>
     * there are no effects registered for a given chunk, which saves CPU cycles,<br>
     * and any given effect will be extra cycles, too, so it is crucial that your<br>
     * code run fast. Also note that the data that your function is given is in<br>
     * the format of the sound device, and not the format you gave to<br>
     * Mix_OpenAudio(), although they may in reality be the same. This is an<br>
     * unfortunate but necessary speed concern. Use Mix_QuerySpec() to determine<br>
     * if you can handle the data before you register your effect, and take<br>
     * appropriate actions.<br>
     * You may also specify a callback (Mix_EffectDone_t) that is called when the<br>
     * channel finishes playing. This gives you a more fine-grained control than<br>
     * Mix_ChannelFinished(), in case you need to free effect-specific resources,<br>
     * etc. If you don't need this, you can specify NULL.<br>
     * You may set the callbacks before or after calling Mix_PlayChannel().<br>
     * Things like Mix_SetPanning() are just internal special effect functions, so<br>
     * if you are using that, you've already incurred the overhead of a copy to a<br>
     * separate buffer, and that these effects will be in the queue with any<br>
     * functions you've registered. The list of registered effects for a channel<br>
     * is reset when a chunk finishes playing, so you need to explicitly set them<br>
     * with each call to Mix_PlayChannel*().<br>
     * You may also register a special effect function that is to be run after<br>
     * final mixing occurs. The rules for these callbacks are identical to those<br>
     * in Mix_RegisterEffect, but they are run after all the channels and the<br>
     * music have been mixed into a single stream, whereas channel-specific<br>
     * effects run on a given channel before any other mixing occurs. These global<br>
     * effect callbacks are call "posteffects". Posteffects only have their<br>
     * Mix_EffectDone_t function called when they are unregistered (since the main<br>
     * output stream is never "done" in the same sense as a channel). You must<br>
     * unregister them manually when you've had enough. Your callback will be told<br>
     * that the channel being mixed is `MIX_CHANNEL_POST` if the processing is<br>
     * considered a posteffect.<br>
     * After all these effects have finished processing, the callback registered<br>
     * through Mix_SetPostMix() runs, and then the stream goes to the audio<br>
     * device.<br>
     * DO NOT EVER call SDL_LockAudio() from your callback function! You are<br>
     * already running in the audio thread and the lock is already held!<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param chan the channel to register an effect to, or MIX_CHANNEL_POST.<br>
     * \param f effect the callback to run when more of this channel is to be<br>
     *          mixed.<br>
     * \param d effect done callback<br>
     * \param arg argument<br>
     * \returns zero if error (no such channel), nonzero if added. Error messages<br>
     *          can be retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_RegisterEffect(int, Mix_EffectFunc_t, Mix_EffectDone_t, void*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:974</i>
     */
    int Mix_RegisterEffect(int chan, Mix_EffectFunc_t f, Mix_EffectDone_t d, Pointer arg);

    /**
     * Explicitly unregister a special effect function.<br>
     * You may not need to call this at all, unless you need to stop an effect<br>
     * from processing in the middle of a chunk's playback.<br>
     * Posteffects are never implicitly unregistered as they are for channels (as<br>
     * the output stream does not have an end), but they may be explicitly<br>
     * unregistered through this function by specifying MIX_CHANNEL_POST for a<br>
     * channel.<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel the channel to unregister an effect on, or MIX_CHANNEL_POST.<br>
     * \param f effect the callback stop calling in future mixing iterations.<br>
     * \returns zero if error (no such channel or effect), nonzero if removed.<br>
     *          Error messages can be retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_UnregisterEffect(int, Mix_EffectFunc_t)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:993</i>
     */
    int Mix_UnregisterEffect(int channel, Mix_EffectFunc_t f);

    /**
     * Explicitly unregister all special effect functions.<br>
     * You may not need to call this at all, unless you need to stop all effects<br>
     * from processing in the middle of a chunk's playback.<br>
     * Note that this will also shut off some internal effect processing, since<br>
     * Mix_SetPanning() and others may use this API under the hood. This is called<br>
     * internally when a channel completes playback. Posteffects are never<br>
     * implicitly unregistered as they are for channels, but they may be<br>
     * explicitly unregistered through this function by specifying<br>
     * MIX_CHANNEL_POST for a channel.<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel the channel to unregister all effects on, or<br>
     *                MIX_CHANNEL_POST.<br>
     * \returns zero if error (no such channel), nonzero if all effects removed.<br>
     *          Error messages can be retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_UnregisterAllEffects(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1014</i>
     */
    int Mix_UnregisterAllEffects(int channel);

    /**
     * Set the panning of a channel.<br>
     * The left and right channels are specified as integers between 0 and 255,<br>
     * quietest to loudest, respectively.<br>
     * Technically, this is just individual volume control for a sample with two<br>
     * (stereo) channels, so it can be used for more than just panning. If you<br>
     * want real panning, call it like this:<br>
     * ```c<br>
     * Mix_SetPanning(channel, left, 255 - left);<br>
     * ```<br>
     * Setting `channel` to MIX_CHANNEL_POST registers this as a posteffect, and<br>
     * the panning will be done to the final mixed stream before passing it on to<br>
     * the audio device.<br>
     * This uses the Mix_RegisterEffect() API internally, and returns without<br>
     * registering the effect function if the audio device is not configured for<br>
     * stereo output. Setting both `left` and `right` to 255 causes this effect to<br>
     * be unregistered, since that is the data's normal state.<br>
     * Note that an audio device in mono mode is a no-op, but this call will<br>
     * return successful in that case. Error messages can be retrieved from<br>
     * Mix_GetError().<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel The mixer channel to pan or MIX_CHANNEL_POST.<br>
     * \param left Volume of stereo left channel, 0 is silence, 255 is full<br>
     *             volume.<br>
     * \param right Volume of stereo right channel, 0 is silence, 255 is full<br>
     *              volume.<br>
     * \returns zero if error (no such channel or Mix_RegisterEffect() fails),<br>
     *          nonzero if panning effect enabled.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_SetPosition<br>
     * \sa Mix_SetDistance<br>
     * Original signature : <code>int Mix_SetPanning(int, Uint8, Uint8)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1050</i>
     */
    int Mix_SetPanning(int channel, short left, short right);

    /**
     * Set the position of a channel.<br>
     * `angle` is an integer from 0 to 360, that specifies the location of the<br>
     * sound in relation to the listener. `angle` will be reduced as necessary<br>
     * (540 becomes 180 degrees, -100 becomes 260). Angle 0 is due north, and<br>
     * rotates clockwise as the value increases. For efficiency, the precision of<br>
     * this effect may be limited (angles 1 through 7 might all produce the same<br>
     * effect, 8 through 15 are equal, etc). `distance` is an integer between 0<br>
     * and 255 that specifies the space between the sound and the listener. The<br>
     * larger the number, the further away the sound is. Using 255 does not<br>
     * guarantee that the channel will be removed from the mixing process or be<br>
     * completely silent. For efficiency, the precision of this effect may be<br>
     * limited (distance 0 through 5 might all produce the same effect, 6 through<br>
     * 10 are equal, etc). Setting `angle` and `distance` to 0 unregisters this<br>
     * effect, since the data would be unchanged.<br>
     * If you need more precise positional audio, consider using OpenAL for<br>
     * spatialized effects instead of SDL_mixer. This is only meant to be a basic<br>
     * effect for simple "3D" games.<br>
     * If the audio device is configured for mono output, then you won't get any<br>
     * effectiveness from the angle; however, distance attenuation on the channel<br>
     * will still occur. While this effect will function with stereo voices, it<br>
     * makes more sense to use voices with only one channel of sound, so when they<br>
     * are mixed through this effect, the positioning will sound correct. You can<br>
     * convert them to mono through SDL before giving them to the mixer in the<br>
     * first place if you like.<br>
     * Setting the channel to MIX_CHANNEL_POST registers this as a posteffect, and<br>
     * the positioning will be done to the final mixed stream before passing it on<br>
     * to the audio device.<br>
     * This is a convenience wrapper over Mix_SetDistance() and Mix_SetPanning().<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel The mixer channel to position, or MIX_CHANNEL_POST.<br>
     * \param angle angle, in degrees. North is 0, and goes clockwise.<br>
     * \param distance distance; 0 is the listener, 255 is maxiumum distance away.<br>
     * \returns zero if error (no such channel or Mix_RegisterEffect() fails),<br>
     *          nonzero if position effect is enabled. Error messages can be<br>
     *          retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetPosition(int, Sint16, Uint8)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1092</i>
     */
    int Mix_SetPosition(int channel, int angle, short distance);

    /**
     * Set the "distance" of a channel.<br>
     * `distance` is an integer from 0 to 255 that specifies the location of the<br>
     * sound in relation to the listener. Distance 0 is overlapping the listener,<br>
     * and 255 is as far away as possible. A distance of 255 does not guarantee<br>
     * silence; in such a case, you might want to try changing the chunk's volume,<br>
     * or just cull the sample from the mixing process with Mix_HaltChannel(). For<br>
     * efficiency, the precision of this effect may be limited (distances 1<br>
     * through 7 might all produce the same effect, 8 through 15 are equal, etc).<br>
     * (distance) is an integer between 0 and 255 that specifies the space between<br>
     * the sound and the listener. The larger the number, the further away the<br>
     * sound is. Setting the distance to 0 unregisters this effect, since the data<br>
     * would be unchanged. If you need more precise positional audio, consider<br>
     * using OpenAL for spatialized effects instead of SDL_mixer. This is only<br>
     * meant to be a basic effect for simple "3D" games.<br>
     * Setting the channel to MIX_CHANNEL_POST registers this as a posteffect, and<br>
     * the distance attenuation will be done to the final mixed stream before<br>
     * passing it on to the audio device.<br>
     * This uses the Mix_RegisterEffect() API internally.<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel The mixer channel to attenuate, or MIX_CHANNEL_POST.<br>
     * \param distance distance; 0 is the listener, 255 is maxiumum distance away.<br>
     * \returns zero if error (no such channel or Mix_RegisterEffect() fails),<br>
     *          nonzero if position effect is enabled. Error messages can be<br>
     *          retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetDistance(int, Uint8)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1123</i>
     */
    int Mix_SetDistance(int channel, short distance);

    /**
     * Cause a channel to reverse its stereo.<br>
     * This is handy if the user has his speakers hooked up backwards, or you<br>
     * would like to have a trippy sound effect.<br>
     * Calling this function with `flip` set to non-zero reverses the chunks's<br>
     * usual channels. If `flip` is zero, the effect is unregistered.<br>
     * This uses the Mix_RegisterEffect() API internally, and thus is probably<br>
     * more CPU intensive than having the user just plug in his speakers<br>
     * correctly. Mix_SetReverseStereo() returns without registering the effect<br>
     * function if the audio device is not configured for stereo output.<br>
     * If you specify MIX_CHANNEL_POST for `channel`, then this effect is used on<br>
     * the final mixed stream before sending it on to the audio device (a<br>
     * posteffect).<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param channel The mixer channel to reverse, or MIX_CHANNEL_POST.<br>
     * \param flip non-zero to reverse stereo, zero to disable this effect.<br>
     * \returns zero if error (no such channel or Mix_RegisterEffect() fails),<br>
     *          nonzero if reversing effect is enabled. Note that an audio device<br>
     *          in mono mode is a no-op, but this call will return successful in<br>
     *          that case. Error messages can be retrieved from Mix_GetError().<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetReverseStereo(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1149</i>
     */
    int Mix_SetReverseStereo(int channel, int flip);

    /**
     * Reserve the first channels for the application.<br>
     * While SDL_mixer will use up to the number of channels allocated by<br>
     * Mix_AllocateChannels(), this sets channels aside that will not be available<br>
     * when calling Mix_PlayChannel with a channel of -1 (play on the first unused<br>
     * channel). In this case, SDL_mixer will treat reserved channels as "used"<br>
     * whether anything is playing on them at the moment or not.<br>
     * This is useful if you've budgeted some channels for dedicated audio and the<br>
     * rest are just used as they are available.<br>
     * Calling this function will set channels 0 to `n - 1` to be reserved. This<br>
     * will not change channel allocations. The number of reserved channels will<br>
     * be clamped to the current number allocated.<br>
     * By default, no channels are reserved.<br>
     * \param num number of channels to reserve, starting at index zero.<br>
     * \returns the number of reserved channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_ReserveChannels(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1168</i>
     */
    int Mix_ReserveChannels(int num);

    /**
     * Assign a tag to a channel.<br>
     * A tag is an arbitary number that can be assigned to several mixer channels,<br>
     * to form groups of channels.<br>
     * If 'tag' is -1, the tag is removed (actually -1 is the tag used to<br>
     * represent the group of all the channels).<br>
     * This function replaces the requested channel's current tag; you may only<br>
     * have one tag per channel.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * \param which the channel to set the tag on.<br>
     * \param tag an arbitrary value to assign a channel.<br>
     * \returns non-zero on success, zero on error (no such channel).<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_GroupChannel(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1184</i>
     */
    int Mix_GroupChannel(int which, int tag);

    /**
     * Assign several consecutive channels to the same tag.<br>
     * A tag is an arbitary number that can be assigned to several mixer channels,<br>
     * to form groups of channels.<br>
     * If 'tag' is -1, the tag is removed (actually -1 is the tag used to<br>
     * represent the group of all the channels).<br>
     * This function replaces the requested channels' current tags; you may only<br>
     * have one tag per channel.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * Note that this returns success and failure in the _opposite_ way from<br>
     * Mix_GroupChannel(). We regret the API design mistake.<br>
     * \param from the first channel to set the tag on.<br>
     * \param to the last channel to set the tag on, inclusive.<br>
     * \param tag an arbitrary value to assign a channel.<br>
     * \returns 0 if successful, negative on error<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_GroupChannels(int, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1203</i>
     */
    int Mix_GroupChannels(int from, int to, int tag);

    /**
     * Finds the first available channel in a group of channels.<br>
     * A tag is an arbitary number that can be assigned to several mixer channels,<br>
     * to form groups of channels.<br>
     * This function searches all channels with a specified tag, and returns the<br>
     * channel number of the first one it finds that is currently unused.<br>
     * If no channels with the specified tag are unused, this function returns -1.<br>
     * \param tag an arbitrary value, assigned to channels, to search for.<br>
     * \returns first available channel, or -1 if none are available.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_GroupAvailable(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1216</i>
     */
    int Mix_GroupAvailable(int tag);

    /**
     * Returns the number of channels in a group.<br>
     * If tag is -1, this will return the total number of channels allocated,<br>
     * regardless of what their tag might be.<br>
     * \param tag an arbitrary value, assigned to channels, to search for.<br>
     * \returns the number of channels assigned the specified tag.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_GroupCount(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1226</i>
     */
    int Mix_GroupCount(int tag);

    /**
     * Find the "oldest" sample playing in a group of channels.<br>
     * Specifically, this function returns the channel number that is assigned the<br>
     * specified tag, is currently playing, and has the lowest start time, based<br>
     * on the value of SDL_GetTicks() when the channel started playing.<br>
     * If no channel with this tag is currently playing, this function returns -1.<br>
     * \param tag an arbitrary value, assigned to channels, to search through.<br>
     * \returns the "oldest" sample playing in a group of channels<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GroupNewer<br>
     * Original signature : <code>int Mix_GroupOldest(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1239</i>
     */
    int Mix_GroupOldest(int tag);

    /**
     * Find the "most recent" sample playing in a group of channels.<br>
     * Specifically, this function returns the channel number that is assigned the<br>
     * specified tag, is currently playing, and has the highest start time, based<br>
     * on the value of SDL_GetTicks() when the channel started playing.<br>
     * If no channel with this tag is currently playing, this function returns -1.<br>
     * \param tag an arbitrary value, assigned to channels, to search through.<br>
     * \returns the "most recent" sample playing in a group of channels<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GroupOldest<br>
     * Original signature : <code>int Mix_GroupNewer(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1252</i>
     */
    int Mix_GroupNewer(int tag);

    /**
     * Play an audio chunk on a specific channel.<br>
     * If the specified channel is -1, play on the first free channel (and return<br>
     * -1 without playing anything new if no free channel was available).<br>
     * If a specific channel was requested, and there is a chunk already playing<br>
     * there, that chunk will be halted and the new chunk will take its place.<br>
     * If `loops` is greater than zero, loop the sound that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * Note that before SDL_mixer 2.6.0, this function was a macro that called<br>
     * Mix_PlayChannelTimed() with a fourth parameter ("ticks") of -1. This<br>
     * function still does the same thing, but promotes it to a proper API<br>
     * function. Older binaries linked against a newer SDL_mixer will still call<br>
     * Mix_PlayChannelTimed directly, as they are using the macro, which was<br>
     * available since the dawn of time.<br>
     * \param channel the channel on which to play the new chunk.<br>
     * \param chunk the new chunk to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \returns which channel was used to play the sound, or -1 if sound could not<br>
     *          be played.<br>
     * \since This function is available since SDL_mixer 2.6.0 (and as a macro<br>
     *        since 2.0.0).<br>
     * Original signature : <code>int Mix_PlayChannel(int, Mix_Chunk*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1277</i>
     */
    int Mix_PlayChannel(int channel, Mix_Chunk chunk, int loops);

    /**
     * Play an audio chunk on a specific channel for a maximum time.<br>
     * If the specified channel is -1, play on the first free channel (and return<br>
     * -1 without playing anything new if no free channel was available).<br>
     * If a specific channel was requested, and there is a chunk already playing<br>
     * there, that chunk will be halted and the new chunk will take its place.<br>
     * If `loops` is greater than zero, loop the sound that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * `ticks` specifies the maximum number of milliseconds to play this chunk<br>
     * before halting it. If you want the chunk to play until all data has been<br>
     * mixed, specify -1.<br>
     * Note that this function does not block for the number of ticks requested;<br>
     * it just schedules the chunk to play and notes the maximum for the mixer to<br>
     * manage later, and returns immediately.<br>
     * \param channel the channel on which to play the new chunk.<br>
     * \param chunk the new chunk to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \param ticks the maximum number of milliseconds of this chunk to mix for<br>
     *              playback.<br>
     * \returns which channel was used to play the sound, or -1 if sound could not<br>
     *          be played.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_PlayChannelTimed(int, Mix_Chunk*, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1303</i>
     */
    int Mix_PlayChannelTimed(int channel, Mix_Chunk chunk, int loops, int ticks);

    /**
     * Play a new music object.<br>
     * This will schedule the music object to begin mixing for playback.<br>
     * There is only ever one music object playing at a time; if this is called<br>
     * when another music object is playing, the currently-playing music is halted<br>
     * and the new music will replace it.<br>
     * Please note that if the currently-playing music is in the process of fading<br>
     * out (via Mix_FadeOutMusic()), this function will *block* until the fade<br>
     * completes. If you need to avoid this, be sure to call Mix_HaltMusic()<br>
     * before starting new music.<br>
     * \param music the new music object to schedule for mixing.<br>
     * \param loops the number of loops to play the music for (0 means "play once<br>
     *              and stop").<br>
     * \returns zero on success, -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_PlayMusic(Mix_Music*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1321</i>
     */
    int Mix_PlayMusic(PointerByReference music, int loops);

    /**
     * Play a new music object, fading in the audio.<br>
     * This will start the new music playing, much like Mix_PlayMusic() will, but<br>
     * will start the music playing at silence and fade in to its normal volume<br>
     * over the specified number of milliseconds.<br>
     * If there is already music playing, that music will be halted and the new<br>
     * music object will take its place.<br>
     * If `loops` is greater than zero, loop the music that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * Fading music will change it's volume progressively, as if Mix_VolumeMusic()<br>
     * was called on it (which is to say: you probably shouldn't call<br>
     * Mix_VolumeMusic() on fading music).<br>
     * \param music the new music object to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \param ms the number of milliseconds to spend fading in.<br>
     * \returns zero on success, -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeInMusic(Mix_Music*, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1342</i>
     */
    int Mix_FadeInMusic(PointerByReference music, int loops, int ms);

    /**
     * Play a new music object, fading in the audio, from a starting position.<br>
     * This will start the new music playing, much like Mix_PlayMusic() will, but<br>
     * will start the music playing at silence and fade in to its normal volume<br>
     * over the specified number of milliseconds.<br>
     * If there is already music playing, that music will be halted and the new<br>
     * music object will take its place.<br>
     * If `loops` is greater than zero, loop the music that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * Fading music will change it's volume progressively, as if Mix_VolumeMusic()<br>
     * was called on it (which is to say: you probably shouldn't call<br>
     * Mix_VolumeMusic() on fading music).<br>
     * This function allows the caller to start the music playback past the<br>
     * beginning of its audio data. You may specify a start position, in seconds,<br>
     * and the playback and fade-in will start there instead of with the first<br>
     * samples of the music.<br>
     * An app can specify a `position` of 0.0 to start at the beginning of the<br>
     * music (or just call Mix_FadeInMusic() instead).<br>
     * To convert from milliseconds, divide by 1000.0.<br>
     * \param music the new music object to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \param ms the number of milliseconds to spend fading in.<br>
     * \param position the start position within the music, in seconds, where<br>
     *                 playback should start.<br>
     * \returns zero on success, -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeInMusicPos(Mix_Music*, int, int, double)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1372</i>
     */
    int Mix_FadeInMusicPos(PointerByReference music, int loops, int ms, double position);

    /**
     * Play an audio chunk on a specific channel, fading in the audio.<br>
     * This will start the new sound playing, much like Mix_PlayChannel() will,<br>
     * but will start the sound playing at silence and fade in to its normal<br>
     * volume over the specified number of milliseconds.<br>
     * If the specified channel is -1, play on the first free channel (and return<br>
     * -1 without playing anything new if no free channel was available).<br>
     * If a specific channel was requested, and there is a chunk already playing<br>
     * there, that chunk will be halted and the new chunk will take its place.<br>
     * If `loops` is greater than zero, loop the sound that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * A fading channel will change it's volume progressively, as if Mix_Volume()<br>
     * was called on it (which is to say: you probably shouldn't call Mix_Volume()<br>
     * on a fading channel).<br>
     * Note that before SDL_mixer 2.6.0, this function was a macro that called<br>
     * Mix_FadeInChannelTimed() with a fourth parameter ("ticks") of -1. This<br>
     * function still does the same thing, but promotes it to a proper API<br>
     * function. Older binaries linked against a newer SDL_mixer will still call<br>
     * Mix_FadeInChannelTimed directly, as they are using the macro, which was<br>
     * available since the dawn of time.<br>
     * \param channel the channel on which to play the new chunk, or -1 to find<br>
     *                any available.<br>
     * \param chunk the new chunk to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \param ms the number of milliseconds to spend fading in.<br>
     * \returns which channel was used to play the sound, or -1 if sound could not<br>
     *          be played.<br>
     * \since This function is available since SDL_mixer 2.6.0 (and as a macro<br>
     *        since 2.0.0).<br>
     * Original signature : <code>int Mix_FadeInChannel(int, Mix_Chunk*, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1405</i>
     */
    int Mix_FadeInChannel(int channel, Mix_Chunk chunk, int loops, int ms);

    /**
     * Play an audio chunk on a specific channel, fading in the audio, for a<br>
     * maximum time.<br>
     * This will start the new sound playing, much like Mix_PlayChannel() will,<br>
     * but will start the sound playing at silence and fade in to its normal<br>
     * volume over the specified number of milliseconds.<br>
     * If the specified channel is -1, play on the first free channel (and return<br>
     * -1 without playing anything new if no free channel was available).<br>
     * If a specific channel was requested, and there is a chunk already playing<br>
     * there, that chunk will be halted and the new chunk will take its place.<br>
     * If `loops` is greater than zero, loop the sound that many times. If `loops`<br>
     * is -1, loop "infinitely" (~65000 times).<br>
     * `ticks` specifies the maximum number of milliseconds to play this chunk<br>
     * before halting it. If you want the chunk to play until all data has been<br>
     * mixed, specify -1.<br>
     * Note that this function does not block for the number of ticks requested;<br>
     * it just schedules the chunk to play and notes the maximum for the mixer to<br>
     * manage later, and returns immediately.<br>
     * A fading channel will change it's volume progressively, as if Mix_Volume()<br>
     * was called on it (which is to say: you probably shouldn't call Mix_Volume()<br>
     * on a fading channel).<br>
     * \param channel the channel on which to play the new chunk, or -1 to find<br>
     *                any available.<br>
     * \param chunk the new chunk to play.<br>
     * \param loops the number of times the chunk should loop, -1 to loop (not<br>
     *              actually) infinitely.<br>
     * \param ms the number of milliseconds to spend fading in.<br>
     * \param ticks the maximum number of milliseconds of this chunk to mix for<br>
     *              playback.<br>
     * \returns which channel was used to play the sound, or -1 if sound could not<br>
     *          be played.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeInChannelTimed(int, Mix_Chunk*, int, int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1440</i>
     */
    int Mix_FadeInChannelTimed(int channel, Mix_Chunk chunk, int loops, int ms, int ticks);

    /**
     * Set the volume for a specific channel.<br>
     * The volume must be between 0 (silence) and MIX_MAX_VOLUME (full volume).<br>
     * Note that MIX_MAX_VOLUME is 128. Values greater than MIX_MAX_VOLUME are<br>
     * clamped to MIX_MAX_VOLUME.<br>
     * Specifying a negative volume will not change the current volume; as such,<br>
     * this can be used to query the current volume without making changes, as<br>
     * this function returns the previous (in this case, still-current) value.<br>
     * If the specified channel is -1, this function sets the volume for all<br>
     * channels, and returns _the average_ of all channels' volumes prior to this<br>
     * call.<br>
     * The default volume for a channel is MIX_MAX_VOLUME (no attenuation).<br>
     * \param channel the channel on set/query the volume on, or -1 for all<br>
     *                channels.<br>
     * \param volume the new volume, between 0 and MIX_MAX_VOLUME, or -1 to query.<br>
     * \returns the previous volume. If the specified volume is -1, this returns<br>
     *          the current volume. If `channel` is -1, this returns the average<br>
     *          of all channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_Volume(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1462</i>
     */
    int Mix_Volume(int channel, int volume);

    /**
     * Set the volume for a specific chunk.<br>
     * In addition to channels having a volume setting, individual chunks also<br>
     * maintain a separate volume. Both values are considered when mixing, so both<br>
     * affect the final attenuation of the sound. This lets an app adjust the<br>
     * volume for all instances of a sound in addition to specific instances of<br>
     * that sound.<br>
     * The volume must be between 0 (silence) and MIX_MAX_VOLUME (full volume).<br>
     * Note that MIX_MAX_VOLUME is 128. Values greater than MIX_MAX_VOLUME are<br>
     * clamped to MIX_MAX_VOLUME.<br>
     * Specifying a negative volume will not change the current volume; as such,<br>
     * this can be used to query the current volume without making changes, as<br>
     * this function returns the previous (in this case, still-current) value.<br>
     * The default volume for a chunk is MIX_MAX_VOLUME (no attenuation).<br>
     * \param chunk the chunk whose volume to adjust.<br>
     * \param volume the new volume, between 0 and MIX_MAX_VOLUME, or -1 to query.<br>
     * \returns the previous volume. If the specified volume is -1, this returns<br>
     *          the current volume. If `chunk` is NULL, this returns -1.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_VolumeChunk(Mix_Chunk*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1484</i>
     */
    int Mix_VolumeChunk(Mix_Chunk chunk, int volume);

    /**
     * Set the volume for the music channel.<br>
     * The volume must be between 0 (silence) and MIX_MAX_VOLUME (full volume).<br>
     * Note that MIX_MAX_VOLUME is 128. Values greater than MIX_MAX_VOLUME are<br>
     * clamped to MIX_MAX_VOLUME.<br>
     * Specifying a negative volume will not change the current volume; as such,<br>
     * this can be used to query the current volume without making changes, as<br>
     * this function returns the previous (in this case, still-current) value.<br>
     * The default volume for music is MIX_MAX_VOLUME (no attenuation).<br>
     * \param volume the new volume, between 0 and MIX_MAX_VOLUME, or -1 to query.<br>
     * \returns the previous volume. If the specified volume is -1, this returns<br>
     *          the current volume.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_VolumeMusic(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1500</i>
     */
    int Mix_VolumeMusic(int volume);

    /**
     * Query the current volume value for a music object.<br>
     * \param music the music object to query.<br>
     * \returns the music's current volume, between 0 and MIX_MAX_VOLUME (128).<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>int Mix_GetMusicVolume(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1508</i>
     */
    int Mix_GetMusicVolume(PointerByReference music);

    /**
     * Set the master volume for all channels.<br>
     * SDL_mixer keeps a per-channel volume, a per-chunk volume, and a master<br>
     * volume, and considers all three when mixing audio. This function sets the<br>
     * master volume, which is applied to all playing channels when mixing.<br>
     * The volume must be between 0 (silence) and MIX_MAX_VOLUME (full volume).<br>
     * Note that MIX_MAX_VOLUME is 128. Values greater than MIX_MAX_VOLUME are<br>
     * clamped to MIX_MAX_VOLUME.<br>
     * Specifying a negative volume will not change the current volume; as such,<br>
     * this can be used to query the current volume without making changes, as<br>
     * this function returns the previous (in this case, still-current) value.<br>
     * Note that the master volume does not affect any playing music; it is only<br>
     * applied when mixing chunks. Use Mix_MusicVolume() for that. *<br>
     * \param volume the new volume, between 0 and MIX_MAX_VOLUME, or -1 to query.<br>
     * \returns the previous volume. If the specified volume is -1, this returns<br>
     *          the current volume.<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>int Mix_MasterVolume(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1528</i>
     */
    int Mix_MasterVolume(int volume);

    /**
     * Halt playing of a particular channel.<br>
     * This will stop further playback on that channel until a new chunk is<br>
     * started there.<br>
     * Specifying a channel of -1 will halt _all_ channels, except for any playing<br>
     * music.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * before this function returns.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * \param channel channel to halt, or -1 to halt all channels.<br>
     * \returns 0 on success, or -1 on error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_HaltChannel(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1544</i>
     */
    int Mix_HaltChannel(int channel);

    /**
     * Halt playing of a group of channels by arbitrary tag.<br>
     * This will stop further playback on all channels with a specific tag, until<br>
     * a new chunk is started there.<br>
     * A tag is an arbitrary number that can be assigned to several mixer<br>
     * channels, to form groups of channels.<br>
     * The default tag for a channel is -1.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * before this function returns.<br>
     * \param tag an arbitrary value, assigned to channels, to search for.<br>
     * \returns zero, whether any channels were halted or not.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_HaltGroup(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1560</i>
     */
    int Mix_HaltGroup(int tag);

    /**
     * Halt playing of the music stream.<br>
     * This will stop further playback of music until a new music object is<br>
     * started there.<br>
     * Any halted music will call any callback specified by<br>
     * Mix_HookMusicFinished() before this function returns.<br>
     * \returns zero, regardless of whether any music was halted.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_HaltMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1571</i>
     */
    int Mix_HaltMusic();

    /**
     * Change the expiration delay for a particular channel.<br>
     * The channel will halt after the 'ticks' milliseconds have elapsed, or<br>
     * remove the expiration if 'ticks' is -1.<br>
     * This overrides the value passed to the fourth parameter of<br>
     * Mix_PlayChannelTimed().<br>
     * Specifying a channel of -1 will set an expiration for _all_ channels.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * once the halt occurs.<br>
     * Note that this function does not block for the number of ticks requested;<br>
     * it just schedules the chunk to expire and notes the time for the mixer to<br>
     * manage later, and returns immediately.<br>
     * \param channel the channel to change the expiration time on.<br>
     * \param ticks number of milliseconds from now to let channel play before<br>
     *              halting, -1 to not halt.<br>
     * \returns the number of channels that changed expirations.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_ExpireChannel(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1592</i>
     */
    int Mix_ExpireChannel(int channel, int ticks);

    /**
     * Halt a channel after fading it out for a specified time.<br>
     * This will begin a channel fading from its current volume to silence over<br>
     * `ms` milliseconds. After that time, the channel is halted.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * once the halt occurs.<br>
     * A fading channel will change it's volume progressively, as if Mix_Volume()<br>
     * was called on it (which is to say: you probably shouldn't call Mix_Volume()<br>
     * on a fading channel).<br>
     * Note that this function does not block for the number of milliseconds<br>
     * requested; it just schedules the chunk to fade and notes the time for the<br>
     * mixer to manage later, and returns immediately.<br>
     * \param which the channel to fade out.<br>
     * \param ms number of milliseconds to fade before halting the channel.<br>
     * \returns the number of channels scheduled to fade.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeOutChannel(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1612</i>
     */
    int Mix_FadeOutChannel(int which, int ms);

    /**
     * Halt a playing group of channels by arbitrary tag, after fading them out<br>
     * for a specified time.<br>
     * This will begin fading a group of channels with a specific tag from their<br>
     * current volumes to silence over `ms` milliseconds. After that time, those<br>
     * channels are halted.<br>
     * A tag is an arbitrary number that can be assigned to several mixer<br>
     * channels, to form groups of channels.<br>
     * The default tag for a channel is -1.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * once the halt occurs.<br>
     * A fading channel will change it's volume progressively, as if Mix_Volume()<br>
     * was called on it (which is to say: you probably shouldn't call Mix_Volume()<br>
     * on a fading channel).<br>
     * Note that this function does not block for the number of milliseconds<br>
     * requested; it just schedules the group to fade and notes the time for the<br>
     * mixer to manage later, and returns immediately.<br>
     * \param tag an arbitrary value, assigned to channels, to search for.<br>
     * \param ms number of milliseconds to fade before halting the group.<br>
     * \returns the number of channels that were scheduled for fading.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeOutGroup(int, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1637</i>
     */
    int Mix_FadeOutGroup(int tag, int ms);

    /**
     * Halt the music stream after fading it out for a specified time.<br>
     * This will begin the music fading from its current volume to silence over<br>
     * `ms` milliseconds. After that time, the music is halted.<br>
     * Any halted music will call any callback specified by<br>
     * Mix_HookMusicFinished() once the halt occurs.<br>
     * Fading music will change it's volume progressively, as if Mix_VolumeMusic()<br>
     * was called on it (which is to say: you probably shouldn't call<br>
     * Mix_VolumeMusic() on a fading channel).<br>
     * Note that this function does not block for the number of milliseconds<br>
     * requested; it just schedules the music to fade and notes the time for the<br>
     * mixer to manage later, and returns immediately.<br>
     * \param ms number of milliseconds to fade before halting the channel.<br>
     * \returns non-zero if music was scheduled to fade, zero otherwise. If no<br>
     *          music is currently playing, this returns zero.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_FadeOutMusic(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1656</i>
     */
    int Mix_FadeOutMusic(int ms);

    /**
     * Query the fading status of the music stream.<br>
     * This reports one of three values:<br>
     * - `MIX_NO_FADING`<br>
     * - `MIX_FADING_OUT`<br>
     * - `MIX_FADING_IN`<br>
     * If music is not currently playing, this returns `MIX_NO_FADING`.<br>
     * \returns the current fading status of the music stream.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>Mix_Fading Mix_FadingMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1668</i>
     */
    int Mix_FadingMusic();

    /**
     * Query the fading status of a channel.<br>
     * This reports one of three values:<br>
     * - `MIX_NO_FADING`<br>
     * - `MIX_FADING_OUT`<br>
     * - `MIX_FADING_IN`<br>
     * If nothing is currently playing on the channel, or an invalid channel is<br>
     * specified, this returns `MIX_NO_FADING`.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * You may not specify -1 for all channels; only individual channels may be<br>
     * queried.<br>
     * \param which the channel to query.<br>
     * \returns the current fading status of the channel.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>Mix_Fading Mix_FadingChannel(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1685</i>
     */
    int Mix_FadingChannel(int which);

    /**
     * Pause a particular channel.<br>
     * Pausing a channel will prevent further playback of the assigned chunk but<br>
     * will maintain the chunk's current mixing position. When resumed, this<br>
     * channel will continue to mix the chunk where it left off.<br>
     * A paused channel can be resumed by calling Mix_Resume().<br>
     * A paused channel with an expiration will not expire while paused (the<br>
     * expiration countdown will be adjusted once resumed).<br>
     * It is legal to halt a paused channel. Playing a new chunk on a paused<br>
     * channel will replace the current chunk and unpause the channel.<br>
     * Specifying a channel of -1 will pause _all_ channels. Any music is<br>
     * unaffected.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * \param channel the channel to pause, or -1 to pause all channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_Pause(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1703</i>
     */
    void Mix_Pause(int channel);

    /**
     * Resume a particular channel.<br>
     * It is legal to resume an unpaused or invalid channel; it causes no effect<br>
     * and reports no error.<br>
     * If the paused channel has an expiration, its expiration countdown resumes<br>
     * now, as well.<br>
     * Specifying a channel of -1 will resume _all_ paused channels. Any music is<br>
     * unaffected.<br>
     * \param channel the channel to resume, or -1 to resume all paused channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_Resume(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1716</i>
     */
    void Mix_Resume(int channel);

    /**
     * Query whether a particular channel is paused.<br>
     * If an invalid channel is specified, this function returns zero.<br>
     * \param channel the channel to query, or -1 to query all channels.<br>
     * \return 1 if channel paused, 0 otherwise. If `channel` is -1, returns the<br>
     *         number of paused channels.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_Paused(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1726</i>
     */
    int Mix_Paused(int channel);

    /**
     * Pause the music stream.<br>
     * Pausing the music stream will prevent further playback of the assigned<br>
     * music object, but will maintain the object's current mixing position. When<br>
     * resumed, this channel will continue to mix the music where it left off.<br>
     * Paused music can be resumed by calling Mix_ResumeMusic().<br>
     * It is legal to halt paused music. Playing a new music object when music is<br>
     * paused will replace the current music and unpause the music stream.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_PauseMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1738</i>
     */
    void Mix_PauseMusic();

    /**
     * Resume the music stream.<br>
     * It is legal to resume an unpaused music stream; it causes no effect and<br>
     * reports no error.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_ResumeMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1746</i>
     */
    void Mix_ResumeMusic();

    /**
     * Rewind the music stream.<br>
     * This causes the currently-playing music to start mixing from the beginning<br>
     * of the music, as if it were just started.<br>
     * It's a legal no-op to rewind the music stream when not playing.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>void Mix_RewindMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1755</i>
     */
    void Mix_RewindMusic();

    /**
     * Query whether the music stream is paused.<br>
     * \return 1 if music is paused, 0 otherwise.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_PauseMusic<br>
     * \sa Mix_ResumeMusic<br>
     * Original signature : <code>int Mix_PausedMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1764</i>
     */
    int Mix_PausedMusic();

    /**
     * Jump to a given order in mod music.<br>
     * This only applies to MOD music formats.<br>
     * \param order order<br>
     * \returns 0 if successful, or -1 if failed or isn't implemented.<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>int Mix_ModMusicJumpToOrder(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1773</i>
     */
    int Mix_ModMusicJumpToOrder(int order);

    /**
     * Start a track in music object.<br>
     * This only applies to GME music formats.<br>
     * \param music the music object.<br>
     * \param track the track number to play. 0 is the first track.<br>
     * \returns 0 if successful, or -1 if failed or isn't implemented.<br>
     * \since This function is available since SDL_mixer 2.8.0.<br>
     * Original signature : <code>int Mix_StartTrack(Mix_Music*, int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1783</i>
     */
    int Mix_StartTrack(PointerByReference music, int track);

    /**
     * Get number of tracks in music object.<br>
     * This only applies to GME music formats.<br>
     * \param music the music object.<br>
     * \returns number of tracks if successful, or -1 if failed or isn't<br>
     *          implemented.<br>
     * \since This function is available since SDL_mixer 2.8.0.<br>
     * Original signature : <code>int Mix_GetNumTracks(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1793</i>
     */
    int Mix_GetNumTracks(PointerByReference music);

    /**
     * Set the current position in the music stream, in seconds.<br>
     * To convert from milliseconds, divide by 1000.0.<br>
     * This function is only implemented for MOD music formats (set pattern order<br>
     * number) and for WAV, OGG, FLAC, MP3, and MODPLUG music at the moment.<br>
     * \param position the new position, in seconds (as a double).<br>
     * \returns 0 if successful, or -1 if it failed or not implemented.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetMusicPosition(double)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1804</i>
     */
    int Mix_SetMusicPosition(double position);

    /**
     * Get the time current position of music stream, in seconds.<br>
     * To convert to milliseconds, multiply by 1000.0.<br>
     * \param music the music object to query.<br>
     * \returns -1.0 if this feature is not supported for some codec.<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>double Mix_GetMusicPosition(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1813</i>
     */
    double Mix_GetMusicPosition(PointerByReference music);

    /**
     * Get a music object's duration, in seconds.<br>
     * To convert to milliseconds, multiply by 1000.0.<br>
     * If NULL is passed, returns duration of current playing music.<br>
     * \param music the music object to query.<br>
     * \returns music duration in seconds, or -1.0 on error.<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>double Mix_MusicDuration(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1823</i>
     */
    double Mix_MusicDuration(PointerByReference music);

    /**
     * Get the loop start time position of music stream, in seconds.<br>
     * To convert to milliseconds, multiply by 1000.0.<br>
     * If NULL is passed, returns duration of current playing music.<br>
     * \param music the music object to query.<br>
     * \returns -1.0 if this feature is not used for this music or not supported<br>
     *          for some codec<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>double Mix_GetMusicLoopStartTime(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1834</i>
     */
    double Mix_GetMusicLoopStartTime(PointerByReference music);

    /**
     * Get the loop end time position of music stream, in seconds.<br>
     * To convert to milliseconds, multiply by 1000.0.<br>
     * If NULL is passed, returns duration of current playing music.<br>
     * \param music the music object to query.<br>
     * \returns -1.0 if this feature is not used for this music or not supported<br>
     *          for some codec<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>double Mix_GetMusicLoopEndTime(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1845</i>
     */
    double Mix_GetMusicLoopEndTime(PointerByReference music);

    /**
     * Get the loop time length of music stream, in seconds.<br>
     * To convert to milliseconds, multiply by 1000.0.<br>
     * If NULL is passed, returns duration of current playing music.<br>
     * \param music the music object to query.<br>
     * \returns -1.0 if this feature is not used for this music or not supported<br>
     *          for some codec<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>double Mix_GetMusicLoopLengthTime(Mix_Music*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1856</i>
     */
    double Mix_GetMusicLoopLengthTime(PointerByReference music);

    /**
     * Check the playing status of a specific channel.<br>
     * If the channel is currently playing, this function returns 1. Otherwise it<br>
     * returns 0.<br>
     * If the specified channel is -1, all channels are checked, and this function<br>
     * returns the number of channels currently playing.<br>
     * You may not specify MAX_CHANNEL_POST for a channel.<br>
     * Paused channels are treated as playing, even though they are not currently<br>
     * making forward progress in mixing.<br>
     * \param channel channel<br>
     * \returns non-zero if channel is playing, zero otherwise. If `channel` is<br>
     *          -1, return the total number of channel playings.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_Playing(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1872</i>
     */
    int Mix_Playing(int channel);

    /**
     * Check the playing status of the music stream.<br>
     * If music is currently playing, this function returns 1. Otherwise it<br>
     * returns 0.<br>
     * Paused music is treated as playing, even though it is not currently making<br>
     * forward progress in mixing.<br>
     * \returns non-zero if music is playing, zero otherwise.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_PlayingMusic()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1883</i>
     */
    int Mix_PlayingMusic();

    /**
     * Run an external command as the music stream.<br>
     * This halts any currently-playing music, and next time the music stream is<br>
     * played, SDL_mixer will spawn a process using the command line specified in<br>
     * `command`. This command is not subject to shell expansion, and beyond some<br>
     * basic splitting up of arguments, is passed to execvp() on most platforms,<br>
     * not system().<br>
     * The command is responsible for generating sound; it is NOT mixed by<br>
     * SDL_mixer! SDL_mixer will kill the child process if asked to halt the<br>
     * music, but otherwise does not have any control over what the process does.<br>
     * You are strongly encouraged not to use this function without an extremely<br>
     * good reason.<br>
     * \param command command<br>
     * \returns 0 if successful, -1 on error<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetMusicCMD(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1901</i>
     */
    int Mix_SetMusicCMD(String command);

    /**
     * This function does nothing, do not use.<br>
     * This was probably meant to expose a feature, but no codecs support it, so<br>
     * it only remains for binary compatibility.<br>
     * Calling this function is a legal no-op that returns -1.<br>
     * \param value this parameter is ignored.<br>
     * \returns -1.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetSynchroValue(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1912</i>
     */
    int Mix_SetSynchroValue(int value);

    /**
     * This function does nothing, do not use.<br>
     * This was probably meant to expose a feature, but no codecs support it, so<br>
     * it only remains for binary compatibility.<br>
     * Calling this function is a legal no-op that returns -1.<br>
     * \returns -1.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_GetSynchroValue()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1922</i>
     */
    int Mix_GetSynchroValue();

    /**
     * Set SoundFonts paths to use by supported MIDI backends.<br>
     * You may specify multiple paths in a single string by separating them with<br>
     * semicolons; they will be searched in the order listed.<br>
     * This function replaces any previously-specified paths.<br>
     * Passing a NULL path will remove any previously-specified paths.<br>
     * Note that unlike most SDL and SDL_mixer functions, this function returns<br>
     * zero if there's an error, not on success. We apologize for the API design<br>
     * inconsistency here.<br>
     * \param paths Paths on the filesystem where SoundFonts are available,<br>
     *              separated by semicolons.<br>
     * \returns 1 if successful, 0 on error (out of memory).<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>int Mix_SetSoundFonts(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1938</i>
     */
    int Mix_SetSoundFonts(String paths);

    /**
     * Get SoundFonts paths to use by supported MIDI backends.<br>
     * There are several factors that determine what will be reported by this<br>
     * function:<br>
     * - If the boolean _SDL hint_ `"SDL_FORCE_SOUNDFONTS"` is set, AND the<br>
     *   `"SDL_SOUNDFONTS"` _environment variable_ is also set, this function will<br>
     *   return that environment variable regardless of whether<br>
     *   Mix_SetSoundFounts() was ever called.<br>
     * - Otherwise, if Mix_SetSoundFonts() was successfully called with a non-NULL<br>
     *   path, this function will return the string passed to that function.<br>
     * - Otherwise, if the `"SDL_SOUNDFONTS"` variable is set, this function will<br>
     *   return that environment variable.<br>
     * - Otherwise, this function will search some common locations on the<br>
     *   filesystem, and if it finds a SoundFont there, it will return that.<br>
     * - Failing everything else, this function returns NULL.<br>
     * This returns a pointer to internal (possibly read-only) memory, and it<br>
     * should not be modified or free'd by the caller.<br>
     * \returns semicolon-separated list of sound font paths.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>char* Mix_GetSoundFonts()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1960</i>
     */
    String Mix_GetSoundFonts();

    /**
     * Iterate SoundFonts paths to use by supported MIDI backends.<br>
     * This function will take the string reported by Mix_GetSoundFonts(), split<br>
     * it up into separate paths, as delimited by semicolons in the string, and<br>
     * call a callback function for each separate path.<br>
     * If there are no paths available, this returns 0 without calling the<br>
     * callback at all.<br>
     * If the callback returns non-zero, this function stops iterating and returns<br>
     * non-zero. If the callback returns 0, this function will continue iterating,<br>
     * calling the callback again for further paths. If the callback never returns<br>
     * 1, this function returns 0, so this can be used to decide if an available<br>
     * soundfont is acceptable for use.<br>
     * \param function the callback function to call once per path.<br>
     * \param data a pointer to pass to the callback for its own personal use.<br>
     * \returns non-zero if callback ever returned non-zero, 0 on error or the<br>
     *          callback never returned non-zero.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_GetSoundFonts<br>
     * Original signature : <code>int Mix_EachSoundFont(Mix_EachSoundFont_function_callback*, void*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1981</i>
     */
    int Mix_EachSoundFont(Mix_EachSoundFont_function_callback function, Pointer data);

    /**
     * Set full path of the Timidity config file.<br>
     * For example, "/etc/timidity.cfg"<br>
     * This is obviously only useful if SDL_mixer is using Timidity internally to<br>
     * play MIDI files.<br>
     * \param path path to a Timidity config file.<br>
     * \returns 1 if successful, 0 on error<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * Original signature : <code>int Mix_SetTimidityCfg(const char*)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:1992</i>
     */
    int Mix_SetTimidityCfg(String path);

    /**
     * Get full path of a previously-specified Timidity config file.<br>
     * For example, "/etc/timidity.cfg"<br>
     * If a path has never been specified, this returns NULL.<br>
     * This returns a pointer to internal memory, and it should not be modified or<br>
     * free'd by the caller.<br>
     * \returns the previously-specified path, or NULL if not set.<br>
     * \since This function is available since SDL_mixer 2.6.0.<br>
     * \sa Mix_SetTimidityCfg<br>
     * Original signature : <code>char* Mix_GetTimidityCfg()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:2004</i>
     */
    String Mix_GetTimidityCfg();

    /**
     * Get the Mix_Chunk currently associated with a mixer channel.<br>
     * You may not specify MAX_CHANNEL_POST or -1 for a channel.<br>
     * \param channel the channel to query.<br>
     * \returns the associated chunk, if any, or NULL if it's an invalid channel.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * Original signature : <code>Mix_Chunk* Mix_GetChunk(int)</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:2013</i>
     */
    Mix_Chunk Mix_GetChunk(int channel);

    /**
     * Close the mixer, halting all playing audio.<br>
     * Any halted channels will have any currently-registered effects<br>
     * deregistered, and will call any callback specified by Mix_ChannelFinished()<br>
     * before this function returns.<br>
     * Any halted music will call any callback specified by<br>
     * Mix_HookMusicFinished() before this function returns.<br>
     * Do not start any new audio playing during callbacks in this function.<br>
     * This will close the audio device. Attempting to play new audio after this<br>
     * function returns will fail, until another successful call to<br>
     * Mix_OpenAudio() or Mix_OpenAudioDevice().<br>
     * Note that (unlike Mix_OpenAudio optionally calling SDL_Init(SDL_INIT_AUDIO)<br>
     * on the app's behalf), this will _not_ deinitialize the SDL audio subsystem<br>
     * in any case. At some point after calling this function and Mix_Quit(), some<br>
     * part of the application should be responsible for calling SDL_Quit() to<br>
     * deinitialize all of SDL, including its audio subsystem.<br>
     * This function should be the last thing you call in SDL_mixer before<br>
     * Mix_Quit(). However, the following notes apply if you don't follow this<br>
     * advice:<br>
     * Note that this will not free any loaded chunks or music; you should dispose<br>
     * of those resources separately. It is probably poor form to dispose of them<br>
     * _after_ this function, but it is safe to call Mix_FreeChunk() and<br>
     * Mix_FreeMusic() after closing the device.<br>
     * Note that any chunks or music you don't free may or may not work if you<br>
     * call Mix_OpenAudio again, as the audio device may be in a new format and<br>
     * the existing chunks will not be converted to match.<br>
     * \since This function is available since SDL_mixer 2.0.0.<br>
     * \sa Mix_Quit<br>
     * Original signature : <code>void Mix_CloseAudio()</code><br>
     * <i>native declaration : /usr/local/include/SDL2/SDL_mixer.h:2044</i>
     */
    void Mix_CloseAudio();

    interface MIX_InitFlags {
        int MIX_INIT_FLAC = 0x00000001;
        int MIX_INIT_MOD = 0x00000002;
        int MIX_INIT_MP3 = 0x00000008;
        int MIX_INIT_OGG = 0x00000010;
        int MIX_INIT_MID = 0x00000020;
        int MIX_INIT_OPUS = 0x00000040;
        int MIX_INIT_WAVPACK = 0x00000080;
    }

    interface Mix_Fading {
        int MIX_NO_FADING = 0;
        int MIX_FADING_OUT = 1;
        int MIX_FADING_IN = 2;
    }

    interface Mix_MusicType {
        int MUS_NONE = 0;
        int MUS_CMD = 1;
        int MUS_WAV = 2;
        int MUS_MOD = 3;
        int MUS_MID = 4;
        int MUS_OGG = 5;
        int MUS_MP3 = 6;
        int MUS_MP3_MAD_UNUSED = 7;
        int MUS_FLAC = 8;
        int MUS_MODPLUG_UNUSED = 9;
        int MUS_OPUS = 10;
        int MUS_WAVPACK = 11;
        int MUS_GME = 12;
    }

    interface Mix_EffectFunc_t extends Callback {
        void apply(int chan, Pointer stream, int len, Pointer udata);
    }

    interface Mix_EffectDone_t extends Callback {
        void apply(int chan, Pointer udata);
    }

    interface Mix_SetPostMix_mix_func_callback extends Callback {
        void apply(Pointer udata, short stream, int len);
    }

    interface Mix_HookMusic_mix_func_callback extends Callback {
        void apply(Pointer udata, short stream, int len);
    }

    interface Mix_HookMusicFinished_music_finished_callback extends Callback {
        void apply();
    }

    interface Mix_ChannelFinished_channel_finished_callback extends Callback {
        void apply(int channel);
    }

    interface Mix_EachSoundFont_function_callback extends Callback {
        int apply(Pointer charPtr1, Pointer voidPtr1);
    }

    class SDL_version extends PointerType {
        public SDL_version(Pointer address) {
            super(address);
        }

        public SDL_version() {
            super();
        }
    }

    class SDL_RWops extends PointerType {
        public SDL_RWops(Pointer address) {
            super(address);
        }

        public SDL_RWops() {
            super();
        }
    }

    class SDL_bool extends PointerType {
        public SDL_bool(Pointer address) {
            super(address);
        }

        public SDL_bool() {
            super();
        }
    }

    class Sint16 extends PointerType {
        public Sint16(Pointer address) {
            super(address);
        }

        public Sint16() {
            super();
        }
    }

    class Mix_Music extends PointerType {
        public Mix_Music(Pointer address) {
            super(address);
        }

        public Mix_Music() {
            super();
        }
    }
}
