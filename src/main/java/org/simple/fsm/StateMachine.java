package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des 状态机接口。提供了fire方法，用于触发状态机。
 */
public interface StateMachine<S, E, C> {

    /**
     * 触发状态机
     * @param sourceState
     * @param event
     * @param ctx
     * @return
     */
    S fire(S sourceState, E event, C ctx);

    void setName(String name);

    void setReady(boolean ready);

    boolean getReady();
}
