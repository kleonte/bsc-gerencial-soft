/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpbsorteiointermediate.resources;

import br.edu.ifpb.sorteiointermediate.estatisticas.FrequencyManager;
import com.google.gson.Gson;
import java.sql.SQLException;
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
public class EstatiscaResourceMaiorFrequenciaPorFaixaDeCodigo extends ServerResource {
    
    @Get
    public JSONObject getMaiorFrequenciaPorFaixaDeCodigo(){
        int codInicial = Integer.parseInt((String)getRequestAttributes().get("codInicial"));
        int codFinal = Integer.parseInt((String)getRequestAttributes().get("codFinal"));
        
        FrequencyManager frequencyManager = new FrequencyManager();
        JSONObject json = new JSONObject();
        try {
            
            List<Integer> numeros = frequencyManager.getMaiorFrequenciaPorFaixaDeCodigo(codInicial, codFinal);
            Gson gson = new Gson();
            String lista = gson.toJson(numeros);
            json.put("lista", lista);
            
        } catch (JSONException ex) {
            Logger.getLogger(EstatiscaResourceMaiorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstatiscaResourceMaiorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstatiscaResourceMaiorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
        
    }
    
}
