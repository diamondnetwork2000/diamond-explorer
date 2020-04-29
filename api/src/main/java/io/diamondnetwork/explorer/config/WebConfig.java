package io.diamondnetwork.explorer.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.diamondnetwork.util.DateUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public static final ObjectMapper RENDER = new ObjectMapper(); {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RENDER.setDateFormat(df);
    }
    public WebConfig() {
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

    public static class String2DateConverter implements org.springframework.core.convert.converter.Converter<String, Date> {

        @Override
        public Date convert(String source) {

            return DateUtil.getDate(source);
        }
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 从前台过来的数据转换成对应类型的转换器
        registry.addConverter(new String2DateConverter());
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的拦截器
       // registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (!converters.isEmpty()) {
            converters.removeIf(converter -> converter instanceof StringHttpMessageConverter
                    || converter instanceof MappingJackson2HttpMessageConverter);
        }

        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converters.add(new CustomizeJacksonConverter());
    }
    private static class CustomizeJacksonConverter extends MappingJackson2HttpMessageConverter {
        private CustomizeJacksonConverter() { super(RENDER); }
        @Override
        protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
            super.writeSuffix(generator, object);
        }
    }
}
