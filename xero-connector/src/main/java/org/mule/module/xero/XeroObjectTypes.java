package org.mule.module.xero;

public class XeroObjectTypes {
	
	public enum XeroGetType {
	    ACCOUNTS, 
	    BANKTRANSACTIONS, 
	    BRANDINGTHEMES, 
	    CONTACTS, 
	    CREDITNOTES, 
	    CURRENCIES, 
	    EMPLOYEES, 
	    EXPENSECLAIMS, 
	    INVOICES, 
	    ITEMS, 
	    JOURNALS, 
	    MANUALJOURNALS, 
	    ORGANISATION, 
	    PAYMENTS,
	    RECEIPTS,
	    REPORTS, 
	    TAXRATES, 
	    TRACKINGCATEGORIES, 
	    USERS;
	    
	    @Override public String toString() {
	    //only capitalize the first letter
	    String s = super.toString();
	    return s.substring(0, 1) + s.substring(1).toLowerCase();
	    }
	}
	
	public enum XeroPostType {
	    BANKTRANSACTIONS, 
	    CONTACTS, 
	    CREDITNOTES,  
	    EMPLOYEES, 
	    EXPENSECLAIMS, 
	    INVOICES, 
	    ITEMS, 
	    MANUALJOURNALS, 
	    RECEIPTS;
	    
	    @Override public String toString() {
	    //only capitalize the first letter
	    String s = super.toString();
	    return s.substring(0, 1) + s.substring(1).toLowerCase();
	    }
	}
	
	public enum XeroPutType {
	    BANKTRANSACTIONS, 
	    CONTACTS, 
	    CREDITNOTES,  
	    EMPLOYEES, 
	    EXPENSECLAIMS, 
	    INVOICES, 
	    ITEMS, 
	    MANUALJOURNALS, 
	    PAYMENTS,
	    RECEIPTS;
	    
	    @Override public String toString() {
	    //only capitalize the first letter
	    String s = super.toString();
	    return s.substring(0, 1) + s.substring(1).toLowerCase();
	    }
	}
	
	public enum XeroAllTypes {
	    ACCOUNTS, 
	    BANKTRANSACTIONS, 
	    BRANDINGTHEMES, 
	    CONTACTS, 
	    CREDITNOTES, 
	    CURRENCIES, 
	    EMPLOYEES, 
	    EXPENSECLAIMS, 
	    INVOICES, 
	    ITEMS, 
	    JOURNALS, 
	    MANUALJOURNALS, 
	    ORGANISATION, 
	    PAYMENTS,
	    RECEIPTS,
	    REPORTS, 
	    TAXRATES, 
	    TRACKINGCATEGORIES, 
	    USERS;
	    
	    @Override public String toString() {
	    //only capitalize the first letter
	    String s = super.toString();
	    return s.substring(0, 1) + s.substring(1).toLowerCase();
	    }
	}
}
