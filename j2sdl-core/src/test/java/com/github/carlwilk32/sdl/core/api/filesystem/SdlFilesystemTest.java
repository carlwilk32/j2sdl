package com.github.carlwilk32.sdl.core.api.filesystem;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Init;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.sdl.core.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static com.github.carlwilk32.sdl.core.api.filesystem.SdlFilesystem.SDL_GetBasePath;
import static com.github.carlwilk32.sdl.core.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SdlFilesystemTest {

  @BeforeEach
  public void setUp() {
    SDL_Init(SDL_INIT_VIDEO);
  }

  @Test
  public void basePathShouldBeValid() {
    int allocCountBefore = SDL_GetNumAllocations();

    Path actualBasePath = Paths.get(SDL_GetBasePath());
    Path expectedBasePath = Paths.get(System.getProperty("java.home"), "bin");
    assertEquals(expectedBasePath, actualBasePath);

    int allocCountAfter = SDL_GetNumAllocations();
    System.out.println(allocCountAfter);
    assertEquals(allocCountBefore, allocCountAfter);
  }

  @AfterEach
  public void tearDown() {
    SDL_Quit();
  }
}
