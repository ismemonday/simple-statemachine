package org.simple.fsm.impl;

import org.simple.fsm.StateMachine;
import org.simple.fsm.Transition;
import org.simple.fsm.exception.FSMException;
import org.simple.fsm.utils.TransitionUtil;

import java.util.Map;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public class StateMachineImpl<S, E, C> implements StateMachine<S, E, C> {
    private String name;
    private final Map<String, Transition> transitionMap;
    private boolean ready;

    public StateMachineImpl(Map<String, Transition> transitionMap) {
        this.transitionMap = transitionMap;
    }


    @Override
    public S fire(S sourceState, E event, C ctx) {
        isReady();
        Transition<S, E, C> transition = transitionMap.get(TransitionUtil.buildTransitionKey(sourceState, event));
        if (transition == null) {
            throw new FSMException("No transition found for source state %s and event %s", sourceState, event);
        }
        return transition.transit(ctx, true);
    }

    private void isReady() {
        if (!ready) {
            throw new FSMException("FSM is not ready");
        }
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
