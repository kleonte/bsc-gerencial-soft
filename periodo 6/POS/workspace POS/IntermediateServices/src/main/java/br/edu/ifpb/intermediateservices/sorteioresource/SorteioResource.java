/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.sorteioresource;

import br.edu.ifpb.basicservices.dao.EstatisticasDAO;
import br.edu.ifpb.basicservices.dao.SorteioDAO;
import br.edu.ifpb.basicservices.entidades.Sorteio;
import br.edu.ifpb.intermediateservices.result.JsonResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
 
public class SorteioResource extends ServerResource {

    //cria sorteio
    @Post
    public JsonRepresentation create(JsonRepresentation jsonrep) throws SQLException, SQLException, ClassNotFoundException {

        JsonResult result = new JsonResult();

        try {
            //recuperando o Json
            
            JSONObject json = new JSONObject();
            //int id = json.getInt("id");
//            String data = (String) getRequestAttributes().get("data");
//            Integer num1 = (Integer).parseInt((String) getRequestAttributes().get("num1"));
//            Integer num2 = (Integer) getRequestAttributes().get("num2");
//            Integer num3 = (Integer) getRequestAttributes().get("num3");
//            Integer num4 = (Integer) getRequestAttributes().get("num4");
//            Integer num5 = (Integer) getRequestAttributes().get("num5");
//            Integer num6 = (Integer) getRequestAttributes().get("num6");
               Integer num1 = json.getInt("num1");
               Integer num2 = json.getInt("num2");
               Integer num3 = json.getInt("num3");
               Integer num4 = json.getInt("num4");
               Integer num5 = json.getInt("num5");
               Integer num6 = json.getInt("num6");
                json.put("num1", num1);
                json.put("num2", num2);
                json.put("num3", num3);
                json.put("num4", num4);
                json.put("num5", num5);
                json.put("num6", num6);
                
//            Integer num1 = (Integer) getRequestAttributes().get("num1");
//            System.out.println(num1);
//            String data = json.getString("data");
              
//              num1 = json.getInt("num1");          
//              num2 = json.getInt("num2");
//              num3 = json.getInt("num3");
//              num4 = json.getInt("num4");
//              num5 = json.getInt("num5");
//              num6 = json.getInt("num6");

            //criar o objeto no bd
            Sorteio sorteio = new Sorteio();
            //sorteio.setId(id);
            sorteio.setDataSorteio(new java.util.Date());
            sorteio.setNum1(num1);
            sorteio.setNum2(num2);
            sorteio.setNum3(num3);
            sorteio.setNum4(num4);
            sorteio.setNum5(num5);
            sorteio.setNum6(num6);

            SorteioDAO sorteioDao = new SorteioDAO();
            sorteioDao.addSorteio(sorteio);

            result.setSucess(true);
            result.setMessage("cadastro realizado com sucesso!");
            //result.setData(json);


        } catch (JSONException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
            result.setSucess(false);
            result.setMessage("cadastro não realizado");
        }
        return new JsonRepresentation(result);

    }
    //recupera sorteio por codigo

  /*  @Get("/codigoId/{id}")
    public JSONObject getSorteioByCodigo() throws SQLException, ClassNotFoundException {

        JsonResult result = new JsonResult();

        //recuperando o codigo do sorteio
        // Integer id = Integer.parseInt((String)getRequestAttributes().get("id"));

        SorteioDAO sorteioDAO = new SorteioDAO();
        Sorteio sorteio = new Sorteio();
        //sorteio = sorteioDAO.getSorteioPorCodigo(id);

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
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
//                return new JsonRepresentation(data);
        }
            // return new JsonRepresentation(json);
        return json;

    }*/

    //recupera sorteios por faixa de codigo do sorteio
    //
    //@Get("/codigoFaixa/{id_inicial, id_final}")
//    public JSONObject getSorteioByCodigoInterval() throws SQLException, ClassNotFoundException {
//
//        JsonResult result = new JsonResult();
//        JSONObject json = new JSONObject();
//
//
//        try {
//            Integer idInicial = (Integer) getRequestAttributes().get("idInicial");
//            Integer idFinal = (Integer) getRequestAttributes().get("idFinal");
//
//            SorteioDAO sorteioDAO = new SorteioDAO();
//            List<Sorteio> sorteios = new ArrayList<Sorteio>();
//            sorteios = sorteioDAO.getSorteioPorIntervaloDeCodigo(idInicial, idFinal);
//
//            Gson gson = new Gson();
//            String lista = gson.toJson(sorteios);
//
//            json.put("lista", lista);
//
//            result.setSucess(true);
//            result.setMessage("lista recuperada com sucesso!");
//            result.setData(json);
//        } catch (JSONException ex) {
//            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
//            result.setSucess(false);
//            result.setMessage("nao houve sorteio durante esse periodo");
//        }
//        // return new JsonRepresentation(data);
//        return json;
//    }

//    //@Get
//    @Path("/data/{data}")
//    public JSONObject getSorteioByData() {
//
//        JsonResult result = new JsonResult();
//        JSONObject json = new JSONObject();
//        try {
//            String data = (String) getRequestAttributes().get("data");
//
//            SorteioDAO sorteioDAO = new SorteioDAO();
//            List<Sorteio> sorteios = new ArrayList<Sorteio>();
//
//            sorteios = sorteioDAO.getSorteioPorData(data);
//
//            Gson gson = new Gson();
//            String lista = gson.toJson(sorteios);
//            json.put("lista", lista);
//
//            result.setSucess(true);
//            result.setMessage("consulta efetuada com suceeso!");
//            result.setData(json);
//
//        } catch (JSONException ex) {
//            result.setSucess(false);
//            result.setMessage("consulta nao realizada!");
//            result.setData(json);
//            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //return new JsonRepresentation(json);
//        return json;
//    }

   // @Get
    @Path("/periodo/{dataInicial}/{dataFinal}")
    public JSONObject getSorteioByPeriodo() {
        JsonResult result = new JsonResult();
        Gson gson = new Gson();
        JSONObject json = new JSONObject();
//        JsonArray array = new JsonArray();
        try {

            String dtInicial = (String) getRequestAttributes().get("dataInicial");
            String dtFinal = (String) getRequestAttributes().get("dataFinal");
        System.out.println(dtInicial);

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
    
 /*   @Get
    @Path("/maiorFrequencia")
    public JSONObject getNumeroMaiorFrequencia() {

        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();

        EstatisticasDAO estatisticasDAO = new EstatisticasDAO();
        try {
            List<Integer> maiorFrequencia = estatisticasDAO.numeroMaiorFrequencia();

            Gson gson = new Gson();
            String lista = gson.toJson(maiorFrequencia);

            json.put("lista", lista);

            result.setSucess(true);
            result.setMessage("recuperou blz");
            result.setData(json);
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);

            result.setSucess(false);
            result.setMessage("falha na execução");
            result.setData(json);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        //return new JsonRepresentation(json);
        return json;
    }
    
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
*/
    public static void main(String[] args) {
        try {
            SorteioDAO sorteioDAO = new SorteioDAO();
            List<Sorteio> sorteios = new ArrayList<Sorteio>();
            EstatisticasDAO estatisticasDAO = new EstatisticasDAO();
            
            List<Integer> menorNumero = estatisticasDAO.numeroMenorFrequencia();
            
            for (Integer menor : menorNumero) {
                System.out.println(menor);
            }

//            sorteios = sorteioDAO.getSorteiosPorPeriodo("16-11-2013", "27-11-2013");
//            Gson gson = new Gson();
//            
//            
//            JSONObject j = new JSONObject();
//            j.put("lista", sorteios);
//            
//            System.out.println(j.toString());
            
     //   } catch (JSONException ex) {
      //      Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
