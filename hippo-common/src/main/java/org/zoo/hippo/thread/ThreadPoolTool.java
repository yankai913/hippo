package org.zoo.hippo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-3-23
 */
public class ThreadPoolTool {

    public static ExecutorService getFixedThreadPool(String name, int threads, int queues) {
        return new ThreadPoolExecutor(threads, threads, 0, TimeUnit.MILLISECONDS,
            queues == 0 ? new SynchronousQueue<Runnable>()
                    : (queues < 0 ? new LinkedBlockingQueue<Runnable>() : new LinkedBlockingQueue<Runnable>(
                        queues)), new NamedThreadFactory(name, true), new AbortPolicyWithReport(name));
    }


    public static ExecutorService getFixedThreadPool(ThreadConfig threadConfig) {
        String name = threadConfig.getName();
        int threads = threadConfig.getThreads();
        int queues = threadConfig.getQueues();
        return getFixedThreadPool(name, threads, queues);
    }
}
