package com.hp.hmsgateway.filters;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
@Configuration
public class PostFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PostFilter.class);
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx =  RequestContext.getCurrentContext();
        HttpServletResponse response=ctx.getResponse();
        log.info("Response status = {} ",response.getStatus());
        try(InputStream is = ctx.getResponseDataStream()){
            String respData = CharStreams.toString(new InputStreamReader(is, StandardCharsets.UTF_8));
            log.info("Response data = {}", respData);
            //we have consumed the data above we have to set it back in
            ctx.setResponseBody(respData);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        return null;
    }
}
