/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.sorteioresource;

import br.edu.ifpb.basicservices.dao.SorteioDAO;
import br.edu.ifpb.basicservices.entidades.Sorteio;
import br.edu.ifpb.intermediateservices.result.JsonResult;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class SorteioPorPeriodo extends ServerResource {
    
    @Get("/periodo/{dataInicial}/{dataFinal}")
    public JSONObject getSorteioByPeriodo() {
        JsonResult result = new JsonResult();
        Gson gson = new Gson();
        JSONObject json = new JSONObject();
//        JsonArray array = new JsonArray();
        try {

            String dtInicial = (String) getRequestAttributes().get("dataInicial");
            String dtFinal = (String) getRequestAttributes().get("dataFinal");
            //System.out.println(dtInicial);

            SorteioDAO sorteioDAO = new SorteioDAO();
            List<Sorteio> sorteios = new ArrayList<Sorteio>();

            sorteios = sorteioDAO.getSorteiosPorPeriodo(dtInicial, dtFinal);
            json.put("lista", sorteios);
            
            result.setSucess(true);
            result.setMessage("consulta recuperada com sucesso!");
            result.setData(json);
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
            result.setSucess(false);
            result.setMessage("consulta nao realizada");
            result.setData(json);

        } catch (SQLException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }

         return json;
    }
    
}
