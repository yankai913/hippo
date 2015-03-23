package org.zoo.hippo.thread;

import java.io.Serializable;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-3-23
 */
public class ThreadConfig implements Serializable {
   
    private static final long serialVersionUID = 6726580965130772072L;
    
    private String name;
    private int threads;
    private int queues;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getThreads() {
        return threads;
    }


    public void setThreads(int threads) {
        this.threads = threads;
    }


    public int getQueues() {
        return queues;
    }


    public void setQueues(int queues) {
        this.queues = queues;
    }

}
