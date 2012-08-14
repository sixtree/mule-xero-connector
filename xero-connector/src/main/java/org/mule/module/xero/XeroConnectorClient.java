package org.mule.module.xero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


import net.oauth.OAuth;
import net.oauth.OAuth.Parameter;
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
	
	public String getInvoice(String invoiceId)
	{
		String invoiceData = null;
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();
			OAuthMessage response = client.invoke(accessor, OAuthMessage.GET, xeroApiUrl + "Invoices" + "/" + invoiceId, null);
			
			invoiceData = response.readBodyAsString();
			
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
		
		return invoiceData;
	}
	
	public String create(XeroObjectTypes.XeroAllTypes objectType,
						 String optionalPayload,
						 String payload)
	{
		String responseString = null;
		
		//Check if the user has configured the connector to pass data other than the message payload to the endpoint. 
		//If so, pass this data instead
		if (!optionalPayload.isEmpty())
		{
			payload = optionalPayload;
		}
		
		try {
			OAuthClient client = new OAuthClient(new HttpClient3());
			OAuthAccessor accessor = createOAuthAccessor();			
			OAuthMessage response = client.invoke(accessor, OAuthMessage.POST, setApiUrl(objectType), OAuth.newList("xml", payload));
			responseString = response.readBodyAsString();
			
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
				
		return responseString;
	}
	
	public String setApiUrl (XeroObjectTypes.XeroAllTypes objectType)
	{
		String fullApiUri = null;
		
		switch (objectType) {
        case ACCOUNTS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.ACCOUNTS.toString();
                 break;
        case BANKTRANSACTIONS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.BANKTRANSACTIONS.toString();
                 break;
        case BRANDINGTHEMES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.BRANDINGTHEMES.toString();
                 break;
        case CONTACTS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.CONTACTS.toString();
        		break;
        case CREDITNOTES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.CREDITNOTES.toString();
				break;
        case CURRENCIES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.CURRENCIES.toString();
				break;
        case EMPLOYEES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.EMPLOYEES.toString();
				break;
        case EXPENSECLAIMS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.EXPENSECLAIMS.toString();
				break;
        case INVOICES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.INVOICES.toString();
				break;
        case ITEMS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.ITEMS.toString();
				break;
        case JOURNALS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.JOURNALS.toString();
				break;
        case MANUALJOURNALS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.MANUALJOURNALS.toString();
				break;
        case ORGANISATION:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.ORGANISATION.toString();
				break;
        case PAYMENTS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.PAYMENTS.toString();
				break;
        case RECEIPTS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.RECEIPTS.toString();
				break;
        case REPORTS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.REPORTS.toString();
				break;
        case TAXRATES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.TAXRATES.toString();
				break;
        case TRACKINGCATEGORIES:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.TRACKINGCATEGORIES.toString();
				break;
        case USERS:  fullApiUri = xeroApiUrl + XeroObjectTypes.XeroAllTypes.USERS.toString();
				break;
        default: fullApiUri = "xeroApiUrl";
                break;
		}
		
		return fullApiUri;
	}
}
