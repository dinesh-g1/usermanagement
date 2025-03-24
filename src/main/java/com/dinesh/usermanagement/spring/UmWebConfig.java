package com.dinesh.usermanagement.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan({"com.dinesh.usermanagement.web"})
public class UmWebConfig extends WebMvcConfigurationSupport {
    public UmWebConfig(){
        super();
    }

    @Override
    protected void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> converterFound = converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();
        if (converterFound.isPresent()) {
            AbstractJackson2HttpMessageConverter jsonMsgConverter = (AbstractJackson2HttpMessageConverter) converterFound.get();
            jsonMsgConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            jsonMsgConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }  
}
