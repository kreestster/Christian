package multithreading.basic.demo3;

class Runner extends Thread{
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

public class App{

	public static void main(String...strings) {
		Runner app = new Runner();
		
		/**start esegue il metodo run() di Runner in un suo thread */
		app.start();
		/**run esegue il codice di run() nello stesso thread di main */
		//app.run();
		
		// esegue il secondo thread in multithreading
		Runner app2 = new Runner();
		
		app2.start();
	}
}
