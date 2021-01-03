package main;

import dao.AccountDao;
import model.Account;

public class Authentication {

	public AccountDao dao;

	public Account authenticate(String userId, String pass) {
		
		Account account = dao.findOrNull(userId);
		
		if(account==null) return null;
		
		return account.getPassword().equals(pass) ? account : null;
		
	}

}
