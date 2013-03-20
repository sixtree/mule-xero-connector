Welcome
=======
This is a Mule cloud connector for Xero - www.xero.com

./pom.xml: A maven project descriptor that describes how to build this module.

./LICENSE.md: The open source license text for this project.

About this Cloud Connector
==========================
The Mule cloud connector for Xero is designed to interact with XML-formatted string objects. It expects to receive XML-formatted string objects as input, and will reply back with XML-formatted string objects which conform to the Xero API XML Schema Definitions available here: https://github.com/XeroAPI/XeroAPI-Schemas

For full details of the Xero API, refer to the Xero API reference - http://developer.xero.com/api/

For an example of how to use this connector, refer to the 'sample' project avaliable here: XXXX. The sample flows below can also be used as a guide

Importing the Cloud Connector into Mule Studio
==============================================
1. Refer to documentation - Installing additional connectors: 
http://www.mulesoft.org/documentation/display/current/Additional+Cloud+Connectors

2. Add the Mule Xero Connector update site - MuleStudio > Help > Install New Software... - Click "Add" and enter, Name=Mule Xero Connector, Location=http://github.com/sixtree/mule-xero-connector/update-site

3. Install the Xero Connector - Select Connectors/Xero Mule Studio Extension then Click 'Next' - Review and Accept license details, then Click 'Finish'

4. Restart MuleStudio when prompted and your new Xero Cloud Connector should now be available under the 'Cloud Connectors' palette

Usage
=====
1. Set up a Xero developer account and register your application as a 'Private' application as per the steps outlined here:
http://developer.xero.com/api-overview/private-applications/ - we recommend using the Xero 'Demo Company' account to avoid corrupting your organisations data while you are testing your integration.

Sample Get Xero Invoice flow:

![Sample Get Xero Invoice flow](/sample/img/XeroGetInvoiceSample.jpg)

Sample CreateInvoice:

![Sample Create Xero Invoice flow](/sample/img/XeroCreateInvoiceSample.jpg)

Manually Building the Connector
===============================
If you'd like to make your own modifications and/or you'd just like to rebuild this cloud connector, use the following steps.

1. Clone repository locally via the git clone command

2. Set up a Xero developer account and register your application as a 'Private' application as per the steps outlined here:
http://developer.xero.com/api-overview/private-applications/ - we recommend using the Xero 'Demo Company' account 
to avoid corrupting your organisations data while you are testing and rebuilding the cloud connector.

3. Create a file called 'xero.properties' under src/test/resources folder and include the following four properties:  
  - xero.consumerKey=[Your Xero Applications OAuth Consumer Key]
  - xero.consumerSecret=[Your Xero Applications OAuth Consumer Secret>]
  - xero.privateKeyFile=[The path to your Xero Applications private key (.pem) file]
  - xero.xeroApiUrl=https://api.xero.com/api.xro/2.0/

4. Follow the steps outlined at the following link in order to rebuild the connector:
http://www.mulesoft.org/documentation/display/DEVKIT/Your+First+Cloud+Connector

Testing
=======
This project also contains test classes that can be run as part of a test suite.

Additional Resources
====================
Everything you need to know about getting started with Mule can be found here: http://www.mulesoft.org/documentation/display/MULE3INTRO/Home

There further useful information about extending Mule here: http://www.mulesoft.org/documentation/display/DEVKIT/Home

Remember if you get stuck you can try getting help on the Mule user list: http://www.mulesoft.org/email-lists

Also, MuleSoft, the company behind Mule, offers 24x7 support options: http://www.mulesoft.com/enterprise-subscriptions-and-support

Enjoy your Mule ride!

The Mule Team
