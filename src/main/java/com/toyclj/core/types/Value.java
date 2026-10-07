package com.toyclj.core.types;

/** sealed interface + concrete records */
public sealed interface Value permits Symbol, LispList, NumberVal, BoolVal {}
