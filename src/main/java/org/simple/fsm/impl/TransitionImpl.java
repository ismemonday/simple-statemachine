package org.simple.fsm.impl;

import org.simple.fsm.Action;
import org.simple.fsm.Condition;
import org.simple.fsm.Transition;
import org.simple.fsm.exception.ConditionException;
import org.simple.fsm.utils.TransitionUtil;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author mao
 * date 2024/6/28
 * des
 */
public class TransitionImpl<S, E, C> implements Transition<S, E, C> {
    private S sourceState;
    private S targetState;
    private E event;
    private Condition<C> condition;
    private Action<S, E, C> action;
    private Action<S, E, C> asyncAction;
    private ScheduledExecutorService asyncActionPool;


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
                throw new ConditionException("condition is passive");
            }
        }
        if(action!=null){
            action.execute(sourceState, targetState, event, context);
        }
        if(asyncAction!=null){
            asyncActionPool.execute(()->{asyncAction.execute(sourceState, targetState, event, context);});
        }
        return targetState;
    }

    @Override
    public void setAsyncAction(Action<S, E, C> action) {
        this.asyncAction = action;
    }

    @Override
    public void setAsyncActionPool(ScheduledExecutorService asyncActionPool){
        this.asyncActionPool=asyncActionPool;
    }
}
