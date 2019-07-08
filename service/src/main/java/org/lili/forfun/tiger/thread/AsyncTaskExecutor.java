package org.lili.forfun.tiger.thread;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.*;

@Log4j2
public class AsyncTaskExecutor {

    private static final int CORE_POOL_SIZE = 200;

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
        CORE_POOL_SIZE, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
        new SynchronousQueue<>(),
        new TigerThreadFactory(true));

    public static <T> Future<T> submitTask(Callable<T> callable) {
        try {
            Future<T> result = threadPool.submit(callable);
            return result;
        } catch (RejectedExecutionException e) {
            log.error("task is rejected ", e);
        } catch (Exception e) {
            log.error("execute task failed!", e);
        }

        return null;
    }
}
