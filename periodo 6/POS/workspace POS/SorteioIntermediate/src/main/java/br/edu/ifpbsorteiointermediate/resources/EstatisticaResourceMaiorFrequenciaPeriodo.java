/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpbsorteiointermediate.resources;

import br.edu.ifpb.sorteiointermediate.estatisticas.FrequencyManager;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.text.ParseException;
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
public class EstatisticaResourceMaiorFrequenciaPeriodo extends ServerResource {
    
    @Get
    public JSONObject getMaiorFrequenciaPeriodo(){
        String dataIncial = (String) getRequestAttributes().get("dtInicial");
        String dataFinal = (String) getRequestAttributes().get("dtFinal");
        JSONObject json = new JSONObject();
        
        FrequencyManager frequencyManager = new FrequencyManager();
        try {
            
            List<Integer> numeros = frequencyManager.getMaiorFrequenciaPorPeriodo(dataIncial, dataFinal);
            Gson gson = new Gson();
            String lista = gson.toJson(numeros);
            json.put("lista", lista);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
        
    }
    
}
