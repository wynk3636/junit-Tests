package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import main.ItemStock;
import model.Item;

/**
 * 
 * @author hikaru
 * voidが戻り値のテスト
 */
@RunWith(Enclosed.class)
public class ItemStockTest {
	 
	public static class 初期状態の場合{
		
		ItemStock sut;
		Item book;
		 
		@Before
		public void setUp() throws Exception{
			book = new Item("book",3800);
			sut = new ItemStock();
		}
		
		@Test
		public void 最初はgetNumで0を返す() throws Exception{
			assertThat(sut.getNum(book), is(0));
		}
		
		@Test
		public void addでbookを追加するとgetNumで1を返却する() throws Exception{
			sut.add(book);
			
			assertThat(sut.getNum(book), is(1));
		}
	}
	
	public static class bookが一回追加されている場合{
		
	}
}
