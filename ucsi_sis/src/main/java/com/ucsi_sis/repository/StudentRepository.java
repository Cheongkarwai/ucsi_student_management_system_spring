package com.ucsi_sis.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ucsi_sis.entity.Student;

@Repository
public class StudentRepository {

	private SessionFactory sessionFactory;
	
	public StudentRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Student> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student",Student.class)
				.list();
	}
	public Student findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class,id);
	}
	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(student);
	}

	public void update(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}

	public void deleteById(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Student WHERE id = :id")
				.setParameter("id", id)
				.executeUpdate();
	}
}
