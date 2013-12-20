/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.dao;

import br.edu.ifpb.sorteiointermediate.connection.ConnectionPostgresql;
import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import br.edu.ifpb.sorteiointermediate.estatisticas.FrequencyManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class EstatisticaDAO {
    
    ConnectionPostgresql connection = new ConnectionPostgresql();
    public void save(Estatistica estatistica) throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        String sql = ("insert into estatisticas(numero,qtd_ocorrencias,tipo_consulta)values(?,?,?) ");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, estatistica.getNumero());
        ps.setInt(2, estatistica.getQtdeOcorrencias());
        ps.setString(3, estatistica.getTipoConsulta());
        ps.execute();
        ps.close();
        con.close();
        //FrequencyManager frequencyManager = new FrequencyManager();
        
    }
    
}
