package com.example.demo.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/24 15:01
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean registerFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter((servletRequest, servletResponse, filterChain) -> {
            System.out.println("来自Filter的url:"+URLDecoder.decode(((HttpServletRequest)servletRequest).getRequestURL().toString(),"utf-8"));
            filterChain.doFilter(servletRequest,servletResponse);
        });
        registration.addUrlPatterns("/*");

        return registration;
    }


}
