package case3;

import java.io.*;

public class ProgramaB implements Runnable {
	/**
	 * lê o conteúdo do arquivo dataA.txt e o salvo no arquivo dataB.txt sobrepondo o antigo
	 */
	
	@Override
	public void run() {

		while (true) {
			Controle control = new Controle();

			File file = new File("C:/Temp/dataB.txt");

			int dataA = control.readDataA();

			control.insertData(dataA, file);
			
			System.out.println("Salvo no arquivo dataB.txt o número "+dataA);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
