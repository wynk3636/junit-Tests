package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import model.Employee;

/**
 * 
 * @author hikaru
 * JavaBeansのアサーション
 */
public class EmployeeTest {
	
	@Test
	public void Employeeの一覧を取得() {
		
		//setup
		InputStream input = getClass().getResourceAsStream("../Files/Employee.txt");
		/*ファイル読み込み例
		BufferedReader is = new BufferedReader(new InputStreamReader(input));
		try {
			System.out.println(is.readLine());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		*/
		
		//execise
		List<Employee> actual = Employee.load(input);
		
		//verify
		assertThat(actual, is(notNullValue()));
		assertThat(actual.size(), is(1));
		Employee actualEmployee = actual.get(0);
		assertThat(actualEmployee.getFirstName(), is("TEST"));
		assertThat(actualEmployee.getLastName(), is("MAN"));
		assertThat(actualEmployee.getEmail(), is("test@test.com"));
	}
	
	@Test
	public void 複数のEmployeeの一覧を取得() {
		
		//setup
		InputStream input = getClass().getResourceAsStream("../Files/Employees.txt");
		
		//execise
		List<Employee> actual = Employee.load(input);
		
		//verify
		assertThat(actual, is(notNullValue()));
		assertThat(actual.size(), is(2));
		Employee actualEmployee = actual.get(0);
		assertThat(actualEmployee.getFirstName(), is("TEST"));
		assertThat(actualEmployee.getLastName(), is("MAN"));
		assertThat(actualEmployee.getEmail(), is("test@test.com"));
		actualEmployee = actual.get(1);
		assertThat(actualEmployee.getFirstName(), is("TEST2"));
		assertThat(actualEmployee.getLastName(), is("MAN2"));
		assertThat(actualEmployee.getEmail(), is("test@test.com2"));
	}
	
	@Test(expected=NullPointerException.class)
	public void 存在しないEmployeeの一覧を取得() {
		
		//setup
		InputStream input = getClass().getResourceAsStream("../Files/notFound.txt");
		
		//execise
		List<Employee> actual = Employee.load(input);
	}

}
