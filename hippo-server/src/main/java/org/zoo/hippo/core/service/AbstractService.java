package org.zoo.hippo.core.service;

import java.util.concurrent.Callable;

import org.zoo.hippo.core.config.HippoConfig;


public abstract class AbstractService<V> implements Callable<V> {

    private HippoConfig hippoConfig;


    public AbstractService(HippoConfig hippoConfig) {
        this.hippoConfig = hippoConfig;
    }


    public HippoConfig getHippoConfig() {
        return hippoConfig;
    }


    protected String getName() {
        return this.getClass().getSimpleName();
    }


    @Override
    public V call() throws Exception {
        return doService();
    }


    protected abstract V doService() throws Exception;
}
