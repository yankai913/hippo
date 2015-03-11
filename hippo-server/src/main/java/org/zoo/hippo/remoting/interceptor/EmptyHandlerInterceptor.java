package org.zoo.hippo.remoting.interceptor;

import io.netty.channel.ChannelHandlerContext;

import org.zoo.hippo.remoting.HandlerInterceptor;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-2-13
 */
public class EmptyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void beforeInvoke(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub

    }


    @Override
    public void afterInvoke(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub

    }

}
