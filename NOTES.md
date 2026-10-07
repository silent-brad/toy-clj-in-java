# Notes

## Process

- [ ] Start with the overarching system design

  ```
  com.toyclj/
    App.java                 # REPL entry point
    core/
      Reader.java            # tokenization + s-expr reading
      Printer.java           # pretty-printing of Values
      Parser.java            # turns tokens into AST
      Evaluator.java         # the interpreter
      Environment.java       # bindings / scopes (Env)
      Stdlib.java            # loads & evaluates stdlib.clj
      types/
        Value.java           # sealed interface + concrete records
        Symbol.java
        LispList.java
        Number.java
        Bool.java
        ...
      ast/
        Node.java            # base AST node (or sealed interface)
        ListNode.java
        SymbolNode.java
        LiteralNode.java
        ...
      primitives/
        Primitives.java      # +, -, def, if, etc. (or individual files)
      patterns/
        Pattern.java         # pattern matching / destructuring
      macros/
        Macro.java
        expand.java          # macro expansion
  ```

- [ ] Break the system into modules/files and then functions with signatures
- [ ] Write test code for each function
- [ ] Write each function
