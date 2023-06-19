package Application;

import java.io.IOException;
import java.sql.SQLException;

import Application.conection.ConexaoMySQL;
import Application.controller.DepositosController;
import Application.dao.DepositoDao;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		ConexaoMySQL.create();
	
		//NegociacaoController.leitorArquivo();
		
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  Procurando ===========================================");

//		ProventosController.controleProventos();
//		MovimentacaoController.controleProventos();
		DepositosController.controleDepositos();
		
//		NegociacaoController.leitorArquivo();

//		NegociacaDao negDao = new NegociacaDao();
		
//		ProventosDao provDao = new ProventosDao();

//		for(Negociacao c : negDao.getLista()) {
//			
////			System.out.println(c);
////			System.out.println("\nbanco de dados");
//			
////			if(c.getAtivo().contains("CVC")) {
////				System.out.println(c);
////			}
//		}

//		for(Proventos p : provDao.getProventos()) {
//			System.out.println("Lista de Pronventos");
//			System.out.println(p);
//			System.out.println();
//			
//		}
	}

}
