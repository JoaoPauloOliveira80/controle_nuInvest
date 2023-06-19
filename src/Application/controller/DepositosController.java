package Application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Application.dao.DepositoDao;
import Application.model.Depositos;

public class DepositosController {
	static Scanner scan = new Scanner(System.in);

	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

	public static void controleDepositos() throws IOException, SQLException {
		String p1 = "Extrato_2023-05-23.csv";
		String caminho = "Extrato_2023-06-13.csv";
		String path = "C:\\Users\\vigjo\\OneDrive\\Área de Trabalho\\01-PROJEOT-FANATICOS\\COMPRA-VENDA-NUINVEST\\extrato\\original/"
				+ caminho;

		DepositoDao depDao = new DepositoDao();
		String[] dados = null;
		FileReader arquivo = new FileReader(new File(path));

		File file = new File(path);
		FileInputStream entrada = new FileInputStream(new File(path));
		ArrayList<Depositos> lista = new ArrayList<>();
		if (isFileExists(file)) {
			System.out.println("Arquivo existe");
			Scanner sc = new Scanner(arquivo);

			Double preco;
			int cont = 1;
			sc.nextLine();
			sc.nextLine();
			int chave = 0;
			while (sc.hasNextLine()) {

				Depositos dep = new Depositos();
				String linha = sc.nextLine();

				if (linha != null && !linha.isEmpty()) {
					dados = linha.split("\\;");
					System.out.println(linha);

					dep.setDt_deposito(dados[1]);

					if (dados[2].contains("TED")) {
						dep.setOperacao("TED");
					}

					dep.setDepositos(Double.valueOf(dados[3].replace(".", "").replace(",", ".")));
					dep.setId(Integer.valueOf(dados[6]));
					
					if (dados[2].contains("TED")) {
						//dep.setId(cont++);
						lista.add(dep);
					}

				}

			}
			DepositoDao dao = new DepositoDao();
			Double soma = 0.00;
			for (Depositos l : lista) {

				Depositos dep = new Depositos();
				dep = dao.buscarByChave(l.getId());
				
				soma += l.getDepositos();
				
				
				if(dep == null) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("| Fazer NOVO cadastro |");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println(l);
					System.out.println("=================================");
					System.out.println();
					System.out.println("Digite 1 para João 2 para Flavia");
					soma+= l.getValorDep();
					int n = scan.nextInt();
					
					if(n == 0) {
						System.out.println();
						System.exit(0);
					}else if (n == 1) {
						l.setDepositante("Joao");
						dao.insert(l);
					} else if (n == 2) {
						l.setDepositante("flavia");
						dao.insert(l);
					}
					
				}
			}
			Double div = 276.42;
			Double nu_invest = 7782.00;
			Double res = soma + div ;
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("Depositos: " +  String.format("%.2f",soma));
			System.out.println("Dividendo: " +  String.format("%.2f", div ));
			System.out.println("Total investido: " +  String.format("%.2f",  res));
			
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			System.out.println("Nu_invest: " +  String.format("%.2f", nu_invest ));
			
			System.out.println("lucro liquido : "+ String.format("%.2f", nu_invest - soma ));
			
			
		} else

		{
			System.out.println("File doesn't exist or program doesn't have access " + "to the file");
		}

	}

}
