package case3;

import java.io.*;
import java.util.Random;

public class ProgramaA implements Runnable {
	/**
	 * lê o conteúdo do arquivo dataA.txt (caso não recupere salva o valor zero) e a cada 5 segundos 
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

			System.out.println("Salvo no arquivo dataA.txt o número "+dataA);

			/* caso eu queira que o programaA seja executado com intervalos de tempo aleatórios entre 1 e 5 segundos
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
