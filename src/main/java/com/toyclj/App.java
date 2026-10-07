package com.toyclj;

import com.toyclj.core.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
  public static void main(String[] args) throws IOException {
    System.out.println("Toy Clojure Interpreter in Java");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.print("Type 'exit' to exit: ");
      System.out.flush();
      System.out.print("> ");
      String input = reader.readLine();
      if (input.equals("exit")) break;

      // TODO: Do something with input
      // TODO: Handle errors
      Reader.Result result = Reader.read(input);
      switch (result.type()) {
        case SUCCESS:
          System.out.println(result.value());
          break;
        case ERROR:
          System.out.println(result.error());
          break;
        case EOF:
          System.out.println("EOF");
          break;
      }
    }
  }
}
