/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.grizzly.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USUARIO
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
//            Configuration configuration = new Configuration();
//            configuration.configure("hibernate.cfg.xml");
//
//            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//            sessionFactory = configuration.buildSessionFactory(ssrb.build());

        	sessionFactory = new MetadataSources( 
    			new StandardServiceRegistryBuilder()
    				.configure("hibernate.cfg.xml").build()
        	).buildMetadata().buildSessionFactory();
        	
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {

        // Alternatively, you could look up in JNDI here
        return sessionFactory;
    }

    public static void shutdown() {

        // Close caches and connection pools
        getSessionFactory().close();
    }
}
