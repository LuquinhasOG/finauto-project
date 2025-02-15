package org.example.automata;

import java.util.ArrayList;
import java.util.List;

public class State {
    private List<iTransition> transitions = new ArrayList<>();
    private String str;

    public void add(iTransition transition) {
        transitions.add(transition);
    }

    public State match(String str) {
        if (str.isEmpty() && transitions.isEmpty())
            return this;

        for (iTransition t : transitions) {
            State next = t.nextState(str);
            if (!next.equals(FiniteAutomaton.ERROR_STATE))
                return next;
        }

        return FiniteAutomaton.ERROR_STATE;
    }

    public boolean hasRecursiveTransition() {
        for (iTransition t : transitions) {
            if (t.isRecursive())
                return true;
        }

        return false;
    }

    public boolean hasNonRecursiveTransition() {
        for (iTransition t : transitions) {
            if (!t.isRecursive())
                return true;
        }

        return false;
    }
}
