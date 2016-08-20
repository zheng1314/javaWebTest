package com.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import java.util.UUID;
import java.util.Enumeration;


/**
 * Created by zheng1617 on 16-7-21.
 */
public class WebUtils {
    public static <T>T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while(e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                System.out.println(value);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String makeId() {
        return UUID.randomUUID().toString();
    }
}
