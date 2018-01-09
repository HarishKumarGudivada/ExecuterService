package Executor_Basic.Executor_Basic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		System.out.println("Start");
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.submit(new MyTask("one"));
		es.submit(ExecutorServiceExample :: get);
		es.submit(new MyTask("two"));
		es.submit(new MyTask("three"));
		es.shutdown();
		System.out.println("End");
	}

	public static void get()
	{
		System.out.println("simha");
		
	}
}


class MyTask implements Runnable {
	String threadName;
	public MyTask(String name) {
		threadName = name;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Thread:"+threadName+"::::"+i);
		}
	}
}