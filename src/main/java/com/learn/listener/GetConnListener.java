package com.learn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContextListener用于监听Web应用的启动和关闭
 *
 * <listener>
 *     <listener-class>com.learn.listener.GetConnListener</listener-class>
 * </listener>
 */
@WebListener
public class GetConnListener implements ServletContextListener {

    /**
     * 应用启动时被触发
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("GetConnListener contextInitialized-------------------");
        String driver = sce.getServletContext().getInitParameter("driver");
        System.out.println("driver = " + driver);
    }

    /**
     * 应用关闭时被触发
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("GetConnListener contextDestroyed");
    }
}
