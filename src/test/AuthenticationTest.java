package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import dao.AccountDao;
import main.Authentication;
import model.Account;

@RunWith(Enclosed.class)
public class AuthenticationTest {
	
	public static class アカウントが存在しない場合{
		
		Authentication sut;
		
		@Before
		public void setUp() throws Exception{
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			when(sut.dao.findOrNull("user001")).thenReturn(null);
		}
		
		@Test
		public void autheniticationはmockしたnullを返却する() throws Exception{
			assertThat(sut.authenticate("user001","pw123"), is(nullValue()));
		}
	}
	
	public static class アカウントが存在しパスワードが一致する場合1{
		
		Authentication sut;
		
		@Before
		public void setUp() throws Exception{
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			when(sut.dao.findOrNull("user001")).thenReturn(new Account("user001","pw123"));
		}
		
		@Test
		public void autheniticationはmockしたnullを返却する() throws Exception{
			assertThat(sut.authenticate("user001","pw123").getName(), is("user001"));
		}
	}
	
	public static class アカウントが存在しパスワードが一致する場合2{
		
		Authentication sut;
		Account account;
		
		@Before
		public void setUp() throws Exception{
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("user001","pw123");
			when(sut.dao.findOrNull("user001")).thenReturn(account);
		}
		
		@Test
		public void autheniticationはmockしたnullを返却する() throws Exception{
			assertThat(sut.authenticate("user001","pw123"), is(sameInstance(account)));
		}
	}
	
	public static class アカウントが存在するがパスワードが違う場合{
		
		Authentication sut;
		Account account;
		
		@Before
		public void setUp() throws Exception{
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("user001","pw999");
			when(sut.dao.findOrNull("user001")).thenReturn(account);
		}
		
		@Test
		public void autheniticationはmockしたnullを返却する() throws Exception{
			assertThat(sut.authenticate("user001","pw123"), is(nullValue()));
		}
	}

}
