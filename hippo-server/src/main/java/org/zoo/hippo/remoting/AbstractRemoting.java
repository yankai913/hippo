package org.zoo.hippo.remoting;

import io.netty.bootstrap.AbstractBootstrap;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoo.hippo.exception.HippoException;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-13
 */
public abstract class AbstractRemoting {

    private static final Logger logger = LoggerFactory.getLogger(AbstractRemoting.class);

    private final AtomicBoolean isStarted = new AtomicBoolean(false);

    private final AbstractBootstrap<?, ?> bootstrap;


    public AbstractRemoting(AbstractBootstrap<?, ?> bootstrap) throws HippoException {
        this.bootstrap = bootstrap;
        start();
    }


    public void start() throws HippoException {
        if (isStarted.compareAndSet(false, true)) {
            try {
                doStart();
                logger.info("start success...");
            } catch (Throwable t) {
                throw new HippoException("start failed, " + t.getMessage(), t);
            }
        } else {
            logger.warn("bootstrap has already started!, bootstrap = " + bootstrap);
        }
    }


    public void destroy() {
        bootstrap.group().shutdownGracefully();
        doDestroy();
    }


    protected AbstractBootstrap<?, ?> getBootstrap() {
        return bootstrap;
    }


    protected abstract void doStart() throws HippoException;


    protected abstract void doDestroy();

}
