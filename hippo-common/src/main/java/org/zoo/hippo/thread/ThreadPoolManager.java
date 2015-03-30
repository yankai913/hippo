package org.zoo.hippo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ThreadPoolManager {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolManager.class);

    private Map<String, ExecutorService> name2ThreadPoolMap = new HashMap<String, ExecutorService>();


    public ThreadPoolManager() {

    }


    public void initThreadPool(ThreadConfig threadConfig) {
        logger.info("init threadPool use threadConfig: [{}]", threadConfig);

        if (name2ThreadPoolMap.get(threadConfig.getName()) == null) {
            ExecutorService executor = ThreadPoolTool.getFixedThreadPool(threadConfig);
            name2ThreadPoolMap.put(threadConfig.getName(), executor);

            logger.info("init threadPool successed, name=[{}]", threadConfig.getName());
        } else {
            logger.info("skip init threadPool, because name=[{}] already exist.", threadConfig.getName());
        }
    }


    public ExecutorService getThreadPool(String name) {
        return name2ThreadPoolMap.get(name);
    }


    public void destroy() {
        for (ExecutorService executor : name2ThreadPoolMap.values()) {
            executor.shutdown();
        }
    }
}
