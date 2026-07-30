package com.springboot.spring_filters.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//NOTES-------------------------------------------------------------------------------------------------
/*
1> If we want to reader response from the controllers then httpServletResponse does not allow that so we
have to create a wrapper response then we can read as we want .
 */
//------------------------------------------------------------------------------------------------------
@Component
@Order(4)
public class ResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)  response;

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(httpServletResponse);
//---------------------------------------------------------------------------------------------------------------

        chain.doFilter(request,response);
//--------------------------------------------------------------------------------------------------------------

        byte[] wrappedContent = wrapperResponse.getContentAsByteArray();

        String originalBody = new String(wrappedContent);

        String modifiedBody=
                """
                "OriginalResponse" : %s,
                "appName" : "Student Management Application"
                """.formatted(originalBody);

        wrapperResponse.resetBuffer();

        wrapperResponse.getWriter().write(modifiedBody);
        System.out.println("Response Filter Executed");

        wrapperResponse.copyBodyToResponse();



    }
}
