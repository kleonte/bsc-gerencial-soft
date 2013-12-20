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
public class SorteioPorFaixaDeCodigo extends ServerResource {
    
    @Get("/codigoFaixa/{id_inicial}/{id_final}")
     public JSONObject getSorteioByCodigoInterval() throws SQLException, ClassNotFoundException {

        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();


        try {
            Integer idInicial = Integer.parseInt((String) getRequestAttributes().get("id_inicial"));
            Integer idFinal = Integer.parseInt((String) getRequestAttributes().get("id_final"));

            SorteioDAO sorteioDAO = new SorteioDAO();
            List<Sorteio> sorteios = new ArrayList<Sorteio>();
            sorteios = sorteioDAO.getSorteioPorIntervaloDeCodigo(idInicial, idFinal);

            Gson gson = new Gson();
            String lista = gson.toJson(sorteios);

            json.put("lista", lista);

            result.setSucess(true);
            result.setMessage("lista recuperada com sucesso!");
            result.setData(json);
        
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
            result.setSucess(false);
            result.setMessage("nao houve sorteio durante esse periodo");
        }
        // return new JsonRepresentation(data);
        return json;
    }
    
}
