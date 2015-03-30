package org.zoo.hippo.core.service.support;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoo.hippo.core.config.HippoConfig;
import org.zoo.hippo.core.service.AbstractService;
import org.zoo.hippo.fileserver.FileClient;
import org.zoo.hippo.utils.HttpTool;


public class FetchFileDataService extends AbstractService<ByteBuf> {

    private static final Logger logger = LoggerFactory.getLogger(FetchFileDataService.class);

    private HttpRequest httpRequest;

    private ChannelHandlerContext ctx;

    private FileClient fileClient;


    public FetchFileDataService(HippoConfig hippoConfig, HttpRequest httpRequest, ChannelHandlerContext ctx,
            FileClient fileClient) {
        super(hippoConfig);
        this.httpRequest = httpRequest;
        this.ctx = ctx;
        this.fileClient = fileClient;
    }


    @Override
    protected ByteBuf doService() throws Exception {
        String url = httpRequest.uri();
        RequestUrlParam requestUrlParam = parse(url);
        if (requestUrlParam == null) {
            HttpTool.sendError(ctx, HttpResponseStatus.BAD_REQUEST);
            return null;
        }
        byte[] data = fileClient.fetch(requestUrlParam.getPath());
        return null;
    }


    private RequestUrlParam parse(String url) {
        Pattern p = Pattern.compile(getHippoConfig().getRegex());
        Matcher m = p.matcher(url);
        if (m.find() && m.groupCount() == 3) {
            RequestUrlParam requestUrlParam = new RequestUrlParam();
            requestUrlParam.setUrl(url);
            requestUrlParam.setPath(m.group(1));
            requestUrlParam.setWidth(Integer.parseInt(m.group(2)));
            requestUrlParam.setHeight(Integer.parseInt(m.group(3)));
            return requestUrlParam;
        } else {
            logger.error("requested url = [{}] is invalid!", url);
            return null;
        }
    }

    static class RequestUrlParam implements Serializable {

        private static final long serialVersionUID = 1640363749051295282L;

        private String url;
        private String path;
        private int height;
        private int width;


        public RequestUrlParam() {

        }


        public String getUrl() {
            return url;
        }


        public void setUrl(String url) {
            this.url = url;
        }


        public String getPath() {
            return path;
        }


        public void setPath(String path) {
            this.path = path;
        }


        public int getHeight() {
            return height;
        }


        public void setHeight(int height) {
            this.height = height;
        }


        public int getWidth() {
            return width;
        }


        public void setWidth(int width) {
            this.width = width;
        }

    }
}
