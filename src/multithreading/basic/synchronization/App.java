package multithreading.basic.synchronization;

import java.util.Scanner;

class Processor extends Thread {
	
	/** settando la variabile come volatile si impedisce che il compilatore 
	 * ottimizzi il ciclo sostituendo direttamente con true il valore 
	 * dal momento che all'interno della classe il suo valore non cambia mai
	 * */
	private volatile boolean running = true;
	
	public void run() {
		while(running){
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void shutdown(){
		running = false;
	}
	
}

public class App {

	public static void main(String[] args) {
		Processor p = new Processor();
		
		p.start();
		Scanner sca = new Scanner(System.in);
		
		// mette in pausa il thread attuale fino alla ricezione dell'input
		sca.nextLine();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.shutdown();
	}

}
