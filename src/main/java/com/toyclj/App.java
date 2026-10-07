package com.toyclj;

import com.toyclj.core.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {

  public static void runRepl(BufferedReader in, PrintStream out) throws IOException {
    while (true) {
      out.print("Type 'exit' to exit: ");
      out.flush();
      out.print("> ");
      String input = in.readLine();
      if (input == null || input.equals("exit")) break;

      Reader.Result result = Reader.read(input);
      switch (result.type()) {
        case SUCCESS -> out.println(result.value());
        case ERROR -> out.println(result.error());
        case EOF -> out.println("EOF");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Toy Clojure Interpreter in Java");
    runRepl(new BufferedReader(new InputStreamReader(System.in)), System.out);
  }
}
