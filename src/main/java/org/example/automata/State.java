package org.example.automata;

import java.util.ArrayList;
import java.util.List;

public class State {
    private List<iTransition> transitions = new ArrayList<>();
    private String str;

    public final static State ERROR_STATE = new State();

    public void add(iTransition transition) {
        transitions.add(transition);
    }

    public State match(String str) {
        if (str.isEmpty() && transitions.isEmpty())
            return this;

        if (str.isEmpty())
            return this;

        for (iTransition t : transitions) {
            State next = t.nextState(str);
            if (!next.equals(ERROR_STATE))
                return next;
        }

        return ERROR_STATE;
    }
}
