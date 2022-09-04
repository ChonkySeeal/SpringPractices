package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
								
		
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new student object");
			Student student = new Student("Dum", "Wall", "dum@naver.com");
			session.beginTransaction();
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id: "+ student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
