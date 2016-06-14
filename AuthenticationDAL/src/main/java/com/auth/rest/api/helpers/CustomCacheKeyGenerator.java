/**
 * 
 */
package com.auth.rest.api.helpers;

import java.lang.reflect.Method;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 12 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

@Component
public class CustomCacheKeyGenerator implements KeyGenerator {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.cache.interceptor.KeyGenerator#generate(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object generate(Object o, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getDeclaringClass().getSimpleName());
        sb.append("_");
        sb.append(method.getName());
        if (params != null) {
            for (Object param : params) {
                if (param != null) {
                    sb.append("_");
                    sb.append(param.toString());
                }
            }
        }
        return sb.toString();
    }

}
