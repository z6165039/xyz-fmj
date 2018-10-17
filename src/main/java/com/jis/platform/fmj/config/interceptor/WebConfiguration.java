package com.jis.platform.fmj.config.interceptor;

import com.jis.platform.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ace on 2017/9/8.
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    SessionAuthRestInterceptor getSessionAuthRestInterceptor() {
        return new SessionAuthRestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        //web
        registry.addInterceptor(getSessionAuthRestInterceptor()).addPathPatterns("/web/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        //h5
        registry.addInterceptor(getSessionAuthMemberInterceptor()).addPathPatterns("/fmj/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }

    @Bean
    SessionAuthMemberInterceptor getSessionAuthMemberInterceptor() {
        return new SessionAuthMemberInterceptor();
    }

//
//    @Bean
//    UserAuthRestInterceptor getUserAuthRestInterceptor() {
//        return new UserAuthRestInterceptor();
//    }

    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<String>();
        String[] urls = {
                "/v2/api-docs",
                "/swagger-resources/**",
                "/cache/**"
        };
        Collections.addAll(list, urls);
        return list;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
          registry.addResourceHandler("/webjars/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/cache/**").addResourceLocations(
//                "classpath:/META-INF/static/");
//        super.addResourceHandlers(registry);
//    }
}
