/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.sorteioresource;

import br.edu.ifpb.basicservices.dao.EstatisticasDAO;
import br.edu.ifpb.intermediateservices.result.JsonResult;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class MenorFrequencia extends ServerResource {
    
    @Get
    @Path("/menorFrequencia")
    public JSONObject getNumeroMenorFrequencia(){
        
        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();
        
        EstatisticasDAO estatisticasDAO = new EstatisticasDAO();
        try {
            List<Integer> menorFrequencia = estatisticasDAO.numeroMenorFrequencia();
            
            Gson gson = new Gson();
            String lista = gson.toJson(menorFrequencia);
            
            json.put("lista", menorFrequencia);
            
            result.setSucess(true);
            result.setMessage("recuperado com sucesso!");
            result.setData(json);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
            result.setSucess(false);
            result.setMessage("operacao nao efetuada");
            result.setData(json);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    
}
