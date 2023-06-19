package Application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Application.dao.ProventosDao;
import Application.model.Depositos;
import Application.model.Negociacao;
import Application.model.Proventos;

public class MovimentacaoController {
//rendimento.csv
	// Mï¿½todo para verificar se o arquivo existe e nï¿½o ï¿½ um diretï¿½rio
	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

	public static void controleProventos() throws IOException, SQLException {
		String caminho = "Extrato_2023-06-08.csv";
		String path = "C:\\Users\\vigjo\\OneDrive\\Área de Trabalho\\01-PROJEOT-FANATICOS\\COMPRA-VENDA-NUINVEST\\extrato\\original/"+ caminho;

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
			int cont = 1;
			sc.nextLine();
			sc.nextLine();

			while (sc.hasNextLine()) {

				Proventos prov = new Proventos();
				String linha = sc.nextLine();
				Negociacao neg = new Negociacao();

				if (linha != null && !linha.isEmpty()) {

					dados = linha.split("\\;");
					System.out.println(linha);

					prov.setId(cont++);
					prov.setDt_recib(dados[1]);

					if (dados[2].contains("VGHF11")) {

						prov.setAtivo("VGHF11");

					} else if (dados[2].contains("KISU11")) {

						prov.setAtivo("KISU11");
					} else if (dados[2].contains("MXRF11")) {

						prov.setAtivo("MXRF11");
					} else if (dados[2].contains("SNFF11")) {

						prov.setAtivo("SNFF11");
					}else if (dados[2].contains("HABT11")) {

						prov.setAtivo("HABT11");
					}else if (dados[2].contains("DEVA11")) {

						prov.setAtivo("DEVA11");
					}else if (dados[2].contains("VCRI11")) {

						prov.setAtivo("VCRI11");
					}else if (dados[2].contains("VSLH11")) {

						prov.setAtivo("VSLH11");
					}else if (dados[2].contains("PETR4")) {

						prov.setAtivo("PETR4");
					}else if (dados[2].contains("UNIP3")) {

						prov.setAtivo("UNIP3");
					}

					else {
						System.out.println("XXXXXXXXXXXXXXXXXXXXX");
						System.out.println("Dados nao encontrado");
						System.out.println("XXXXXXXXXXXXXXXXXXXXX");
					}

					filtroAtivo(dados[2]);
					prov.setProventos(Double.valueOf(dados[3].replace(".", "").replace(",", ".")));

//					
					if (dados[2].contains("Rendimento") || dados[2].contains("Dividendos")) {
						lista.add(prov);
					}

					// lista.add(prov);

				}
			}

		
			for (Proventos proventos : lista) {
				System.out.println(proventos);
				System.out.println();

				Proventos prov = new Proventos();
				prov.setDt_recib(proventos.getDt_recib());
				prov.setAtivo(proventos.getAtivo());
				prov.setProventos(proventos.getProventos());

				// provDao.insert(prov);

			}

		} else {
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
