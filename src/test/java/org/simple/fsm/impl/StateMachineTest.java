package org.simple.fsm.impl;

import org.junit.jupiter.api.Test;
import org.simple.fsm.builder.StateMachineBuilder;
import org.simple.fsm.builder.StateMachineBuilderFactory;

/**
 * @author mao
 * date 2024/6/28
 * des
 */
class StateMachineTest {
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
        StateMachineBuilder<StateMachineImplTest.WarehouseState, StateMachineImplTest.WarehouseEvent, Object> fsmBuilder = StateMachineBuilderFactory.create("库位状态机");
        fsmBuilder.transition()
                .from(StateMachineImplTest.WarehouseState.EMPTY)
                .to(StateMachineImplTest.WarehouseState.FULL)
                .on(StateMachineImplTest.WarehouseEvent.PUT_IN)
                .when(c -> c != null)
                .then((start, end, event, context) -> {
                    doSome(start,end,event,context);
                });
    }

    private void doSome(StateMachineImplTest.WarehouseState start, StateMachineImplTest.WarehouseState end, StateMachineImplTest.WarehouseEvent event, Object context) {
    }


}