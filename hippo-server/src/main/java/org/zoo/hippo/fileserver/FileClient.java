package org.zoo.hippo.fileserver;

/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-21
 */
public interface FileClient {

    void start();
    
    byte[] fetch(String fileName);

    void destroy();
}
