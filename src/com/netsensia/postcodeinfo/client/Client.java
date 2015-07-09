package com.netsensia.postcodeinfo.client;

import java.io.*;
import java.util.ArrayList;

import org.json.*;
import org.apache.http.Header;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.message.BasicHeader;

import com.netsensia.postcodeinfo.client.model.Address;
import com.netsensia.postcodeinfo.client.model.LocalAuthority;
import com.netsensia.postcodeinfo.client.model.Point;
import com.netsensia.postcodeinfo.client.model.Postcode;

public class Client {

	private String apiKey;
	
	private String endpoint;
	
	public Client(String apiKey, String endpoint) {
		this.apiKey = apiKey;
		this.endpoint = endpoint;
	}
	
	/**
	 * Lookup information for the given postcode
     * and return the contents in a Postcode object
     * 
	 * @param postcodeString
	 * @return Postcode
	 */
	public Postcode lookupPostcode(String postcodeString) throws IOException {
		
		Postcode postcode = new Postcode();
		
		String path = endpoint + "/addresses/?postcode=" + postcodeString.replaceAll("\\s+","");

		Header header = new BasicHeader("Authorization", "Token " + apiKey);
		Request request = Request.Get(path).addHeader(header);
		Response response = request.execute();
		Content content = response.returnContent();
		
		JSONArray jsonArray = new JSONArray(content.toString());
		
		if (jsonArray.length() > 0) {
			postcode.setValid(true);
			
			for (int i=0; i<jsonArray.length(); i++) {
				Address address = new Address();
				JSONObject jo = jsonArray.getJSONObject(i);
				
				address.setUprn(jo.getString("uprn"));
				address.setThoroughfareName(jo.getString("thoroughfare_name"));
				address.setOrganisationName(jo.getString("organisation_name"));
				address.setDepartmentName(jo.getString("department_name"));
				address.setPoBoxNumber(jo.getString("po_box_number"));
				address.setBuildingName(jo.getString("building_name"));
				address.setSubBuildingName(jo.getString("sub_building_name"));

				try {
					address.setBuildingNumber(jo.getInt("building_number"));
				} catch (JSONException e) {	}
					
				address.setDependentLocality(jo.getString("dependent_locality"));
				address.setDoubleDependentLocality(jo.getString("double_dependent_locality"));
				address.setPostTown(jo.getString("post_town"));
				address.setPostcode(jo.getString("postcode"));
				address.setPostcodeType(jo.getString("postcode_type"));
				address.setFormattedAddress(jo.getString("formatted_address"));
				
				JSONObject jsonPoint = jo.getJSONObject("point");
				
				address.setPoint(createPointFromJson(jsonPoint));
				postcode.addAddress(address);
			}
			
			postcode = addGeneralInformation(postcode, postcodeString);
			
		} else {
			postcode.setValid(false);
		}
		
		return postcode;
		
	}
	
	private Postcode addGeneralInformation(Postcode postcode, String postcodeString) throws IOException {
		
		String path = endpoint + "/postcodes/" + postcodeString.replaceAll("\\s+","") + "/";

		Header header = new BasicHeader("Authorization", "Token " + apiKey);
		Request request = Request.Get(path).addHeader(header);
		Response response = request.execute();
		Content content = response.returnContent();
		
		JSONObject jsonObject = new JSONObject(content.toString());

		JSONObject jsonPoint = jsonObject.getJSONObject("centre");
		postcode.setCentrePoint(createPointFromJson(jsonPoint));
		
		try {
			JSONObject jsonLocalAuth = jsonObject.getJSONObject("local_authority");
			LocalAuthority localAuthority = new LocalAuthority();
			
			localAuthority.setName(jsonLocalAuth.getString("name"));
			localAuthority.setGssCode(jsonLocalAuth.getString("gss_code"));
			
			postcode.setLocalAuthority(localAuthority);
		} catch (JSONException e) { }
		
		return postcode;
		
	}

	private Point createPointFromJson(JSONObject jsonPoint) {
		Point point = new Point();
		point.setType(jsonPoint.getString("type"));
		
		JSONArray coords = jsonPoint.getJSONArray("coordinates");
		
		point.setLatitude(coords.getDouble(0));
		point.setLongitude(coords.getDouble(1));
		
		return point;
	}

}
