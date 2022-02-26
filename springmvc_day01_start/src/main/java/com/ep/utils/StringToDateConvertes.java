package com.ep.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 自定义类型转换类
* */
public class StringToDateConvertes implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(source == null){
            throw  new RuntimeException("字符转化为日期格式传入值为空");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("字符串转化为日期发生错误");
        }
    }
}
