package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.StringUtils;

/**
 * 
 * @author hikaru
 * 状態を持たない場合
 */
public class StringUtilsTest {
	
	@Test
	public void aaaの場合() {
		assertThat(StringUtils.toSnakeCase("aaa"),is("aaa"));
	}

	@Test
	public void HelloWorldの場合(){
		assertThat(StringUtils.toSnakeCase("HelloWorld"), is("hello_world"));
	}
	
	@Test
	public void practiceJunitの場合() {
		assertThat(StringUtils.toSnakeCase("practiceJunit"), is("practice_junit"));
	}
	
	@Test(expected = NullPointerException.class)
	public void nullの場合() {
		StringUtils.toSnakeCase(null);
	}
}
