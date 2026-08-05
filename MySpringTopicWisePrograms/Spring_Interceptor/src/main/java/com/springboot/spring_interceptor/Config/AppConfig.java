package com.springboot.spring_interceptor.Config;

import com.springboot.spring_interceptor.Interceptors.AuthenticationInterceptor;
import com.springboot.spring_interceptor.Interceptors.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;
    private final AuthenticationInterceptor authenticationInterceptor;

    public AppConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor=authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/students/**")
                .excludePathPatterns("/api/students/auth/**","/api/students/public/**")
                .order(2);

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/students/**")
                .excludePathPatterns("/api/students/public/**") 
                .order(1);

    }
}
