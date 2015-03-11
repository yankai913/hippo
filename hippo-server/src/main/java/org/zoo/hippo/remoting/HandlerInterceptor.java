package org.zoo.hippo.remoting;

import io.netty.channel.ChannelHandlerContext;

/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-2-13
 */
public interface HandlerInterceptor {

    void beforeInvoke(ChannelHandlerContext ctx, Object msg);
    
    void afterInvoke(ChannelHandlerContext ctx, Object msg);
}
