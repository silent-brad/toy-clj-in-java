package com.toyclj.core.types;

import java.util.List;

public record LispList(List<Value> items) implements Value {}
