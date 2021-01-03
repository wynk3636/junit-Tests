package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.NumberUtils;

/**
 * 
 * @author hikaru
 * 同値クラスのテスト
 */
public class NumberUtilsTest {
	
	@Test
	public void trueを返す場合() {
		assertThat(NumberUtils.isEven(10), is(true));
	}
	
	@Test
	public void falseを返す場合() {
		assertThat(NumberUtils.isEven(3), is(false));
	}
}
