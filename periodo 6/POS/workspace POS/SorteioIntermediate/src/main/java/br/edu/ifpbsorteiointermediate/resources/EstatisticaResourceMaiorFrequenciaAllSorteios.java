/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpbsorteiointermediate.resources;

import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import br.edu.ifpb.sorteiointermediate.estatisticas.FrequencyManager;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */

public class EstatisticaResourceMaiorFrequenciaAllSorteios extends ServerResource {

    @Get
    //@Path("/all/maior")
    @Produces("text/xml")
    public Estatistica getMaiorFrequenciaAllSorteios() {
        //JSONObject json = new JSONObject();
        FrequencyManager frequencyManager = new FrequencyManager();

        Estatistica estatitisca = new Estatistica();
        try {
            List<Integer> resultado = frequencyManager.getMaiorFrequenciaAllSorteios();

            estatitisca.setNumero(resultado.get(0));
            estatitisca.setQtdeOcorrencias(resultado.get(1));
            estatitisca.setTipoConsulta("maior frequencia todos os sorteios");

//            Gson gson = new Gson();
//            String lista = gson.toJson(resultado);

            // json.put("lista", lista);

//        } catch (JSONException ex) {
//            Logger.getLogger(EstatisticaResourceMaiorFrequenciaAllSorteios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaAllSorteios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstatisticaResourceMaiorFrequenciaAllSorteios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estatitisca;
        //return json;
    }
}
