package com.github.carlwilk32.sdl.core.api.messagebox;

import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxButtonFlags.SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxButtonFlags.SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BACKGROUND;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_BORDER;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_TEXT;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_INFORMATION;
import static com.github.carlwilk32.sdl.core.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_WARNING;
import static com.github.carlwilk32.sdl.core.api.messagebox.SdlMessagebox.SDL_ShowMessageBox;
import static com.github.carlwilk32.sdl.core.api.messagebox.SdlMessagebox.SDL_ShowSimpleMessageBox;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.carlwilk32.sdl.core.api.error.SdlError;
import com.github.carlwilk32.sdl.core.jna.ContiguousArrayList;
import com.sun.jna.ptr.IntByReference;

class SdlMessageboxTest {

  // This class does not contain proper @Test methods because it isn't easy to close the message box
  // programatically
  // in an OS portable fashion.
  public static void main(String[] args) throws InterruptedException {
    SdlMessageboxTest testObject = new SdlMessageboxTest();
    testObject.simpleMessageBoxShouldBeDisplayedEvenWithoutSdlInit();
    testObject.fullMessageBoxShouldBeDisplayedEvenWithoutSdlInit();
  }

  public void simpleMessageBoxShouldBeDisplayedEvenWithoutSdlInit() {
    int result =
        SDL_ShowSimpleMessageBox(SDL_MESSAGEBOX_INFORMATION, "Test title", "Test message", null);
    assertEquals(result, 0);
  }

  public void fullMessageBoxShouldBeDisplayedEvenWithoutSdlInit() throws InterruptedException {
    SDL_MessageBoxData data = new SDL_MessageBoxData();
    data.flags = SDL_MESSAGEBOX_WARNING;
    data.window = null;
    data.title = "Test title 2";
    data.message = "Test message 2";
    prepareButtons(data);
    data.colorScheme = new SDL_MessageBoxColorScheme();
    data.colorScheme.setColorFor(
        SDL_MESSAGEBOX_COLOR_BACKGROUND, new SDL_MessageBoxColor(255, 255, 255));
    data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_TEXT, 0, 0, 0);
    data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_BORDER, 255, 0, 0);
    data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND, 0, 255, 0);
    data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED, 0, 0, 255);
    IntByReference clickedButtonRef = new IntByReference();

    int result = SDL_ShowMessageBox(data, clickedButtonRef);

    assertEquals(result, 0, "Error in SDL call: " + SdlError.SDL_GetError());
    if (clickedButtonRef.getValue() == 999) {
      System.out.println("User clicked Yes (" + clickedButtonRef.getValue() + ")");
    } else if (clickedButtonRef.getValue() == 5555) {
      System.out.println("User clicked No (" + clickedButtonRef.getValue() + ")");
    } else {
      throw new AssertionError(
          "Failed to check which button was clicked on the message box ("
              + clickedButtonRef.getValue()
              + ")");
    }
  }

  private void prepareButtons(SDL_MessageBoxData data) {
    ContiguousArrayList<SDL_MessageBoxButtonData> buttons =
        new ContiguousArrayList<>(SDL_MessageBoxButtonData.class, 2);
    buttons.get(0).flags = SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT;
    buttons.get(0).buttonid = 999;
    buttons.get(0).text = "Yes";
    buttons.get(1).flags = SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT;
    buttons.get(1).buttonid = 5555;
    buttons.get(1).text = "No";
    data.setButtons(buttons);
  }
}
