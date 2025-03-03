package com.github.carlwilk32.sdl.core.api.rwops;

import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Init;
import static com.github.carlwilk32.sdl.core.api.Sdl.SDL_Quit;
import static com.github.carlwilk32.sdl.core.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static com.github.carlwilk32.sdl.core.api.error.SdlError.SDL_GetError;
import static com.github.carlwilk32.sdl.core.api.rwops.SdlRWops.SDL_LoadFile;
import static com.github.carlwilk32.sdl.core.api.rwops.SdlRWops.SDL_LoadFile_RW;
import static com.github.carlwilk32.sdl.core.api.rwops.SdlRWops.SDL_RWFromFile;
import static com.github.carlwilk32.sdl.core.api.rwops.SdlRWops.SDL_RWclose;
import static com.github.carlwilk32.sdl.core.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static com.github.carlwilk32.sdl.core.api.stdinc.SdlStdinc.SDL_free;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.carlwilk32.sdl.core.api.SdlTest;
import com.github.carlwilk32.sdl.core.jna.size_t;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class SdlRWopsTest {

  @BeforeEach
  public void setUp() {
    SDL_Init(SDL_INIT_VIDEO);
  }

  @Test
  public void rwOpsShouldLoadFileContent() throws Exception {
    Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
    Memory buffer = new Memory(1024L);

    SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
    assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
    try {
      SDL_RWReadFunction readFunction = ops.read;
      size_t actualReadCount =
          readFunction.read(ops, buffer, new size_t(1L), new size_t(buffer.size()));

      assertEquals(Files.size(sampleFile), actualReadCount.longValue());
      long offset = 0L;
      assertEquals('T', (char) (buffer.getByte(offset++)));
      assertEquals('h', (char) (buffer.getByte(offset++)));
      assertEquals('i', (char) (buffer.getByte(offset++)));
      assertEquals('s', (char) (buffer.getByte(offset++)));
      assertEquals(' ', (char) (buffer.getByte(offset++)));
      assertEquals('i', (char) (buffer.getByte(offset++)));
      assertEquals('s', (char) (buffer.getByte(offset)));
    } finally {
      SDL_RWclose(ops);
    }
  }

  @Test
  public void rwOpsShouldReportCorrectFileSize() throws Exception {
    Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

    SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
    assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
    try {
      SDL_RWSizeFunction readFunction = ops.size;
      long actualFileSize = readFunction.size(ops);

      assertEquals(Files.size(sampleFile), actualFileSize);
    } finally {
      SDL_RWclose(ops);
    }
  }

  @Test
  public void LoadFileUsingRwOpsShouldGiveFileContent() throws Exception {
    Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

    SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
    assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
    size_t.Ref actualReadCount = new size_t.Ref();
    Pointer buffer = SDL_LoadFile_RW(ops, actualReadCount, 1);

    assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
    long offset = 0L;
    assertEquals('T', (char) (buffer.getByte(offset++)));
    assertEquals('h', (char) (buffer.getByte(offset++)));
    assertEquals('i', (char) (buffer.getByte(offset++)));
    assertEquals('s', (char) (buffer.getByte(offset++)));
    assertEquals(' ', (char) (buffer.getByte(offset++)));
    assertEquals('i', (char) (buffer.getByte(offset++)));
    assertEquals('s', (char) (buffer.getByte(offset)));
  }

  @Test
  public void LoadFileShouldGiveFileContent() throws Exception {
    Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
    int allocCount = SDL_GetNumAllocations();

    size_t.Ref actualReadCount = new size_t.Ref();
    Pointer buffer = SDL_LoadFile(sampleFile.toString(), actualReadCount);
    assertNotNull(buffer, "Failed to load file " + sampleFile + ": " + SDL_GetError());

    assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
    long offset = 0L;
    assertEquals('T', (char) (buffer.getByte(offset++)));
    assertEquals('h', (char) (buffer.getByte(offset++)));
    assertEquals('i', (char) (buffer.getByte(offset++)));
    assertEquals('s', (char) (buffer.getByte(offset++)));
    assertEquals(' ', (char) (buffer.getByte(offset++)));
    assertEquals('i', (char) (buffer.getByte(offset++)));
    assertEquals('s', (char) (buffer.getByte(offset)));

    assertEquals(allocCount + 1, SDL_GetNumAllocations());
    SDL_free(buffer);
    assertEquals(allocCount, SDL_GetNumAllocations());
  }

  @AfterEach
  public void tearDown() {
    SDL_Quit();
  }
}
