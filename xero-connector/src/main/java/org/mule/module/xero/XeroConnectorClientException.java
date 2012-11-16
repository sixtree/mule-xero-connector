package org.mule.module.xero;

import java.util.Map;

/**
 * @author Andy Evans on behalf of Sixtree
 *
 */

import net.oauth.OAuthException;
import net.oauth.OAuthProblemException;
import net.oauth.http.HttpMessage;

public class XeroConnectorClientException extends Exception {
	
	private String xeroException = null;
	
	public XeroConnectorClientException(OAuthProblemException oAuthProblemException) {
		// TODO Auto-generated constructor stub
		super(oAuthProblemException);
		
        String oAuthProblemExceptionString = null;
        Map<String, Object> params = oAuthProblemException.getParameters();
        for (String key : params.keySet()) {
            if (key.contains("ApiException")) {
                Object o = params.get(key);
                oAuthProblemExceptionString = key + "=" + o.toString();
                xeroException = oAuthProblemExceptionString;
            }    
        }
        
        if (xeroException == null && (oAuthProblemException.getHttpStatusCode()!=200)){
        	throw new RuntimeException(oAuthProblemException);
        	//xeroException = (String) oAuthProblemException.getParameters().get(HttpMessage.RESPONSE);
        }
	}
	
	public String getXeroException(){
		return xeroException;		
	}
}

