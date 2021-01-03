package main;

import java.util.concurrent.Executors;

public class BackGroundTask {
	
	private final Runnable task;
	
	public BackGroundTask(Runnable task) {
		this.task = task;
	}

	public void invoke() {
		Executors.newSingleThreadExecutor().execute(task);
	}

}
