package com.ucsi_sis.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucsi_sis.entity.Result;

@Repository
public class ResultRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ResultRepository() {
		
	}
	
	public Optional<Result> findById(String id){
		Session session = sessionFactory.getCurrentSession();
		return Optional.ofNullable(session.get(Result.class,id));
	}
	public List<Result> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Result",Result.class)
				.list();
	}

}
