package org.mule.module.xero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


import net.oauth.OAuth;
import net.oauth.OAuth.Parameter;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient3.HttpClient3;
import net.oauth.signature.RSA_SHA1;

public class XeroConnectorClient {
	
    private String xeroApiUrl;
    private String consumerKey;
    private String consumerSecret;
    private String privateKeyLoc;

    public XeroConnectorClient(String xeroApiUrl, String consumerKey, String consumerSecret, String privateKeyLoc) {
        this.xeroApiUrl = xeroApiUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.privateKeyLoc = privateKeyLoc;
    }
		
	//Sets up the OAuth accessor credentials to be passed in all requests to the Xero API
    public OAuthAccessor createOAuthAccessor() {

        OAuthConsumer consumer = new OAuthConsumer(null, consumerKey, null, null);
        
        //Load private key from File
        String privateKey = null;
        File keyFile = new File(privateKeyLoc);
        
        try{
        	
	        BufferedReader reader = new BufferedReader(new FileReader(keyFile));
	        StringBuilder stringBuilder = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            stringBuilder.append(line).append("\n");
	        }
	        privateKey = stringBuilder.toString();
        }
	    catch (FileNotFoundException fnf)
	    {
	    	
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        consumer.setProperty(RSA_SHA1.PRIVATE_KEY, privateKey);
        consumer.setProperty(OAuth.OAUTH_SIGNATURE_METHOD, OAuth.RSA_SHA1);

        OAuthAccessor accessor = new OAuthAccessor(consumer);
        accessor.accessToken = consumerKey;
        accessor.tokenSecret = consumerSecret;

        return accessor;
    }
	
	public String getAccountsList(String filterString) throws XeroConnectorClientException, XeroConnectorClientUnexpectedException
	{
		String responseString = null;
		String stringObjectType = "Accounts";
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			
			//Invoke Xero
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, createRequestUri(stringObjectType), addFilterParam(filterString));
			
			responseString = response.readBodyAsString();
			
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientException((OAuthProblemException) e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientUnexpectedException(e);
		}
		
		return responseString;
	}
	
	public String getInvoicesList(String filterString) throws XeroConnectorClientException, XeroConnectorClientUnexpectedException
	{
		String responseString = null;
		String stringObjectType = "Invoices"; 

		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			
			//Invoke Xero
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, createRequestUri(stringObjectType), addFilterParam(filterString));
			
			responseString = response.readBodyAsString();
			
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientException((OAuthProblemException) e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientUnexpectedException(e);
		}
		
		return responseString;
	}
	
	public String getAccount(String accountId) throws XeroConnectorClientException, XeroConnectorClientUnexpectedException
	{
		String responseString = null;
		String stringObjectType = "Accounts"; 
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, createRequestUri(stringObjectType) + "/" + accountId, null);
			
			responseString = response.readBodyAsString();
			
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientException((OAuthProblemException) e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientUnexpectedException(e);
		}
		
		return responseString;
	}
	
	public String getInvoice(String invoiceId) throws XeroConnectorClientException, XeroConnectorClientUnexpectedException
	{
		String responseString = null;
		String stringObjectType = "Invoices"; 
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, createRequestUri(stringObjectType) + "/" + invoiceId, null);
			
			responseString = response.readBodyAsString();
			
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientException((OAuthProblemException) e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientUnexpectedException(e);
		}
		
		return responseString;
	}
	
	public String create(XeroObjectTypes.XeroPostTypes objectType,
						 String payload) throws XeroConnectorClientException, XeroConnectorClientUnexpectedException
	{
		String responseString = null;
		String stringObjectType = objectType.toString();
				
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();			
			OAuthMessage response = client.invoke(accessor, OAuthMessage.POST, createRequestUri(stringObjectType), OAuth.newList("xml", payload));
			responseString = response.readBodyAsString();
			
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientException((OAuthProblemException) e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new XeroConnectorClientUnexpectedException(e);
		}
				
		return responseString;
	}
	
	public String createRequestUri(String objectType)
	{
		String fullApiUri = xeroApiUrl + objectType;	
		
		return fullApiUri;
	}
	
	public Collection<OAuth.Parameter> addFilterParam(String filterString)
	{
		Collection<OAuth.Parameter> parameters = new ArrayList<OAuth.Parameter>();
		Parameter whereClause = new Parameter("where", filterString);
		parameters.add(whereClause);	
		
		return parameters;
	}
}
