package dao;

import model.Account;

public interface AccountDao {
	
	Account findOrNull(String userId);

}
