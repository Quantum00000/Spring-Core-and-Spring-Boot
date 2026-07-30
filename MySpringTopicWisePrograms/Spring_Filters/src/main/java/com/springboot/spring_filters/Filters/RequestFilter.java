package com.springboot.spring_filters.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
@Order(3)
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)  response;

        BufferedReader reader = request.getReader();
        StringBuilder body = new StringBuilder();

        String line = reader.readLine();

        while(!(line==null)){
            body.append(line);
            line=reader.readLine();
        }

        System.out.println("Request Details:"+body);

        chain.doFilter(request,response);

    }
}
