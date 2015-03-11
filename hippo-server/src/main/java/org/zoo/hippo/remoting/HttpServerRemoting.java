package org.zoo.hippo.remoting;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoo.hippo.exception.HippoException;
import org.zoo.hippo.utils.NetUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-13
 */
public class HttpServerRemoting extends AbstractRemoting {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerRemoting.class);

    private InetSocketAddress bindAddress;

    private Channel channel;

    private ChannelInitializer<SocketChannel> channelInitializer;


    public HttpServerRemoting(int port) throws HippoException {
        super(new ServerBootstrap());
        this.bindAddress = new InetSocketAddress(NetUtils.getLocalAddress().getHostAddress(), port);
    }


    @Override
    protected void doStart() throws HippoException {
        ServerBootstrap bootStrap = (ServerBootstrap) getBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            bootStrap.group(bossGroup, workerGroup);
            bootStrap.channel(NioServerSocketChannel.class);
            bootStrap.childHandler(getChannelInitializer());
            channel = bootStrap.bind(bindAddress).sync().channel();

            logger.info("binded channel: " + channel);
        } catch (Throwable t) {
            throw new HippoException(t);
        }
    }


    @Override
    protected void doDestroy() {
        channel.close();
    }


    public ChannelInitializer<SocketChannel> getChannelInitializer() {
        return channelInitializer;
    }


    public void setChannelInitializer(ChannelInitializer<SocketChannel> channelInitializer) {
        this.channelInitializer = channelInitializer;
    }
}
