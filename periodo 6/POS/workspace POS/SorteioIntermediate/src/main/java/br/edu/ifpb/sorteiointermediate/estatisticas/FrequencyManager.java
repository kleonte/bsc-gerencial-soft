/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.estatisticas;

import br.edu.ifpb.sorteiointermediate.dao.EstatisticaDAO;
import br.edu.ifpb.sorteiointermediate.dao.SorteioDAO;
import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Luciano
 */
public class FrequencyManager {
    
    public FrequencyManager(){
        
    }
    
    public List<Integer> getMaiorFrequenciaAllSorteios() throws ClassNotFoundException, SQLException{
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = sorteioDAO.getAllSorteios();
        EstatisticaDAO estatisticaDAO = new EstatisticaDAO();
        Estatistica estatistica = new Estatistica();
 List<Integer> resultado = new ArrayList<Integer>();
        int numeroMaisRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMaisRepetido = Collections.frequency(numerosSorteados, numeroMaisRepetido);
        String tipo = "maior frequencia todos os sorteios";
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMaisRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisRepetidoAux = Collections.frequency(numerosSorteados, numeroMaisRepetidoAux);
            
            if(frequenciaDoNumeroMaisRepetidoAux > frequenciaNumeroMaisRepetido ){
                numeroMaisRepetido = numeroMaisRepetidoAux;
                frequenciaNumeroMaisRepetido = frequenciaDoNumeroMaisRepetidoAux;
            }
        }
        estatistica.setNumero(numeroMaisRepetido);
        estatistica.setQtdeOcorrencias(frequenciaNumeroMaisRepetido);
        estatistica.setTipoConsulta(tipo);
        estatisticaDAO.save(estatistica);
        resultado.add(numeroMaisRepetido);
        resultado.add(frequenciaNumeroMaisRepetido);
        return resultado;
        
    }
    
    public List<Integer> getMenorFrequenciaAllSorteios() throws ClassNotFoundException, SQLException{
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = sorteioDAO.getAllSorteios();
        List<Integer> resultado = new ArrayList<Integer>();
        
        int numeroMenosRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMenosRepetido = Collections.frequency(numerosSorteados, numeroMenosRepetido);
        
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMenosRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosRepetidoAux = Collections.frequency(numerosSorteados, numeroMenosRepetidoAux);
            
            if(frequenciaDoNumeroMenosRepetidoAux < frequenciaNumeroMenosRepetido ){
                numeroMenosRepetido = numeroMenosRepetidoAux;
                frequenciaNumeroMenosRepetido = frequenciaDoNumeroMenosRepetidoAux;
            }
        }
        resultado.add(numeroMenosRepetido);
        resultado.add(frequenciaNumeroMenosRepetido);
        return resultado;
        
    }
    
    public List<Integer> getMaiorFrequenciaPorPeriodo(String dtInicial, String dtFinal) throws ClassNotFoundException, SQLException, ParseException{
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = new ArrayList<Integer>();
        List<Integer> resultado = new ArrayList<Integer>();
        numerosSorteados = sorteioDAO.getSorteioPorPeriodo(dtInicial, dtFinal);
        
        int numeroMaisRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMaisRepetido = Collections.frequency(numerosSorteados, numeroMaisRepetido);
        
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMaisRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisRepetidoAux = Collections.frequency(numerosSorteados, numeroMaisRepetidoAux);
            
            if(frequenciaDoNumeroMaisRepetidoAux > frequenciaNumeroMaisRepetido ){
                numeroMaisRepetido = numeroMaisRepetidoAux;
                frequenciaNumeroMaisRepetido = frequenciaDoNumeroMaisRepetidoAux;
            }
        }
        resultado.add(numeroMaisRepetido);
        resultado.add(frequenciaNumeroMaisRepetido);
        return resultado;
         
    }
    public List<Integer> getMenorFrequenciaPorPeriodo(String dtInicial, String dtFinal) throws ClassNotFoundException, SQLException, ParseException{
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = new ArrayList<Integer>();
        List<Integer> resultado = new ArrayList<Integer>();
        numerosSorteados = sorteioDAO.getSorteioPorPeriodo(dtInicial, dtFinal);
        
        int numeroMenosRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMenosRepetido = Collections.frequency(numerosSorteados, numeroMenosRepetido);
        
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMenosRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosRepetidoAux = Collections.frequency(numerosSorteados, numeroMenosRepetidoAux);
            
            if(frequenciaDoNumeroMenosRepetidoAux < frequenciaNumeroMenosRepetido ){
                numeroMenosRepetido = numeroMenosRepetidoAux;
                frequenciaNumeroMenosRepetido = frequenciaDoNumeroMenosRepetidoAux;
            }
        }
        resultado.add(numeroMenosRepetido);
        resultado.add(frequenciaNumeroMenosRepetido);
        return resultado;
         
    }
    
    public List<Integer> getMaiorFrequenciaPorFaixaDeCodigo(int codInicial, int codFinal) throws ClassNotFoundException, SQLException{
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = new ArrayList<Integer>();
        List<Integer> resultado = new ArrayList<Integer>();
        numerosSorteados = sorteioDAO.getSorteiosPorFaixaDeCodigos(codInicial, codFinal);
                
        int numeroMaisRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMaisRepetido = Collections.frequency(numerosSorteados, numeroMaisRepetido);
        
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMaisRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisRepetidoAux = Collections.frequency(numerosSorteados, numeroMaisRepetidoAux);
            
            if(frequenciaDoNumeroMaisRepetidoAux > frequenciaNumeroMaisRepetido ){
                numeroMaisRepetido = numeroMaisRepetidoAux;
                frequenciaNumeroMaisRepetido = frequenciaDoNumeroMaisRepetidoAux;
            }
        }
        resultado.add(numeroMaisRepetido);
        resultado.add(frequenciaNumeroMaisRepetido);
        return resultado;
        
    }
    
    public List<Integer> getMenorFrequenciaPorFaixaDeCodigo(int codInicial, int codigoFinal) throws ClassNotFoundException, SQLException{
        
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Integer> numerosSorteados = new ArrayList<Integer>();
        List<Integer> resultado = new ArrayList<Integer>();
        numerosSorteados = sorteioDAO.getSorteiosPorFaixaDeCodigos(codInicial, codigoFinal);
        
        int numeroMenosRepetido = numerosSorteados.get(0);
        int frequenciaNumeroMenosRepetido = Collections.frequency(numerosSorteados, numeroMenosRepetido);
        
        for(int i =0; i< numerosSorteados.size(); i++){
            int numeroMenosRepetidoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosRepetidoAux = Collections.frequency(numerosSorteados, numeroMenosRepetidoAux);
            
            if(frequenciaDoNumeroMenosRepetidoAux < frequenciaNumeroMenosRepetido ){
                numeroMenosRepetido = numeroMenosRepetidoAux;
                frequenciaNumeroMenosRepetido = frequenciaDoNumeroMenosRepetidoAux;
            }
        }
        resultado.add(numeroMenosRepetido);
        resultado.add(frequenciaNumeroMenosRepetido);
        return resultado;
         
        
    }
    
}
