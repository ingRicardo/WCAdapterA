/**
 * 
 */
package wcadapter.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import wcadapter.clases.Wc_data;
import wcadapter.clases.WooCommerceObj;
import wcadapter.service.JsonService;

/**
 * @author TIJUANA
 *
 */
@Controller
public class Wc_get_list_Controller {
	
	@Autowired
	private JsonService jsonservice;
		


	  @GetMapping("/wcadapter/wc/v1/wc-json-list")
	  public String getList(Model model) {
		  model.addAttribute("name", "RAMO");
		//  System.out.println("size --> "+ jsonservice.getAlldata().size());
		  System.out.println(jsonservice.getAlldata());
		
		  Iterator<Wc_data> iter = jsonservice.getAlldata().iterator();		  
		  List<Wc_data> wclist = new ArrayList<Wc_data>();
		  while(iter.hasNext()) {
			  Wc_data wcomer = (Wc_data) iter.next();
			 // System.out.println(wcomer.getJson()); 
			  wclist.add(wcomer);
		  }
		  System.out.println(wclist.size() +" "+ wclist.get(0).getId()); 
		  model.addAttribute("wclist",wclist);
		  return "wclist";
	  }
	  @RequestMapping(value = "/submitStatus", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseBody
	  public String InsertSURStatus(@RequestBody Map mapparams) throws SQLException {
		  System.out.println("-------------- submitStatus ----------");
		  
		  System.out.println("params: "+ mapparams); 
		   String id= (String) mapparams.get("Key");
		   String WorkOrder =  (String) mapparams.get("WorkOrder");
		   //WorkOrder 
		   System.out.println("WorkOrder -> "+ WorkOrder);
		   //Status 
		   String Status =  (String) mapparams.get("Status");
		   System.out.println("Status - > "+ Status);
		   System.out.println(" key -> "+ id);
		   String json= jsonservice.getJsonOT(Integer.parseInt(id));
		   System.out.println("json -> " + json);
		   System.out.println(" json.length() -> " + json.length());
		   if (json.length() > 0 ) {
			   System.out.println(" json INSERTED -> ");
		//	   jsonservice.insertJsonObj(WorkOrder, id, json, Status);
		   }else {
			   System.out.println(" json NOT INSERTED -> ");
		   }
			   
		   System.out.println("--------------End submitStatus ----------"); 
		  return json.toString();
	  }
	  
	  @RequestMapping(value = "/submitid", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody
	  String Submitid(@RequestParam("idval") String idval, Model model) throws SQLException, IOException {
		  String res="";
		  System.out.println("idval "+ idval);
		  res = idval;
		  int id = 0;
		  Gson g = new Gson();
		  WooCommerceObj p = null;
		  Wc_data wcdataobj = null;
		  String json="";
		  JSONObject jsonObj=null;
		 if (!"".equals(res)) {
			  id = Integer.parseInt(res);		  
			   json = jsonservice.getJson(id);
			   try {
				jsonObj= new JSONObject(json);
				
				
				
				System.out.println(" jsonObj ------> "+ jsonObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("json val ->>" + wcdataobj.getJson().toString()); 
	
			/* if (wcdataobj.getJson() instanceof String) {
				 System.out.println("it's string");
				 			
				  p = g.fromJson(wcdataobj.getJson(), WooCommerceObj.class);
				 System.out.println("customer id -->>> "+p.getCustomer_id());
				 			 
			 }*/
			   
			//   System.out.println("GETTING STRING JSON ->> "+json);
		}
		 // return jsonObj;
		  return json.toString();
	  }
	  

	
	  
	  
	  @RequestMapping(value = "/submitidpro", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody
	  void Submitidpro(@RequestParam("idval") String idval) throws IOException { 
		  System.out.println("New method ID-> "+idval);
		 Date date = new Date();
		  System.out.println("time ->> "+date.getTime());
		  OkHttpClient client = new OkHttpClient(); 
		  
		  Request request = new Request.Builder()
				  .url("http://10.168.5.116/mysite/wp-json/wc/v1/products/"+idval)
				  .get()
				  .addHeader("Authorization", "OAuth oauth_consumer_key=\"cXaQrdEWrGT8\",oauth_token=\"6Oy8rcaP55UlqOIYcp8aSD8M\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\""+date.getTime()+"\",oauth_nonce=\"et7SQgSUguq\",oauth_version=\"1.0\",oauth_signature=\"EXI7rPvLo5XJvJQ%2Fh9YFyimybUY%3D\"")
				  .addHeader("cache-control", "no-cache")
				  .addHeader("Postman-Token", "5ec16e99-9802-49d0-b788-606a18632fc6")
				  .build();

				Response response = client.newCall(request).execute(); 
				System.out.println("response ->> "+ response);
				response.body().close();
				
				///////////////////////////
				
			//	 OAuthConfig config = new OAuthConfig("http://localhost:8080/greeting", "ck_37397d65f6d6899372a2351ec5a25942159ccc34", "cs_09cb3c9e604f834e18adeeb88eb76985302d6329");
			 //       WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V2);
			        /*
			        // Prepare object for request
			        Map<String, Object> productInfo = new HashMap<>();
			        productInfo.put("name", "Premium Quality");
			        productInfo.put("type", "simple");
			        productInfo.put("regular_price", "21.99");
			        productInfo.put("description", "Pellentesque habitant morbi tristique senectus et netus");

			        // Make request and retrieve result
			        Map product = wooCommerce.create(EndpointBaseType.PRODUCTS.getValue(), productInfo);

			        System.out.println(product.get("id"));

			        // Get all with request parameters
			        Map<String, String> params = new HashMap<>();
			        params.put("per_page","100");
			        params.put("offset","0");
			        List products = wooCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
*/
		//	        Map wooCommerceRes = wooCommerce.get("http://localhost:8080/greeting", 0);
			         
		//	        System.out.println("wooCommerceRes.toString() --->>>"+ wooCommerceRes.toString());
			        
			        
			   //     System.out.println(products.size());
				
		  
	  }
	  

}
