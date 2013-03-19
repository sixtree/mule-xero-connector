
package org.mule.module.xero.adapters;

import org.mule.api.Capabilities;
import org.mule.api.Capability;


/**
 * A <code>XeroConnectorCapabilitiesAdapter</code> is a wrapper around {@link org.mule.module.xero.XeroConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
public class XeroConnectorCapabilitiesAdapter
    extends org.mule.module.xero.XeroConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(Capability capability) {
        if (capability == Capability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == Capability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
