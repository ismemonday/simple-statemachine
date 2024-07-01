package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface StateMachine<S, E, C> {

    S fire(S sourceState, E event, C ctx);

    void setName(String name);

    void setReady(boolean ready);
}
