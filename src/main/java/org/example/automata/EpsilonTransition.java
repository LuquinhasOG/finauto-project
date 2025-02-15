package org.example.automata;

public class EpsilonTransition implements iTransition {
    private State reference;

    public EpsilonTransition(State reference) {
        this.reference = reference;
    }

    @Override
    public State nextState(String str) {
        return reference.match(str);
    }

    @Override
    public boolean isRecursive() {
        return false;
    }
}
