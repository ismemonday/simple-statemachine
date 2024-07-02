package org.simple.fsm.builder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mao
 * date 2024/7/1
 * des 状态机构建类工厂
 */
public class StateMachineBuilderFactory<S, E, C> {
    private static Map<String, StateMachineBuilder> fsmMap = new ConcurrentHashMap<String, StateMachineBuilder>();

    /**
     * 创建一个状态机构建类
     * @param name 状态机名称
     * @param <S> 状态
     * @param <E> 事件
     * @param <C> 上下文
     * @return 状态机构建器
     */
    public static <S,E,C>StateMachineBuilder create(String name) {
        if (fsmMap.get(name) == null) {
            return new StateMachineBuilderImpl<S,E,C>(name);
        }
        return fsmMap.get(name);
    }
}
