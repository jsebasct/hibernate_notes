package org.learn.grizzly;

import org.learn.grizzly.util.HibernateUtil;
import org.learn.grizzly.model.Message;
import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // System.out.println("Maven + Hibernate + Oracle");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Message msg = new Message();
        msg.setText("Hola Bebé");

        session.save(msg);
        session.getTransaction().commit();
    }
}
