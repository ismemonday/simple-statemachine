package org.simple.fsm.exception;

/**
 * @author mao
 * date 2024/7/1
 * des
 */
public class ConditionException extends RuntimeException {
    public ConditionException(String format, Object... obj) {
        super(String.format(format, obj));
    }
}
