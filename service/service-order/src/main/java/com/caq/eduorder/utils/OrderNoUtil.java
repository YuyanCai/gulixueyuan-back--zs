package com.caq.eduorder.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 订单号工具类
 *
 * @author qy
 * @since 1.0
 */
public class OrderNoUtil {

    /**
     * 获取订单号
     * @return
     */
    public static String getOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            //nextInt(n)将返回一个大于等于0小于n的随机数
            result += random.nextInt(10);
        }
        return newDate + result;
    }

}
