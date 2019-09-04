package com.ygy.ad.adsearch.utils;

import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class CommonUtils {

    private static Logger logger= LoggerFactory.getLogger(CommonUtils.class);

    public static <K, V> V getrorCreate(K key, Map<K,V> map, Supplier<V> factory){
        return map.computeIfAbsent(key,k -> factory.get());
    }

    public static String stringConcat(String... args){

        StringBuilder result=new StringBuilder();
        for (String arg:args){
            result.append(arg);
            result.append("-");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static Date parseStringDate(String dateString){

        try{

            DateFormat dateFormat=new SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            return DateUtils.addHours(dateFormat.parse(dateString),-8);
        } catch (ParseException ex){

            logger.error("parseStringDate error:{}",dateString);
            return null;
        }
    }
}
