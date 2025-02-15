package org.example.automata;

public interface iTransition {
    boolean nextState(String str);
    boolean isRecursive();
}
