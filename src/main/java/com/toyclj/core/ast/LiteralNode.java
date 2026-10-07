package com.toyclj.core.ast;

import com.toyclj.core.types.Value;

record LiteralNode(Value val) implements Node {}
