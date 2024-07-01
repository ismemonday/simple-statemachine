package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface Transition<S, E, C> {
    String getKey();

    void setSourceState(S sourceState);

    void setTargetState(S targetState);

    void setEvent(E event);

    void setCondition(Condition<C> condition);

    void setAction(Action<S, E, C> action);

     S transit(C context, boolean checkCondition);
}
