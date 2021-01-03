package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.Calculator;

/**
 * 
 * @author hikaru
 * 例外を出力する場合
 */
public class CalculatorTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void divide0割り() {
		
		Calculator sut = new Calculator();
		sut.divide(1,0);
	}
	
	@Test
	public void divideTest() {
		
		Calculator sut = new Calculator();
		assertThat(sut.divide(4, 2),is(2));
	}

}
