package com.learn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 用于监听ServletContext范围(application)内属性的改变
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /**
     * 当程序把一个属性存入application范围时触发
     * @param event
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(context + "范围内添加了名为" + name + ",值为" + value + "的属性!");
    }

    /**
     * 当程序替换application范围内的属性时触发该方法
     * @param event
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(context + "范围内添加了名为" + name + ",值为" + value + "的属性被替换了!");
    }
    /**
     * 当程序把一个属性从application范围删除时触发该方法
     * @param event
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(context + "范围内添加了名为" + name + ",值为" + value + "的属性被删除了!");
    }
}
