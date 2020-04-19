package happy.demo.design;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDesgin {


	private   volatile static Boolean check;
	private  static SingletonDesgin singletonDesgin;
	private static Object o = new Object();
	private SingletonDesgin() {
 	}

 	public static SingletonDesgin getInstance() {
	    if (Objects.isNull(singletonDesgin)) {
		    synchronized (o) {
			    if (Objects.isNull(singletonDesgin)) {
				    singletonDesgin = new SingletonDesgin();
			    }
		    }
	    }
		return singletonDesgin;
    }

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		int i = 20;
		for (int i1 = 0; i1 < i; i1++) {
			executorService.execute(()->{
				System.out.println(SingletonDesgin.getInstance());
			});
		}
		executorService.shutdown();


	}


}
