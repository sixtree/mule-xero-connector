
package org.mule.module.xero.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/xero</code>.
 * 
 */
public class XeroConnectorNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new XeroConnectorConfigDefinitionParser());
        registerBeanDefinitionParser("get-accounts-list", new GetAccountsListDefinitionParser());
        registerBeanDefinitionParser("get-account", new GetAccountDefinitionParser());
        registerBeanDefinitionParser("get-invoices-list", new GetInvoicesListDefinitionParser());
        registerBeanDefinitionParser("get-invoice", new GetInvoiceDefinitionParser());
        registerBeanDefinitionParser("create", new CreateDefinitionParser());
    }

}
