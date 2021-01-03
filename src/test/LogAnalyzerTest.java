package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Calendar;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.LogAnalyzer;
import main.LogLoader;

/**
 * 
 * @author hikaru
 * 例外ハンドリングのテスト
 */
public class LogAnalyzerTest {
	
	@Rule
	public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void LogLoaderが例外を送出するときAnalyzeExceptionが再送出される() throws Exception {
		
		//setup
		LogAnalyzer sut = new LogAnalyzer();
		final IOException errorCause = new IOException("error by stub");
		LogLoader mockLoader = mock(LogLoader.class);
		sut.logLoader = mockLoader; //mockの設定
		
		when(mockLoader.load("test")).thenThrow(errorCause); //mockの定義を設定
		
		ex.expect(LogAnalyzer.AnalyzeException.class);
		ex.expectMessage("error by stub");
		ex.expect(new BaseMatcher<Object>() {
			Throwable cause;
			
			@Override
			public boolean matches(Object item) {
				Throwable t = (Throwable) item;
				cause = t.getCause();
				return cause == errorCause;
			}
			
			@Override
			public void describeTo(Description description) {
				description.appendValue(cause);
			}
		});
		
		//execise
		sut.analyze("test");
	}

}
