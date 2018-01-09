package Executor_Basic.Executor_Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExampleInvokeAll {
	public static void main(String[] args) {
		System.out.println("Start");
		List<MyTask2> list = new ArrayList<>();
		list.add(new MyTask2("one"));
		list.add(new MyTask2("one"));
		list.add(new MyTask2("one"));
		list.add(new MyTask2("one"));
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		//ExecutorService es = Executors.newCachedThreadPool();
		//ExecutorService es = Executors.newSingleThreadExecutor();
		
		try {
			List<Future<Object>> objects = es.invokeAll(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("End");
	}

}


class MyTask2 implements Callable<Object> {
	String threadName;
	public MyTask2(String name) {
		threadName = name;
	}
	
	@Override
	public Object call() throws Exception {
		for(int i=0;i<100;i++) {
			System.out.println("Thread:"+threadName+"::::"+i);
		}
		return threadName;
	}
}