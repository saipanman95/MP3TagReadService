/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author michael
 */
public class ApplicationContextUtils implements ApplicationContextAware{

    private static ApplicationContext ctx;
    
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        ctx = ac;
    }
    
    public static ApplicationContext getApplicationContext(){
        if (null == ctx){
            ctx = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        }
        return ctx;
    }
    
}
