/**
 * 
 */

$(".btn-primary")
		.click(
				function() {
					var $item = $(this).closest("tr").find(".tdc").text();
					console.log($item);

					$
							.ajax({
								url : "/submitid",
								type : "post", // send it through get method
								data : {
									idval : $item
								}, // parameters
								success : function(data) {

									$("#submenu7").empty();
									console.log("data -> " + data);
									var stringConstructor = "test".constructor;
									var arrayConstructor = [].constructor;
									var objectConstructor = {}.constructor;

									var myJSON = JSON.stringify(data);

									if (myJSON === null) {
										console.log("null");
									} else if (myJSON === undefined) {
										console.log("undefined");
									} else if (myJSON.constructor === stringConstructor) {
										console.log("String");
									} else if (myJSON.constructor === arrayConstructor) {
										console.log("Array");
									} else if (myJSON.constructor === objectConstructor) {
										console.log("Object");
									} else {
										console.log("don't know");
									}

									var myObj = JSON.parse(myJSON);
									$
											.ajax({
												type : "POST",
												url : "http://localhost:9083/ventagenerica/servlet/zntservlet.WCAdapter",
												data : JSON.stringify(myObj),
												contentType : "application/json",
												success : function(data) {
													values = {};
													values["WorkOrder"] = data.WorkOrder;
													values["Status"] = data.Status;
													values["Key"] = data.key;
													console.log(Object
															.values(data));
													console
															.log("WorkOrder -> "
																	+ values["WorkOrder"]);
													console.log("Status -> "
															+ values["Status"]);
													console.log("key -> "
															+ values["Key"]);

													$
															.ajax({
																type : "POST",
																url : "/submitStatus",
																data : JSON
																		.stringify(values),
																contentType : "application/json",
																dataType : 'json',
																success : function(
																		data) {
																	console
																			.log(" submitStatus  data  --> "
																					+ data);
																},
																error : function(
																		x, e) {
																	console
																			.log("submitStatus error occur");
																	console
																			.log(e);
																}
															});

												},
												error : function(x, e) {
													console.log("error occur");
													console.log(e);
												}
											});

									$("#submenu7").text(myJSON);
									$("#id").text(data.id);
									$("#status").text(data.status);
									$("#number").text(data.number);
									$("#currency").text(data.currency);
									$("#customer_id").text(data.customer_id);
									$("#discount_total").text(
											data.discount_total);
									$("#discount_tax").text(data.discount_tax);
									$("#shipping_total").text(
											data.shipping_total);
									$("#shipping_tax").text(data.shipping_tax);
									$("#cart_tax").text(data.cart_tax);
									$("#total").text(data.total);
									$("#total_tax").text(data.total_tax);
									$("#billing_first_name").text(
											data.billing.first_name);
									$("#billing_last_name").text(
											data.billing.last_name);
									$("#billing_company").text(
											data.billing.company);
									$("#billing_address_1").text(
											data.billing.address_1);
									$("#billing_address_2").text(
											data.billing.address_2);
									$("#billing_city").text(data.billing.city);
									$("#billing_state")
											.text(data.billing.state);
									$("#billing_postcode").text(
											data.billing.postcode);
									$("#billing_country").text(
											data.billing.country);
									$("#billing_email")
											.text(data.billing.email);
									$("#billing_phone")
											.text(data.billing.phone);
									$("#shipping_first_name").text(
											data.shipping.first_name);
									$("#shipping_last_name").text(
											data.shipping.last_name);
									$("#shipping_company").text(
											data.shipping.company);
									$("#shipping_address_1").text(
											data.shipping.address_1);
									$("#shipping_address_2").text(
											data.shipping.address_2);
									$("#shipping_city")
											.text(data.shipping.city);
									$("#shipping_state").text(
											data.shipping.state);
									$("#shipping_postcode").text(
											data.shipping.postcode);
									$("#shipping_country").text(
											data.shipping.country);
									$("#payment_method").text(
											data.payment_method);
									$("#payment_method_title").text(
											data.payment_method_title);
									$("#transaction_id").text(
											data.transaction_id);
									$("#customer_ip_address").text(
											data.customer_ip_address);
									$("#customer_user_agent").text(
											data.customer_user_agent);
									$("#created_via").text(data.created_via);
									$("#customer_note")
											.text(data.customer_note);
									$("#date_completed").text(
											data.date_completed);
									$("#date_paid").text(data.date_paid);
									$("#cart_hash").text(data.cart_hash);
									$("#submenu4").empty();

									$
											.each(
													data.line_items,
													function(index, value) {

														if (index >= 0) {
															$("#submenu4")
																	.append(
																			'<hr>');
															var item = '<div class="row" '
																	+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																	+ '<div class="col-md-4" >'
																	+ '<p>#Item:</p>'
																	+ '</div>'
																	+ '<div class="col-md-8" >'
																	+ '<p >'
																	+ index
																	+ '</p>'
																	+ '</div>'
																	+ '</div>';
															$("#submenu4")
																	.append(
																			item);

															if (index > 0) {
																$
																		.each(
																				value,
																				function(
																						index,
																						value) {
																					var id = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Id:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["id"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									id);
																					var name = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Name:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["name"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									name);
																					var sku = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Sku:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["sku"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									sku);
																					var product_id = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Product_id:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["product_id"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									product_id);
																					var variation_id = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Variation_id:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["variation_id"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									variation_id);
																					var quantity = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Quantity:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["quantity"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									quantity);
																					var tax_class = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Tax_class:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["tax_class"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									tax_class);
																					var price = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Price:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["price"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									price);
																					var subtotal = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Subtotal:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["subtotal"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									subtotal);
																					var subtotal_tax = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Subtotal_tax:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["subtotal_tax"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									subtotal_tax);
																					var total = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Total:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["total"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									total);
																					var total_tax = '<div class="row" '
																							+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																							+ '<div class="col-md-4" >'
																							+ '<p>Total_tax:</p>'
																							+ '</div>'
																							+ '<div class="col-md-8" >'
																							+ '<p >'
																							+ value["total_tax"]
																							+ '</p>'
																							+ '</div>'
																							+ '</div>';
																					$(
																							"#submenu4")
																							.append(
																									total_tax);
																					if (value["taxes"].length > 0) {
																						$
																								.each(
																										value["taxes"],
																										function(
																												index,
																												value) {
																											var taxes = '<div class="row" '
																													+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																													+ '<div class="col-md-4" >'
																													+ '<p>Taxes:</p>'
																													+ '</div>'
																													+ '<div class="col-md-8" >'
																													+ '<p >'
																													+ value
																													+ '</p>'
																													+ '</div>'
																													+ '</div>';
																											$(
																													"#submenu4")
																													.append(
																															taxes);
																										});
																					} else {
																						var taxes = '<div class="row" '
																								+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																								+ '<div class="col-md-4" >'
																								+ '<p>Taxes:</p>'
																								+ '</div>'
																								+ '<div class="col-md-8" >'
																								+ '<p >'
																								+ value["taxes"].length
																								+ '</p>'
																								+ '</div>'
																								+ '</div>';
																						$(
																								"#submenu4")
																								.append(
																										taxes);
																					}
																					if (value["meta"].length > 0) {
																						$
																								.each(
																										value["meta"],
																										function(
																												index,
																												value) {
																											var meta = '<div class="row" '
																													+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																													+ '<div class="col-md-4" >'
																													+ '<p>Meta:</p>'
																													+ '</div>'
																													+ '<div class="col-md-8" >'
																													+ '<p >'
																													+ value
																													+ '</p>'
																													+ '</div>'
																													+ '</div>';
																											$(
																													"#submenu4")
																													.append(
																															meta);
																										});
																					} else {
																						var meta = '<div class="row" '
																								+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																								+ '<div class="col-md-4" >'
																								+ '<p>Meta:</p>'
																								+ '</div>'
																								+ '<div class="col-md-8" >'
																								+ '<p >'
																								+ value["meta"].length
																								+ '</p>'
																								+ '</div>'
																								+ '</div>';
																						$(
																								"#submenu4")
																								.append(
																										meta);
																					}
																				});
															}
														}
													});
									$("#submenu5").empty();
									if (data.tax_lines) {

										var taxlines = '<div class="row" '
												+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
												+ '<div class="col-md-4" >'
												+ '<p>Tax_lines:</p>'
												+ '</div>'
												+ '<div class="col-md-8" >'
												+ '<p >'
												+ data.tax_lines.length
												+ '</p>' + '</div>' + '</div>';
										$("#submenu5").append(taxlines);
									}

									if (data.shipping_lines) {
										$
												.each(
														data.shipping_lines,
														function(index, value) {
															// alert("shipping
															// lines ->> index
															// "+ index + "
															// value "+ value );
															var shipping_lines = '<div class="row" '
																	+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																	+ '<div class="col-md-4" >'
																	+ '<p>Shipping_lines:</p>'
																	+ '</div>'
																	+ '<div class="col-md-8" >'
																	+ '<p >'
																	+ index
																	+ '</p>'
																	+ '</div>'
																	+ '</div>';
															$("#submenu5")
																	.append(
																			shipping_lines);
															if (value) {
																$
																		.each(
																				value,
																				function(
																						sindex,
																						svalue) {
																					alert("sindex  "
																							+ sindex
																							+ " svalue "
																							+ svalue);
																				});
															}
														});
									}

									if (data.fee_lines) {

										var fee_lines = '<div class="row" '
												+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
												+ '<div class="col-md-4" >'
												+ '<p>Fee_lines:</p>'
												+ '</div>'
												+ '<div class="col-md-8" >'
												+ '<p >'
												+ data.fee_lines.length
												+ '</p>' + '</div>' + '</div>';
										$("#submenu5").append(fee_lines);
									}

									if (data.coupon_lines) {

										var coupon_lines = '<div class="row" '
												+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
												+ '<div class="col-md-4" >'
												+ '<p>Coupon_lines:</p>'
												+ '</div>'
												+ '<div class="col-md-8" >'
												+ '<p >'
												+ data.coupon_lines.length
												+ '</p>' + '</div>' + '</div>';
										$("#submenu5").append(coupon_lines);
									}

									if (data.coupon_lines) {

										if (data.refunds) {
											var refunds = '<div class="row" '
													+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
													+ '<div class="col-md-4" >'
													+ '<p>Refunds:</p>'
													+ '</div>'
													+ '<div class="col-md-8" >'
													+ '<p >'
													+ data.refunds.length
													+ '</p>' + '</div>'
													+ '</div>';
											$("#submenu5").append(refunds);
										}
									}

									$("#submenu6").empty();
									$
											.each(
													data._links,
													function(index, value) {

														var self = '<div class="row" '
																+ 'style="background: url(http://somesite.com/path/to/image.jpg);">'
																+ '<div class="col-md-12" >'
																+ '<p>'
																+ index
																+ ':</p>'
																+ '</div>';/*+
																	              '<div class="col-md-8" >'+
																	    		  		'<p >'+data.refunds.length+'</p>'+
																	    		  	'</div>'+ */

														$("#submenu6").append(
																self);

														$
																.each(
																		value,
																		function(
																				sindex,
																				svalue) {
																			//  alert( sindex + ": " + svalue["href"] );
																			//0: [object Object]

																			$
																					.each(
																							svalue,
																							function(
																									suindex,
																									suvalue) {
																								// alert( suindex + ": " + suvalue );
																								//href: http://localhost/mysite/wp-json/wc/v1/orders/187

																								//  alert( index +" : "+value+" : "+sindex+" : "+svalue+" : "+suindex +" : "+ suvalue);

																								var href = '<div class="col-md-12" >'
																										+ '<p >'
																										+ suindex
																										+ '</p>'
																										+ '</div>'
																										+ '<div class="col-md-12" >'
																										+ '<p >'
																										+ suvalue
																										+ '</p>'
																										+ '</div>';
																								$(
																										"#submenu6")
																										.append(
																												href);
																							});
																		});

													});
									$("#submenu6").append('</div>');

								},
								error : function(xhr) {
									//Do Something to handle error
									console.log("xhr error -> " + xhr);
								}
							});

				});

$(".btn-info").click(function() {

	$item = "72";
	console.log($item);
	$.ajax({
		type : "POST",
		url : "/submitidpro",
		data : {
			idval : $item
		}, // parameters
		success : function(data) {
			alert(data);
		}
	});
});

$(".btn-success").click(function() {
	location.reload();
});

$(document).ready(function() {
	$('#idtable').DataTable();
});
