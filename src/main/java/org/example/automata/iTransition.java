package org.example.automata;

public interface iTransition {
    State nextState(String str);
    boolean isRecursive();
}
