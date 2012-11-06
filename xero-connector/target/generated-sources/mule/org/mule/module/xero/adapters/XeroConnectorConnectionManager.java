
package org.mule.module.xero.adapters;

import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.mule.api.Capabilities;
import org.mule.api.Capability;
import org.mule.api.ConnectionManager;
import org.mule.api.MuleContext;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.config.PoolingProfile;
import org.mule.module.xero.XeroConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A {@code XeroConnectorConnectionManager} is a wrapper around {@link XeroConnector } that adds connection management capabilities to the pojo.
 * 
 */
public class XeroConnectorConnectionManager
    implements Capabilities, ConnectionManager<XeroConnectorConnectionManager.ConnectionKey, XeroConnectorLifecycleAdapter> , MuleContextAware, Initialisable
{

    private String consumerKey;
    private String consumerSecret;
    private String privateKeyPath;
    private String xeroApiUrl;
    private static Logger logger = LoggerFactory.getLogger(XeroConnectorConnectionManager.class);
    /**
     * Mule Context
     * 
     */
    private MuleContext muleContext;
    /**
     * Flow construct
     * 
     */
    private FlowConstruct flowConstruct;
    /**
     * Connector Pool
     * 
     */
    private GenericKeyedObjectPool connectionPool;
    protected PoolingProfile connectionPoolingProfile;

    /**
     * Sets consumerKey
     * 
     * @param value Value to set
     */
    public void setConsumerKey(String value) {
        this.consumerKey = value;
    }

    /**
     * Retrieves consumerKey
     * 
     */
    public String getConsumerKey() {
        return this.consumerKey;
    }

    /**
     * Sets consumerSecret
     * 
     * @param value Value to set
     */
    public void setConsumerSecret(String value) {
        this.consumerSecret = value;
    }

    /**
     * Retrieves consumerSecret
     * 
     */
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    /**
     * Sets privateKeyPath
     * 
     * @param value Value to set
     */
    public void setPrivateKeyPath(String value) {
        this.privateKeyPath = value;
    }

    /**
     * Retrieves privateKeyPath
     * 
     */
    public String getPrivateKeyPath() {
        return this.privateKeyPath;
    }

    /**
     * Sets xeroApiUrl
     * 
     * @param value Value to set
     */
    public void setXeroApiUrl(String value) {
        this.xeroApiUrl = value;
    }

    /**
     * Retrieves xeroApiUrl
     * 
     */
    public String getXeroApiUrl() {
        return this.xeroApiUrl;
    }

    /**
     * Sets connectionPoolingProfile
     * 
     * @param value Value to set
     */
    public void setConnectionPoolingProfile(PoolingProfile value) {
        this.connectionPoolingProfile = value;
    }

    /**
     * Retrieves connectionPoolingProfile
     * 
     */
    public PoolingProfile getConnectionPoolingProfile() {
        return this.connectionPoolingProfile;
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        this.flowConstruct = flowConstruct;
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        this.muleContext = context;
    }

    public void initialise() {
        GenericKeyedObjectPool.Config config = new GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
        }
        connectionPool = new GenericKeyedObjectPool(new XeroConnectorConnectionManager.ConnectionFactory(this), config);
    }

    public XeroConnectorLifecycleAdapter acquireConnection(XeroConnectorConnectionManager.ConnectionKey key)
        throws Exception
    {
        return ((XeroConnectorLifecycleAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(XeroConnectorConnectionManager.ConnectionKey key, XeroConnectorLifecycleAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(XeroConnectorConnectionManager.ConnectionKey key, XeroConnectorLifecycleAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

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

    private static class ConnectionFactory
        implements KeyedPoolableObjectFactory
    {

        private XeroConnectorConnectionManager connectionManager;

        public ConnectionFactory(XeroConnectorConnectionManager connectionManager) {
            this.connectionManager = connectionManager;
        }

        public Object makeObject(Object key)
            throws Exception
        {
            if (!(key instanceof XeroConnectorConnectionManager.ConnectionKey)) {
                throw new RuntimeException("Invalid key type");
            }
            XeroConnectorLifecycleAdapter connector = new XeroConnectorLifecycleAdapter();
            connector.setConsumerKey(connectionManager.getConsumerKey());
            connector.setConsumerSecret(connectionManager.getConsumerSecret());
            connector.setPrivateKeyPath(connectionManager.getPrivateKeyPath());
            connector.setXeroApiUrl(connectionManager.getXeroApiUrl());
            if (connector instanceof Initialisable) {
                connector.initialise();
            }
            if (connector instanceof Startable) {
                connector.start();
            }
            return connector;
        }

        public void destroyObject(Object key, Object obj)
            throws Exception
        {
            if (!(key instanceof XeroConnectorConnectionManager.ConnectionKey)) {
                throw new RuntimeException("Invalid key type");
            }
            if (!(obj instanceof XeroConnectorLifecycleAdapter)) {
                throw new RuntimeException("Invalid connector type");
            }
            try {
                ((XeroConnectorLifecycleAdapter) obj).disconnect();
            } catch (Exception e) {
                throw e;
            } finally {
                if (((XeroConnectorLifecycleAdapter) obj) instanceof Stoppable) {
                    ((XeroConnectorLifecycleAdapter) obj).stop();
                }
                if (((XeroConnectorLifecycleAdapter) obj) instanceof Disposable) {
                    ((XeroConnectorLifecycleAdapter) obj).dispose();
                }
            }
        }

        public boolean validateObject(Object key, Object obj) {
            if (!(obj instanceof XeroConnectorLifecycleAdapter)) {
                throw new RuntimeException("Invalid connector type");
            }
            try {
                return ((XeroConnectorLifecycleAdapter) obj).isConnected();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return false;
            }
        }

        public void activateObject(Object key, Object obj)
            throws Exception
        {
            if (!(key instanceof XeroConnectorConnectionManager.ConnectionKey)) {
                throw new RuntimeException("Invalid key type");
            }
            if (!(obj instanceof XeroConnectorLifecycleAdapter)) {
                throw new RuntimeException("Invalid connector type");
            }
            try {
                if (!((XeroConnectorLifecycleAdapter) obj).isConnected()) {
                    ((XeroConnectorLifecycleAdapter) obj).connect();
                }
            } catch (Exception e) {
                throw e;
            }
        }

        public void passivateObject(Object key, Object obj)
            throws Exception
        {
        }

    }


    /**
     * A tuple of connection parameters
     * 
     */
    public static class ConnectionKey {


        public ConnectionKey() {
        }

        public int hashCode() {
            int hash = 1;
            return hash;
        }

        public boolean equals(Object obj) {
            return (obj instanceof XeroConnectorConnectionManager.ConnectionKey);
        }

    }

}
