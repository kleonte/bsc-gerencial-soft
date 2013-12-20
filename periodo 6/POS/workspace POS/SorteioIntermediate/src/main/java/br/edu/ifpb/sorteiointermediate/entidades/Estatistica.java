/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.entidades;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luciano
 */
@XmlRootElement
public class Estatistica implements Serializable {
    
    @XmlElement
    private int id;
    @XmlElement
    private int numero;
    @XmlElement
    private int qtdeOcorrencias;
    @XmlElement
    private String tipoConsulta;
    
    public Estatistica(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdeOcorrencias() {
        return qtdeOcorrencias;
    }

    public void setQtdeOcorrencias(int qtdeOcorrencias) {
        this.qtdeOcorrencias = qtdeOcorrencias;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

//    @Override
//    public String toString() {
//        return "Estatistica{" + "id=" + id + ", numero=" + numero + ", qtdeOcorrencias=" + qtdeOcorrencias + ", tipoConsulta=" + tipoConsulta + '}';
//    }
//    
//    
//    
}
