package com.toyclj.core.types;

public class Token {
  public final String value;
  public final int line;
  public final int column;

  public Token(String value, int line, int column) {
    this.value = value;
    this.line = line;
    this.column = column;
  }

  @Override
  public String toString() {
    return String.format("Token(%s, %d, %d)", value, line, column);
  }
}
