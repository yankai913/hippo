package org.zoo.hippo.remoting;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-13
 */
public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private AbstractHttpServerHandler httpChannelHandler;


    public HttpServerChannelInitializer(AbstractHttpServerHandler httpChannelHandler) {
        this.httpChannelHandler = httpChannelHandler;
    }


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
//        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(getHttpServerHandler());
    }


    public ChannelHandler getHttpServerHandler() {
        return httpChannelHandler;
    }
}
