/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.basicservices.entidades;

import java.util.Date;



/**
 *
 * @author Luciano
 */
public class Sorteio {
    
    private Integer id;
    //private String dataSorteio;
    private Date dataSorteio;
    private Integer num1,num2,num3,num4,num5,num6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public Integer getNum4() {
        return num4;
    }

    public void setNum4(Integer num4) {
        this.num4 = num4;
    }

    public Integer getNum5() {
        return num5;
    }

    public void setNum5(Integer num5) {
        this.num5 = num5;
    }

    public Integer getNum6() {
        return num6;
    }

    public void setNum6(Integer num6) {
        this.num6 = num6;
    }

    @Override
    public String toString() {
        return "Sorteio -" + "id=" + id + ", dataSorteio=" + dataSorteio + ", num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4=" + num4 + ", num5=" + num5 + ", num6=" + num6 + '}';
    }
    
    
    
}
