/**
 * 
 */
package wcadapter.clases;


import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import wcadapter.service.JsonService;

/**
 * @author TIJUANA
 *
 */
public class JsonParser {

	/**
	 * 
	 */
	@Autowired
	private static JsonService jsonservice;
	private static String status;
	
	public static String GetJsonParser( String data) throws NumberFormatException, JSONException, SQLException {
		// TODO Auto-generated constructor stub

		 			
		
		
		JSONObject jsonObj = new JSONObject( data);									
		WooCommerceObj wooComOBJ =  new WooCommerceObj();
		boolean error = false; 									
		if  (jsonObj.has("id")) {
					//	System.out.println(" jsonObj ID ->>> "+jsonObj.get("id"));
						wooComOBJ.setId( Integer.parseInt( jsonObj.get("id").toString()));			
					//	System.out.println("ID FROM JAVA OBJECT ->> "+ wooComOBJ.getId());
						
					//	System.out.println("data data -> "+ data);
						
						if (wooComOBJ.getId() > 0 ) {
							System.out.println("DECODE -BEFORE INSERT-->> "+ URLDecoder.decode(data)); 
							status = "Order received";
							System.out.println("status ->> "+ status);
							// Insert JSON in to DATABASE	
								jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()) , URLDecoder.decode(data), status);
															
						
							
							if (jsonObj.has("parent_id")) {
							//	System.out.println(" jsonObj parent_id ->>> "+jsonObj.get("parent_id"));			
								wooComOBJ.setParent_id( Integer.parseInt( jsonObj.get("parent_id").toString()));
							}
							
							if (jsonObj.has("status")) {
								//System.out.println(" jsonObj status ->>> "+jsonObj.get("status"));			
								wooComOBJ.setStatus(jsonObj.get("status").toString());
							}
							
							if (jsonObj.has("currency")) {
								//System.out.println(" jsonObj currency ->>> "+jsonObj.get("currency"));
								wooComOBJ.setCurrency(jsonObj.get("currency").toString());
							}
							
							if (jsonObj.has("version")) {
								//System.out.println(" jsonObj version ->>> "+jsonObj.get("version"));
								wooComOBJ.setVersion(jsonObj.get("version").toString());	
							}
							
							if (jsonObj.has("prices_include_tax")) {
								//System.out.println(" jsonObj prices_include_tax ->>> "+jsonObj.get("prices_include_tax"));
								wooComOBJ.setPrices_include_tax( Boolean.valueOf(jsonObj.get("prices_include_tax").toString()) );	
							}
							
							
							if (jsonObj.has("date_created")) {
								
							//	System.out.println(" jsonObj date_created ->>> "+jsonObj.get("date_created"));
								
								
								if (jsonObj.get("date_created") instanceof String) {
									//System.out.println("date_created ->> " + jsonObj.get("date_created"));
									wooComOBJ.setDates_created(jsonObj.get("date_created").toString());
								}else {
										Date_created datecr = new Date_created();
									
										if ( jsonObj.getJSONObject("date_created").has("date")) {
										//	System.out.println(" jsonObj date_created date ->>>" + jsonObj.getJSONObject("date_created").get("date"));
											datecr.setDate(jsonObj.getJSONObject("date_created").get("date").toString());
										}
										
										if (jsonObj.getJSONObject("date_created").has("timezone")) {
										//	System.out.println(" jsonObj date_created timezone ->>>" + jsonObj.getJSONObject("date_created").get("timezone")); 
											datecr.setTimezone(jsonObj.getJSONObject("date_created").get("timezone").toString());
										}
										
										if (jsonObj.getJSONObject("date_created").has("timezone_type")) {
										//	System.out.println(" jsonObj date_created timezone_type ->>>" + jsonObj.getJSONObject("date_created").get("timezone_type"));
											datecr.setTimezone_type(Integer.parseInt( jsonObj.getJSONObject("date_created").get("timezone_type").toString()));			
										}
																											
										wooComOBJ.setDate_created(datecr);
									}
							}
							
																							
							if (jsonObj.has("date_modified")) {
									
								if (jsonObj.get("date_modified") instanceof String) {
									wooComOBJ.setDates_modified(jsonObj.get("date_modified").toString());
								}else {
								//date_modified									
									//System.out.println(" jsonObj date_modified ->>> "+jsonObj.get("date_modified"));
																		 																		
									Date_modified datemod =  new Date_modified();
									
									if (jsonObj.getJSONObject("date_modified").has("date")) {
										//System.out.println(" jsonObj date_modified date ->>>" + jsonObj.getJSONObject("date_modified").get("date"));
										datemod.setDate(jsonObj.getJSONObject("date_modified").get("date").toString());
									}
									
									if (jsonObj.getJSONObject("date_modified").has("timezone")) {
										//System.out.println(" jsonObj date_modified timezone ->>>" + jsonObj.getJSONObject("date_modified").get("timezone"));
										datemod.setTimezone(jsonObj.getJSONObject("date_modified").get("timezone").toString());
									}
									
									if (jsonObj.getJSONObject("date_modified").has("timezone_type")) {										
										//System.out.println(" jsonObj date_modified timezone_type ->>>" + jsonObj.getJSONObject("date_modified").get("timezone_type"));
										datemod.setTimezone_type(Integer.parseInt(jsonObj.getJSONObject("date_modified").get("timezone_type").toString()));
									
									}
																											
									wooComOBJ.setDate_modified(datemod);
								}																											
							}
							
							
							if (jsonObj.has("discount_total")) {
								//System.out.println(" jsonObj discount_total ->>> "+jsonObj.get("discount_total"));
								wooComOBJ.setDiscount_total(jsonObj.get("discount_total").toString());
							}
							
							if (jsonObj.has("discount_tax")) {
								//System.out.println(" jsonObj discount_tax ->>> "+jsonObj.get("discount_tax"));
								wooComOBJ.setDiscount_tax(jsonObj.get("discount_tax").toString());
							}
							
							
							if (jsonObj.has("shipping_total")) {
								//System.out.println(" jsonObj shipping_total ->>> "+jsonObj.get("shipping_total"));
								wooComOBJ.setShipping_total(jsonObj.get("shipping_total").toString());
							}
							
							if (jsonObj.has("shipping_tax")) {
								//System.out.println(" jsonObj shipping_tax ->>> "+jsonObj.get("shipping_tax"));
								wooComOBJ.setShipping_tax(jsonObj.get("shipping_tax").toString());	
							}
					
							
							if (jsonObj.has("cart_tax")) {
							//	System.out.println(" jsonObj cart_tax ->>> "+jsonObj.get("cart_tax"));
								wooComOBJ.setCart_tax( jsonObj.get("cart_tax").toString());
							}
							
							
							if (jsonObj.has("total")) {
								//System.out.println(" jsonObj total ->>> "+jsonObj.get("total"));
								wooComOBJ.setTotal(jsonObj.get("total").toString());	
							}
							
															
							if (jsonObj.has("total_tax")) {
							//	System.out.println(" jsonObj total_tax ->>> "+jsonObj.get("total_tax"));						
								wooComOBJ.setTotal_tax(jsonObj.get("total_tax").toString() );	
							}
							
							
							if (jsonObj.has("customer_id")) {
								//System.out.println(" jsonObj customer_id ->>> "+jsonObj.get("customer_id"));					
								wooComOBJ.setCustomer_id(Integer.parseInt( jsonObj.get("customer_id").toString() ));									
							}
							
							
							if (jsonObj.has("order_key")) {
								System.out.println(" jsonObj order_key ->>> "+jsonObj.get("order_key"));
								wooComOBJ.setOrder_key( jsonObj.get("order_key").toString());
							}
							
							
							if (jsonObj.has("billing")) {
								//System.out.println(" jsonObj billing ->>> "+jsonObj.get("billing"));						
								Billing billingObj = new Billing();
								
								
								
								if (jsonObj.getJSONObject("billing").has("first_name")) {
									//System.out.println(" jsonObj billing first_name ->>> "+jsonObj.getJSONObject("billing").get("first_name"));
									billingObj.setFirst_name(jsonObj.getJSONObject("billing").get("first_name").toString());
								}
								
								
								if (jsonObj.getJSONObject("billing").has("last_name")) {
									//System.out.println(" jsonObj billing last_name ->>> "+jsonObj.getJSONObject("billing").get("last_name"));
									billingObj.setLast_name(jsonObj.getJSONObject("billing").get("last_name").toString() );
								}
								
								
								if (jsonObj.getJSONObject("billing").has("company")) {
									//System.out.println(" jsonObj billing company ->>> "+jsonObj.getJSONObject("billing").get("company"));
									billingObj.setCompany( jsonObj.getJSONObject("billing").get("company").toString() );
								}
								
					
								
								if (jsonObj.getJSONObject("billing").has("address_1")) {
								
									//System.out.println(" jsonObj billing address_1 ->>> "+jsonObj.getJSONObject("billing").get("address_1"));
									billingObj.setAddress_1(jsonObj.getJSONObject("billing").get("address_1").toString() );
								}
								
								
								if (jsonObj.getJSONObject("billing").has("address_2")) {
								
									//System.out.println(" jsonObj billing address_2 ->>> "+jsonObj.getJSONObject("billing").get("address_2"));
									billingObj.setAddress_2(jsonObj.getJSONObject("billing").get("address_2").toString() );			
								}
								
								
								if (jsonObj.getJSONObject("billing").has("city")) {
									//System.out.println(" jsonObj billing city ->>> "+jsonObj.getJSONObject("billing").get("city"));
									billingObj.setCity( jsonObj.getJSONObject("billing").get("city").toString());
								}
								
								
								if (jsonObj.getJSONObject("billing").has("state")) {
									//System.out.println(" jsonObj billing state ->>> "+jsonObj.getJSONObject("billing").get("state"));
									billingObj.setState( jsonObj.getJSONObject("billing").get("state").toString());
								}
								
								
								if (jsonObj.getJSONObject("billing").has("postcode")) {
								
									//System.out.println(" jsonObj billing postcode ->>> "+jsonObj.getJSONObject("billing").get("postcode"));						
									billingObj.setPostcode( jsonObj.getJSONObject("billing").get("postcode").toString());
								}
								
								if (jsonObj.getJSONObject("billing").has("country")) {
									//System.out.println(" jsonObj billing country ->>> "+jsonObj.getJSONObject("billing").get("country"));						
									billingObj.setCountry( jsonObj.getJSONObject("billing").get("country").toString());
								}
								
								
								if (jsonObj.getJSONObject("billing").has("email")) {
									//System.out.println(" jsonObj billing email ->>> "+jsonObj.getJSONObject("billing").get("email"));						
									billingObj.setEmail(jsonObj.getJSONObject("billing").get("email").toString() );
									
								}
								
								if (jsonObj.getJSONObject("billing").has("phone")) {
									//System.out.println(" jsonObj billing phone ->>> "+jsonObj.getJSONObject("billing").get("phone"));						
									billingObj.setPhone(jsonObj.getJSONObject("billing").get("phone").toString() );
								}
								
								
								
								wooComOBJ.setBilling(billingObj);
								
								
							}// billing
							
															
							if (jsonObj.has("shipping")) {
								
								//System.out.println(" jsonObj shipping ->>> "+jsonObj.get("shipping"));						
								Shipping shippingObj = new Shipping();									
								
								if (jsonObj.getJSONObject("shipping").has("first_name")) {										
									//System.out.println(" jsonObj shipping first_name ->>> "+jsonObj.getJSONObject("shipping").get("first_name"));
									shippingObj.setFirst_name(jsonObj.getJSONObject("shipping").get("first_name").toString());					
								}
								
								if (jsonObj.getJSONObject("shipping").has("last_name")) {
									//System.out.println(" jsonObj shipping last_name ->>> "+jsonObj.getJSONObject("shipping").get("last_name"));						
									shippingObj.setLast_name(jsonObj.getJSONObject("shipping").get("last_name").toString());							
								}
								
								if (jsonObj.getJSONObject("shipping").has("company")) {
									//System.out.println(" jsonObj shipping company ->>> "+jsonObj.getJSONObject("shipping").get("company"));						
									shippingObj.setCompany( jsonObj.getJSONObject("shipping").get("company").toString());					
								}
								if (jsonObj.getJSONObject("shipping").has("address_1")) {
									//System.out.println(" jsonObj shipping address_1 ->>> "+jsonObj.getJSONObject("shipping").get("address_1"));						
									shippingObj.setAddress_1( jsonObj.getJSONObject("shipping").get("address_1").toString());
								}
								
								if (jsonObj.getJSONObject("shipping").has("address_2")) {
									//System.out.println(" jsonObj shipping address_2 ->>> "+jsonObj.getJSONObject("shipping").get("address_2"));						
									shippingObj.setAddress_2(jsonObj.getJSONObject("shipping").get("address_2").toString());					
								}
								
								if (jsonObj.getJSONObject("shipping").has("city")) {
									//System.out.println(" jsonObj shipping city ->>> "+jsonObj.getJSONObject("shipping").get("city"));						
									shippingObj.setCity( jsonObj.getJSONObject("shipping").get("city").toString() );				
								}
								
								if (jsonObj.getJSONObject("shipping").has("state")) {
									//System.out.println(" jsonObj shipping state ->>> "+jsonObj.getJSONObject("shipping").get("state"));						
									shippingObj.setState( jsonObj.getJSONObject("shipping").get("state").toString());		
								}
								if (jsonObj.getJSONObject("shipping").has("postcode")) {
									//System.out.println(" jsonObj shipping postcode ->>> "+jsonObj.getJSONObject("shipping").get("postcode"));						
									shippingObj.setPostcode( jsonObj.getJSONObject("shipping").get("postcode").toString());					
								}
								if (jsonObj.getJSONObject("shipping").has("country")) {
									//System.out.println(" jsonObj shipping country ->>> "+jsonObj.getJSONObject("shipping").get("country"));
									shippingObj.setCountry( jsonObj.getJSONObject("shipping").get("country").toString());					
								}
								
								wooComOBJ.setShipping(shippingObj);
								
							}//shipping
																							
							if (jsonObj.has("payment_method")) {
								//System.out.println(" jsonObj payment_method ->>> "+jsonObj.get("payment_method"));
								wooComOBJ.setPayment_method(jsonObj.get("payment_method").toString());	
								
							}
							if (jsonObj.has("payment_method_title")) {
								//System.out.println(" jsonObj payment_method_title ->>> "+jsonObj.get("payment_method_title"));
								wooComOBJ.setPayment_method_title(jsonObj.get("payment_method_title").toString());
							}
								
							if (jsonObj.has("transaction_id")) {
								//System.out.println(" jsonObj transaction_id ->>> "+jsonObj.get("transaction_id"));
								wooComOBJ.setTransaction_id( jsonObj.get("transaction_id").toString());	
							}
							if (jsonObj.has("customer_ip_address")) {
								//System.out.println(" jsonObj customer_ip_address ->>> "+jsonObj.get("customer_ip_address"));
								wooComOBJ.setCustomer_ip_address(jsonObj.get("customer_ip_address").toString());
							}
							if (jsonObj.has("customer_user_agent")) {
								//System.out.println(" jsonObj customer_user_agent ->>> "+jsonObj.get("customer_user_agent"));
								wooComOBJ.setCustomer_user_agent( jsonObj.get("customer_user_agent").toString());	
							}
							if (jsonObj.has("created_via")) {
								//System.out.println(" jsonObj created_via ->>> "+jsonObj.get("created_via"));
								wooComOBJ.setCreated_via(jsonObj.get("created_via").toString() );
							}
							if (jsonObj.has("customer_note")) {
								//System.out.println(" jsonObj customer_note ->>> "+jsonObj.get("customer_note"));
								wooComOBJ.setCustomer_note( jsonObj.get("customer_note").toString());				
							}
							if (jsonObj.has("date_completed")) {
								//System.out.println(" jsonObj date_completed ->>> "+jsonObj.get("date_completed"));						
								wooComOBJ.setDate_completed(jsonObj.get("date_completed").toString() );					
							}
							if (jsonObj.has("date_paid")) {
								//System.out.println(" jsonObj date_paid ->>> "+jsonObj.get("date_paid"));						
								wooComOBJ.setDate_paid( jsonObj.get("date_paid").toString());				
							}
							if (jsonObj.has("cart_hash")) {
								//System.out.println(" jsonObj cart_hash ->>> "+jsonObj.get("cart_hash"));
								wooComOBJ.setCart_hash( jsonObj.get("cart_hash").toString());				
							}
							if (jsonObj.has("number")) {
								//System.out.println(" jsonObj number ->>> "+jsonObj.get("number"));
								wooComOBJ.setNumber(jsonObj.get("number").toString());					
							}
							if (jsonObj.has("meta_data")) {
								//System.out.println(" jsonObj meta_data ->>> "+jsonObj.get("meta_data"));											
								JSONArray jsonArray = new JSONArray(jsonObj.get("meta_data").toString());
								//System.out.println(" JSONArray meta_data size ->> " + jsonArray.length());
								if (jsonArray.length() >= 0) {
									 Meta_data metadata = new Meta_data();
									 wooComOBJ.setMetadata(metadata);
								 }
								
							}// meta data
								
							if (jsonObj.has("line_items")) {
								//System.out.println("jsonObj line_items ->>> "+ jsonObj.get("line_items") );									 
								 //System.out.println("jsonObj line_items 24->>> "+ jsonObj.getJSONObject("line_items").get("24") );									
								Line_items litems =null;
								if (jsonObj.get("line_items") instanceof String) {
									 litems = new Line_items();
									if (jsonObj.getJSONObject("line_items").has("24")) {
										litems.setId(Integer.parseInt( jsonObj.getJSONObject("line_items").get("24").toString()));
									}																		
								 //tax_lines
								 wooComOBJ.setLine_item(litems);
								 
								}else if (jsonObj.get("line_items") instanceof JSONObject) {
									
									System.out.println(" line_items ---> length ->> " + jsonObj.getJSONObject("line_items").length());
									
										if ( jsonObj.getJSONObject("line_items").length() > 0) {
											
											for (int i =0; i < jsonObj.getJSONObject("line_items").length(); i++ ) {
												 litems = new Line_items();
												 if (jsonObj.getJSONObject("line_items").has("id")) {
													 litems.setId(Integer.parseInt(jsonObj.getJSONObject("line_items").get("id").toString()));
												 }else {
													 System.out.println("LINE ITEMS : NO ID FOUND");
													
													 error = true;
												 }
												 
											}
											
											if (jsonObj.getJSONObject("line_items").has("24")) {
											//	litems.setId(Integer.parseInt( jsonObj.getJSONObject("line_items").get("24").toString()));
												
											}	
										}
																											
									 //tax_lines
									 wooComOBJ.setLine_item(litems);
								
								} else {
									
								//	System.out.println("jsonObj line_items ->>> "+ jsonObj.get("line_items") );		
									
								//	litems.setId( Integer.parseInt(jsonObj.getJSONObject("line_items").toString()));
									JSONArray line_items = new JSONArray(jsonObj.get("line_items").toString());
									Tax tax = null;
									List<Tax> ltaxes = null; 
									JSONArray taxes = null;
									JSONObject items = null;
									List<Line_items> lisitems = null;
									if (line_items.length() > 0) {
										lisitems = new ArrayList<Line_items>();
										for (int i =0; i< line_items.length(); i++) {
											litems = new Line_items();
											//[{"quantity":1,"tax_class":"","taxes":[],"total_tax":"0.00","total":"10.00","variation_id":0,"price":"10.00","subtotal":"10.00","meta":[],"product_id":173,"name":"SAMPLE","id":22,"sku":"","subtotal_tax":"0.00"}]
											items = line_items.getJSONObject(i);
											int quantity = Integer.parseInt( items.optString("quantity").toString());
											litems.setQuantity(quantity);
											String tax_class = items.optString("tax_class").toString();
											litems.setTax_class(tax_class);
											
											if (jsonObj.has("taxes")) {
												taxes = new JSONArray(jsonObj.get("taxes").toString());
												if (taxes.length() > 0) {
													for ( i =0; i< taxes.length(); i++) {
														tax = new Tax();
														ltaxes = new ArrayList<Tax>();
														ltaxes.add(tax);
														System.out.println("taxes " +ltaxes);													
													}
													litems.setTaxes(ltaxes);
												}
											}else {
												ltaxes = new ArrayList<Tax>();
												litems.setTaxes(ltaxes);
											}
											
											
											//"total_tax":"0.00"
											String total_tax = items.optString("total_tax").toString();
											litems.setTotal_tax(total_tax);
											//"total":"10.00"
											String total = items.optString("total").toString();
											litems.setTotal(total);											
											//"variation_id":0
											int variation_id = Integer.parseInt(items.optString("variation_id").toString());
											litems.setVariation_id(variation_id);
											//"price":"10.00"
											String price = items.optString("price").toString();
											litems.setPrice(price);
											//"subtotal":"10.00"
											String subtotal = items.optString("subtotal").toString();
											litems.setSubtotal(subtotal);
											//"meta":[]
											List<Meta> lmetas = null;
											Meta metas = null;
											if (jsonObj.has("meta")) {
												JSONArray meta = new JSONArray(jsonObj.get("meta").toString());
																								
												if (meta.length() > 0) {
													lmetas = new ArrayList<Meta>();
													for ( i =0; i< meta.length(); i++) {
														metas = new Meta();
														lmetas.add(metas);
													}
												}										
											}else {
												metas = new Meta();
												lmetas = new ArrayList<Meta>();
												lmetas.add(metas);
											}
											litems.setMeta(lmetas);
											//"product_id":173
											int product_id = Integer.parseInt( items.optString("product_id").toString());
											litems.setProduct_id(product_id);
											
											//"name":"SAMPLE"
											String name = items.optString("name").toString();
											litems.setName(name);
											
											//"id":22											
											int id = Integer.parseInt(items.optString("id").toString());
											litems.setId(id);

											//"sku":""
											String sku = items.optString("sku").toString();
											litems.setSku(sku);
											//"subtotal_tax":"0.00"
											String subtotal_tax = items.optString("subtotal_tax").toString();
											litems.setSubtotal_tax(subtotal_tax);
											
											
											lisitems.add(litems);
										}
										
									}
									
									wooComOBJ.setLine_items(lisitems); 	
								}

																
							}// line items
							

							if (jsonObj.has("tax_lines")) {
								//System.out.println(" jsonObj tax_lines ->>> "+jsonObj.get("tax_lines"));
								JSONArray jsontax_linesArray = new JSONArray(jsonObj.get("tax_lines").toString());
								 //System.out.println(" JSONArray tax_lines size ->> " + jsontax_linesArray.length());
								Tax_lines txlines = null;
								 if (jsontax_linesArray.length() >= 0) {
									  txlines = new Tax_lines();										 
								 }
								 wooComOBJ.setTax_line(txlines);
							}//tax lines
							
							Shipping_lines shiplines = null;
							List<Shipping_lines> lshiplines = null;
							if (jsonObj.has("shipping_lines")) {
								//System.out.println("jsonObj shipping_lines ->>> "+ jsonObj.get("shipping_lines") );
								if (jsonObj.get("shipping_lines") instanceof String) {
									if (jsonObj.getJSONObject("shipping_lines").has("25")) {
										//System.out.println("jsonObj shipping_lines 25->>> "+ jsonObj.getJSONObject("shipping_lines").get("25") );										 
										 shiplines = new Shipping_lines(Integer.parseInt(jsonObj.getJSONObject("shipping_lines").get("25").toString()));										 
									}
									wooComOBJ.setShipping_line(shiplines);							
								}else if(jsonObj.get("shipping_lines") instanceof JSONObject) {
								
									
									Shipping_lines slines = null;
									
									if ( jsonObj.getJSONObject("shipping_lines").length() > 0) {
											
										for (int i =0; i < jsonObj.getJSONObject("shipping_lines").length(); i++ ) {
											slines = new Shipping_lines();
											 if (jsonObj.getJSONObject("shipping_lines").has("id")) {
												 slines.setId(Integer.parseInt(jsonObj.getJSONObject("shipping_lines").get("id").toString()));
											 }else {
												 System.out.println("shipping_lines : NO ID FOUND");
												 error = true;
											 }
											 
										}
										
										wooComOBJ.setShipping_line(slines);
									}
									
									
								
								
								}else {
									JSONArray shiplinesArray = new JSONArray(jsonObj.get("shipping_lines").toString());
									if (shiplinesArray.length() > 0) {
										lshiplines = new ArrayList<Shipping_lines>();
										for (int i =0 ; i < shiplinesArray.length(); i++) {
											shiplines = new Shipping_lines();
											lshiplines.add(shiplines);
										}
										wooComOBJ.setShipping_lines( lshiplines);
									}
									
									
								}
							}else {
								shiplines = new Shipping_lines();
								wooComOBJ.setShipping_line(shiplines);
							}
							
							
							 Fee_lines feelins = null;
							 List<Fee_lines> lfeeline = null;
							 if (jsonObj.has("fee_lines")) {
								// fee_lines
								 //System.out.println("jsonObj fee_lines ->>> "+ jsonObj.get("fee_lines") );
								 JSONArray jsonfee_linesArray = new JSONArray(jsonObj.get("fee_lines").toString());
								// System.out.println(" JSONArray fee_lines size ->> " + jsonfee_linesArray.length());
								
								 if (jsonfee_linesArray.length() > 0 ) {
									 lfeeline = new ArrayList<Fee_lines>();
									 for (int i=0; i < jsonfee_linesArray.length(); i++ ) {
										 feelins = new Fee_lines();
										 lfeeline.add(feelins);
									 }
								
									 wooComOBJ.setFee_lines(lfeeline);
									 
									 
								 }
								 
							 }else {
								 lfeeline = new ArrayList<Fee_lines>();
								 feelins = new Fee_lines();
								 wooComOBJ.setFee_line(feelins);
							 }
							 		 
															 								 
							//coupon_lines
							 Coupon_lines co_lines = null;
							 List<Coupon_lines> lcolines = null;
							 if (jsonObj.has("coupon_lines")) {
								 //System.out.println("jsonObj coupon_lines ->>> "+ jsonObj.get("coupon_lines") );
								 JSONArray jsoncoupon_linesArray = new JSONArray(jsonObj.get("coupon_lines").toString());
								 //System.out.println(" JSONArray coupon_lines size ->> " + jsoncoupon_linesArray.length());
								 
								 if (jsoncoupon_linesArray.length() > 0) {
									 lcolines = new ArrayList<Coupon_lines>();
									 for (int i=0; i< jsoncoupon_linesArray.length(); i++) {
										 co_lines = new Coupon_lines();
										 lcolines.add(co_lines);
									 }
									 
									 wooComOBJ.setCoupon_lines(lcolines);
										
									 }
									
							 }else {
								 //co_lines = new Coupon_lines();
								 lcolines = new ArrayList<Coupon_lines>();
								 wooComOBJ.setCoupon_lines(lcolines);
							 }
							 
							//refunds
							 Refunds refund = null;
							 List<Refunds> lrefund = null;
							 if (jsonObj.has("refunds")) {
								 JSONArray jrefund = new JSONArray(jsonObj.get("refunds").toString());
								 if (jrefund.length() > 0) {
									 lrefund = new ArrayList<Refunds>();
									 for (int i=0; i < jrefund.length(); i++) {
										 refund = new Refunds();
										 lrefund.add(refund);
									 }
									 wooComOBJ.setRefunds(lrefund);
								 }
							 }else {
								 lrefund = new ArrayList<Refunds>();
								 wooComOBJ.setRefunds(lrefund);
							 }
							 
							 //_links
							 Links _links = null;
							 Self self = null;
							 List<Self> lself = null;
							 
							 Collection colle = null;
							 List<Collection> lcolle = null;
							 
							 Customer custom = null;
							 List<Customer> lcustom = null;
							 
							 if (jsonObj.has("_links")) {
								 _links = new Links();
								 if (jsonObj.getJSONObject("_links").has("self")) {
									 JSONArray jlself = new JSONArray(jsonObj.getJSONObject("_links").get("self").toString());
									 System.out.println("jlself.length() ->> "+ jlself.length());
									 
									if ( jlself.length() > 0) {
										lself = new ArrayList<Self>();
										for (int i =0; i < jlself.length(); i++ ) {
											self = new Self();
											
											 self.setHref( jlself.getJSONObject(i).getString("href").toString());	
											// System.out.println("self.getHref() ->>> " + self.getHref());
											 lself.add(self);
										 }	
										
										_links.setSelf(lself);
										
									}
									 
								 }
								 
								 if(jsonObj.getJSONObject("_links").has("collection")) {
									 JSONArray jlcollec = new JSONArray(jsonObj.getJSONObject("_links").get("collection").toString());
									 if (jlcollec.length() > 0) {
										 lcolle = new ArrayList<Collection>();
										 for(int i=0; i< jlcollec.length(); i++) {
											 colle = new Collection();
											 colle.setHref(jlcollec.getJSONObject(i).getString("href").toString());
											 lcolle.add(colle);
										 }
										 
										 _links.setCollection(lcolle);
										 
									 }
									 
								 }
								 
								 if(jsonObj.getJSONObject("_links").has("customer")) {
									 JSONArray jlcustom = new JSONArray(jsonObj.getJSONObject("_links").get("customer").toString());
									 if (jlcustom.length() > 0) {
										 lcustom = new ArrayList<Customer>();
										 for (int i=0; i < jlcustom.length(); i++) {
											 custom = new Customer();
											 custom.setHref(jlcustom.getJSONObject(i).getString("href").toString());
											 lcustom.add(custom);
										 }
										 
										 _links.setCustomer(lcustom);
									 }
								 }
								 
							 }else {
								 _links = new Links();
								 lself = new ArrayList<Self>();
								 _links.setSelf(lself);
								 lcolle = new ArrayList<Collection>();
								 _links.setCollection(lcolle);
								 lcustom= new ArrayList<Customer>();
								 _links.setCustomer(lcustom);
							 }
							 wooComOBJ.set_links(_links); 
									
							 
							 if (error) { 
								 status = "Order missing information";
								 jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()) , URLDecoder.decode(data), status);
							 }else { 
								 status = "Order read successfully";
								 jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()) , URLDecoder.decode(data), status);
								 
								// System.out.println("wooComOBJ.toString() ->>> "+ wooComOBJ.toString() );  
								 								 
							 }
							 
						}else {
							status =  "Order read unsuccessfully";
							jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()) , URLDecoder.decode(data), status);
						}
						
					}else {
						status =  "Order read unsuccessfully";
						jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()) , URLDecoder.decode(data), status);
					}					
											
						 
			/*		 System.out.println("//////////////////////////////////////////");
					 
					 System.out.println("wooComOBJ.getId() "+wooComOBJ.getId()); 
					 System.out.println("wooComOBJ.getParent_id() "+wooComOBJ.getParent_id());
					 System.out.println("wooComOBJ.getStatus() "+wooComOBJ.getStatus());
					 System.out.println("wooComOBJ.getCurrency() "+wooComOBJ.getCurrency());
					 System.out.println("wooComOBJ.getVersion() "+wooComOBJ.getVersion());
					 System.out.println("wooComOBJ.isPrices_include_tax() "+wooComOBJ.isPrices_include_tax());
					 System.out.println("wooComOBJ.getDate_created().getDate() "+wooComOBJ.getDate_created().getDate());
					 System.out.println("wooComOBJ.getDate_created().getTimezone_type() "+wooComOBJ.getDate_created().getTimezone_type());
					 System.out.println("wooComOBJ.getDate_created().getTimezone() "+wooComOBJ.getDate_created().getTimezone());
					 System.out.println("wooComOBJ.getDate_modified().getDate() "+wooComOBJ.getDate_modified().getDate());
					 System.out.println("wooComOBJ.getDate_modified().getTimezone_type() "+wooComOBJ.getDate_modified().getTimezone_type());
					 System.out.println("wooComOBJ.getDate_modified().getTimezone() "+wooComOBJ.getDate_modified().getTimezone());
					 System.out.println("wooComOBJ.getDiscount_total() "+ wooComOBJ.getDiscount_total());
					 System.out.println("wooComOBJ.getDiscount_tax() "+wooComOBJ.getDiscount_tax());
					 System.out.println("wooComOBJ.getShipping_total() "+wooComOBJ.getShipping_total());
					 System.out.println("wooComOBJ.getShipping_tax() "+wooComOBJ.getShipping_tax());
					 
					 System.out.println("wooComOBJ.getCart_tax() "+wooComOBJ.getCart_tax());
					 System.out.println("wooComOBJ.getTotal() "+wooComOBJ.getTotal());
					 System.out.println("wooComOBJ.getTotal_tax() "+wooComOBJ.getTotal_tax());
					 System.out.println("wooComOBJ.getCustomer_id() "+wooComOBJ.getCustomer_id());
					 System.out.println("wooComOBJ.getOrder_key() "+wooComOBJ.getOrder_key());
					 System.out.println("wooComOBJ.getBilling().getFirst_name() "+wooComOBJ.getBilling().getFirst_name());
					 System.out.println("wooComOBJ.getBilling().getLast_name() "+wooComOBJ.getBilling().getLast_name());
					 System.out.println("wooComOBJ.getBilling().getCompany() "+wooComOBJ.getBilling().getCompany());
					 System.out.println("wooComOBJ.getBilling().getAddress_1() "+wooComOBJ.getBilling().getAddress_1());
					 System.out.println("wooComOBJ.getBilling().getAddress_2() "+wooComOBJ.getBilling().getAddress_2());
					 System.out.println("wooComOBJ.getBilling().getCity() "+wooComOBJ.getBilling().getCity());
					 System.out.println("wooComOBJ.getBilling().getState() "+wooComOBJ.getBilling().getState());
					 System.out.println("wooComOBJ.getBilling().getPostcode() "+wooComOBJ.getBilling().getPostcode());
					 System.out.println("wooComOBJ.getBilling().getCountry() "+wooComOBJ.getBilling().getCountry());
					 System.out.println("wooComOBJ.getBilling().getEmail() "+wooComOBJ.getBilling().getEmail());
					 System.out.println("wooComOBJ.getBilling().getPhone() "+wooComOBJ.getBilling().getPhone());
					 System.out.println("wooComOBJ.getShipping().getFirst_name() "+wooComOBJ.getShipping().getFirst_name());
					 System.out.println("wooComOBJ.getShipping().getLast_name() "+wooComOBJ.getShipping().getLast_name());
					 System.out.println("wooComOBJ.getShipping().getCompany() "+wooComOBJ.getShipping().getCompany());
					 System.out.println("wooComOBJ.getShipping().getAddress_1() "+wooComOBJ.getShipping().getAddress_1());
					 System.out.println("wooComOBJ.getShipping().getAddress_2() "+wooComOBJ.getShipping().getAddress_2());
					 System.out.println("wooComOBJ.getShipping().getCity() "+wooComOBJ.getShipping().getCity());
					 System.out.println("wooComOBJ.getShipping().getState() "+wooComOBJ.getShipping().getState());
					 System.out.println("wooComOBJ.getShipping().getPostcode() "+wooComOBJ.getShipping().getPostcode());
					 System.out.println("wooComOBJ.getShipping().getCountry() "+ wooComOBJ.getShipping().getCountry());
					 
					 System.out.println("wooComOBJ.getPayment_method() "+wooComOBJ.getPayment_method());
					 System.out.println("wooComOBJ.getPayment_method_title() "+wooComOBJ.getPayment_method_title());
					 System.out.println("wooComOBJ.getTransaction_id() "+wooComOBJ.getTransaction_id());
					 System.out.println("wooComOBJ.getCustomer_ip_address() "+wooComOBJ.getCustomer_ip_address());
					 System.out.println("wooComOBJ.getCustomer_user_agent() "+wooComOBJ.getCustomer_user_agent());
					 System.out.println("wooComOBJ.getCreated_via() "+ wooComOBJ.getCreated_via());
					 System.out.println("wooComOBJ.getCustomer_note() "+wooComOBJ.getCustomer_note());
					 System.out.println("wooComOBJ.getDate_completed() "+wooComOBJ.getDate_completed());
					 System.out.println("wooComOBJ.getDate_paid() "+wooComOBJ.getDate_paid());
					 System.out.println("wooComOBJ.getCart_hash() "+wooComOBJ.getCart_hash());
					 System.out.println("wooComOBJ.getNumber() "+wooComOBJ.getNumber());
					 System.out.println("wooComOBJ.getMetadata() "+wooComOBJ.getMetadata());
					 System.out.println("wooComOBJ.getLine_item().getId() "+wooComOBJ.getLine_item().getId());
					 System.out.println("wooComOBJ.getTax_line().getId() "+wooComOBJ.getTax_line().getId());
					 System.out.println("wooComOBJ.getShipping_line().getId() "+ wooComOBJ.getShipping_line().getId());
					 System.out.println("wooComOBJ.getFee_line() "+wooComOBJ.getFee_line());
					 System.out.println("+wooComOBJ.getCoupon_lines() ->> "+wooComOBJ.getCoupon_lines());
					*/
					 //JSON TO JAVA
					
		
 
	
		
		
		return status;
	}

}
