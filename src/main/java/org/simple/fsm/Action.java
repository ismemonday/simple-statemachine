package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des 执行的动作
 */
public interface Action<S, E, C> {
    /**
     * 具体执行动作
     * @param from    其实状态
     * @param to      目的状态
     * @param event   事件
     * @param context 上下文
     */
    public void execute(S from, S to, E event, C context);
}
