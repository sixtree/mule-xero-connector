TESTING
This project also contains test classes that can be run as part of a test suite.

Importing the Cloud Connector into Mule Studio
Refer to documentation - Installing additional connectors: http://www.mulesoft.org/documentation/display/current/Additional+Cloud+Connectors

Add the Mule Xero Connector update site - MuleStudio > Help > Install New Software... - Click "Add" and enter, Name=Mule Xero Connector, Location=http://github.com/sixtree/mule-xero-connector/update-site

Install the Xero Connector - Select Connectors/Xero Mule Studio Extension then Click 'Next' - Review and Accept license details, then Click 'Finish'

Restart MuleStudio when prompted and your new Xero Cloud Connector should now be available under the 'Cloud Connectors' palette

Manually Building the Connector
Clone repository locally (git clone ...)

Set up a Xero developer account and register your application as a 'Private' application as per the steps outlined here:

http://developer.xero.com/api-overview/private-applications/

Next you'll need to authroise the Xero 'Demo' account to allow API access to your application, then... TBD
Usage Guide
-- Step 2 above

-- sample project.

-- screenshot of usage

-- mention that the api is XML based etc etc

TBC

ADDITIONAL RESOURCES
Everything you need to know about getting started with Mule can be found here: http://www.mulesoft.org/documentation/display/MULE3INTRO/Home

There further useful information about extending Mule here: http://www.mulesoft.org/documentation/display/DEVKIT/Home

Remember if you get stuck you can try getting help on the Mule user list: http://www.mulesoft.org/email-lists

Also, MuleSoft, the company behind Mule, offers 24x7 support options: http://www.mulesoft.com/enterprise-subscriptions-and-support

Enjoy your Mule ride!

The Mule Team