/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.basicservices.dao;

import br.edu.ifpb.basicservices.connection.Conexao;
import br.edu.ifpb.basicservices.entidades.Sorteio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano
 */
public class EstatisticasDAO {
    
    Conexao connection = new Conexao();
     SorteioDAO sorteioDAO = new SorteioDAO() ;
   
    public List<Integer> numeroMaiorFrequencia() throws SQLException, ClassNotFoundException{
        //EstatisticasDAO dao = new EstatisticasDAO();
        List<Integer> numerosSorteados = sorteioDAO.allNumerosSorteados();
        List<Integer> resultado = new ArrayList<Integer>();
        
        int numeroMaisRepetido = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisRepetido = Collections.frequency(numerosSorteados, numeroMaisRepetido);
           
        for (int i = 1; i < numerosSorteados.size(); i++){
            int numeroMaisRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisRepetidoAux = Collections.frequency(numerosSorteados, numeroMaisRepetidoAux);
               
                if (frequenciaDoNumeroMaisRepetidoAux > frequenciaDoNumeroMaisRepetido){
                    numeroMaisRepetido = numeroMaisRepetidoAux;
                    frequenciaDoNumeroMaisRepetido = frequenciaDoNumeroMaisRepetidoAux;
                }
        }
        resultado.add(numeroMaisRepetido);
        resultado.add(frequenciaDoNumeroMaisRepetido);
        return resultado;
        
    }
    
    public List<Integer> numeroMenorFrequencia() throws SQLException, ClassNotFoundException{
        EstatisticasDAO dao = new EstatisticasDAO();
        List<Integer> numerosSorteados = sorteioDAO.allNumerosSorteados();
        List<Integer> resultado = new ArrayList<Integer>();
        
        int numeroMenosRepetido = numerosSorteados.get(0);
        int frequenciaDoNumeroMenosRepetido = Collections.frequency(numerosSorteados, numeroMenosRepetido);
           
        for (int i = 1; i < numerosSorteados.size(); i++){
            int numeroMenosRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosRepetidoAux = Collections.frequency(numerosSorteados, numeroMenosRepetidoAux);
               
                if (frequenciaDoNumeroMenosRepetidoAux < frequenciaDoNumeroMenosRepetido){
                    numeroMenosRepetido = numeroMenosRepetidoAux;
                    frequenciaDoNumeroMenosRepetido = frequenciaDoNumeroMenosRepetidoAux;
                }
        }
        resultado.add(numeroMenosRepetido);
        resultado.add(frequenciaDoNumeroMenosRepetido);
        return resultado;
        
    }
    
   
}
