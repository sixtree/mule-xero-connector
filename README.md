Welcome
=======
This is a Mule cloud connector for the Xero online accounting system - www.xero.com

About this Cloud Connector
==========================
The Mule cloud connector for Xero supports the following operations of the Xero API.

![Xero API Support](/doc/APISupportTable.jpg)

For full details of the Xero API, refer to the Xero API reference - http://developer.xero.com/api/

There are four types of operations supported by this cloud connector:

1. 'Get' a single Xero resource - Pass a unique resource identifier (such as an InvoiceNumber) as the input payload to a cloud connector operation (such as GetInvoice) to retrieve and XML-formatted string object representation of that resource.

2. 'Get' a list of Xero resources - Pass a request to a cloud connector operation with a blank payload to retrieve a list of Xero resources. Filter parameters can also be applied to requests to refine the returned list - refer to the Xero API reference for further details.

3. 'CreateOrUpdate' Xero resource(s) - When passed an XML-formatted string object(s), this operation will either 
  - Create a new Xero resource if a resource matching the input doesn't exist, or 
  - Update a Xero resource if a resource matching the input already exists 
The operation will then reply back with XML-formatted string response message.

4. 'Create' Xero resource(s) - When passed an XML-formatted string object(s), this operation will Create a new Xero resource (if a resource matching the input doesn't exist).

All resources supported by this cloud connector conform to the Xero API XML Schema Definitions available here: https://github.com/XeroAPI/XeroAPI-Schemas

For an example of how to use this connector, refer to the 'sample' project avaliable here: XXXX. The sample flows below can also be used as a guide

Importing the Cloud Connector into Mule Studio
==============================================
1. Refer to documentation - Installing additional connectors: 
http://www.mulesoft.org/documentation/display/current/Additional+Cloud+Connectors

2. Add the Mule Xero Connector update site - MuleStudio > Help > Install New Software... - Click "Add" and enter, Name=Mule Xero Connector, Location=XXXX

3. Install the Xero Connector - Select Connectors/Xero Mule Studio Extension then Click 'Next' - Review and Accept license details, then Click 'Finish'

4. Restart MuleStudio when prompted and your new Xero Cloud Connector should now be available under the 'Cloud Connectors' palette

Usage
=====
1. Set up a Xero developer account and register your application as a 'Private' application as per the steps outlined here:
http://developer.xero.com/api-overview/private-applications/ - we recommend using the Xero 'Demo Company' account to avoid corrupting your organisations data while you are testing your integration.

Sample Get Xero Invoice flow:

![Sample Get Xero Invoice flow](/sample/img/XeroGetInvoiceSample.jpg)

Sample Create Xero Invoice flow:

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
  - xero.consumerSecret=[Your Xero Applications OAuth Consumer Secret]
  - xero.privateKeyFile=[The path to your Xero Applications private key (.pem) file]
  - xero.xeroApiUrl=https://api.xero.com/api.xro/2.0/

4. Follow the steps outlined at the following link in order to rebuild the connector:
http://www.mulesoft.org/documentation/display/DEVKIT/Your+First+Cloud+Connector

Artefacts
=========
./pom.xml: A maven project descriptor that describes how to build this module.

./LICENSE.md: The open source license text for this project.

Testing
=======
This project also contains test classes that can be run as part of a test suite.
