package org.zoo.hippo.core;

import org.zoo.hippo.exception.HippoException;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-2-13
 */
public interface HippoServer {

    void start() throws HippoException;


    void destroy();
}
