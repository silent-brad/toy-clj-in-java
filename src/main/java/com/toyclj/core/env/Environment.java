package com.toyclj.core.env;

import com.toyclj.core.types.Symbol;
import com.toyclj.core.types.Value;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Lexical environment (bindings / scopes).
 *
 * <p>Global scope has no parent. Child scopes point to their parent (for lexical scoping). {@code
 * define} always adds/updates a binding in this scope. {@code set} looks up the binding in the
 * chain and mutates it (for {@code set!}) {@code lookup} walks the parent chain.
 */
public final class Environment {
  private final Environment parent;
  private final Map<Symbol, Value> bindings = new HashMap<>();

  public Environment() {
    this.parent = null;
  }

  public Environment(Environment parent) {
    this.parent = Objects.requireNonNull(parent, "parent must not be null");
  }

  public Value lookup(Symbol name) {
    Objects.requireNonNull(name, "name");
    Value v = bindings.get(name);
    if (v != null) return v;
    else if (parent != null) return parent.lookup(name);
    else throw new RuntimeException("Unable to resolve symbol: " + name);
  }

  public void define(Symbol name, Value val) {
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(val, "val");
    bindings.put(name, val);
  }

  public void set(Symbol name, Value val) {
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(val, "val");

    Environment env = this;
    while (env != null) {
      if (env.bindings.containsKey(name)) {
        env.bindings.put(name, val);
        return;
      }
      env = env.parent;
    }
    throw new RuntimeException("Unable to set unbound symbol: " + name);
  }

  public boolean contains(Symbol name) {
    if (bindings.containsKey(name)) return true;
    return parent != null && parent.contains(name);
  }

  /** Optional helper – useful for debugging / the printer. */
  @Override
  public String toString() {
    return "Environment{bindings="
        + bindings.keySet()
        + ", parent="
        + (parent == null ? "null" : "..")
        + "}";
  }
}
