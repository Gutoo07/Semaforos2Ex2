package controller;
import java.util.concurrent.Semaphore;

public class Metodos2 extends Thread {
	private Semaphore porta;
	private int id, distanciaPerc;
	
	
	public Metodos2(Semaphore porta, int id) {
		this.porta = porta;
		this.id = id;		
	}
	public void run() {
		System.out.println("Pessoa "+id+" esta andando");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (distanciaPerc < 200) {
			distanciaPerc += (int) ((Math.random()*3)+4);
		}
		System.out.println("Pessoa "+id+" chegou na porta");
		try {
			porta.acquire();
			System.err.println("Pessoa "+id+" esta abrindo e passando pela porta");
			sleep( (int) ((Math.random()*1001) + 1000) );
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			porta.release();
		}
	}
	
}
