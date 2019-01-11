package jpa.webservices.artifacts;

public class CheckDroneAvailableProxy implements jpa.webservices.artifacts.CheckDroneAvailable {
  private String _endpoint = null;
  private jpa.webservices.artifacts.CheckDroneAvailable checkDroneAvailable = null;
  
  public CheckDroneAvailableProxy() {
    _initCheckDroneAvailableProxy();
  }
  
  public CheckDroneAvailableProxy(String endpoint) {
    _endpoint = endpoint;
    _initCheckDroneAvailableProxy();
  }
  
  private void _initCheckDroneAvailableProxy() {
    try {
      checkDroneAvailable = (new jpa.webservices.artifacts.CheckDroneAvailableServiceLocator()).getCheckDroneAvailablePort();
      if (checkDroneAvailable != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)checkDroneAvailable)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)checkDroneAvailable)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (checkDroneAvailable != null)
      ((javax.xml.rpc.Stub)checkDroneAvailable)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public jpa.webservices.artifacts.CheckDroneAvailable getCheckDroneAvailable() {
    if (checkDroneAvailable == null)
      _initCheckDroneAvailableProxy();
    return checkDroneAvailable;
  }
  
  public boolean checkDroneAvailable() throws java.rmi.RemoteException{
    if (checkDroneAvailable == null)
      _initCheckDroneAvailableProxy();
    return checkDroneAvailable.checkDroneAvailable();
  }
  
  
}