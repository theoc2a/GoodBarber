package testapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class main {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
		
		JsonReader j= new JsonReader();
		JSONObject json = j.readJsonFromUrl("https://cdn.discordapp.com/attachments/788813841718444072/789139761792548894/api_17_12_2020.json");
	    System.out.println(json.toString());
	    
	    ArrayList<HashMap<String,Object>> data =new ArrayList<HashMap<String,Object>>();
	   // System.out.println(( json.getJSONArray("items").getJSONObject(0).get("title")));
	    	for (int i=0;i<json.getJSONArray("items").length();i++) {
	    		HashMap<String,Object> h=new HashMap<String,Object>();
	    		JSONObject item=json.getJSONArray("items").getJSONObject(i);
	    		h.put("title", item.get("title"));
	    		h.put("upc", item.get("upc"));
	    		System.out.println(( item.get("title")));
	    		System.out.println(( item.get("upc")));
	    		HashMap<String,Object> h2=new HashMap<String,Object>();
	    		
	    		for (int i2=0;i2<item.getJSONArray("offers").length();i2++) {
	    			JSONObject offer=item.getJSONArray("offers").getJSONObject(i2);
	    			h2.put("merchant", offer.get("merchant"));
	    			System.out.println(offer.get("merchant"));
	    			h2.put("price", offer.get("price"));
	    			System.out.println(offer.get("price"));
	    			h.put("offers", h2);
	    		}
	    		data.add(h);
	    		System.out.println(((HashMap) h.get("offers")).get("price"));	
	    	}
	    	
	    	for(int i=0;i<data.size();i++) {
	    		
	    		System.out.println(data.get(i).get("title"));
	    		System.out.println(data.get(i).get("upc"));
	    		System.out.println(((HashMap) data.get(i).get("offers")).get("price"));
	    	}

	  
	    

	}
}
