package Application.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Application.dao.DepositoDao;
import Application.model.Depositos;
import Application.model.Proventos;

public class DepositosController {
	static Scanner scan = new Scanner(System.in);
	static String[] dados = null;

	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

	public static void controleDepositos() throws IOException, SQLException {

		String caminho = "extratos_2023-06-30.csv";
		String path = "C:\\Users\\vigjo\\OneDrive\\Área de Trabalho\\01-PROJEOT-FANATICOS\\COMPRA-VENDA-NUINVEST\\extrato\\original/"
				+ caminho;

		FileReader arquivo = new FileReader(new File(path));

		File file = new File(path);
		ArrayList<Depositos> listaDep = new ArrayList<>();
		ArrayList<Proventos> listaProv = new ArrayList<>();

		if (isFileExists(file)) {
			// System.out.println("Arquivo existe");
			Scanner sc = new Scanner(arquivo);

			sc.nextLine();

			while (sc.hasNextLine()) {

				Depositos dep = new Depositos();
				Proventos prov = new Proventos();

				String linha = sc.nextLine();

				if (linha != null && !linha.isEmpty()) {
					dados = linha.split("\\;");
					System.out.println(linha);

					// PEGA DADOS DE DEPOSITOS REALIZADO
					if (dados[2].contains("TED")) {

						dep.setDt_deposito(dados[1]);
						dep.setOperacao("TED");
						dep.setDepositos(Double.valueOf(dados[3].replace(".", "").replace(",", ".")));
						dep.setId(Integer.valueOf(dados[6]));
						listaDep.add(dep);
					}
					// PEGA DADOS DE PROVENTOS RECEBIDO
					if (dados[2].contains("Rendimento") || dados[2].contains("Dividendos")
							|| dados[2].contains("Juros")) {

						prov.setDt_recebimeto(dados[1]);
						if (dados[2].contains("MXRF11")) {
							prov.setAtivo("MXRF11");
						} else if (dados[2].contains("VGHF11")) {
							prov.setAtivo("VGHF11");
						} else if (dados[2].contains("HABT11")) {
							prov.setAtivo("HABT11");
						} else if (dados[2].contains("DEVA11")) {
							prov.setAtivo("DEVA11");
						} else if (dados[2].contains("DEVA11")) {
							prov.setAtivo("DEVA11");
						} else if (dados[2].contains("VCRI11")) {
							prov.setAtivo("VCRI11");
						} else if (dados[2].contains("VSLH11")) {
							prov.setAtivo("VSLH11");
						} else if (dados[2].contains("PETR4")) {
							prov.setAtivo("PETR4");
						} else if (dados[2].contains("FESA4")) {
							prov.setAtivo("FESA4");
						} else if (dados[2].contains("UNIP3")) {
							prov.setAtivo("UNIP3");
						} else if (dados[2].contains("KISU11")) {
							prov.setAtivo("KISU11");
						} else if (dados[2].contains("SNFF11")) {
							prov.setAtivo("SNFF11");
						}
						prov.setValorDep(Double.valueOf(dados[3].replace(".", "").replace(",", ".")));
						prov.setId(Integer.valueOf(dados[6]));
						listaProv.add(prov);
					}

				}

			}
			DepositoDao dao = new DepositoDao();
			String msg = "";

			// FAZ A LISTAGEM DOS PROVENTOS RECEBIDO
			for (Proventos l : listaProv) {
				Proventos p = new Proventos();
				p = dao.getProvId(l.getId());

				if (p == null) {
					System.out.println("Foi encontrado NOVOS pagamento de ativo. Deseja salvá-los?");
					System.out.println("Digite  Y/N");
					String res = scan.nextLine();

					if (res.equalsIgnoreCase("S")) {
						System.out.println(l);
						System.out.println();
						dao.insertProventos(l);
					}
					System.out.println(l);
					System.out.println();
					dao.insertProventos(l);

				} else {
					msg = "Não existe proventos recente";

				}

			}
			JOptionPane.showMessageDialog(null, msg);

			
			Double soma = 0.00;
			Double totalProventos = 0.00;
			Double patrimonio = 0.00;

			patrimonio = soma + totalProventos;

			// FAZ A LISTA DOS DEPOSITOS FEITO
			Depositos dep = new Depositos();
			for (Depositos l : listaDep) {

				// Depositos dep = new Depositos();
				dep = dao.buscarByChave(l.getId());

				soma += l.getDepositos();

				
				
				if (dep == null) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("| Fazer NOVO cadastro |");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println(l);
					System.out.println("=================================");
					System.out.println();
					System.out.println("Digite 1 para João 2 para Flavia");
					int n = scan.nextInt();

					if (n == 0) {
						System.out.println();
						System.exit(0);
					} else if (n == 1) {
						l.setDepositante("João Paulo");
						dao.insert(l);
					} else if (n == 2) {
						l.setDepositante("Flavia");
						dao.insert(l);
					}

				} else {

					msg = "Não há dados novo no momento...";

				}

			}
			JOptionPane.showMessageDialog(null, msg);

//			for (Depositos buscar : dao.getDepositos()) {
//
//				soma += buscar.getDepositos();
//				
//			}
			
			
			// RECUPERA DO BANCO OS PROVENTOS SALVO
		
			int cont = 0;
//			for (Proventos p : dao.getProventos()) {
//				totalProventos += p.getValorDep();
//
//				cont++;
//
//			}
			
			System.out.println("Quantidade de proventos registrado: " + cont);

			patrimonio = soma + totalProventos;

			System.out.println("Proventos recebido: " + String.format("%.2f", totalProventos));
			System.out.println("Depositos Total banco: " + String.format("%.2f", soma));
			System.out.println("Patrimonio: " + String.format("%.2f", patrimonio));

			sc.close();
		} else

		{
			System.out.println("File doesn't exist or program doesn't have access " + "to the file");
		}

	}

	public static void filterDividendo(String nome) {
		Proventos prov = new Proventos();
		if (dados[2].contains(nome)) {
			prov.setAtivo("MXRF11");
		} else if (dados[2].contains(nome)) {
			prov.setAtivo("VGHF11");
		} else if (dados[2].contains("HABT11")) {
			prov.setAtivo("HABT11");
		} else if (dados[2].contains("DEVA11")) {
			prov.setAtivo("DEVA11");
		} else if (dados[2].contains("DEVA11")) {
			prov.setAtivo("DEVA11");
		} else if (dados[2].contains("VCRI11")) {
			prov.setAtivo("VCRI11");
		} else if (dados[2].contains("VSLH11")) {
			prov.setAtivo("VSLH11");
		} else if (dados[2].contains("PETR4")) {
			prov.setAtivo("PETR4");
		} else if (dados[2].contains("FESA4")) {
			prov.setAtivo("FESA4");
		} else if (dados[2].contains("UNIP3")) {
			prov.setAtivo("UNIP3");
		} else if (dados[2].contains("KISU11")) {
			prov.setAtivo("KISU11");
		} else if (dados[2].contains("SNFF11")) {
			prov.setAtivo("SNFF11");
		}
	}

}
