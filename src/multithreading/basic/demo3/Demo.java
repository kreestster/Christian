package multithreading.basic.demo3;

class Runner2 implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
            System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
}

public class Demo {
	public static void main (String...strings){
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());
		System.out.println(Thread.currentThread().getName() + "\n\n\n");
		t1.start();
		t2.start();
	}

}
