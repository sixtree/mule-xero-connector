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
    private String xeroApiURL = "https://api.xero.com/api.xro/2.0/";

    /**
     * The OAuth Consumer Secret 
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
     *{@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-all-accounts}
     * 
     * getAllAccounts
     * @return - returns all accounts listed for the Xero domain.
     */    
    @Processor
    public String getAllAccounts()
    {
    	String accounts = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	accounts = xeroClient.getAllAccounts();

        return accounts;
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
    	String accountData = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	accountData = xeroClient.getAccount(accountId);
        
    	return accountData;
    }
    
    /**
     * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-all-invoices}
     * 
     * getAllInvoices
     * @return - returns all invoices listed for the Xero domain.
     */    
    @Processor
    public String getAllInvoices()
    {
    	String invoices = null;
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	invoices = xeroClient.getAllInvoices();

        return invoices;
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
    	String invoice = null;
        XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	invoice = xeroClient.getInvoice(invoiceId);

        return invoice;
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
    public String create(XeroObjectTypes.XeroAllTypes objectType, 
    					 String payload)
    {
    	XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiURL, consumerKey, consumerSecret, privateKeyLoc);
    	String createResponse = xeroClient.create(objectType, payload);    	
    	        
    	return createResponse;
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
