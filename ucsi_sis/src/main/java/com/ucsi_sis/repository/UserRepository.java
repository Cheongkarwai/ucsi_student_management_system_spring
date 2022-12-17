package com.ucsi_sis.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucsi_sis.entity.User;

@Repository
public class UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class,username);
	}

}
