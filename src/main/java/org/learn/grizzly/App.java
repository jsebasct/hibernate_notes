package org.learn.grizzly;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.learn.grizzly.model.Message;
import org.learn.grizzly.model.Phone;
import org.learn.grizzly.model.Student;
import org.learn.grizzly.util.HibernateUtil;

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

        Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house","32354353"));
		phoneNumbers.add(new Phone("mobile","9889343423"));
		
		Student student = new Student("Eswar");
		student.setStudentPhoneNumbers(phoneNumbers);
		session.save(student);
		
//        session.save(msg);
        session.getTransaction().commit();
    }
}
