package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import main.NetworkLoader;
import main.NetworkResources;

/**
 * 
 * @author hikaru
 * 外部システム依存のテスト
 */
public class NetworkResourcesTest {
	
	@Test
	public void loadでネットワークから取得した文字を返す() throws Exception {
		
		//setup
		String expected = "Hello World";
		NetworkLoader mockLoader = mock(NetworkLoader.class);
		
		ByteArrayInputStream input = new ByteArrayInputStream(expected.getBytes());
		when(mockLoader.getInput()).thenReturn(input);
		
		NetworkResources sut = new NetworkResources();
		sut.loader = mockLoader;//上書き
		
		//execise
		String actual = sut.load();
		
		//assertion
		assertThat(actual, is(expected));
	}

}
