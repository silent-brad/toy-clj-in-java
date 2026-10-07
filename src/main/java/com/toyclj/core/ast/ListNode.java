package com.toyclj.core.ast;

import java.util.List;

record ListNode(List<Node> children) implements Node {}
