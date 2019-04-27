package com.taoqi.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.taoqi.base.domain.auth.UserInfo;
import com.taoqi.gateway.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @作者：刘时明
 * @时间：2019/4/10-9:29
 * @作用：
 */
@Component
public class AuthFilter extends ZuulFilter
{
    @Value("${auth.shopUrl}")
    private Set<String> shopUrls;

    @Value("${auth.userUrl}")
    private Set<String> userUrls;

    @Value("${auth.adminUrl}")
    private Set<String> adminUrls;

    @Override
    public String filterType()
    {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String url = request.getRequestURI();
        String jwt = getJwt(request);
        List<String> roles = null;
        if (jwt != null)
        {
            try
            {
                Claims claims=JwtUtil.parseJWT(jwt);
                UserInfo userInfo=(UserInfo)claims.get("user");
                roles = userInfo.getAuth();
                System.out.println("roles => "+roles);
            } catch (Exception e)
            {
                System.out.println("jwt解析异常");
            }
        }
        if (shopUrls.contains(url))
        {
            if (roles == null || !JwtUtil.isAuth(roles, "SHOP"))
            {
                noAuth(context);
            }
        }
        if (adminUrls.contains(url))
        {
            if (roles == null || !JwtUtil.isAuth(roles, "ADMIN"))
            {
                noAuth(context);
            }
        }
        if (userUrls.contains(url))
        {
            if (roles == null || !JwtUtil.isAuth(roles, "USER"))
            {
                noAuth(context);
            }
        }
        return null;
    }

    private String getJwt(HttpServletRequest request)
    {
        if (request.getParameter("tq_jwt") == null)
        {
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
            {
                for (Cookie c : cookies)
                {
                    if (c.getName().equals("tq_jwt"))
                    {
                        return c.getValue();
                    }
                }
            }
        } else
        {
            return request.getParameter("tq_jwt");
        }
        return null;
    }

    private void noAuth(RequestContext context)
    {
        // 不再通过路由转发
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(401);
    }
}
