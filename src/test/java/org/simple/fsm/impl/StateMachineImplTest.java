package org.simple.fsm.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simple.fsm.StateMachine;
import org.simple.fsm.builder.StateMachineBuilder;
import org.simple.fsm.builder.StateMachineBuilderFactory;

/**
 * @Author mao
 * @Date 2024/6/28
 * @Des
 */
class StateMachineImplTest {
    /**
     * 定义库位状态：空库位，满库位
     */
    enum WarehouseState {
        EMPTY, FULL
    }

    /**
     * 定义库位事件：取走，放入
     */
    enum WarehouseEvent {
        TAKE_AWAY, PUT_IN
    }


    @Test
    public void testCreateFsm() {
        StateMachineBuilder<WarehouseState, WarehouseEvent, Object> fsmBuilder = StateMachineBuilderFactory.create("库位状态机");
        fsmBuilder.transition()
                .from(WarehouseState.EMPTY)
                .to(WarehouseState.FULL)
                .on(WarehouseEvent.PUT_IN)
                .when(c -> c != null)
                .then((start, end, event, context) -> {
                    System.out.println(String.format("sourceState:%s，targetState：%s,event:%s,context:%s", start, end, event, context));
                });
        fsmBuilder.transition()
                .from(WarehouseState.FULL)
                .to(WarehouseState.EMPTY)
                .on(WarehouseEvent.TAKE_AWAY)
                .when(c -> c != null)
                .then((start, end, event, context) -> {
                    System.out.println(String.format("sourceState:%s，targetState：%s,event:%s,context:%s", start, end, event, context));
                });
        StateMachine<WarehouseState, WarehouseEvent, Object> stateMachine = fsmBuilder.build();

        WarehouseState S1 = stateMachine.fire(WarehouseState.EMPTY, WarehouseEvent.PUT_IN, "context");
        Assertions.assertTrue(S1 == WarehouseState.FULL);

        WarehouseState S3 = stateMachine.fire(WarehouseState.FULL, WarehouseEvent.TAKE_AWAY, "context");
        Assertions.assertTrue(S3 == WarehouseState.EMPTY);
    }
}