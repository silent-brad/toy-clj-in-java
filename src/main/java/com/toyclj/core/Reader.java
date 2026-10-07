package com.toyclj.core;

/** tokenization + s-expr reading */
public class Reader {
  public enum ResultType {
    SUCCESS,
    ERROR,
    EOF
  }

  public enum ErrorType {
    UNKNOWN_INPUT,
    NONE
  }

  public record Result(ResultType type, String value, ErrorType error) {}

  // NOTE: this only reads one line right now
  public static Result read(String line) {
    if (line.equals("exit")) return new Result(ResultType.EOF, "", ErrorType.NONE);

    line = eatWhitespace(line);

    switch (line) {
      case "+":
        return new Result(ResultType.SUCCESS, "+", ErrorType.NONE);
      case "-":
        return new Result(ResultType.SUCCESS, "-", ErrorType.NONE);
      case "*":
        return new Result(ResultType.SUCCESS, "*", ErrorType.NONE);
      case "/":
        return new Result(ResultType.SUCCESS, "/", ErrorType.NONE);
      case "=":
        return new Result(ResultType.SUCCESS, "=", ErrorType.NONE);
      case ">":
        return new Result(ResultType.SUCCESS, ">", ErrorType.NONE);
      case "<":
        return new Result(ResultType.SUCCESS, "<", ErrorType.NONE);
      case "and":
        return new Result(ResultType.SUCCESS, "and", ErrorType.NONE);
      case "or":
        return new Result(ResultType.SUCCESS, "or", ErrorType.NONE);
      case "not":
        return new Result(ResultType.SUCCESS, "not", ErrorType.NONE);
      case "true":
        return new Result(ResultType.SUCCESS, "true", ErrorType.NONE);
      case "false":
        return new Result(ResultType.SUCCESS, "false", ErrorType.NONE);
      case "#":
        return new Result(ResultType.SUCCESS, "", ErrorType.UNKNOWN_INPUT);
      default:
        return new Result(ResultType.ERROR, "ERROR: unknown input", ErrorType.UNKNOWN_INPUT);
    }
  }

  static String eatWhitespace(String line) {
    while (line.startsWith(" ") || line.startsWith("\t")) line = line.substring(1);
    return line;
  }
}
