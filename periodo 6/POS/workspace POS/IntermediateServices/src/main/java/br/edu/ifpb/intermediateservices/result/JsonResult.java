/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.result;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Luciano
 */
public class JsonResult extends JSONObject {
    
    public JsonResult(){
        setMessage("Dados não inseridos corretamente");
        setSucess(false);
    }
    
    public void setMessage(String msg){
        try {
            put("message", msg);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setSucess(boolean s){
        try {
            put("sucess", s);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setData(JSONObject json){
        try {
            put("data", json);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
