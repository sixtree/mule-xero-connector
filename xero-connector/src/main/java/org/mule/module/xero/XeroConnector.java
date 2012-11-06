/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module.xero;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.param.Payload;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;

/**
 * Cloud Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="xero", schemaVersion="1.0")
public class XeroConnector
{
    /**
     * Configurable
     */
    @Configurable
    private String consumerKey;
    /**
     * Configurable
     */
    @Configurable
    private String consumerSecret;
    /**
     * Configurable
     */
    @Configurable
    private String privateKeyLoc;
    
    /**
     * Configurable
     */
    @Configurable 
    @Optional
    @Default("https://api.xero.com/api.xro/2.0/") 
    private String xeroApiURL;

    /**
     * The OAuth Consumer Key 
     * @param consumerKey Consumer Key
     */
    public void setConsumerKey(String consumerKey)
    {
        this.consumerKey = consumerKey;
    }
    
	/** 
	 * The OAuth Consumer Secret  
	 * @param consumerSecret Consumer Secret
	 * */
    public void setConsumerSecret(String consumerSecret)
    {
        this.consumerSecret = consumerSecret;
    }
    
    /** 
	 * The location of the private key file  
	 * @param privateKeyLoc Private Key File
	 * */
    public void setPrivateKeyLoc(String privateKeyLoc)
    {
        this.privateKeyLoc = privateKeyLoc;
    }
    
    /**
     * The Xero API URL 
     * @param xeroApiURL Xero API URL
     */
    public void setXeroApiURL(String xeroApiURL)
    {
        this.xeroApiURL = xeroApiURL;
    }

    /**
     *{@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-accounts-list}
     * 
     * getAccountsList
     * @param filterString filter string used to filter query results from Xero
     * @return - returns all accounts listed for the Xero domain.
     */    
    @Processor
    public String getAccountsList(@Optional String filterString)
    {
    	String response = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	try {
    		response = xeroClient.getAccountsList(filterString);
		} catch (XeroConnectorClientException e) {
			// TODO Auto-generated catch block
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

        return response;
    }
    
    /**
     * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-account}
     * 
     * getAccount
     * @param accountId a unique Xero account id
     * @return - returns details of an individual account
     */
    @Processor
    public String getAccount(String accountId)
    {
    	String response = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	try {
    		response = xeroClient.getAccount(accountId);
		} catch (XeroConnectorClientException e) {
			// TODO Auto-generated catch block
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
    	return response;
    }
    
    /**
     * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-invoices-list}
     * 
     * getInvoicesList
     * @param filterString filter string used to filter query results from Xero
     * @return - returns all invoices listed for the Xero domain.
     */    
    @Processor
    public String getInvoicesList(@Optional String filterString)
    {
    	String response = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	try {
    		response = xeroClient.getInvoicesList(filterString);
		} catch (XeroConnectorClientException e) {
			// TODO Auto-generated catch block
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

        return response;
    }
    
    /**
     * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-invoice}
     * 
     * getInvoice
     * @param invoiceId a unique Xero invoice id
     * @return - returns details of an individual invoice
     */
    @Processor
    public String getInvoice(String invoiceId)
    {
    	String response = null;
        XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	try {
    		response = xeroClient.getInvoice(invoiceId);
		} catch (XeroConnectorClientException e) {
			// TODO Auto-generated catch block
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

        return response;
    }
    
    /**
     * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:create}
     * 
     * create
     * @param objectType The type of object to be created in Xero
     * @param payload The content of the object to be created in Xero
     * @return - returns the status of the create request
     */
    @Processor
    public String create(XeroObjectTypes.XeroPostTypes objectType, 
    					 String payload)
    {
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	String response = null;
		try {
			response = xeroClient.create(objectType, payload);
		} catch (XeroConnectorClientException e) {
			// TODO Auto-generated catch block
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	        
    	return response;
    }
    
    
    /*************************************************************************
     * Skeleton methods below required for Maven build - not used by connector
     ************************************************************************/
    
    /**
     * Connect
     *
     * @throws ConnectionException
     */
    @Connect
    public void connect()
        throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES IN HERE
         */
    }
    
    @ValidateConnection
    public boolean isConnected() {
		return false;
    	
    }

    @ConnectionIdentifier
    public String getSessionId() {
		String sessionId = null;
    	
    	return sessionId; 
    
    }
}
