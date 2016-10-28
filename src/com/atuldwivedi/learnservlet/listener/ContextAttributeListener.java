package com.atuldwivedi.learnservlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextAttributeListener
 *
 */
@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ContextAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0) {
    	String name = arg0.getName();
    	String value = arg0.getValue().toString();
    	System.out.println(this.getClass().getName()+" attributeAdded "+ name +" "+value);
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
    	String name = arg0.getName();
    	String value = arg0.getValue().toString();
    	System.out.println(this.getClass().getName()+" attributeRemoved "+ name +" "+value);
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    	String name = arg0.getName();
    	String value = arg0.getValue().toString();
    	System.out.println(this.getClass().getName()+" attributeReplaced "+ name +" "+value);
    }
	
}
