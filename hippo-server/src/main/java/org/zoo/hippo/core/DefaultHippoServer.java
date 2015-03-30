package org.zoo.hippo.core;

import org.zoo.hippo.core.HippoServer;
import org.zoo.hippo.exception.HippoException;
import org.zoo.hippo.fileserver.FileClient;
import org.zoo.hippo.remoting.AbstractRemoting;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-2-13
 */
public class DefaultHippoServer implements HippoServer {

    private AbstractRemoting remoting;

    private FileClient fileClient;


    public DefaultHippoServer(AbstractRemoting remoting, FileClient fileClient) {
        this.remoting = remoting;
        this.fileClient = fileClient;
    }


    @Override
    public void start() throws HippoException {
        remoting.start();
        fileClient.start();
    }


    @Override
    public void destroy() {
        remoting.destroy();
        fileClient.destroy();
    }

}
