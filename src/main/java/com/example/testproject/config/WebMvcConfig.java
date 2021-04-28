package com.example.testproject.config;

import com.example.testproject.filter.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 设置url访问静态资源映射(那些静态文件可以访问url)
     * 静态资源包括：html，js，css，图片等，不是动态生成的东西(即加载之后不改变文件)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源位置(classpath为resources文件夹下的意思；static为resources下的文件夹)
        //addResourceHandler表示文件路径，这里的意思是static包下的所有文件
        //addResourceLocations表示要开放的资源，这里的意思是开放static包下的js包下所有文件可以访问，如果js下还有css包，则css包下文件不开放,则css无法使用(静态资源存放的真实路径)
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/js/");

    }

    /**
     * 添加拦截器的配置,不同的url进入不同的拦截器解析
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenAuthenticationFilter())
                // 拦截所有需要登录的请求(因为该系统所有controller路径都是test开头，所以意思是拦截路径为prison开头的controller方法)
                .addPathPatterns("/test/**")
                //允许通过的请求
                .excludePathPatterns("/test/login/**");
        /*registry.addInterceptor(tokenAuthenticationFilter())
                // 拦截所有需要登录的请求
                .addPathPatterns("/b/**");
        registry.addInterceptor(adminAuthenticationFilter())
                // 拦截所有需要登录的请求
                .addPathPatterns("/web/**");
        registry.addInterceptor(reviewAuthenticationFilter())
                // 拦截所有需要登录的请求
                .addPathPatterns("/sh/**");*/
    }

    /**
     * 注入自定义JWT拦截器，(猜测意思为，拦截到路径为prison开头的请求，就注入创建 -- 自定义JWT拦截器，进入token的解析验证方法，即执行JWT拦截器中preHandle()方法)
     */
    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

}
