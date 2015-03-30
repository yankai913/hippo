package org.zoo.hippo.core.config;

import java.io.Serializable;
import java.util.Map;

import org.zoo.hippo.thread.ThreadConfig;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-3-5
 */
public class HippoConfig implements Serializable {

    private static final long serialVersionUID = 437777871173513704L;

    private int width;

    private int height;

    private String regex;

    private long channelTimeout;

    private long fetchTimeout;

    private Map<String, ThreadConfig> threadConfigMap;


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


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

}
