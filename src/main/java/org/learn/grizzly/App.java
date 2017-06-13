package org.learn.grizzly;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.learn.grizzly.dao.StudentDAO;
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
        
        Message msg = new Message();
        msg.setText("Hola Bebé");
        
//        createStudent();
        
        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudentById(1);
        
//        System.out.println( "Student 1:" + s1 );
        System.out.println( "Student 1:" + s1.getStudentName() );
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//    	session.beginTransaction();
        System.out.println( "Student 1:" + s1.getStudentPhoneNumbers() );
//        session.getTransaction().commit();
    }
    
    public static void createStudent() {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house","32354353"));
		phoneNumbers.add(new Phone("mobile","9889343423"));
		
		Student student = new Student("Eswar");
		student.setStudentPhoneNumbers(phoneNumbers);
		session.save(student);
		
		session.getTransaction().commit();
		System.out.println( "Student Guardado");
    }
}
