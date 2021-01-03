package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import main.BackGroundTask;


/**
 * 
 * @author hikaru
 * マルチスレッドのテスト
 */
public class BackGroundTaskTest {
	
	@Rule
	public Timeout timeout = new Timeout(1000);
	
	@Test
	public void invokeで別スレッドで実行される() throws Exception {
		
		//setup
		final AtomicReference<String> backgroundThreadName = new AtomicReference<String>(); //スレッドセーフにオブジェクトの参照を保持
		final CountDownLatch latch = new CountDownLatch(1);
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				backgroundThreadName.set(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		
		BackGroundTask sut = new BackGroundTask(task);
		
		//exercise
		sut.invoke();
		latch.await();
		
		//verify
		assertThat(backgroundThreadName.get(), is(not(Thread.currentThread().getName()))); //現在のスレッドと別であることを検証
	}
}
