package org.simple.fsm.builder;

import org.simple.fsm.Action;
import org.simple.fsm.Condition;
/**
 * @author mao
 * date 2024/6/28
 * des
 */
public interface TransitionBuilder<S, E, C> {
    TransitionBuilder<S,E,C> from(S sourceState);

    TransitionBuilder<S,E,C> to(S targetState);

    TransitionBuilder<S,E,C> on(E event);

    TransitionBuilder<S,E,C> when(Condition<C> condition);

    void then(Action<S, E, C> action);

    void asyncThen(Action<S, E, C> action);
}
