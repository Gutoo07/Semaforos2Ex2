package view;
import java.util.concurrent.Semaphore;

import controller.Metodos2;

public class Main2 {

	public static void main(String[] args) {
		Semaphore porta = new Semaphore(1);
		for (int i = 0; i < 4; i++) {
			Thread pessoa = new Metodos2(porta, i);
			pessoa.start();
		}
	}

}
