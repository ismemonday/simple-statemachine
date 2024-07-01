package org.simple.fsm.impl;

import org.simple.fsm.Action;
import org.simple.fsm.Condition;
import org.simple.fsm.Transition;
import org.simple.fsm.exception.FSMException;
import org.simple.fsm.utils.TransitionUtil;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public class TransitionImpl<S, E, C> implements Transition<S, E, C> {
    private S sourceState;
    private S targetState;
    private E event;
    private Condition<C> condition;
    private Action<S, E, C> action;


    @Override
    public String getKey() {
        return TransitionUtil.buildTransitionKey(sourceState, event);
    }

    public void setSourceState(S sourceState) {
        this.sourceState = sourceState;
    }

    public void setTargetState(S targetState) {
        this.targetState = targetState;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    public void setCondition(Condition<C> condition) {
        this.condition = condition;
    }

    public void setAction(Action<S, E, C> action) {
        this.action = action;
    }

    @Override
    public S transit(C context, boolean checkCondition) {
        if (checkCondition) {
            if (condition == null || !condition.isSatisfied(context)) {
                return sourceState;
            }
        }
        if (action == null) {
            throw new FSMException("transition:%s,action is null", getKey());
        }
        action.execute(sourceState, targetState, event, context);
        return targetState;
    }
}
