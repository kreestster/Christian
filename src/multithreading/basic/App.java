package multithreading.basic;

public class App {

	/** inner anonymous class*/
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){

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
			
		});
		
		t1.start();
	}

}
