package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 */
public interface Transition<S, E, C> {
    String getKey();

    void setSourceState(S sourceState);

    void setTargetState(S targetState);

    void setEvent(E event);

    void setCondition(Condition<C> condition);

    void setAction(Action<S, E, C> action);

    /**
     *  状态机中transit 的核心实现，先查看是否有当前transition, 如果有则执行transition
     * @param context
     * @param checkCondition
     * @return 返回状态
     */
     S transit(C context, boolean checkCondition);
}
