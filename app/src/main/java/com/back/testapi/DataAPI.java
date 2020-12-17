import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataAPI

{

    JsonReader j
    JSObject json;

    DataAPI(String r){
        j== new JsonReader();

        String s="https://api.upcitemdb.com/prod/trial/search?s=";
        String e="&match_mode=1&type=product"

        JSONObject json = j.readJsonFromUrl(s+r+e);

    }

       Public ArrayList<HashMap<String,Object>> getData()
    {
        ArrayList<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();

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
    return h;
}