package org.mule.module.xero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;


import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
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
	
	public String getAllAccounts()
	{
		String accounts = null;
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, xeroApiUrl + "Accounts", null);
			
			accounts = response.readBodyAsString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public String getAllInvoices()
	{
		String accounts = null;
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, xeroApiUrl + "Invoices", null);
			
			accounts = response.readBodyAsString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public String getAccount(String accountId)
	{
		String accountData = null;
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, xeroApiUrl + "Accounts" + "/" + accountId, null);
			
			accountData = response.readBodyAsString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountData;
	}
	

}
