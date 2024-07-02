package org.simple.fsm.builder;

import org.simple.fsm.StateMachine;
import org.simple.fsm.Transition;
import org.simple.fsm.exception.FSMException;
import org.simple.fsm.impl.StateMachineImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mao
 * date 2024/6/28
 * des
 */
public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {
    private final String fsmName;
    private Map<String, Transition<S, E, C>> transitionMap = new ConcurrentHashMap<>();
    private StateMachine stateMachine = new StateMachineImpl(transitionMap);

    public StateMachineBuilderImpl(String fsmName) {
        this.fsmName = fsmName;
    }


    @Override
    public StateMachine build() {
        if (stateMachine == null || stateMachine.getReady()) {
            throw new FSMException("build exception,stateMachine is null or already build");
        }
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
