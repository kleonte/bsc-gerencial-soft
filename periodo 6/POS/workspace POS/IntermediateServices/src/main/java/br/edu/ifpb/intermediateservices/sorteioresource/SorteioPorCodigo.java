/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.sorteioresource;

import br.edu.ifpb.basicservices.dao.SorteioDAO;
import br.edu.ifpb.basicservices.entidades.Sorteio;
import br.edu.ifpb.intermediateservices.result.JsonResult;
import java.sql.SQLException;
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
public class SorteioPorCodigo extends ServerResource {
    
    @Get("/codigoId/{id}")
    public JSONObject getSorteioByCodigo() throws SQLException, ClassNotFoundException {

        JsonResult result = new JsonResult();

        //recuperando o codigo do sorteio
         Integer id = Integer.parseInt((String)getRequestAttributes().get("id"));

        SorteioDAO sorteioDAO = new SorteioDAO();
        Sorteio sorteio = new Sorteio();
        sorteio = sorteioDAO.getSorteioPorCodigo(id);

        JSONObject json = new JSONObject();
        try {
            if (sorteio != null) {

                json.put("id", sorteio.getId());
                json.put("data", sorteio.getDataSorteio());
                json.put("num1", sorteio.getNum1());
                json.put("num2", sorteio.getNum2());
                json.put("num3", sorteio.getNum3());
                json.put("num4", sorteio.getNum4());
                json.put("num5", sorteio.getNum5());
                json.put("num6", sorteio.getNum6());

                //mensagem caso retorno tenha sido efetuado com sucesso

                result.setSucess(true);
                result.setMessage("operacao realizada com sucesso");
                result.setData(json);
            } else {
                //retorno caso tem ocorrido falha
                result.setSucess(false);
                result.setMessage("operação não realizada!");
                result.setData(json);

            }

        } catch (JSONException ex) {
            Logger.getLogger(SorteioPorCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //     return new JsonRepresentation(result);
        return json;

    }
    
}
