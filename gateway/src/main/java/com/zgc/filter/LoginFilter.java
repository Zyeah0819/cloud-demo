package com.zgc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //登录校验逻辑。
        //1）获取zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        //2)从上下文获取request对象
        HttpServletRequest req = ctx.getRequest();
        //3）从请求中获取cookie
        String token = req.getParameter("access-token");
        //判断
//        if(token == null || "".equals(token.trim())){
//            ctx.setSendZuulResponse(false); //true放行，false拦截
//            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
        if(StringUtils.isBlank(token)){
            ctx.setSendZuulResponse(false); //true放行，false拦截
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        //校验通过
        return null;
    }
}
