package org.example;

import org.example.automata.FiniteAutomaton;
import org.example.automata.State;
import org.example.automata.Transition;

public class Main {
    public static void main(String[] args) throws Exception {
        State s0 = new State();
        State s1 = new State();
        State s2 = new State();
        State s3 = new State();
        State s4 = new State();
        State s5 = new State();
        State s6 = new State();
        State s7 = new State();
        Transition t0 = new Transition(new char[]{'n'}, s1);
        Transition t1 = new Transition(new char[]{'o'}, s2);
        Transition t2 = new Transition(new char[]{'v'}, s3);
        Transition t3 = new Transition(new char[]{'o'}, s4);
        Transition t4 = new Transition(new char[]{'s'}, s5);
        Transition t5 = new Transition(new char[]{'s'}, s6);
        Transition t6 = new Transition(new char[]{'o'}, s7);

        s0.add(t0);
        s1.add(t1);
        s2.add(t2);
        s2.add(t4);
        s3.add(t3);
        s5.add(t5);
        s6.add(t6);

        State n0 = new State();
        State n1 = new State();
        Transition t7 = new Transition(FiniteAutomaton.NUMBERS_CHARSET, n1);

        n0.add(t7);

        FiniteAutomaton fa1 = new FiniteAutomaton(s0, s4, s7);
        FiniteAutomaton fa2 = new FiniteAutomaton(n0, n1);

        fa1.concatenate(fa2);
        System.out.println(fa1.match("novo5"));
    }
}