package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import main.FizzBuzz;

/**
 * 
 * @author hikaru
 * listのテスト
 */ 
public class FizzBuzzTest {
	
	@Test
	public void craateFizzBuzzList() {
		List<String> actual = FizzBuzz.createFizzBuzzList(3);
		
		assertThat(actual.size(), is(3));
		assertThat(actual.get(0), is("1"));
		assertThat(actual.get(1), is("2"));
		assertThat(actual.get(2), is("Fizz"));
	}
}
