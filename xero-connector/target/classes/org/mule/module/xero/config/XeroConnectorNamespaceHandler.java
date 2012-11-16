
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
        registerBeanDefinitionParser("get-bank-transactions-list", new GetBankTransactionsListDefinitionParser());
        registerBeanDefinitionParser("get-branding-themes-list", new GetBrandingThemesListDefinitionParser());
        registerBeanDefinitionParser("get-contacts-list", new GetContactsListDefinitionParser());
        registerBeanDefinitionParser("get-credit-notes-list", new GetCreditNotesListDefinitionParser());
        registerBeanDefinitionParser("get-currencies-list", new GetCurrenciesListDefinitionParser());
        registerBeanDefinitionParser("get-employees-list", new GetEmployeesListDefinitionParser());
        registerBeanDefinitionParser("get-expense-claims-list", new GetExpenseClaimsListDefinitionParser());
        registerBeanDefinitionParser("get-invoices-list", new GetInvoicesListDefinitionParser());
        registerBeanDefinitionParser("get-items-list", new GetItemsListDefinitionParser());
        registerBeanDefinitionParser("get-journals-list", new GetJournalsListDefinitionParser());
        registerBeanDefinitionParser("get-manual-journals-list", new GetManualJournalsListDefinitionParser());
        registerBeanDefinitionParser("get-payments-list", new GetPaymentsListDefinitionParser());
        registerBeanDefinitionParser("get-receipts-list", new GetReceiptsListDefinitionParser());
        registerBeanDefinitionParser("get-tracking-categories-list", new GetTrackingCategoriesListDefinitionParser());
        registerBeanDefinitionParser("get-users-list", new GetUsersListDefinitionParser());
        registerBeanDefinitionParser("get-account", new GetAccountDefinitionParser());
        registerBeanDefinitionParser("get-bank-transaction", new GetBankTransactionDefinitionParser());
        registerBeanDefinitionParser("get-branding-theme", new GetBrandingThemeDefinitionParser());
        registerBeanDefinitionParser("get-contact", new GetContactDefinitionParser());
        registerBeanDefinitionParser("get-credit-note", new GetCreditNoteDefinitionParser());
        registerBeanDefinitionParser("get-employee", new GetEmployeeDefinitionParser());
        registerBeanDefinitionParser("get-expense-claim", new GetExpenseClaimDefinitionParser());
        registerBeanDefinitionParser("get-invoice", new GetInvoiceDefinitionParser());
        registerBeanDefinitionParser("get-item", new GetItemDefinitionParser());
        registerBeanDefinitionParser("get-journal", new GetJournalDefinitionParser());
        registerBeanDefinitionParser("get-manual-journal", new GetManualJournalDefinitionParser());
        registerBeanDefinitionParser("get-organisation", new GetOrganisationDefinitionParser());
        registerBeanDefinitionParser("get-payment", new GetPaymentDefinitionParser());
        registerBeanDefinitionParser("get-receipt", new GetReceiptDefinitionParser());
        registerBeanDefinitionParser("get-tax-rates", new GetTaxRatesDefinitionParser());
        registerBeanDefinitionParser("get-tracking-category", new GetTrackingCategoryDefinitionParser());
        registerBeanDefinitionParser("get-user", new GetUserDefinitionParser());
        registerBeanDefinitionParser("create", new CreateDefinitionParser());
        registerBeanDefinitionParser("update", new UpdateDefinitionParser());
    }

}
