package org.lili.forfun.tiger.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class TigerThreadFactory implements ThreadFactory {
    private static final String PREFIX = "TIGER";

    private final ThreadGroup group;
    private final AtomicInteger threadId;
    private final boolean isDaemon;

    public TigerThreadFactory(boolean isDaemon) {
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.threadId = new AtomicInteger(0);
        this.isDaemon = isDaemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, PREFIX + threadId.getAndIncrement());
        t.setDaemon(isDaemon);
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
