package com.famsa.service;

public class DatosTokenServicioImplProxy implements com.famsa.service.DatosTokenServicioImpl {
  private String _endpoint = null;
  private com.famsa.service.DatosTokenServicioImpl datosTokenServicioImpl = null;
  
  public DatosTokenServicioImplProxy() {
    _initDatosTokenServicioImplProxy();
  }
  
  private void _initDatosTokenServicioImplProxy() {
    try {
      datosTokenServicioImpl = (new com.famsa.service.DatosTokenServicioImplServiceLocator()).getdatosTokenServicioImpl();
      if (datosTokenServicioImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)datosTokenServicioImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)datosTokenServicioImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (datosTokenServicioImpl != null)
      ((javax.xml.rpc.Stub)datosTokenServicioImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.famsa.service.DatosTokenServicioImpl getDatosTokenServicioImpl() {
    if (datosTokenServicioImpl == null)
      _initDatosTokenServicioImplProxy();
    return datosTokenServicioImpl;
  }
  
  public java.lang.String datosTokenService(java.lang.String iduser) throws java.rmi.RemoteException{
    if (datosTokenServicioImpl == null)
      _initDatosTokenServicioImplProxy();
    return datosTokenServicioImpl.datosTokenService(iduser);
  }
  
  
}