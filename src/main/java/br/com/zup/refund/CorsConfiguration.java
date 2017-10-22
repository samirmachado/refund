package br.com.zup.refund;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.common.collect.ImmutableList;

@Configuration
public class CorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
        config.setAllowCredentials(true);
        ImmutableList.of("*").forEach(origin -> config.addAllowedOrigin(origin));
        ImmutableList.of("POST", "GET", "PUT", "OPTIONS", "DELETE").forEach(method -> config.addAllowedMethod(method));
        ImmutableList.of("token", "content-type").forEach(header -> config.addAllowedHeader(header));
        config.setExposedHeaders(Arrays.asList("token","Content-Type", "Accept", "X-Requested-With"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}