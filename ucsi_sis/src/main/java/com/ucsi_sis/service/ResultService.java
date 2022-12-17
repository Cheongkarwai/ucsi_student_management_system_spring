package com.ucsi_sis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.ucsi_sis.entity.Result;
import com.ucsi_sis.repository.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	private TransactionTemplate transactionTemplate;
	
	
//	private Result getById(String id) {
//		
//		
//		
//	}
//	public List<Result> getAll(){
//		
//	}

}
