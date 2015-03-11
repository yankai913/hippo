package org.zoo.hippo.remoting;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-13
 */
public abstract class AbstractHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHttpServerHandler.class);

    // <name, interceptor>
    private LinkedHashMap<String, HandlerInterceptor> interceptorMap;


    public AbstractHttpServerHandler(LinkedHashMap<String, HandlerInterceptor> interceptorMap) {
        this.interceptorMap = interceptorMap;
    }


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        foreachInvokeBefore(ctx, msg);
        doMessageReceived(ctx, msg);
        foreachInvokeAfter(ctx, msg);
    }


    protected abstract void doMessageReceived(ChannelHandlerContext ctx, FullHttpRequest msg)
            throws Exception;


    public LinkedHashMap<String, HandlerInterceptor> getInterceptorMap() {
        return interceptorMap;
    }


    protected void foreachInvoke(ChannelHandlerContext ctx, FullHttpRequest msg, boolean isBefore) {
        for (Map.Entry<String, HandlerInterceptor> entry : getInterceptorMap().entrySet()) {
            String name = entry.getKey();
            HandlerInterceptor interceptor = entry.getValue();
            try {
                if (isBefore) {
                    logger.info("[{}] start beforeInvoke", name);
                    interceptor.beforeInvoke(ctx, msg);
                } else {
                    logger.info("[{}] start afterInvoke", name);
                    interceptor.afterInvoke(ctx, msg);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }


    protected void foreachInvokeBefore(ChannelHandlerContext ctx, FullHttpRequest msg) {
        foreachInvoke(ctx, msg, true);
    }


    protected void foreachInvokeAfter(ChannelHandlerContext ctx, FullHttpRequest msg) {
        foreachInvoke(ctx, msg, false);
    }
}
