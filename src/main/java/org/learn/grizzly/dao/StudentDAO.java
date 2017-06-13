package org.learn.grizzly.dao;

import org.hibernate.Session;
import org.learn.grizzly.model.Student;
import org.learn.grizzly.util.HibernateUtil;

public class StudentDAO {
	
	public Student getStudentById(Integer user_id) {
        Session session = null;
        Student student = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            // get return null if object not found, search in the cache first
            // load thrws an exception
            
            student =  session.get(Student.class, user_id);
            //Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                //session.close();
            }
        }
        return student;
    }
}
