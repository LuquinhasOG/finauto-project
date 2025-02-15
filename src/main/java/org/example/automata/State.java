package org.example.automata;

import java.util.ArrayList;
import java.util.List;

public class State {
    private List<iTransition> transitions = new ArrayList<>();
    private String str;

    public void add(iTransition transition) {
        transitions.add(transition);
    }

    public boolean match(String str) {
        if (transitions.isEmpty() && !str.isEmpty())
            return false;

        if (transitions.isEmpty())
            return true;


        for (iTransition t : transitions) {
            if (t.nextState(str))
                return true;
        }

        return false;
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
