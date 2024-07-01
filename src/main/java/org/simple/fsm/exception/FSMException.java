package org.simple.fsm.exception;

/**
 * @Author mao
 * @Date 2024/7/1
 * @Des
 */
public class FSMException extends RuntimeException {
    public FSMException(String format, Object... obj) {
        super(String.format(format, obj));
    }
}
