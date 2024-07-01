package org.simple.fsm.utils;

/**
 * @Author mao
 * @Date 2024/7/1
 * @Des
 */
public class TransitionUtil {
    public static <S, E> String buildTransitionKey(S sourceState, E event) {
        return sourceState.toString() + "->" + event.toString();
    }
}
