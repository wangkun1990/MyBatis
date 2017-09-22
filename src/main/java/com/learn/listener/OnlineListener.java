package com.learn.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener用于监听用户session的创建和销毁
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

    /**
     * 用户与服务器的会话开始、创建时触发该方法
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("OnlineListener sessionCreated-------------");
    }

    /**
     * 用户与服务器的会话断开、销毁时触发该方法
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("OnlineListener sessionDestroyed--------------");
    }
}
