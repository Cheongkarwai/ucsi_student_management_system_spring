package com.ucsi_sis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ucsi_sis.entity.User;
import com.ucsi_sis.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	private TransactionTemplate transactionTemplate;
	
	public boolean authenticateUser(User user) {
		
		transactionTemplate = new TransactionTemplate(platformTransactionManager);
		
		return transactionTemplate.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				User localUser = userRepository.findByUsername(user.getUsername());
				
				if(localUser == null || !localUser.getUsername().equals(user.getUsername()) || !localUser.getPassword().equals(user.getPassword())) {
					return false;
				}
				return true;
			}
		});
		
	}
}
