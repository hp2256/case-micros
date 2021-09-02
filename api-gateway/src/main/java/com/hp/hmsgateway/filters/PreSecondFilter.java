package com.hp.hmsgateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
//@Configuration
public class PreSecondFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PreSecondFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx =  RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("Request method = {}, url = {}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}
