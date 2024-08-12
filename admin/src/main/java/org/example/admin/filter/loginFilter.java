package org.example.admin.filter;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.example.admin.utils.jwtUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.admin.pojo.result;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain chain) throws
            IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI().toString();
        if (requestURI.contains("login")) {
            chain.doFilter(request, response);
            return;
        }
        String jwt=request.getHeader("token");

        if(StringUtils.isEmpty(jwt)){
            result error=result.error("NOT_LOGIN");
            String notlogin= JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }

        try{
            jwtUtils.parseToken(jwt);
        }catch(Exception e){
            e.printStackTrace();
            log.info("解析令牌失败！");
            result error=result.error("NOT_LOGIN");
            String notlogin= JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }

        chain.doFilter(request, response);


    }

}
