package org.zoo.hippo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.zoo.hippo.core.DefaultHippoServer;
import org.zoo.hippo.core.config.HippoConfig;
import org.zoo.hippo.fileserver.DefaultFileClient;
import org.zoo.hippo.fileserver.FileClient;
import org.zoo.hippo.remoting.HttpServerRemoting;
import org.zoo.hippo.thread.ThreadConfig;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-4-7
 */
public class HippoBootstrap {
    public static void main(String[] args) {
        //config
        HippoConfig hippoConfig = new HippoConfig();
        Set<String> sizeSet = new HashSet<String>();
        sizeSet.add("100x100");
        sizeSet.add("200x200");
        hippoConfig.setSizeSet(sizeSet);
        hippoConfig.setRegex("^/size/(.*jpg)_([1-9][0-9]{1,2})x([1-9][0-9]{1,2}).jpg$");
        hippoConfig.setChannelTimeout(1000);
        hippoConfig.setFetchTimeout(1000);
        Map<String, ThreadConfig> threadConfigMap = new HashMap<String, ThreadConfig>();
        threadConfigMap.put("FetchFileDataService", new ThreadConfig("FetchFileDataService", 4, 0));
        hippoConfig.setThreadConfigMap(threadConfigMap);
        
        //server
        HttpServerRemoting remoting = new HttpServerRemoting(9527);
        //fileClient
        //TODO
        //FileClient fileClient = new DefaultFileClient(fdfsClient);
        //HippoServer hippoServer = new DefaultHippoServer(remoting, fileClient);
        
    }
}
