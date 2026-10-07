package com.toyclj;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void replExitsOnExitCommand() throws IOException {
    String input = "exit\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    App.runRepl(new BufferedReader(new InputStreamReader(in)), new PrintStream(out));

    String output = out.toString();
    assertTrue(output.contains("> "));
    // no further processing after "exit"
  }

  @Test
  void replProcessesSuccessfulInput() throws IOException {
    // Adjust the input to whatever Reader.read expects
    String input = "+\nexit\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    App.runRepl(new BufferedReader(new InputStreamReader(in)), new PrintStream(out));

    String output = out.toString();
    assertTrue(
        output.contains("+") || output.contains("SUCCESS")); // whatever your printer produces
  }

  // @Test
  // void replHandlesError() throws IOException {
  //   String input = "!!!invalid!!!\nexit\n";
  //   // … same pattern …
  // }
}
