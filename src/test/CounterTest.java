package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import main.Counter;

/**
 * 
 * @author hikaru
 * 副作用のある場合
 */
@RunWith(Enclosed.class)
public class CounterTest {
	
	public static class 初期状態の場合{
		Counter sut;
		
		@Before
		public void setUp() {
			sut = new Counter();
		}
		
		@Test
		public void incrementで１を取得() {
			assertThat(sut.increment(), is(1));
		}
	}

	public static class 一回実行された後の場合{

		Counter sut;
		
		@Before
		public void setUp() {
			sut = new Counter();
			sut.increment();
		}
		
		@Test
		public void incrementで１を取得() {
			assertThat(sut.increment(), is(2));
		}
	}

	public static class 五十回実行された後の場合{

		Counter sut;
		
		@Before
		public void setUp() {
			sut = new Counter();
			for(int i=0;i<50;i++) {
				sut.increment();
			}
		}
		
		@Test
		public void incrementで１を取得() {
			assertThat(sut.increment(), is(51));
		}
	}
	
}
