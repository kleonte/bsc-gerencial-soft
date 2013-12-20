/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices.client;

import br.edu.ifpb.basicservices.entidades.Sorteio;
import java.io.IOException;
import java.sql.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Luciano
 */
public class Client {
    
    public void createCustomer() throws JSONException{
    ClientResource resource = new ClientResource(
        "http://localhost:8181/CustomerService/customer"
    );
    //objeto de entrada (I)
    JSONObject json = new JSONObject();
    json.put("nome", "Ari Garcia Test");
    json.put("cpf", "98798798797");
    json.put("end", "Algum lugar no IFPB");
    //representação de dados json
    JsonRepresentation jsonrep =new JsonRepresentation(json);
    resource.post(jsonrep);
  }
  
  public Sorteio getSorteioById() throws JSONException, IOException{
    ClientResource resource = new ClientResource(
        "http://localhost:8181/SorteioService/"
    );
    //representação de dados json
    JsonRepresentation jsonrep = new JsonRepresentation(resource.get());
    JSONObject jsonresult = jsonrep.getJsonObject();
    //recuperar cliente
    if (jsonresult.getBoolean("success")){
      JSONObject json = jsonresult.getJSONObject("json");
      Integer id= json.getInt("id");
      //String data = json.getString("data");
      Integer num1 = json.getInt("num1");
      Integer num2 = json.getInt("num2");
      Integer num3 = json.getInt("num3");
      Integer num4 = json.getInt("num4");
      Integer num5 = json.getInt("num5");
      Integer num6 = json.getInt("num6");
      
      //criar o cliente
      
      Sorteio sorteio = new Sorteio();
      sorteio.setId(id);
     // sorteio.setDataSorteio(new Date);
      sorteio.setNum1(num1);
      sorteio.setNum2(num2);
      sorteio.setNum3(num3);
      sorteio.setNum4(num4);
      sorteio.setNum5(num5);
      sorteio.setNum6(num6);
      
      
//      Person p = new Person();
//      p.setCpf(cpf);
//      p.setName(name);
//      Address a = new Address();
//      a.setValue(address);
//      Customer c = new Customer(p, a);
//      assertNotNull(c);
//      assertEquals(c.getPerson().getCpf(), "98798798797");
      return sorteio;
    }
    return null;
  }
 /* 
  public void updateCustomer(Customer c) throws JSONException, IOException{
    ClientResource resource = new ClientResource(
        "http://localhost:8181/CustomerService/customer/" + id
    );
    //
    c.getPerson().setName("Novo nome");
    //objeto de entrada (I)
    JSONObject json = new JSONObject();
    json.put("nome", c.getPerson().getName());
    json.put("cpf", c.getPerson().getCpf());
    json.put("end", c.getAddress().getValue());
    //representação de dados json
    JsonRepresentation jsonrep =new JsonRepresentation(json);
    JsonRepresentation resultrep = new JsonRepresentation(resource.put(jsonrep));
    //
    assertNotNull(resultrep);
    //
    JSONObject jsonresult = resultrep.getJsonObject();
    assertTrue(jsonresult.getBoolean("success"));
  }
  
  public void deleteCustomer() throws JSONException, IOException{
    ClientResource resource = new ClientResource(
        "http://localhost:8181/CustomerService/customer/" + id
    );
    //representação de dados json
    JsonRepresentation resultrep = new JsonRepresentation(resource.delete());
    //
    assertNotNull(resultrep);
    //
    JSONObject jsonresult = resultrep.getJsonObject();
    assertTrue(jsonresult.getBoolean("success"));
  }
  
  public void testExecute() throws JSONException, IOException{
    createCustomer();
    Customer c = getCustomer();
    updateCustomer(c);
    deleteCustomer();
  }
*/
    
}
