package wcadapter.clases;

import java.net.URLEncoder;

public class Functions {

	 public static boolean isNullOrEmpty(String str) {
	        if(str != null && !str.isEmpty())
	            return false;
	        return true;
	    }
	 
	 public static String EncodeJSON(String json) {
		 			
		 return URLEncoder.encode(json);
	 }

}
