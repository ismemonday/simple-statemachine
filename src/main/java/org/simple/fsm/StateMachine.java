package org.simple.fsm;

/**
 * @author mao
 * date 2024/6/28
 * des 状态机接口。提供了fire方法，用于触发状态机。
 */
public interface StateMachine<S, E, C> {

    /**
     * 触发状态机
     * @param sourceState 触发状态
     * @param event 事件
     * @param ctx   上下文
     * @return 目标状态
     */
    S fire(S sourceState, E event, C ctx);

    void setName(String name);

    void setReady(boolean ready);

    boolean getReady();
}
