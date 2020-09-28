package com.project.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomFormatConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry){

//        //位置数据
//        formatterRegistry.addFormatter(new Formatter<Coordinate>() {
//
//            @Override
//            public String print(Coordinate coordinate, Locale locale) {
//                return coordinate.toString();
//            }
//
//            @Override
//            public Coordinate parse(String s, Locale locale) throws ParseException {
//                Coordinate location = new Coordinate();
//                location.fromString(s);
//                return location;
//            }
//        });
//        //姿态数据
//        formatterRegistry.addFormatter(new Formatter<Orientation>() {
//
//            @Override
//            public String print(Orientation orientation, Locale locale) {
//                return orientation.toString();
//            }
//
//            @Override
//            public Orientation parse(String s, Locale locale) throws ParseException {
//                Orientation orientation = new Orientation();
//                orientation.fromString(s);
//                return orientation;
//            }
//        });
//        //时间数据
//        formatterRegistry.addFormatter(new Formatter<LocalDateTime>() {
//
//            @Override
//            public String print(LocalDateTime localDateTime, Locale locale) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                return sdf.format(localDateTime);
//            }
//
//            @Override
//            public LocalDateTime parse(String s, Locale locale) throws ParseException {
//                return LocalDateTime.parse(s);
//            }
//        });

        WebMvcConfigurer.super.addFormatters(formatterRegistry);
    }


}
