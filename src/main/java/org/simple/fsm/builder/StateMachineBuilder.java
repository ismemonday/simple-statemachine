package org.simple.fsm.builder;
import org.simple.fsm.StateMachine;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des 状态机的构建器
 */
public interface StateMachineBuilder<S, E, C> {

    /**
     * 构建一个状态机
     * @return
     */
    StateMachine build();


    /**
     * 初始化转换器的构建类
     * @return
     */
    TransitionBuilder transition();
}
