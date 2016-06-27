package com.qianfeng.android.day15_listviewandjson.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qianfeng.android.day15_listviewandjson.bean.Company;

public class JsonUtils {
	
	public static List<Company> parseJson(String jsonString){
		List<Company> list=new ArrayList<Company>();
		try {
			JSONObject jsonObject=new JSONObject(jsonString);
			JSONArray jsonArray=jsonObject.getJSONArray("results");
			
			for(int i=0; i< jsonArray.length();i++){
				JSONObject jsonObject2=jsonArray.getJSONObject(i);
				String name=jsonObject2.getString("namecn");
				String icon=jsonObject2.getString("titleimg");
				
				Company company=new Company(icon, name);
				list.add(company);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
