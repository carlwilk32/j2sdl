package org.libsdl.api.vulkan;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.video.SDL_Window;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_VULKAN;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.vulkan.SdlVulkan.SDL_Vulkan_GetInstanceExtensions;

public class SdlVulkanTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_VIDEO);
    }

    @Test
    public void getVulkanInfo() throws InterruptedException {
        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_VULKAN | SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        List<String> extensions = SDL_Vulkan_GetInstanceExtensions(window);
        System.out.println("Vulkan extensions: " + extensions);
        assertNotNull(extensions, () -> "SDL Failure: " + SDL_GetError());
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_VIDEO);
    }
}
