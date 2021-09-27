package com.kevin.xing.config;

import com.kevin.xing.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    /**
     * 之前我们在拦截器 LoginInterceptor 中配置的路径，即 index，触发的时机是在拦截器生效之后。也就是说，我们访问一个 URL，会首先通过 Configurer 判断是否需要拦截，
     * 如果需要，才会触发拦截器 LoginInterceptor，根据我们自定义的规则进行再次判断。
     *
     * /index 与 /index.html 是不同的，也就是说 /index 会触发拦截器而 /index.html 不会，但根据拦截器 LoginInterceptor 中我们定义的判断条件，
     * 以 /index 开头的路径都会被转发，包括 index.html。
     *
     * 因为我们做的是单页面应用，之前通过配置 ErrorPage，实际上访问所有路径都会重定向到 /index.html 。我们直接在浏览器地址栏输入 /index 会触发拦截器，
     * 经过拦截器重定向到 /login，然后 /login 再经过 Configurer 的判断，再次触发拦截器，由于不在需要拦截的路径中，
     * 所以被放行，页面则重新定向到了 /index.html，如果没有再 Configurer 中取消对 /index.html 的拦截，则会再次触发拦截器，再次重定向到 /login，引发如下错误。
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 对所有路径应用拦截器，除了 /index.html
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}

