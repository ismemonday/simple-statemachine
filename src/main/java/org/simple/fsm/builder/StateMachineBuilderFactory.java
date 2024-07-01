package org.simple.fsm.builder;

import org.simple.fsm.StateMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author mao
 * @Date 2024/7/1
 * @Des 状态机构建类工厂
 */
public class StateMachineBuilderFactory<S, E, C> {
    private static Map<String, StateMachineBuilder> fsmMap = new ConcurrentHashMap<String, StateMachineBuilder>();

    /**
     * 创建一个状态机构建类
     * @param name
     * @param <S>
     * @param <E>
     * @param <C>
     * @return
     */
    public static <S,E,C>StateMachineBuilder create(String name) {
        if (fsmMap.get(name) == null) {
            return new StateMachineBuilderImpl<S,E,C>(name);
        }
        return fsmMap.get(name);
    }
}
