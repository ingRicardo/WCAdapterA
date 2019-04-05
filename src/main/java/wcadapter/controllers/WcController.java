package wcadapter.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import wcadapter.clases.Billing;
import wcadapter.clases.Collection;
import wcadapter.clases.Coupon_lines;
import wcadapter.clases.Customer;
import wcadapter.clases.Date_created;
import wcadapter.clases.Date_modified;
import wcadapter.clases.Fee_lines;
import wcadapter.clases.Functions;
import wcadapter.clases.Line_items;
import wcadapter.clases.Links;
import wcadapter.clases.Meta;
import wcadapter.clases.Meta_data;
import wcadapter.clases.Refunds;
import wcadapter.clases.Self;
import wcadapter.clases.Shipping;
import wcadapter.clases.Shipping_lines;
import wcadapter.clases.Tax;
import wcadapter.clases.Tax_lines;
import wcadapter.clases.WooCommerceObj;
import wcadapter.service.JsonService;

@RestController
public class WcController {

	@Autowired
	private JsonService jsonservice;

	@RequestMapping("/wcadapter/wc/v1/wc-jsonParser")
	@ResponseBody
	public HashMap<String, Object> JsonParser(String data) throws JSONException, SQLException {

		HashMap<String, Object> hashMap = null;
		String status = "";
		JSONObject jsonObj = null;
		WooCommerceObj wooComOBJ = null;

		if (!Functions.isNullOrEmpty(data)) {

			jsonObj = new JSONObject(data);
			wooComOBJ = new WooCommerceObj();
			boolean error = false;
			if (jsonObj.has("id")) {
				wooComOBJ.setId(Integer.parseInt(jsonObj.get("id").toString()));
				if (wooComOBJ.getId() > 0) {

					status = "Order received";
					System.out.println("status ->> " + status);
					// Insert JSON in to DATABASE
					jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data), status);

					if (jsonObj.has("parent_id")) {
						wooComOBJ.setParent_id(Integer.parseInt(jsonObj.get("parent_id").toString()));
					}

					if (jsonObj.has("status")) {
						wooComOBJ.setStatus(jsonObj.get("status").toString());
					}

					if (jsonObj.has("currency")) {
						wooComOBJ.setCurrency(jsonObj.get("currency").toString());
					}

					if (jsonObj.has("version")) {
						wooComOBJ.setVersion(jsonObj.get("version").toString());
					}

					if (jsonObj.has("prices_include_tax")) {
						wooComOBJ.setPrices_include_tax(Boolean.valueOf(jsonObj.get("prices_include_tax").toString()));
					}

					if (jsonObj.has("date_created")) {
						if (jsonObj.get("date_created") instanceof String) {
							wooComOBJ.setDates_created(jsonObj.get("date_created").toString());
						} else {
							Date_created datecr = new Date_created();
							if (jsonObj.getJSONObject("date_created").has("date")) {
								datecr.setDate(jsonObj.getJSONObject("date_created").get("date").toString());
							}

							if (jsonObj.getJSONObject("date_created").has("timezone")) {
								datecr.setTimezone(jsonObj.getJSONObject("date_created").get("timezone").toString());
							}

							if (jsonObj.getJSONObject("date_created").has("timezone_type")) {
								datecr.setTimezone_type(Integer.parseInt(
										jsonObj.getJSONObject("date_created").get("timezone_type").toString()));
							}

							wooComOBJ.setDate_created(datecr);
						}
					}

					if (jsonObj.has("date_modified")) {

						if (jsonObj.get("date_modified") instanceof String) {
							wooComOBJ.setDates_modified(jsonObj.get("date_modified").toString());
						} else {

							Date_modified datemod = new Date_modified();

							if (jsonObj.getJSONObject("date_modified").has("date")) {
								datemod.setDate(jsonObj.getJSONObject("date_modified").get("date").toString());
							}

							if (jsonObj.getJSONObject("date_modified").has("timezone")) {
								datemod.setTimezone(jsonObj.getJSONObject("date_modified").get("timezone").toString());
							}

							if (jsonObj.getJSONObject("date_modified").has("timezone_type")) {
								datemod.setTimezone_type(Integer.parseInt(
										jsonObj.getJSONObject("date_modified").get("timezone_type").toString()));

							}

							wooComOBJ.setDate_modified(datemod);
						}
					}

					if (jsonObj.has("discount_total")) {
						wooComOBJ.setDiscount_total(jsonObj.get("discount_total").toString());
					}

					if (jsonObj.has("discount_tax")) {
						wooComOBJ.setDiscount_tax(jsonObj.get("discount_tax").toString());
					}

					if (jsonObj.has("shipping_total")) {
						wooComOBJ.setShipping_total(jsonObj.get("shipping_total").toString());
					}

					if (jsonObj.has("shipping_tax")) {
						wooComOBJ.setShipping_tax(jsonObj.get("shipping_tax").toString());
					}

					if (jsonObj.has("cart_tax")) {
						wooComOBJ.setCart_tax(jsonObj.get("cart_tax").toString());
					}

					if (jsonObj.has("total")) {
						wooComOBJ.setTotal(jsonObj.get("total").toString());
					}

					if (jsonObj.has("total_tax")) {
						wooComOBJ.setTotal_tax(jsonObj.get("total_tax").toString());
					}

					if (jsonObj.has("customer_id")) {
						wooComOBJ.setCustomer_id(Integer.parseInt(jsonObj.get("customer_id").toString()));
					}

					if (jsonObj.has("order_key")) {
						System.out.println(" jsonObj order_key ->>> " + jsonObj.get("order_key"));
						wooComOBJ.setOrder_key(jsonObj.get("order_key").toString());
					}

					if (jsonObj.has("billing")) {
						Billing billingObj = new Billing();

						if (jsonObj.getJSONObject("billing").has("first_name")) {
							billingObj.setFirst_name(jsonObj.getJSONObject("billing").get("first_name").toString());
						}

						if (jsonObj.getJSONObject("billing").has("last_name")) {
							billingObj.setLast_name(jsonObj.getJSONObject("billing").get("last_name").toString());
						}

						if (jsonObj.getJSONObject("billing").has("company")) {
							billingObj.setCompany(jsonObj.getJSONObject("billing").get("company").toString());
						}

						if (jsonObj.getJSONObject("billing").has("address_1")) {
							billingObj.setAddress_1(jsonObj.getJSONObject("billing").get("address_1").toString());
						}

						if (jsonObj.getJSONObject("billing").has("address_2")) {
							billingObj.setAddress_2(jsonObj.getJSONObject("billing").get("address_2").toString());
						}

						if (jsonObj.getJSONObject("billing").has("city")) {
							billingObj.setCity(jsonObj.getJSONObject("billing").get("city").toString());
						}

						if (jsonObj.getJSONObject("billing").has("state")) {
							billingObj.setState(jsonObj.getJSONObject("billing").get("state").toString());
						}

						if (jsonObj.getJSONObject("billing").has("postcode")) {
							billingObj.setPostcode(jsonObj.getJSONObject("billing").get("postcode").toString());
						}

						if (jsonObj.getJSONObject("billing").has("country")) {
							billingObj.setCountry(jsonObj.getJSONObject("billing").get("country").toString());
						}

						if (jsonObj.getJSONObject("billing").has("email")) {
							billingObj.setEmail(jsonObj.getJSONObject("billing").get("email").toString());

						}

						if (jsonObj.getJSONObject("billing").has("phone")) {
							billingObj.setPhone(jsonObj.getJSONObject("billing").get("phone").toString());
						}

						wooComOBJ.setBilling(billingObj);

					} // billing

					if (jsonObj.has("shipping")) {

						Shipping shippingObj = new Shipping();

						if (jsonObj.getJSONObject("shipping").has("first_name")) {
							shippingObj.setFirst_name(jsonObj.getJSONObject("shipping").get("first_name").toString());
						}

						if (jsonObj.getJSONObject("shipping").has("last_name")) {
							shippingObj.setLast_name(jsonObj.getJSONObject("shipping").get("last_name").toString());
						}

						if (jsonObj.getJSONObject("shipping").has("company")) {
							shippingObj.setCompany(jsonObj.getJSONObject("shipping").get("company").toString());
						}
						if (jsonObj.getJSONObject("shipping").has("address_1")) {
							shippingObj.setAddress_1(jsonObj.getJSONObject("shipping").get("address_1").toString());
						}

						if (jsonObj.getJSONObject("shipping").has("address_2")) {
							shippingObj.setAddress_2(jsonObj.getJSONObject("shipping").get("address_2").toString());
						}

						if (jsonObj.getJSONObject("shipping").has("city")) {
							shippingObj.setCity(jsonObj.getJSONObject("shipping").get("city").toString());
						}

						if (jsonObj.getJSONObject("shipping").has("state")) {
							shippingObj.setState(jsonObj.getJSONObject("shipping").get("state").toString());
						}
						if (jsonObj.getJSONObject("shipping").has("postcode")) {
							shippingObj.setPostcode(jsonObj.getJSONObject("shipping").get("postcode").toString());
						}
						if (jsonObj.getJSONObject("shipping").has("country")) {

							shippingObj.setCountry(jsonObj.getJSONObject("shipping").get("country").toString());
						}

						wooComOBJ.setShipping(shippingObj);

					} // shipping

					if (jsonObj.has("payment_method")) {
						wooComOBJ.setPayment_method(jsonObj.get("payment_method").toString());

					}
					if (jsonObj.has("payment_method_title")) {

						wooComOBJ.setPayment_method_title(jsonObj.get("payment_method_title").toString());
					}

					if (jsonObj.has("transaction_id")) {

						wooComOBJ.setTransaction_id(jsonObj.get("transaction_id").toString());
					}
					if (jsonObj.has("customer_ip_address")) {
						wooComOBJ.setCustomer_ip_address(jsonObj.get("customer_ip_address").toString());
					}
					if (jsonObj.has("customer_user_agent")) {
						wooComOBJ.setCustomer_user_agent(jsonObj.get("customer_user_agent").toString());
					}
					if (jsonObj.has("created_via")) {
						wooComOBJ.setCreated_via(jsonObj.get("created_via").toString());
					}
					if (jsonObj.has("customer_note")) {

						wooComOBJ.setCustomer_note(jsonObj.get("customer_note").toString());
					}
					if (jsonObj.has("date_completed")) {
						wooComOBJ.setDate_completed(jsonObj.get("date_completed").toString());
					}
					if (jsonObj.has("date_paid")) {
						wooComOBJ.setDate_paid(jsonObj.get("date_paid").toString());
					}
					if (jsonObj.has("cart_hash")) {

						wooComOBJ.setCart_hash(jsonObj.get("cart_hash").toString());
					}
					if (jsonObj.has("number")) {

						wooComOBJ.setNumber(jsonObj.get("number").toString());
					}
					if (jsonObj.has("meta_data")) {
						JSONArray jsonArray = new JSONArray(jsonObj.get("meta_data").toString());
						if (jsonArray.length() >= 0) {
							Meta_data metadata = new Meta_data();
							wooComOBJ.setMetadata(metadata);
						}

					} // meta data

					if (jsonObj.has("line_items")) {

						Line_items litems = null;
						if (jsonObj.get("line_items") instanceof String) {
							litems = new Line_items();
							if (jsonObj.getJSONObject("line_items").has("24")) {
								litems.setId(
										Integer.parseInt(jsonObj.getJSONObject("line_items").get("24").toString()));
							}
							// tax_lines
							wooComOBJ.setLine_item(litems);

						} else if (jsonObj.get("line_items") instanceof JSONObject) {

							System.out.println(
									" line_items ---> length ->> " + jsonObj.getJSONObject("line_items").length());

							if (jsonObj.getJSONObject("line_items").length() > 0) {

								for (int i = 0; i < jsonObj.getJSONObject("line_items").length(); i++) {
									litems = new Line_items();
									if (jsonObj.getJSONObject("line_items").has("id")) {
										litems.setId(Integer
												.parseInt(jsonObj.getJSONObject("line_items").get("id").toString()));
									} else {
										System.out.println("LINE ITEMS : NO ID FOUND");

										error = true;
									}

								}


							}

							// tax_lines
							wooComOBJ.setLine_item(litems);

						} else {

							JSONArray line_items = new JSONArray(jsonObj.get("line_items").toString());
							Tax tax = null;
							List<Tax> ltaxes = null;
							JSONArray taxes = null;
							JSONObject items = null;
							List<Line_items> lisitems = null;
							if (line_items.length() > 0) {
								lisitems = new ArrayList<Line_items>();
								for (int i = 0; i < line_items.length(); i++) {
									litems = new Line_items();
									// [{"quantity":1,"tax_class":"","taxes":[],"total_tax":"0.00","total":"10.00","variation_id":0,"price":"10.00","subtotal":"10.00","meta":[],"product_id":173,"name":"SAMPLE","id":22,"sku":"","subtotal_tax":"0.00"}]
									items = line_items.getJSONObject(i);
									int quantity = Integer.parseInt(items.optString("quantity").toString());
									litems.setQuantity(quantity);
									String tax_class = items.optString("tax_class").toString();
									litems.setTax_class(tax_class);

									if (jsonObj.has("taxes")) {
										taxes = new JSONArray(jsonObj.get("taxes").toString());
										if (taxes.length() > 0) {
											for (i = 0; i < taxes.length(); i++) {
												tax = new Tax();
												ltaxes = new ArrayList<Tax>();
												ltaxes.add(tax);
												System.out.println("taxes " + ltaxes);
											}
											litems.setTaxes(ltaxes);
										}
									} else {
										ltaxes = new ArrayList<Tax>();
										litems.setTaxes(ltaxes);
									}

									// "total_tax":"0.00"
									String total_tax = items.optString("total_tax").toString();
									litems.setTotal_tax(total_tax);
									// "total":"10.00"
									String total = items.optString("total").toString();
									litems.setTotal(total);
									// "variation_id":0
									int variation_id = Integer.parseInt(items.optString("variation_id").toString());
									litems.setVariation_id(variation_id);
									// "price":"10.00"
									String price = items.optString("price").toString();
									litems.setPrice(price);
									// "subtotal":"10.00"
									String subtotal = items.optString("subtotal").toString();
									litems.setSubtotal(subtotal);
									// "meta":[]
									List<Meta> lmetas = null;
									Meta metas = null;
									if (jsonObj.has("meta")) {
										JSONArray meta = new JSONArray(jsonObj.get("meta").toString());

										if (meta.length() > 0) {
											lmetas = new ArrayList<Meta>();
											for (i = 0; i < meta.length(); i++) {
												metas = new Meta();
												lmetas.add(metas);
											}
										}
									} else {
										metas = new Meta();
										lmetas = new ArrayList<Meta>();
										lmetas.add(metas);
									}
									litems.setMeta(lmetas);
									// "product_id":173
									int product_id = Integer.parseInt(items.optString("product_id").toString());
									litems.setProduct_id(product_id);

									// "name":"SAMPLE"
									String name = items.optString("name").toString();
									litems.setName(name);

									// "id":22
									int id = Integer.parseInt(items.optString("id").toString());
									litems.setId(id);

									// "sku":""
									String sku = items.optString("sku").toString();
									litems.setSku(sku);
									// "subtotal_tax":"0.00"
									String subtotal_tax = items.optString("subtotal_tax").toString();
									litems.setSubtotal_tax(subtotal_tax);

									lisitems.add(litems);
								}

							}

							wooComOBJ.setLine_items(lisitems);
						}

					} // line items

					if (jsonObj.has("tax_lines")) {

						JSONArray jsontax_linesArray = new JSONArray(jsonObj.get("tax_lines").toString());
						Tax_lines txlines = null;
						if (jsontax_linesArray.length() >= 0) {
							txlines = new Tax_lines();
						}
						wooComOBJ.setTax_line(txlines);
					} // tax lines

					Shipping_lines shiplines = null;
					List<Shipping_lines> lshiplines = null;
					if (jsonObj.has("shipping_lines")) {

						if (jsonObj.get("shipping_lines") instanceof String) {
							if (jsonObj.getJSONObject("shipping_lines").has("25")) {
								shiplines = new Shipping_lines(
										Integer.parseInt(jsonObj.getJSONObject("shipping_lines").get("25").toString()));
							}
							wooComOBJ.setShipping_line(shiplines);
						} else if (jsonObj.get("shipping_lines") instanceof JSONObject) {

							Shipping_lines slines = null;

							if (jsonObj.getJSONObject("shipping_lines").length() > 0) {

								for (int i = 0; i < jsonObj.getJSONObject("shipping_lines").length(); i++) {
									slines = new Shipping_lines();
									if (jsonObj.getJSONObject("shipping_lines").has("id")) {
										slines.setId(Integer.parseInt(
												jsonObj.getJSONObject("shipping_lines").get("id").toString()));
									} else {
										System.out.println("shipping_lines : NO ID FOUND");
										error = true;
									}

								}

								wooComOBJ.setShipping_line(slines);
							}

						} else {
							JSONArray shiplinesArray = new JSONArray(jsonObj.get("shipping_lines").toString());
							if (shiplinesArray.length() > 0) {
								lshiplines = new ArrayList<Shipping_lines>();
								for (int i = 0; i < shiplinesArray.length(); i++) {
									shiplines = new Shipping_lines();
									lshiplines.add(shiplines);
								}
								wooComOBJ.setShipping_lines(lshiplines);
							}

						}
					} else {
						shiplines = new Shipping_lines();
						wooComOBJ.setShipping_line(shiplines);
					}

					Fee_lines feelins = null;
					List<Fee_lines> lfeeline = null;
					if (jsonObj.has("fee_lines")) {
						// fee_lines
						JSONArray jsonfee_linesArray = new JSONArray(jsonObj.get("fee_lines").toString());

						if (jsonfee_linesArray.length() > 0) {
							lfeeline = new ArrayList<Fee_lines>();
							for (int i = 0; i < jsonfee_linesArray.length(); i++) {
								feelins = new Fee_lines();
								lfeeline.add(feelins);
							}

							wooComOBJ.setFee_lines(lfeeline);

						}

					} else {
						lfeeline = new ArrayList<Fee_lines>();
						feelins = new Fee_lines();
						wooComOBJ.setFee_line(feelins);
					}

					// coupon_lines
					Coupon_lines co_lines = null;
					List<Coupon_lines> lcolines = null;
					if (jsonObj.has("coupon_lines")) {
						JSONArray jsoncoupon_linesArray = new JSONArray(jsonObj.get("coupon_lines").toString());

						if (jsoncoupon_linesArray.length() > 0) {
							lcolines = new ArrayList<Coupon_lines>();
							for (int i = 0; i < jsoncoupon_linesArray.length(); i++) {
								co_lines = new Coupon_lines();
								lcolines.add(co_lines);
							}

							wooComOBJ.setCoupon_lines(lcolines);

						}

					} else {
						// co_lines = new Coupon_lines();
						lcolines = new ArrayList<Coupon_lines>();
						wooComOBJ.setCoupon_lines(lcolines);
					}

					// refunds
					Refunds refund = null;
					List<Refunds> lrefund = null;
					if (jsonObj.has("refunds")) {
						JSONArray jrefund = new JSONArray(jsonObj.get("refunds").toString());
						if (jrefund.length() > 0) {
							lrefund = new ArrayList<Refunds>();
							for (int i = 0; i < jrefund.length(); i++) {
								refund = new Refunds();
								lrefund.add(refund);
							}
							wooComOBJ.setRefunds(lrefund);
						}
					} else {
						lrefund = new ArrayList<Refunds>();
						wooComOBJ.setRefunds(lrefund);
					}

					// _links
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
							System.out.println("jlself.length() ->> " + jlself.length());

							if (jlself.length() > 0) {
								lself = new ArrayList<Self>();
								for (int i = 0; i < jlself.length(); i++) {
									self = new Self();

									self.setHref(jlself.getJSONObject(i).getString("href").toString());
									// System.out.println("self.getHref() ->>> " + self.getHref());
									lself.add(self);
								}

								_links.setSelf(lself);

							}

						}

						if (jsonObj.getJSONObject("_links").has("collection")) {
							JSONArray jlcollec = new JSONArray(
									jsonObj.getJSONObject("_links").get("collection").toString());
							if (jlcollec.length() > 0) {
								lcolle = new ArrayList<Collection>();
								for (int i = 0; i < jlcollec.length(); i++) {
									colle = new Collection();
									colle.setHref(jlcollec.getJSONObject(i).getString("href").toString());
									lcolle.add(colle);
								}

								_links.setCollection(lcolle);

							}

						}

						if (jsonObj.getJSONObject("_links").has("customer")) {
							JSONArray jlcustom = new JSONArray(
									jsonObj.getJSONObject("_links").get("customer").toString());
							if (jlcustom.length() > 0) {
								lcustom = new ArrayList<Customer>();
								for (int i = 0; i < jlcustom.length(); i++) {
									custom = new Customer();
									custom.setHref(jlcustom.getJSONObject(i).getString("href").toString());
									lcustom.add(custom);
								}

								_links.setCustomer(lcustom);
							}
						}

					} else {
						_links = new Links();
						lself = new ArrayList<Self>();
						_links.setSelf(lself);
						lcolle = new ArrayList<Collection>();
						_links.setCollection(lcolle);
						lcustom = new ArrayList<Customer>();
						_links.setCustomer(lcustom);
					}
					wooComOBJ.set_links(_links);

					if (error) {
						status = "Order missing information";
						jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data),
								status);
					} else {
						status = "Order read successfully";
						jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data),
								status);
					}

				} else {
					status = "Order read unsuccessfully";
					jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data), status);
				}

			} else {
				status = "Order read unsuccessfully";
				jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data), status);
			}

			hashMap = new HashMap<String, Object>();
			hashMap.put("data", URLDecoder.decode(data));
			hashMap.put("status", status);

		} else {
			status = "Order read unsuccessfully";
			hashMap = new HashMap<String, Object>();
			hashMap.put("data", data);
			hashMap.put("status", status);

		}
		return hashMap;

	}

	@RequestMapping("/wcadapter/wc/v1/wc-json")
	@ResponseBody
	public HashMap<String, Object> GETwooCommerce(String data)
			throws UnsupportedEncodingException, SQLException, JSONException {

		System.out.println("ORIGINAL DATA -->> " + data);
		// beginning of wooComerce Object
		Billing billing = new Billing("gabriel", "rodriguez", "", "416 w. San Ysidro Blvd.", "ste. L - 1", "san ysidro",
				"CA", "92173", "US", "huertag@globalhitss.com", "6197049434");
		Shipping shipping = new Shipping("", "", "", "", "", "", "", "", "");
		List<Tax> taxesl = new ArrayList<>();
		List<Meta> metasl = new ArrayList<>();
		Line_items line_item = new Line_items(22, "SAMPLE", "", 173, 0, 1, "", "10.00", "10.00", "0.00", "10.00",
				"0.00", taxesl, metasl);
		List<Line_items> line_items = new ArrayList<Line_items>();
		line_items.add(line_item);
		List<Tax_lines> tax_lines = new ArrayList<Tax_lines>();
		List<Shipping_lines> shipping_lines = new ArrayList<Shipping_lines>();
		Shipping_lines shipline = new Shipping_lines(23);
		shipping_lines.add(shipline);
		List<Fee_lines> fee_lines = new ArrayList<Fee_lines>();
		List<Coupon_lines> coupon_lines = new ArrayList<Coupon_lines>();
		List<Refunds> refunds = new ArrayList<Refunds>();
		Self selfObj = new Self("http://localhost/mysite/wp-json/wc/v1/orders/187");
		List<Self> self = new ArrayList<Self>();
		self.add(selfObj);
		List<Collection> collection = new ArrayList<Collection>();
		Collection colle = new Collection("http://localhost/mysite/wp-json/wc/v1/orders");
		collection.add(colle);
		List<Customer> customer = new ArrayList<Customer>();
		Customer custom = new Customer("http://localhost/mysite/wp-json/wc/v1/customers/1");
		customer.add(custom);
		Links _links = new Links(self, collection, customer);
		Date_modified datemodified = new Date_modified("2019-02-13 12:53:06.000000", 3, "America\\/Tijuana");
		Date_created datecreated = new Date_created("2019-02-13 12:53:05.000000", 3, "America\\/Tijuana");

		WooCommerceObj wooObj = new WooCommerceObj(187, 0, "processing", "wc_order_HU5dzVwdshJnA", "187", "USD",
				"3.5.4", false, datecreated, datemodified, 1, "0.00", "0.00", "0.00", "0.00", "0.00", "10.00", "0.00",
				billing, shipping, "cod", "Cash on delivery", "", "::1",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
				"checkout", "please come ASAP", null, null, "aa51cef250dbaafd15cb6317d0871923", line_items, tax_lines,
				shipping_lines, fee_lines, coupon_lines, refunds, _links);

		// end of wooComerce Object

		// Parsing java object to Gson object
		Gson gson = new GsonBuilder().create();
		String jsonObject = gson.toJson(wooObj);
		System.out.println("jsonFromGson : " + jsonObject.toString());

		// Encoding jsonObject
		String s = URLEncoder.encode(jsonObject.toString());
		System.out.println("CODING --> " + s);
		// %7B%22id%22%3A187%2C%22parent_id%22%3A0%2C%22status%22%3A%22processing%22%2C%22order_key%22%3A%22wc_order_HU5dzVwdshJnA%22%2C%22number%22%3A%22187%22%2C%22currency%22%3A%22USD%22%2C%22version%22%3A%223.5.4%22%2C%22prices_include_tax%22%3Afalse%2C%22date_created%22%3A%222019-01-30T20%3A15%3A04%22%2C%22date_modified%22%3A%222019-01-30T20%3A15%3A04%22%2C%22customer_id%22%3A1%2C%22discount_total%22%3A%220.00%22%2C%22discount_tax%22%3A%220.00%22%2C%22shipping_total%22%3A%220.00%22%2C%22shipping_tax%22%3A%220.00%22%2C%22cart_tax%22%3A%220.00%22%2C%22total%22%3A%2210.00%22%2C%22total_tax%22%3A%220.00%22%2C%22billing%22%3A%7B%22first_name%22%3A%22gabriel%22%2C%22last_name%22%3A%22rodriguez%22%2C%22company%22%3A%22%22%2C%22address_1%22%3A%22416+w.+San+Ysidro+Blvd.%22%2C%22address_2%22%3A%22ste.+L+-+1%22%2C%22city%22%3A%22san+ysidro%22%2C%22state%22%3A%22CA%22%2C%22postcode%22%3A%2292173%22%2C%22country%22%3A%22US%22%2C%22email%22%3A%22huertag%40globalhitss.com%22%2C%22phone%22%3A%226197049434%22%7D%2C%22shipping%22%3A%7B%22first_name%22%3A%22%22%2C%22last_name%22%3A%22%22%2C%22company%22%3A%22%22%2C%22address_1%22%3A%22%22%2C%22address_2%22%3A%22%22%2C%22city%22%3A%22%22%2C%22state%22%3A%22%22%2C%22postcode%22%3A%22%22%2C%22country%22%3A%22%22%7D%2C%22payment_method%22%3A%22cod%22%2C%22payment_method_title%22%3A%22Cash+on+delivery%22%2C%22transaction_id%22%3A%22%22%2C%22customer_ip_address%22%3A%22%3A%3A1%22%2C%22customer_user_agent%22%3A%22Mozilla%2F5.0+%28Windows+NT+6.1%3B+Win64%3B+x64%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F71.0.3578.98+Safari%2F537.36%22%2C%22created_via%22%3A%22checkout%22%2C%22customer_note%22%3A%22please+come+ASAP%22%2C%22cart_hash%22%3A%22aa51cef250dbaafd15cb6317d0871923%22%2C%22line_items%22%3A%5B%7B%22id%22%3A22%2C%22name%22%3A%22SAMPLE%22%2C%22sku%22%3A%22%22%2C%22product_id%22%3A173%2C%22variation_id%22%3A0%2C%22quantity%22%3A1%2C%22tax_class%22%3A%22%22%2C%22price%22%3A%2210.00%22%2C%22subtotal%22%3A%2210.00%22%2C%22subtotal_tax%22%3A%220.00%22%2C%22total%22%3A%2210.00%22%2C%22total_tax%22%3A%220.00%22%2C%22taxes%22%3A%5B%5D%2C%22meta%22%3A%5B%5D%7D%5D%2C%22tax_lines%22%3A%5B%5D%2C%22shipping_lines%22%3A%5B%5D%2C%22fee_lines%22%3A%5B%5D%2C%22coupon_lines%22%3A%5B%5D%2C%22refunds%22%3A%5B%5D%2C%22_links%22%3A%7B%22self%22%3A%5B%7B%22href%22%3A%22http%3A%2F%2Flocalhost%2Fmysite%2Fwp-json%2Fwc%2Fv1%2Forders%2F187%22%7D%5D%2C%22collection%22%3A%5B%7B%22href%22%3A%22http%3A%2F%2Flocalhost%2Fmysite%2Fwp-json%2Fwc%2Fv1%2Forders%22%7D%5D%2C%22customer%22%3A%5B%7B%22href%22%3A%22http%3A%2F%2Flocalhost%2Fmysite%2Fwp-json%2Fwc%2Fv1%2Fcustomers%2F1%22%7D%5D%7D%7D

		if (data instanceof String) {
			System.out.println("IS A STRING");
		} else if (data instanceof Object) {
			System.out.println("IS A Object");
		}

		System.out.println("DECODE -BEFORE INSERT-->> " + URLDecoder.decode(data));

		HashMap<String, Object> hashMap;
		if (!Functions.isNullOrEmpty(data) || data != null) {

			JSONObject jsonObj = new JSONObject(data);
			System.out.println("jsonObj ->>> " + jsonObj);
			WooCommerceObj wooComOBJ = new WooCommerceObj();

			System.out.println(" jsonObj ID ->>> " + jsonObj.get("id"));
			wooComOBJ.setId(Integer.parseInt(jsonObj.get("id").toString()));
			System.out.println("ID FROM JAVA OBJECT ->> " + wooComOBJ.getId());
			hashMap = new HashMap<String, Object>();
			jsonservice.insertJsonObj("", String.valueOf(wooComOBJ.getId()), URLDecoder.decode(data), "Order received");
			System.out.println("DECODE INSERTED--->> " + URLDecoder.decode(data));
			hashMap.put("data", URLDecoder.decode(data));
		} else {

			hashMap = new HashMap<String, Object>();
			hashMap.put("data", "204 No Content");
		}


		return hashMap;

	}

}
