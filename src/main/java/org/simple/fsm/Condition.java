package org.simple.fsm;

/**
 * @author mao
 * date 2024/6/28
 * des 状态机条件，根据ctx判断是否执行后续动作
 */
public interface Condition<C> {
    /**
     * 判断条件是否满足,
     * @param context 上下文
     * @return true，继续执行；false中断执行，返回初始状态
     */
    boolean isSatisfied(C context);
}
