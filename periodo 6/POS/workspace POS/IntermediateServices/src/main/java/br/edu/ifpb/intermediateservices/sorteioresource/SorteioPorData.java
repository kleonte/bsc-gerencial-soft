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
import javax.ws.rs.Path;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class SorteioPorData extends ServerResource {
    
    @Get("/data/{data}")
    public JSONObject getSorteioByData() {

        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();
        try {
            String data = (String) getRequestAttributes().get("data");

            SorteioDAO sorteioDAO = new SorteioDAO();
            List<Sorteio> sorteios = new ArrayList<Sorteio>();

            sorteios = sorteioDAO.getSorteioPorData(data);

            Gson gson = new Gson();
            String lista = gson.toJson(sorteios);
            json.put("lista", lista);

            result.setSucess(true);
            result.setMessage("consulta efetuada com suceeso!");
            result.setData(json);

        } catch (JSONException ex) {
            result.setSucess(false);
            result.setMessage("consulta nao realizada!");
            result.setData(json);
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return new JsonRepresentation(json);
        return json;
    }
    
}
