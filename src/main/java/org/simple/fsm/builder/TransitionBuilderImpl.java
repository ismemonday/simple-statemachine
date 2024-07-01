package org.simple.fsm.builder;

import org.simple.fsm.Action;
import org.simple.fsm.Condition;
import org.simple.fsm.Transition;
import org.simple.fsm.impl.TransitionImpl;

import java.util.function.Consumer;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public class TransitionBuilderImpl<S, E, C> implements TransitionBuilder<S, E, C> {
    private TransitionImpl<S, E, C> transition = new TransitionImpl<>();
    private Consumer<Transition<S, E, C>> whenComplete;

    @Override
    public TransitionBuilder from(S sourceState) {
        transition.setSourceState(sourceState);
        return this;
    }

    @Override
    public TransitionBuilder to(S targetState) {
        transition.setTargetState(targetState);
        return this;
    }

    @Override
    public TransitionBuilder on(E event) {
        transition.setEvent(event);
        return this;
    }

    @Override
    public TransitionBuilder when(Condition<C> condition) {
        transition.setCondition(condition);
        return this;
    }

    @Override
    public void then(Action<S, E, C> action) {
        transition.setAction(action);
        whenComplete.accept(transition);
    }

    @Override
    public void whenComplete(Consumer<Transition<S, E, C>> consumer) {
        this.whenComplete = consumer;
    }
}
