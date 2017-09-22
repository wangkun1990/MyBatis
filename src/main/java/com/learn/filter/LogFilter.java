package com.learn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter 可认为是Servlet的一种加强版，它主要用于对用户请求进行预处理，也可以对
 * HttpServletRequest进行后处理，是个典型的处理链。Filter也可以对请求生成响应，这一点与servlet
 * 相同。
 * 使用filter完整的流程是：Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成
 * 响应，最后Filter再对服务器响应进行后处理。
 * Filter有如下几个用处：
 * 在HttpServletRequest到达servlet之前，拦截客户的HttpServletRequest
 * 根据需要检查HttpServletRequest，也可以修改HttpServletRequest头和数据
 * 在HttpServletResponse到达客户端之前，拦截HttpServletResponse
 * 根据需要检查HttpServletResponse，也可以修改HttpServletResponse头和数据
 *
 * Filter有如下几个种类：
 * 用户授权的Filter：Filter负责检查用户请求，根据请求过滤用户非法请求
 * 日志Filter：详细记录某些特殊的用户请求
 * 负责解码的Filter：包括对非标准编码的请求解码
 * 能改变xml内容的xslt Filter等
 * Filter可以负责拦截多个请求或响应，一个请求或响应也可被多个Filter拦截
 *
 *
 */
@WebFilter(filterName = "log", urlPatterns = {"/*"})
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init------------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("Filter 已经获取到用户的请求地址:" + ((HttpServletRequest) request).getServletPath());
        chain.doFilter(request, response);
        System.out.println("Filter 拦截结束");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy---------------------");
    }
}
