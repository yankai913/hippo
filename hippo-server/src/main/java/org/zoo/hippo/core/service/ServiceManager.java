package org.zoo.hippo.core.service;

import java.util.concurrent.ExecutorService;

import org.zoo.hippo.exception.HippoException;

public interface ServiceManager {

    void start() throws HippoException;
    
    void destroy();
    
    ExecutorService getExecutor(Class<?> clazz);
}
