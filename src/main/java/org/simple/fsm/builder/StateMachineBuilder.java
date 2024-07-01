package org.simple.fsm.builder;
import org.simple.fsm.StateMachine;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface StateMachineBuilder<S, E, C> {

    StateMachine build(String fsmName);


    TransitionBuilder transition();
}
