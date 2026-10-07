package com.toyclj.core.ast;

/** base AST node (or sealed interface) */
public sealed interface Node permits ListNode, SymbolNode, LiteralNode {}
