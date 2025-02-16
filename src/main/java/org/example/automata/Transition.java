package org.example.automata;

import java.util.HashSet;
import java.util.Set;

public class Transition implements iTransition {
    private Set<Character> charSet = new HashSet<>();
    private State reference;
    private boolean recursive = false;

    public Transition(char[] charSet, State reference) {
        this.reference = reference;
        for (char c : charSet)
            this.charSet.add(c);
    }

    public Transition(char[] charSet, State reference, boolean recursive) {
        this(charSet, reference);
        this.recursive = recursive;
    }

    @Override
    public State nextState(String str) {
        if (!str.isEmpty()) {
            if (charSet.contains(str.toCharArray()[0])) {
                return reference.match(str.substring(1));
            }

            return State.ERROR_STATE;
        }

        return State.ERROR_STATE;
    }

    public boolean isRecursive() {
        return recursive;
    }
}
