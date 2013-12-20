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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class SorteioDAO {
    
    private Conexao conexao = new Conexao();
    //cadastro de sorteio
    public void addSorteio(Sorteio sorteio) throws SQLException, ClassNotFoundException{
        Date date = new Date();
//        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
//        String dataAtual = data.format(date);
//        sorteio.setDataSorteio(dataAtual);
        Connection con = conexao.getConnection();
        String sql =("insert into sorteio(data_sorteio,num1,num2,num3,num4,num5,num6)values(?,?,?,?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(sorteio.getDataSorteio().getTime()));
        ps.setInt(2, sorteio.getNum1());
        ps.setInt(3, sorteio.getNum2());
        ps.setInt(4, sorteio.getNum3());
        ps.setInt(5, sorteio.getNum4());
        ps.setInt(6, sorteio.getNum5());
        ps.setInt(7, sorteio.getNum6());
        ps.execute();
        ps.close();
        con.close();
       
    }
    
     public List<Sorteio> getSorteiosPorPeriodo(String dtInicial, String dtFinal) throws SQLException, SQLException, ClassNotFoundException{
        Connection con = conexao.getConnection();
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        String sql = ("select * from sorteio s where s.data_sorteio between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dtInicial);
        ps.setString(2, dtFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Sorteio sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
        }
        ps.close();
        rs.close();
        con.close();
        
        return sorteios;
     }
     public List<Sorteio> getSorteioPorIntervaloDeCodigo(Integer codigoInicial, Integer codigoFinal) throws SQLException, ClassNotFoundException{
        Connection con = conexao.getConnection();
        List<Sorteio> sorteios = new ArrayList();
        Sorteio sorteio = null;
        String sql = ("select * from sorteio where id between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigoInicial);
        ps.setInt(2, codigoFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
        }
        rs.close();
        ps.close();
        con.close();
        return sorteios;
        
    }
    
    public List<Integer> allNumerosSorteados() throws SQLException, ClassNotFoundException{
     
        Connection con = conexao.getConnection();
        List<Integer> numeros = new ArrayList<Integer>();
        String sql =("select num1,num2,num3,num4,num5,num6 from sorteio");
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            numeros.add(rs.getInt("num1"));
            numeros.add(rs.getInt("num2"));
            numeros.add(rs.getInt("num3"));
            numeros.add(rs.getInt("num4"));
            numeros.add(rs.getInt("num5"));
            numeros.add(rs.getInt("num6"));
        }
        rs.close();
        ps.close();
        con.close();
        
        return numeros;
        
    }
    public List<Sorteio> getSorteioPorData(String data) throws SQLException, ClassNotFoundException, ParseException{
        Connection con = conexao.getConnection();
        Sorteio sorteio = null;
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        String sql = ("select * from sorteio where data_sorteio = ?");
        PreparedStatement ps = con.prepareStatement(sql);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dt = new java.sql.Date(format.parse(data).getTime());
        ps.setDate(1, dt);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
          }
        ps.close();
        con.close();
        return sorteios;
    }
   
    public Sorteio getSorteioPorCodigo(int codigo) throws SQLException, ClassNotFoundException{
        Connection con = conexao.getConnection();
        Sorteio sorteio = null;
        String sql = ("select * from sorteio where id = ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
        }
        return sorteio;
    }
    
    
    
}
