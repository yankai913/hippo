package org.zoo.hippo.fileserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoo.hippo.fileserver.FileClient;

import com.zoo.fdfs.api.FdfsClient;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-21
 */
public class DefaultFileClient implements FileClient {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFileClient.class);

    private FdfsClient fdfsClient;


    public DefaultFileClient(FdfsClient fdfsClient) {
        this.fdfsClient = fdfsClient;
    }


    @Override
    public void start() {
        fdfsClient.start();
    }


    @Override
    public byte[] fetch(String fileName) {
        byte[] data = null;
        try {
            int idx = fileName.indexOf("/");
            String groupName = fileName.substring(0, idx);
            String remoteFileName = fileName.substring(idx);
            data = fdfsClient.downloadFile(groupName, remoteFileName);
        } catch (Exception e) {
            logger.error("fetch failed, fileName=[{}]", fileName);
        }
        return data;
    }


    @Override
    public void destroy() {
        fdfsClient.shutdown();
    }

}
