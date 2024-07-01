package org.simple.fsm.builder;

import org.simple.fsm.StateMachine;
import org.simple.fsm.Transition;
import org.simple.fsm.impl.StateMachineImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {
    private Map<String, Transition<S, E, C>> transitionMap = new ConcurrentHashMap<>();
    private StateMachine stateMachine = new StateMachineImpl(transitionMap);

    public static StateMachineBuilder create() {
        return new StateMachineBuilderImpl();
    }

    @Override
    public StateMachine build(String fsmName) {
        stateMachine.setName(fsmName);
        stateMachine.setReady(true);
        return stateMachine;
    }

    @Override
    public TransitionBuilder<S, E, C> transition() {
        TransitionBuilderImpl<S, E, C> transitionBuilder = new TransitionBuilderImpl<>();
        transitionBuilder.whenComplete((transition) -> {
            transitionMap.put(transition.getKey(), transition);
        });
        return transitionBuilder;
    }
}
