package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface Action<S, E, C> {
    public void execute(S from, S to, E event, C context);
}
