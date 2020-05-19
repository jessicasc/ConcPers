package case3;

import java.io.*;

public class ProgramaC implements Runnable{
	/**
	 * l� o conte�do do arquivo dataA.txt e do dataB.txt, os compara e salva a compara��o no dataC.txt, criando um log hist�rico
	 */
	
	@Override
	public void run() {

		while(true) {
			Controle control = new Controle();

			File file = new File("C:/Temp/dataC.txt");

			int dataA = control.readDataA();
			int dataB = control.readDataB();

			control.compareData(dataA, dataB, file); 
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
