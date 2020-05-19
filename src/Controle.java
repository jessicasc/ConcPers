package case3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.swing.JOptionPane.*;

public class Controle {
	private int data;
	private File file;

	public synchronized int readDataA() {
		/**
		 * l� o conte�do do arquivo dataA.txt 
		 */
		try {

			file = new File("C:/Temp/dataA.txt"); 

			FileReader input = new FileReader(file);
			BufferedReader readFile = new BufferedReader(input);

			String dados = readFile.readLine();

			if (dados == null) {
				data = -1; //caso n�o recure o valor do arquivo atribui -1
			} else {
				data = Integer.parseInt(dados); //transforma a String emm inteiro
			}

			input.close();

		} catch (FileNotFoundException e) {
			createFile(file);		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public synchronized void insertData(int data, File file) {
		/**
		 * insere um dado inteiro em algum arquivo
		 */
		try {

			FileWriter output = new FileWriter(file);
			PrintWriter writeFile = new PrintWriter(output);

			writeFile.print(data);

			output.close();

		} catch (FileNotFoundException e) {
			createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized int readDataB() {
		/**
		 * l� o conte�do do arquivo dataB.txt 
		 */
		try {

			file = new File("C:/Temp/dataB.txt");

			FileReader input = new FileReader(file);
			BufferedReader readFile = new BufferedReader(input);

			String dados = readFile.readLine();
			if (dados == null) {
				data = -1; 
			} else {
				data = Integer.parseInt(dados);
			}

			input.close();

		} catch (FileNotFoundException e) {
			createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public void compareData(int data1, int data2, File file) {
		/**
		 * compara o conte�do inteiro de 2 arquivos e salva em um terceiro
		 */
		try {

			FileWriter output = new FileWriter(file, true);
			PrintWriter writeFile = new PrintWriter(output);

			String res = (data1 == data2) ? "Igual" : "Diferente";

			writeFile.print(getDate()+" - Resultado da compara��o: "+res+"\n");
			
			System.out.println(getDate()+" - Resultado da compara��o: "+res);

			output.close();

		} catch (FileNotFoundException e) {
			createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getDate() {
		/**
		 * configura formato brasileiro para data e a retorna
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy '�s' HH:mm:ss");
		return sdf.format(new Date());
	}

	private void createFile(File file) {
		/**
		 * caso algum arquivo a ser acessado n�o exista, cria o respectivo arquivo
		 */
		try {
			file.createNewFile();
		} catch (IOException e) {
			showMessageDialog(null, "Arquivo n�o encontrado, falha na cria��o.\n"+
					"Verifique permiss�es do diret�rio", "Erro na cria��o", ERROR_MESSAGE);
		}
	}
}
