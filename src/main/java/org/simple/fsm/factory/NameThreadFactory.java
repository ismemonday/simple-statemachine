package org.simple.fsm.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mao
 * date:2024/9/5
 * des:for some
 */
public class NameThreadFactory implements ThreadFactory{
    private final String threadNamePrefix;
    private int threadPriority=Thread.NORM_PRIORITY;
    private boolean daemon = false;
    private ThreadGroup threadGroup;
    private final AtomicInteger threadCount = new AtomicInteger();

    public NameThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix!=null?threadNamePrefix:getClass().getSimpleName()+"-";
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(threadGroup, r, nextThreadName());
        thread.setPriority(threadPriority);
        thread.setDaemon(daemon);
        return thread;
    }

    private String nextThreadName() {
        return threadNamePrefix + threadCount.incrementAndGet();
    }

    public void setThreadGroup(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
    }

    public static void main(String[] args) {
        System.out.println(new NameThreadFactory("bbb"));
    }
}
