/**
 * This file was automatically generated by the Mule Development Kit
 */
package au.com.sixtree.mule.modules.xero;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Xero Cloud Connector for Mule
 * 
 * @author Sixtree
 */
@Connector(name = "xero", schemaVersion = "1.0")
public class XeroConnector {
	
	private static final String XERO_BASE_ENDPOINT = "https://api.xero.com/api.xro/2.0/";

	/**
	 * Xero Account Consumer Key
	 */
	@Configurable
	private String consumerKey;
	
	/**
	 * Xero Account Consumer Secret
	 */
	@Configurable	
	private String consumerSecret;
	
	/**
	 * Local path to Xero Account Private Key File
	 */
	@Configurable
	private String privateKeyFile;

	/**
	 * The base Xero API URI. Defaults to https://api.xero.com/api.xro/2.0/ if
	 * left blank
	 */
	@Configurable
	@Optional
	@Default(XERO_BASE_ENDPOINT)
	private String xeroApiUrl;

	
	/**
	 * Sets the OAuth Consumer Key
	 * 
	 * @param consumerKey
	 *            Consumer Key
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * Gets the OAuth Consumer Key
	 * 
	 * @return the Consumer Key
	 */
	public String getConsumerKey() {
		return this.consumerKey;
	}
	
	/**
	 * Gets the OAuth Consumer Secret
	 * 
	 * @param consumerSecret
	 *            Consumer Secret
	 * */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	/**
	 * Sets the OAuth Consumer Secret
	 * 
	 * @return the Consumer Secret
	 */
	public String getConsumerSecret() {
		return this.consumerSecret;
	}

	/**
	 * Sets the location of the private key file
	 * 
	 * @param privateKeyFile
	 *            Private Key File
	 * */
	public void setPrivateKeyFile(String privateKeyFile) {
		this.privateKeyFile = privateKeyFile;
	}

	/**
	 * Gets the location of the private key file
	 * 
	 * @return the Private Key File
	 */
	public String getPrivateKeyFile() {
		return this.privateKeyFile;
	}

	/**
	 * Sets the Xero API URL - defaults to https://api.xero.com/api.xro/2.0/
	 * 
	 * @param xeroApiUrl
	 *            Xero API URL
	 */
	public void setXeroApiUrl(String xeroApiUrl) {
		this.xeroApiUrl = xeroApiUrl;
	}

	/**
	 * Gets the Xero API URL - defaults to https://api.xero.com/api.xro/2.0/
	 * 
	 * @return the Xero API URL
	 */
	public String getXeroApiUrl() {
		return this.xeroApiUrl;
	}

	/**
	 * Retrieve the list of accounts from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-accounts-list}
	 *
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)	 
	 * @return list of accounts for the Xero domain.
	 */
	@Processor
	public String getAccountsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Accounts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl, 
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, 
					whereClause, orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/** 
	 * Retrieve the list of bank transactions from Xero.
	 *  
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-bank-transactions-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of bank transactions for the Xero domain.
	 */
	@Processor
	public String getBankTransactionsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "BankTransactions";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve the list of Branding Themes from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-branding-themes-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information) 
	 * @return list of branding themes for the Xero domain.
	 */
	@Processor
	public String getBrandingThemesList(@Optional String whereClause, 
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "BrandingThemes";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve the list of Contacts from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-contacts-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of contacts for the Xero domain.
	 */
	@Processor
	public String getContactsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Contacts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Credit Notes from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-credit-notes-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of credit notes for the Xero domain.
	 */
	@Processor
	public String getCreditNotesList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "CreditNotes";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Currencies from Xero.
	 *  
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-currencies-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of currencies for the Xero domain.
	 */
	@Processor
	public String getCurrenciesList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Currencies";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Employees from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-employees-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of employees for the Xero domain.
	 */
	@Processor
	public String getEmployeesList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Employees";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	 /**
	 * Retrieve a list of Expense Claims from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-expense-claims-list}
	 *
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of expense claims for the Xero domain.
	 */
	 @Processor
	 public String getExpenseClaimsList(@Optional String whereClause, 
			 @Optional String orderBy) {
		 
		 String response = null;
		 String objectType = "ExpenseClaims";
		 XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl, 
				 consumerKey, consumerSecret, privateKeyFile);

		 try {
			 response = xeroClient.getXeroObjectList(objectType, whereClause, 
					 orderBy);
		 } catch (XeroConnectorClientException e) {
			 return e.getXeroException();
		 } catch (XeroConnectorClientUnexpectedException e) {
			 throw new RuntimeException(e);
		 }
	
		 return response;
	 
	 }

	/**
	 * Retrieve a list of Invoices from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-invoices-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of invoices for the Xero domain.
	 */
	@Processor
	public String getInvoicesList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Invoices";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Items from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-items-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of items for the Xero domain.
	 */
	@Processor
	public String getItemsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Items";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Journals from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-journals-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of journals for the Xero domain.
	 */
	@Processor
	public String getJournalsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Journals";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Manual Journals from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-manual-journals-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of manual journals for the Xero domain.
	 */
	@Processor
	public String getManualJournalsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "ManualJournals";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}
	

	/**
	 * Retrieve a list of Payments from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-payments-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of payments for the Xero domain.
	 */
	@Processor
	public String getPaymentsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Payments";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Receipts from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-receipts-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of receipts for the Xero domain.
	 */
	@Processor
	public String getReceiptsList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Receipts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	// TODO Add reports operation

	/**
	 * Retrieve a list of Tracking Categories from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-receipts-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of tracking categories for the Xero domain.
	 */
	@Processor
	public String getTrackingCategoriesList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "TrackingCategories";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve a list of Users from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-users-list}
	 * 
	 * @param whereClause
	 *            filter string used to filter query results from Xero (refer to  
	 *            documentation on Xero filters for further information)
	 * @param orderBy
	 *            filter string used to order results returned from Xero (refer to 
	 *            documentation on Xero ordering-of-results for further information)
	 * @return list of users for the Xero domain.
	 */
	@Processor
	public String getUsersList(@Optional String whereClause,
			@Optional String orderBy) {
		
		String response = null;
		String objectType = "Users";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObjectList(objectType, whereClause,
					orderBy);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Account from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-account}
	 * 
	 * @param accountId
	 *            a unique Xero account id
	 * @return details of an individual account
	 */
	@Processor
	public String getAccount(
			@Optional @Default("#[message.payload]") String accountId) {
		
		String response = null;
		String objectType = "Accounts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, accountId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Bank Transaction from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-bank-transaction}
	 * 
	 * @param bankTransactionId
	 *            a unique Xero bank transaction id
	 * @return details of an individual bank transaction
	 */
	@Processor
	public String getBankTransaction(
			@Optional @Default("#[message.payload]") String bankTransactionId) {
		
		String response = null;
		String objectType = "BankTransactions";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, bankTransactionId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Branding Theme from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-branding-theme}
	 * 
	 * @param brandingThemeId
	 *            a unique Xero branding theme id
	 * @return details of an individual branding theme
	 */
	@Processor
	public String getBrandingTheme(
			@Optional @Default("#[message.payload]") String brandingThemeId) {
		
		String response = null;
		String objectType = "BrandingThemes";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, brandingThemeId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Contact from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-contact}
	 * 
	 * @param contactId
	 *            a unique Xero contact id
	 * @return details of an individual contact
	 */
	@Processor
	public String getContact(
			@Optional @Default("#[message.payload]") String contactId) {
		
		String response = null;
		String objectType = "Contacts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, contactId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Credit Note from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-credit-note}
	 * 
	 * @param creditNoteId
	 *            a unique Xero credit note id
	 * @return details of an individual credit note
	 */
	@Processor
	public String getCreditNote(
			@Optional @Default("#[message.payload]") String creditNoteId) {
		
		String response = null;
		String objectType = "CreditNotes";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, creditNoteId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Employee from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-employee}
	 *
	 * @param employeeId
	 *            a unique Xero employee id
	 * @return details of an individual employee
	 */
	@Processor
	public String getEmployee(
			@Optional @Default("#[message.payload]") String employeeId) {
		
		String response = null;
		String objectType = "Employees";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, employeeId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Expense Claim from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-expense-claim}
	 * 
	 * @param expenseClaimId
	 *            a unique Xero expense claim id
	 * @return details of an individual expense claim
	 */
	@Processor
	public String getExpenseClaim(
			@Optional @Default("#[message.payload]") String expenseClaimId) {
		
		String response = null;
		String objectType = "ExpenseClaims";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, expenseClaimId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Invoice from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-invoice}
	 * 
	 * @param invoiceId
	 *            a unique Xero invoice id
	 * @return details of an individual invoice
	 */
	@Processor
	public String getInvoice(
			@Optional @Default("#[message.payload]") String invoiceId) {
		
		String response = null;
		String objectType = "Invoices";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, invoiceId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details of the specified Item from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-item}
	 * 
	 * @param itemId
	 *            a unique Xero item id
	 * @return details of an individual item
	 */
	@Processor
	public String getItem(@Optional @Default("#[message.payload]") String itemId) {
		String response = null;
		String objectType = "Items";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		try {
			response = xeroClient.getXeroObject(objectType, itemId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	}

	/**
	 * Retrieve details for the specified Journal from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-journal}
	 * 
	 * @param journalId
	 *            a unique Xero journal id
	 * @return details of a journal item
	 */
	@Processor
	public String getJournal(
			@Optional @Default("#[message.payload]") String journalId) {
		
		String response = null;
		String objectType = "Journals";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, journalId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Manual Journal from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-manual-journal}
	 * 
	 * @param manualJournalId
	 *            a unique Xero manual journal id
	 * @return details of a manual journal
	 */
	@Processor
	public String getManualJournal(
			@Optional @Default("#[message.payload]") String manualJournalId) {
		
		String response = null;
		String objectType = "ManualJournals";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, manualJournalId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Organisation from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-organisation}
	 * 
	 * @return details of a Xero organisation
	 */
	@Processor
	public String getOrganisation() {
		
		String response = null;
		String objectType = "Organisation";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Payment from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-payment}
	 * 
	 * @param paymentId
	 *            a unique Xero payment id
	 * @return details of a Xero payment
	 */
	@Processor
	public String getPayment(
			@Optional @Default("#[message.payload]") String paymentId) {
		
		String response = null;
		String objectType = "Payments";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, paymentId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Receipt from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-receipt}
	 * 
	 * @param receiptId
	 *            a unique Xero payment id
	 * @return details of a Xero receipt
	 */
	@Processor
	public String getReceipt(
			@Optional @Default("#[message.payload]") String receiptId) {
		
		String response = null;
		String objectType = "Receipts";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, receiptId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	// TODO Add Reports Operation

	/**
	 * Retrieve a list of Tax Rates from Xero. 
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-tax-rates}
	 * 
	 * @return details of a Xero organisations tax rates
	 */
	@Processor
	public String getTaxRates() {
		
		String response = null;
		String objectType = "TaxRates";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified Tracking Category from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-tracking-category}
	 * 
	 * @param trackingCategoryId
	 *            a unique Xero tracking category id
	 * @return details of a Xero tracking category
	 */
	@Processor
	public String getTrackingCategory(
			@Optional @Default("#[message.payload]") String trackingCategoryId) {
		
		String response = null;
		String objectType = "TrackingCategories";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, trackingCategoryId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Retrieve details for the specified User from Xero.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:get-user}
	 * 
	 * @param userId
	 *            a unique Xero tracking category id
	 * @return details of a Xero user
	 */
	@Processor
	public String getUser(@Optional @Default("#[message.payload]") String userId) {
		
		String response = null;
		String objectType = "Users";
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		
		try {
			response = xeroClient.getXeroObject(objectType, userId);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Create the specified Xero entity.
	 * 
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:create}
	 * 
	 * @param objectType
	 *            The type of object to be created in Xero.
	 *            Can be one of: {@link XeroObjectTypes.XeroPutTypes}
	 * @param payload
	 *            The content of the object to be created in Xero
	 * @return status of the create request
	 */
	@Processor
	public String create(XeroObjectTypes.XeroPutTypes objectType,
			@Optional @Default("#[message.payload]") String payload) {
		
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		String response = null;
		
		try {
			response = xeroClient.createXeroObject(objectType, payload);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}

	/**
	 * Update (or Create if doesn't exist) the specified Xero entity.
	 *  
	 * {@sample.xml ../../../doc/Xero-connector.xml.sample xero:create-or-update}
	 * 
	 * @param objectType
	 *            The type of object to be either created or updated in Xero. 
	 *            Can be one of: {@link XeroObjectTypes.XeroPostTypes}
	 * @param payload
	 *            The content of the object to be either created or updated in
	 *            Xero 
	 * @return status of the createOrUpdate request
	 */
	@Processor
	public String createOrUpdate(XeroObjectTypes.XeroPostTypes objectType,
			@Optional @Default("#[message.payload]") String payload) {
		
		XeroConnectorClient xeroClient = new XeroConnectorClient(xeroApiUrl,
				consumerKey, consumerSecret, privateKeyFile);
		String response = null;
		
		try {
			response = xeroClient.updateXeroObject(objectType, payload);
		} catch (XeroConnectorClientException e) {
			return e.getXeroException();
		} catch (XeroConnectorClientUnexpectedException e) {
			throw new RuntimeException(e);
		}

		return response;
	
	}


}
