package net.htmlonlnie.Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*", dispatcherTypes = {
        DispatcherType.REQUEST
})
public class MyFilter implements Filter {
    private int count = 0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("count::: " + count++);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        StringBuffer requestURI = request.getRequestURL();
        System.out.println(requestURI.toString());


        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after response:::" + count);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init::: " + filterConfig);

    }

    @Override
    public void destroy() {
        System.out.println("destroy::: ");
    }
}
