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
public class EstatiscaResourceMenorFrequenciaPorFaixaDeCodigo extends ServerResource{
    
    
    
    @Get
    public JSONObject getMenorFrequenciFaixaDeCodigo(){
        
   String inicial = (String) getRequestAttributes().get("inicial");
   
   System.out.println(inicial);
        
    int codInicial = Integer.parseInt((String)getRequestAttributes().get("inicial"));
    int codFinal = Integer.parseInt((String)getRequestAttributes().get("final"));
        
    
        
        FrequencyManager frequencyManager = new FrequencyManager();
        JSONObject json = new JSONObject();
        try {
            List<Integer> numeros = frequencyManager.getMenorFrequenciaPorFaixaDeCodigo(codInicial, codFinal);
            Gson gson = new Gson();
            String lista = gson.toJson(numeros);
            
            json.put("lista", lista);
            
        } catch (JSONException ex) {
            Logger.getLogger(EstatiscaResourceMenorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstatiscaResourceMenorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstatiscaResourceMenorFrequenciaPorFaixaDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
    }
    
}
