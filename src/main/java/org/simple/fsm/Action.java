package org.simple.fsm;

/**
 * @author mao
 * date 2024/6/28
 * des 执行动作
 */
public interface Action<S, E, C> {
    /**
     * 具体执行动作
     * @param from 起始状态
     * @param to   目的状态
     * @param event 事件
     * @param context 上下文
     */
    public void execute(S from, S to, E event, C context);
}
