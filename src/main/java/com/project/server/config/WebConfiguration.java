package com.project.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String s, Locale locale) throws ParseException {
                return LocalDateTime.parse(s);
            }

            @Override
            public String print(LocalDateTime o, Locale locale) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", locale);
                return dtf.format(o);
            }
        });

        WebMvcConfigurer.super.addFormatters(registry);
    }

}
