package org.example.automata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FiniteAutomaton {
    private State initialState;
    private Set<State> finalStates = new HashSet<>();

    public final static char[] NUMBERS_CHARSET = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final static char[] NUMBERS_NO_ZERO_CHARSET = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final static char[] LOWERCASE_ALPHABET_CHARSET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public final static char[] UPPERCASE_ALPHABET_CHARSET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public FiniteAutomaton(State initialState, State ...finalStates) {
        this.initialState = initialState;
        this.finalStates.addAll(Arrays.asList(finalStates));
    }

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    public Set<State> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(Set<State> finalStates) {
        this.finalStates = finalStates;
    }

    public boolean match(String str) {
        State end = initialState.match(str);

        return finalStates.contains(end);
    }
}
