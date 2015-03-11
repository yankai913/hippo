package org.zoo.hippo.remoting.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.LinkedHashMap;

import org.zoo.hippo.remoting.AbstractHttpServerHandler;
import org.zoo.hippo.remoting.HandlerInterceptor;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-2-13
 */
public class DefaultHttpServerHandler extends AbstractHttpServerHandler {

    public DefaultHttpServerHandler(LinkedHashMap<String, HandlerInterceptor> interceptorMap) {
        super(interceptorMap);
    }


    @Override
    protected void doMessageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

    }
}
