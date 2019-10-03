package com.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SListnerDemo
 *
 */
@WebListener
public class SListnerDemo implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SListnerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
    	event.getSession().getId();
    	System.out.println("session started");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("session destroyed");
    }
	
}
