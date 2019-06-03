package service.AAADEVSESImagotag.HttpsMethods;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import com.avaya.collaboration.ssl.util.SSLProtocolType;
import com.avaya.collaboration.ssl.util.SSLUtilityException;
import com.avaya.collaboration.ssl.util.SSLUtilityFactory;

public class GetSES_imagotag {
	
	final SSLProtocolType protocolType;
	final SSLContext sslContext;
	
	public GetSES_imagotag() throws SSLUtilityException {
		protocolType = SSLProtocolType.TLSv1_2;
		sslContext = SSLUtilityFactory
				.createSSLContext(protocolType);
	}

	public JSONObject getSerchItems(String domain, String page, String pageSize, String ocpApimSubscriptionKey) throws JSONException{
		JSONObject json = null;
		try{
			
			final String URI = "https://api.ses-imagotag.com/pricing/v1/domains/"+domain+"/items?page="+page+"&pageSize="+pageSize;
			
			HttpClient client = HttpClients.custom().setSslcontext(sslContext)
					.setHostnameVerifier(new AllowAllHostnameVerifier())
					.build();
			HttpGet getMethod = new HttpGet(URI);
			
			getMethod.addHeader("Ocp-Apim-Subscription-Key", ocpApimSubscriptionKey);
			final HttpResponse response = client.execute(getMethod);

			final BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			final StringBuilder result = new StringBuilder();
			while ((line = inputStream.readLine()) != null) {
				result.append(line);
			}
			
			json = new JSONObject(result.toString());
			return json;
		}catch(Exception e){
			json.put("Error", e.toString());
			return json;
		}
	}
	
	public JSONObject getItemById(String id, String ocpApimSubscriptionKey, String domain) throws JSONException{
		JSONObject json = null;
		try{
			
			final String URI = "https://api.ses-imagotag.com/pricing/v1/domains/"+domain+"/items/"+id;
			
			HttpClient client = HttpClients.custom().setSslcontext(sslContext)
					.setHostnameVerifier(new AllowAllHostnameVerifier())
					.build();
			HttpGet getMethod = new HttpGet(URI);
			
			getMethod.addHeader("Ocp-Apim-Subscription-Key", ocpApimSubscriptionKey);
			final HttpResponse response = client.execute(getMethod);

			final BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			final StringBuilder result = new StringBuilder();
			while ((line = inputStream.readLine()) != null) {
				result.append(line);
			}
			
			json = new JSONObject(result.toString());
			return json;
		}catch(Exception e){
			json.put("Error", e.toString());
			return json;
		}
	}
}
