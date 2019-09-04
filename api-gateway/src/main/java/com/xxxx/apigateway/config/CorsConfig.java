package com.xxxx.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-09-04 14:51
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        // 表示服务器是否允许使用 cookies
        config.setAllowCredentials(true);
        // 允许请求的域，多数情况下，就是预检请求中的 Origin 的值
        config.setAllowedOrigins(Arrays.asList("*"));
        // 值为实际请求将会使用的 header 集合
        config.setAllowedHeaders(Arrays.asList("*"));
        // 值为实际请求将会使用的方法
        config.setAllowedMethods(Arrays.asList("*"));
        // 预检请求返回的规则可以被缓存的最长时间，超过这个时间，需要再次发起预检请求
        config.setMaxAge(300L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
