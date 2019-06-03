package service.AAADEVSESImagotag.HttpsMethods;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.avaya.collaboration.ssl.util.SSLProtocolType;
import com.avaya.collaboration.ssl.util.SSLUtilityException;
import com.avaya.collaboration.ssl.util.SSLUtilityFactory;

public class PostSES_imagotag {

	final SSLProtocolType protocolType;
	final SSLContext sslContext;

	public PostSES_imagotag() throws SSLUtilityException {
		protocolType = SSLProtocolType.TLSv1_2;
		sslContext = SSLUtilityFactory.createSSLContext(protocolType);
	}

	public JSONObject postModifyItem(String domain,
			String ocpApimSubscriptionKey, String id, String price, String name)
			throws JSONException {
		JSONObject json = null;
		try {
			final String URI = "https://api.ses-imagotag.com/pricing/v1/domains/"
					+ domain + "/items";

			final HttpClient client = HttpClients.custom()
					.setSslcontext(sslContext)
					.setHostnameVerifier(new AllowAllHostnameVerifier())
					.build();

			final HttpPost postMethod = new HttpPost(URI);

			postMethod.addHeader("Ocp-Apim-Subscription-Key",
					ocpApimSubscriptionKey);
			postMethod.addHeader("Content-Type", "application/octet-stream");

			final String messageBody = "[\n"
	                + "{\n"
	                + "    \"id\": \""+id+"\", \n"
	                + "    \"name\": \""+name+"\",\n"
	                + "    \"price\" : "+Float.parseFloat(price)+"\n"
	                + "}    \n"
	                + "]";

			final StringEntity entity = new StringEntity(messageBody);
			postMethod.setEntity(entity);

			final HttpResponse response = client.execute(postMethod);

			final BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			final StringBuilder result = new StringBuilder();
			while ((line = inputStream.readLine()) != null) {
				result.append(line);
			}

			json = new JSONObject(result.toString());

			return json;

		} catch (Exception e) {
			json.put("Error", e.toString());
			return json;
		}

	}
}
