package com.ucsi_sis.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ucsi_sis.entity.Programme;
import com.ucsi_sis.entity.Student;

@Repository
public class ProgrammeRepository {
	
	private SessionFactory sessionFactory;

	public ProgrammeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Programme findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Programme.class,id);
	}
}
