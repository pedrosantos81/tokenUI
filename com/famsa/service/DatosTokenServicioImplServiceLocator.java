/**
 * DatosTokenServicioImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.famsa.service;

public class DatosTokenServicioImplServiceLocator extends org.apache.axis.client.Service implements com.famsa.service.DatosTokenServicioImplService {

    public DatosTokenServicioImplServiceLocator() {
    }


    public DatosTokenServicioImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DatosTokenServicioImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for datosTokenServicioImpl
    private java.lang.String datosTokenServicioImpl_address = "http://172.17.15.51:1977/userdatosTokenWS/services/datosTokenServicioImpl";

    public java.lang.String getdatosTokenServicioImplAddress() {
        return datosTokenServicioImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String datosTokenServicioImplWSDDServiceName = "datosTokenServicioImpl";

    public java.lang.String getdatosTokenServicioImplWSDDServiceName() {
        return datosTokenServicioImplWSDDServiceName;
    }

    public void setdatosTokenServicioImplWSDDServiceName(java.lang.String name) {
        datosTokenServicioImplWSDDServiceName = name;
    }

    public com.famsa.service.DatosTokenServicioImpl getdatosTokenServicioImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(datosTokenServicioImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getdatosTokenServicioImpl(endpoint);
    }

    public com.famsa.service.DatosTokenServicioImpl getdatosTokenServicioImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.famsa.service.DatosTokenServicioImplSoapBindingStub _stub = new com.famsa.service.DatosTokenServicioImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getdatosTokenServicioImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setdatosTokenServicioImplEndpointAddress(java.lang.String address) {
        datosTokenServicioImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.famsa.service.DatosTokenServicioImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.famsa.service.DatosTokenServicioImplSoapBindingStub _stub = new com.famsa.service.DatosTokenServicioImplSoapBindingStub(new java.net.URL(datosTokenServicioImpl_address), this);
                _stub.setPortName(getdatosTokenServicioImplWSDDServiceName());
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
        if ("datosTokenServicioImpl".equals(inputPortName)) {
            return getdatosTokenServicioImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.famsa.com", "datosTokenServicioImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.famsa.com", "datosTokenServicioImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("datosTokenServicioImpl".equals(portName)) {
            setdatosTokenServicioImplEndpointAddress(address);
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
