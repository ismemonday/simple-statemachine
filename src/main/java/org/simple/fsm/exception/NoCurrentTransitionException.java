package org.simple.fsm.exception;

/**
 * @author mao
 * date 2024/7/1
 * des
 */
public class NoCurrentTransitionException extends RuntimeException {
    public NoCurrentTransitionException(String format, Object... obj) {
        super(String.format(format, obj));
    }
}
