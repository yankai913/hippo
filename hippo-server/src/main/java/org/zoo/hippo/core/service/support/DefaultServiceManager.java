package org.zoo.hippo.core.service.support;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoo.hippo.core.config.HippoConfig;
import org.zoo.hippo.core.service.ServiceManager;
import org.zoo.hippo.exception.HippoException;
import org.zoo.hippo.thread.ThreadConfig;
import org.zoo.hippo.thread.ThreadPoolManager;


public class DefaultServiceManager implements ServiceManager {

    private static final Logger logger = LoggerFactory.getLogger(DefaultServiceManager.class);

    private final HippoConfig hippoConfig;
    private final ThreadPoolManager threadPoolManager = new ThreadPoolManager();


    public DefaultServiceManager(HippoConfig hippoConfig) {
        this.hippoConfig = hippoConfig;
        init();
    }


    private void init() {
        for (ThreadConfig threadConfig : hippoConfig.getThreadConfigMap().values()) {
            threadPoolManager.initThreadPool(threadConfig);
        }
    }


    @Override
    public void start() throws HippoException {
        logger.info(this.getClass().getName() + " start!");
    }


    @Override
    public void destroy() {
        logger.info(this.getClass().getName() + " destroy!");
        threadPoolManager.destroy();
    }


    @Override
    public ExecutorService getExecutor(Class<?> clazz) {
        return threadPoolManager.getThreadPool(clazz.getSimpleName());
    }

}
