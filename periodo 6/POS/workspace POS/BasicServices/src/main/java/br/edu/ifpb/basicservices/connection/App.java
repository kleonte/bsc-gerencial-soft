/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.basicservices.connection;


import br.edu.ifpb.basicservices.dao.EstatisticasDAO;
import br.edu.ifpb.basicservices.dao.SorteioDAO;
import br.edu.ifpb.basicservices.entidades.Sorteio;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
//        Conexao conexao = new Conexao();
//        if(conexao.getConnection()!=null){
//            System.out.println("conectado");
//        }else{
//         System.out.println("nao conectado");
//        }
        
       // Estatistica estatistica = new Estatistica();
    
       //salvar
//  System.out.println(estatistica.getTipo().DATA_ESPECIFICA.getValor());
        //recuperar
    //System.out.println(estatistica.getTipo().valueOf("DATA_ESPECIFICA"));
        SorteioDAO  sorteioDAO = new SorteioDAO();
       
//        Sorteio sorteio = new Sorteio();
//        sorteio.setDataSorteio(new Date());
//        sorteio.setNum1(33);
//        sorteio.setNum2(12);
//        sorteio.setNum3(16);
//        sorteio.setNum4(18);
//        sorteio.setNum5(22);
//        sorteio.setNum6(40);
//        SorteioDAO sorteiodao = new SorteioDAO();
//        sorteiodao.addSorteio(sorteio);
        
       
//       EstatisticasDAO estatisticasDAO = new EstatisticasDAO();
//       List<Integer> numeros = new ArrayList<Integer>();
//       numeros = sorteioDAO.allNumerosSorteados();
//       List<Integer> resultadoMaiorFrequencia = new ArrayList<Integer>();
//       List<Integer> resultadoMenorFrequencia = new ArrayList<Integer>();
//       
//       resultadoMaiorFrequencia = estatisticasDAO.numeroMaiorFrequencia();
//       resultadoMenorFrequencia = estatisticasDAO.numeroMenorFrequencia();
//       
//       
//       System.out.println("Resultado de todos os sorteios"); 
//       System.out.println(numeros);
//        System.out.println("");
//        System.out.print("Numero de maior frequencia - ");
//        System.out.println(resultadoMaiorFrequencia.get(0));
//        System.out.print("Quantidade de vezes - ");
//        System.out.println(resultadoMaiorFrequencia.get(1));
//        
//         System.out.println("");
//        System.out.print("Numero de menor frequencia - ");
//        System.out.println(resultadoMenorFrequencia.get(0));
//        System.out.print("Quantidade de vezes - ");
//        System.out.println(resultadoMenorFrequencia.get(1));
       
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        sorteios = sorteioDAO.getSorteioPorData("10/11/2013");
        //sorteios = sorteioDAO.getSorteiosPorPeriodo("20/11/2013", "28/11/2013");
        //sorteios = sorteioDAO.getSorteioPorIntervaloDeCodigo(7, 11);
//         Sorteio sorteio = sorteioDAO.getSorteioPorCodigo(8);
//         System.out.println(sorteio);
        
        for (Sorteio sorteio : sorteios) {
            System.out.println(sorteio);
        }
        
    }
    
    
}
