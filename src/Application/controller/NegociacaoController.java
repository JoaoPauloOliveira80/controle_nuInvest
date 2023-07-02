package Application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Application.dao.NegociacaDao;
import Application.model.Negociacao;

public class NegociacaoController {

	private static NegociacaDao dao = new NegociacaDao();

	// Mï¿½todo para verificar se o arquivo existe e nï¿½o ï¿½ um diretï¿½rio
	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

//19/05/2023;3566708;"AMAR3F";0,66;4;0;2,64;0,00
	public static void leitorArquivo() throws IOException, SQLException {
		String path2 = "C:\\Users\\vigjo\\OneDrive\\Área de Trabalho\\01-PROJEOT-FANATICOS\\"
				+ "COMPRA-VENDA-NUINVEST\\extrato\\original/ResumoNegociacao_2023-02-28.csv";

		String path = path2;
 
		String[] dados;
		FileReader arquivo = new FileReader(new File(path));

		File file = new File(path);
		FileInputStream entrada = new FileInputStream(new File(path));

		if (isFileExists(file)) {
			System.out.println("Arquivo existe");
			Scanner sc = new Scanner(arquivo);
			ArrayList<Negociacao> lista = new ArrayList<>();
			sc.nextLine();
			sc.nextLine();
			Double preco;
			int cont = 1;
			while (sc.hasNext()) {
				Negociacao neg = new Negociacao();
				String linha = sc.nextLine();

				if (linha != null && !linha.isEmpty()) {
					System.out.println(linha);
					dados = linha.split("\\;");
					neg.setId(cont++);
					neg.setDt_negociacao(dados[0]);

					neg.setAtivo(dados[2].replace("\"", ""));

					neg.setPreco_cota(Double.parseDouble(dados[3].replaceAll(",", ".")));
					neg.setQtd_compra(Integer.parseInt(dados[4]));
					neg.setQtd_venda(Integer.valueOf(dados[5]));
					neg.setTotalCompra(Double.valueOf(dados[6].replace(".", "").replace(",", ".")));
					neg.setTotalVenda(Double.valueOf(dados[7].replace(".", "").replace(",", ".")));

					lista.add(neg);

				}
			}

			NegociacaDao negDao = new NegociacaDao();

			for (Negociacao c : negDao.getLista()) {
				System.out.println(c);
				// System.out.println();

			}
			Double soma = 0.00;
			Double res = 0.00;
			Double compra = 0.00;
			Double compra1 = 0.00;
			Double venda = 0.00;
			
			String getAtivo = null;
			
//			for (Negociacao n : lista) {
//				System.out.println(n);
//				
//			}

			
//
//					Negociacao neg = new Negociacao();
//
//					neg.setDt_negociacao(n.getDt_negociacao());
//					neg.setAtivo(n.getAtivo());
//					neg.setPreco_cota(n.getPreco_cota());
//					neg.setQtd_compra(n.getQtd_compra());
//					neg.setQtd_venda(n.getQtd_venda());
//					neg.setTotalCompra(n.getTotalCompra());
//					neg.setTotalVenda(n.getTotalVenda());
//					
//					
//					
//					//res+= n.getTotalCompra() - n.getTotalVenda();
//
//				//	dao.insert(neg);
//					
//				
			

		

		} else {
			System.out.println("File doesn't exist or program doesn't have access " + "to the file");
		}

	}

}
