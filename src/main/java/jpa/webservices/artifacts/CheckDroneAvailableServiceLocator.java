/**
 * CheckDroneAvailableServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package jpa.webservices.artifacts;

public class CheckDroneAvailableServiceLocator extends org.apache.axis.client.Service implements jpa.webservices.artifacts.CheckDroneAvailableService {

    public CheckDroneAvailableServiceLocator() {
    }


    public CheckDroneAvailableServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CheckDroneAvailableServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CheckDroneAvailablePort
    private java.lang.String CheckDroneAvailablePort_address = "http://localhost:8080/Bestellung_per_Drohne/CheckDroneAvailable";

    public java.lang.String getCheckDroneAvailablePortAddress() {
        return CheckDroneAvailablePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CheckDroneAvailablePortWSDDServiceName = "CheckDroneAvailablePort";

    public java.lang.String getCheckDroneAvailablePortWSDDServiceName() {
        return CheckDroneAvailablePortWSDDServiceName;
    }

    public void setCheckDroneAvailablePortWSDDServiceName(java.lang.String name) {
        CheckDroneAvailablePortWSDDServiceName = name;
    }

    public jpa.webservices.artifacts.CheckDroneAvailable getCheckDroneAvailablePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CheckDroneAvailablePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCheckDroneAvailablePort(endpoint);
    }

    public jpa.webservices.artifacts.CheckDroneAvailable getCheckDroneAvailablePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            jpa.webservices.artifacts.CheckDroneAvailableServiceSoapBindingStub _stub = new jpa.webservices.artifacts.CheckDroneAvailableServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCheckDroneAvailablePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCheckDroneAvailablePortEndpointAddress(java.lang.String address) {
        CheckDroneAvailablePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (jpa.webservices.artifacts.CheckDroneAvailable.class.isAssignableFrom(serviceEndpointInterface)) {
                jpa.webservices.artifacts.CheckDroneAvailableServiceSoapBindingStub _stub = new jpa.webservices.artifacts.CheckDroneAvailableServiceSoapBindingStub(new java.net.URL(CheckDroneAvailablePort_address), this);
                _stub.setPortName(getCheckDroneAvailablePortWSDDServiceName());
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
        if ("CheckDroneAvailablePort".equals(inputPortName)) {
            return getCheckDroneAvailablePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.jpa/", "CheckDroneAvailableService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.jpa/", "CheckDroneAvailablePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CheckDroneAvailablePort".equals(portName)) {
            setCheckDroneAvailablePortEndpointAddress(address);
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
