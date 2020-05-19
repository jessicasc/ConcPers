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
		 * lê o conteúdo do arquivo dataA.txt 
		 */
		try {

			file = new File("C:/Temp/dataA.txt"); 

			FileReader input = new FileReader(file);
			BufferedReader readFile = new BufferedReader(input);

			String dados = readFile.readLine();

			if (dados == null) {
				data = -1; //caso não recure o valor do arquivo atribui -1
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
		 * lê o conteúdo do arquivo dataB.txt 
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
		 * compara o conteúdo inteiro de 2 arquivos e salva em um terceiro
		 */
		try {

			FileWriter output = new FileWriter(file, true);
			PrintWriter writeFile = new PrintWriter(output);

			String res = (data1 == data2) ? "Igual" : "Diferente";

			writeFile.print(getDate()+" - Resultado da comparação: "+res+"\n");
			
			System.out.println(getDate()+" - Resultado da comparação: "+res);

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss");
		return sdf.format(new Date());
	}

	private void createFile(File file) {
		/**
		 * caso algum arquivo a ser acessado não exista, cria o respectivo arquivo
		 */
		try {
			file.createNewFile();
		} catch (IOException e) {
			showMessageDialog(null, "Arquivo não encontrado, falha na criação.\n"+
					"Verifique permissões do diretório", "Erro na criação", ERROR_MESSAGE);
		}
	}
}
