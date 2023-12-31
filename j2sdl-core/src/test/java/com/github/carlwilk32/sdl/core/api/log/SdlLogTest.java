package com.github.carlwilk32.sdl.core.api.log;

import com.github.carlwilk32.sdl.core.api.log.SdlLog;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import com.github.carlwilk32.sdl.core.api.video.SDL_Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_InitSubSystem;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_QuitSubSystem;
import static com.github.carlwilk32.sdl.core.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static com.github.carlwilk32.sdl.core.api.error.SdlError.SDL_GetError;
import static com.github.carlwilk32.sdl.core.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_ASSERT;
import static com.github.carlwilk32.sdl.core.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_INFO;
import static com.github.carlwilk32.sdl.core.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_VERBOSE;
import static com.github.carlwilk32.sdl.core.api.log.SdlLog.SDL_LogGetOutputFunction;
import static com.github.carlwilk32.sdl.core.api.log.SdlLog.SDL_LogMessage;
import static com.github.carlwilk32.sdl.core.api.log.SdlLog.SDL_LogSetAllPriority;
import static com.github.carlwilk32.sdl.core.api.log.SdlLog.SDL_LogSetOutputFunction;
import static com.github.carlwilk32.sdl.core.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static com.github.carlwilk32.sdl.core.api.video.SdlVideo.SDL_CreateWindow;
import static com.github.carlwilk32.sdl.core.api.video.SdlVideo.SDL_DestroyWindow;

public final class SdlLogTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_EVERYTHING);
    }

    @Test
    public void registerLogCallback() {
        PointerByReference originalLogFunction = new PointerByReference();
        PointerByReference originalUserData = new PointerByReference();
        SDL_LogGetOutputFunction(originalLogFunction, originalUserData);
        SDL_LogSetOutputFunction(SdlLog::routeSdlLoggingToSlf4j, Pointer.NULL);
        SDL_LogSetAllPriority(SDL_LOG_PRIORITY_VERBOSE);

        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        SDL_LogMessage(SDL_LOG_CATEGORY_ASSERT, SDL_LOG_PRIORITY_INFO, "Sample message %d, %d", 10, 20);

        SDL_DestroyWindow(window);

        SDL_LogSetOutputFunction(originalLogFunction.getValue(), originalUserData.getValue());
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_EVERYTHING);
    }
}
