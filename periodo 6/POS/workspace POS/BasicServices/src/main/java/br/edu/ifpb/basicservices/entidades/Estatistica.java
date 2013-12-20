/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.basicservices.entidades;

/**
 *
 * @author Luciano
 */
public class Estatistica {
    
   
    private Integer id;
    private Integer numero;
    private Integer qtdOcorrencias;
    private Tipo tipo;
    
    
    public enum Tipo{
        INTERVALO_DATA("INTERVALO_DATA"),
        DATA_ESPECIFICA("DATA_ESPECIFICA"),
        SORTEIOS("SORTEIOS"),
        INTERVALO_CODIGO_DO_SORTEIO("INTERVALO_CODIGO_DO_SORTEIO");
    
        private String valor;
       
        private Tipo(String value){
            this.valor = value;
        }

        public String getValor() {
            return valor;
        }

        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getQtdOcorrencias() {
        return qtdOcorrencias;
    }

    public void setQtdOcorrencias(Integer qtdOcorrencias) {
        this.qtdOcorrencias = qtdOcorrencias;
    }
    
    
    
    
    
}
