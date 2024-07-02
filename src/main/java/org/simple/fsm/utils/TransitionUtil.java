package org.simple.fsm.utils;

/**
 * @author mao
 * date 2024/7/1
 * des
 */
public class TransitionUtil {
    public static <S, E> String buildTransitionKey(S sourceState, E event) {
        return sourceState.toString() + "->" + event.toString();
    }
}
