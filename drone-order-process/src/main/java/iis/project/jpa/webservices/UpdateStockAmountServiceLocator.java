/**
 * UpdateStockAmountServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package iis.project.jpa.webservices;

public class UpdateStockAmountServiceLocator extends org.apache.axis.client.Service implements iis.project.jpa.webservices.UpdateStockAmountService {

    public UpdateStockAmountServiceLocator() {
    }


    public UpdateStockAmountServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UpdateStockAmountServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UpdateStockAmountPort
    private java.lang.String UpdateStockAmountPort_address = "http://localhost:8080/drone-order-war/UpdateStockAmount";

    public java.lang.String getUpdateStockAmountPortAddress() {
        return UpdateStockAmountPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UpdateStockAmountPortWSDDServiceName = "UpdateStockAmountPort";

    public java.lang.String getUpdateStockAmountPortWSDDServiceName() {
        return UpdateStockAmountPortWSDDServiceName;
    }

    public void setUpdateStockAmountPortWSDDServiceName(java.lang.String name) {
        UpdateStockAmountPortWSDDServiceName = name;
    }

    public iis.project.jpa.webservices.UpdateStockAmount getUpdateStockAmountPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UpdateStockAmountPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUpdateStockAmountPort(endpoint);
    }

    public iis.project.jpa.webservices.UpdateStockAmount getUpdateStockAmountPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            iis.project.jpa.webservices.UpdateStockAmountServiceSoapBindingStub _stub = new iis.project.jpa.webservices.UpdateStockAmountServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUpdateStockAmountPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUpdateStockAmountPortEndpointAddress(java.lang.String address) {
        UpdateStockAmountPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (iis.project.jpa.webservices.UpdateStockAmount.class.isAssignableFrom(serviceEndpointInterface)) {
                iis.project.jpa.webservices.UpdateStockAmountServiceSoapBindingStub _stub = new iis.project.jpa.webservices.UpdateStockAmountServiceSoapBindingStub(new java.net.URL(UpdateStockAmountPort_address), this);
                _stub.setPortName(getUpdateStockAmountPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UpdateStockAmountPort".equals(inputPortName)) {
            return getUpdateStockAmountPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.jpa.project.iis/", "UpdateStockAmountService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.jpa.project.iis/", "UpdateStockAmountPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UpdateStockAmountPort".equals(portName)) {
            setUpdateStockAmountPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
