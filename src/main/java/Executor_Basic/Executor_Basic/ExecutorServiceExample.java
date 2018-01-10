package Executor_Basic.Executor_Basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		System.out.println("Start");
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.submit(new MyTask("one"));
		//Runnable
		//callable
		//Runnable with parameter returns the same
		//Returns value
		Future<Integer> object = es.submit(ExecutorServiceExample :: get);
		try {
			waitForValue(object.get());
			System.out.println("after get");
			System.out.println(object.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// execute will not return anything
		//submit will return Future object
		//returns nothing
		es.execute(ExecutorServiceExample :: get);
		
		//es.submit(new MyTask("two"));
		//es.submit(new MyTask("three"));
		es.shutdown();
		System.out.println("End");
	}

	public static int get()
	{
		int i=0;
		for(;i<200;i++) {
			System.out.println("without param"+i);
		}
		return i;
		
	}
	public static int waitForValue(int i)
	{
		for(;i<250;i++) {
			System.out.println("with param"+i);
		}
		return 20;
		
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