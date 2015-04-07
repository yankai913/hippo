package org.zoo.hippo.core.config;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.zoo.hippo.thread.ThreadConfig;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-3-5
 */
public class HippoConfig implements Serializable {

    private static final long serialVersionUID = 437777871173513704L;

    private Set<String> sizeSet;// 宽x高，例如100x100

    private String regex;

    private long channelTimeout;

    private long fetchTimeout;

    private Map<String, ThreadConfig> threadConfigMap;


    public String getRegex() {
        return regex;
    }


    public void setRegex(String regex) {
        this.regex = regex;
    }


    public long getChannelTimeout() {
        return channelTimeout;
    }


    public void setChannelTimeout(long channelTimeout) {
        this.channelTimeout = channelTimeout;
    }


    public long getFetchTimeout() {
        return fetchTimeout;
    }


    public void setFetchTimeout(long fetchTimeout) {
        this.fetchTimeout = fetchTimeout;
    }


    public Map<String, ThreadConfig> getThreadConfigMap() {
        return threadConfigMap;
    }


    public void setThreadConfigMap(Map<String, ThreadConfig> threadConfigMap) {
        this.threadConfigMap = threadConfigMap;
    }


    public Set<String> getSizeSet() {
        return sizeSet;
    }


    public void setSizeSet(Set<String> sizeSet) {
        this.sizeSet = sizeSet;
    }

}
