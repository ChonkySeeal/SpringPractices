package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
								
		
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 1);
			
//			myStudent.setFirstName("Scooby");
//			
//			session.getTransaction().commit();
			
			
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
