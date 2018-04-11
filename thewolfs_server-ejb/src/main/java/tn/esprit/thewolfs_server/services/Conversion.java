package tn.esprit.thewolfs_server.services;

import java.net.URL;
import java.util.Scanner;

public class Conversion {
/*	public static Float converter(String ss) {
		  String info = "";
		  Float f = 0f;
		  try {
		   String s = "https://spreadsheets.google.com/feeds/list/0Av2v4lMxiJ1AdE9laEZJdzhmMzdmcW90VWNfUTYtM2c/2/public/basic?alt=json";
		   URL url1 = new URL(s);
		   Scanner scan = new Scanner(url1.openStream());
		   String str = new String();
		   while (scan.hasNext()) {
		    str += scan.nextLine();
		   }
		   scan.close();
		   JSONObject obj = (JSONObject) JSONValue.parse(str);
		   JSONObject obj1 = (JSONObject) obj.get("feed");
		   JSONArray jsar = new JSONArray();
		   jsar = (JSONArray) obj1.get("entry");
		   for (int i = 0; i < 89; i++) {
		    JSONObject obj2 = (JSONObject) jsar.get(i);
		    JSONObject obj3 = (JSONObject) obj2.get("content");
		    JSONObject obj4 = (JSONObject) obj2.get("title");
		    if (obj4.get("$t").equals(ss)) {
		     info = (String) obj3.get("$t");
		     System.out.println(info);
		     f = Float.valueOf(info.substring(8, info.length()));
		     return f;
		    }
		   }

		  } catch (IOException e) {
		  }
		  return f;
		 }*/
}
