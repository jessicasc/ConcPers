package case3;

import java.io.*;
import java.util.Random;

public class ProgramaA implements Runnable {
	/**
	 * l� o conte�do do arquivo dataA.txt (caso n�o recupere salva o valor zero) e a cada 5 segundos 
	 * incrementa o valor lido e salva o novo valor sobrepondo o antigo
	 */

	private int tempo;

	@Override
	public void run() {

		while(true) {
			Controle control = new Controle();

			File file = new File("C:/Temp/dataA.txt");

			int dataA = control.readDataA();

			dataA++;
			control.insertData(dataA, file);

			System.out.println("Salvo no arquivo dataA.txt o n�mero "+dataA);

			/* caso eu queira que o programaA seja executado com intervalos de tempo aleat�rios entre 1 e 5 segundos
			 * Random ger = new Random();
				tempo = ger.nextInt(4001) + 1000;*/
	
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
