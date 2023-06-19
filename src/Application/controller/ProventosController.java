package Application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Application.dao.DepositoDao;
import Application.dao.ProventosDao;
import Application.model.Depositos;
import Application.model.Negociacao;
import Application.model.Proventos;

public class ProventosController {
	// rendimento.csv
	// Mï¿½todo para verificar se o arquivo existe e nï¿½o ï¿½ um diretï¿½rio
	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

	public static void controleProventos() throws IOException, SQLException {
		String p1 = "Extrato_2023-05-23.csv";
		String p = p1;
		String path = "C:\\Users\\vigjo\\OneDrive\\Área de Trabalho\\01-PROJEOT-FANATICOS\\COMPRA-VENDA-NUINVEST\\extrato\\original/Extrato_2023-05-30.csv";

		ProventosDao provDao = new ProventosDao();
		String[] dados = null;
		FileReader arquivo = new FileReader(new File(path));

		File file = new File(path);
		FileInputStream entrada = new FileInputStream(new File(path));
		ArrayList<Proventos> lista = new ArrayList<>();
		if (isFileExists(file)) {
			System.out.println("Arquivo existe");
			Scanner sc = new Scanner(arquivo);

			Double preco;
			
			sc.nextLine();
			sc.nextLine();
			
			while (sc.hasNextLine()) {
				
				Proventos prov = new Proventos();
				String linha = sc.nextLine();
				Negociacao neg = new Negociacao();
				int cont = 0;
				if (linha != null && !linha.isEmpty()) {

					dados = linha.split("\\;");
					System.out.println(linha);
					
					prov.setDt_recib(dados[1]);

					// filtroAtivo(dados[2]);

					if (dados[2].contains("VGHF11")) {

						prov.setAtivo("VGHF11");

					} else if (dados[2].contains("KISU11")) {

						prov.setAtivo("KISU11");
					} else if (dados[2].contains("MXRF11")) {

						prov.setAtivo("MXRF11");
					} else if (dados[2].contains("SNFF11")) {

						prov.setAtivo("SNFF11");
					} else if (dados[2].contains("HABT11")) {

						prov.setAtivo("HABT11");
					} else if (dados[2].contains("DEVA11")) {

						prov.setAtivo("DEVA11");
					} else if (dados[2].contains("VCRI11")) {

						prov.setAtivo("VCRI11");
					} else if (dados[2].contains("VSLH11")) {

						prov.setAtivo("VSLH11");
					} else if (dados[2].contains("PETR4")) {

						prov.setAtivo("PETR4");
					} else if (dados[2].contains("UNIP3")) {

						prov.setAtivo("UNIP3");
					}

					prov.setProventos(Double.valueOf(dados[3].replaceAll("\"", "").replace(",", ".")));

//					if (dados[2].contains("Rendimento") || dados[2].contains("Dividendos")) {
//						lista.add(prov);
//					}
					
					if (dados[2].contains("TED")) {
						DepositoDao depDao = new DepositoDao();
						for (Depositos depositos : depDao.getDepositos()) {
							System.out.println();
							System.out.println(depositos);
						}
					}

					// lista.add(prov);



				}

			}
//			DepositoDao depDao = new DepositoDao();
//			for (Depositos depositos : depDao.getProventos()) {
//				System.out.println();
//				System.out.println(depositos);
//			}
			
			
			
			
			int contagem = 1;
//			for (Proventos proventos : lista) {
//				Proventos prov = new Proventos();
//				System.out.println(proventos);
//				System.out.println();
//				
//				
//					prov.setId(contagem);
//				
//				
//				prov.setDt_recib(proventos.getDt_recib());
//				prov.setAtivo(proventos.getAtivo());
//				prov.setProventos(proventos.getProventos());
//
//				//provDao.insert(prov);
//				
//				contagem++;
//
//			}
			System.out.println("Total de registro salvo: " + contagem);

		} else

		{
			System.out.println("File doesn't exist or program doesn't have access " + "to the file");
		}

	}

	public static String filtroAtivo(String dado) {
		Proventos prov = new Proventos();

		if (dado.contains("VGHF11")) {
			prov.setAtivo("VGHF11");
		} else if (dado.contains("KISU11")) {
			prov.setAtivo("KISU11");
		} else if (dado.contains("MXRF11")) {
			prov.setAtivo("MXRF11");
		} else if (dado.contains("SNFF11")) {
			prov.setAtivo("SNFF11");
		} else if (dado.contains("HABT11")) {
			prov.setAtivo("HABT11");
		} else if (dado.contains("DEVA11")) {
			prov.setAtivo("DEVA11");
		} else if (dado.contains("VCRI11")) {
			prov.setAtivo("VCRI11");
		} else if (dado.contains("VSLH11")) {
			prov.setAtivo("VSLH11");
		} else if (dado.contains("PETR4")) {
			prov.setAtivo("PETR4");
		} else if (dado.contains("UNIP3")) {
			prov.setAtivo("UNIP3");
		}

		return dado;
	}

}
