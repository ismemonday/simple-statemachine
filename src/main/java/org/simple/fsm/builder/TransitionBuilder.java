package org.simple.fsm.builder;

import org.simple.fsm.Action;
import org.simple.fsm.Condition;
import org.simple.fsm.Transition;

import java.util.function.Consumer;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface TransitionBuilder<S, E, C> {
    TransitionBuilder from(S sourceState);

    TransitionBuilder to(S targetState);

    TransitionBuilder on(E event);

    TransitionBuilder when(Condition<C> condition);

    void then(Action<S, E, C> action);

    void whenComplete(Consumer<Transition<S, E, C>> consumer);
}
