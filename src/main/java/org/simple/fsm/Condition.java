package org.simple.fsm;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
public interface Condition<C> {
    boolean isSatisfied(C context);
}
