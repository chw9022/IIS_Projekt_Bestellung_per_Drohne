package iis.project.jpa.webservices;

public class CheckDroneAvailableProxy implements iis.project.jpa.webservices.CheckDroneAvailable {
  private String _endpoint = null;
  private iis.project.jpa.webservices.CheckDroneAvailable checkDroneAvailable = null;
  
  public CheckDroneAvailableProxy() {
    _initCheckDroneAvailableProxy();
  }
  
  public CheckDroneAvailableProxy(String endpoint) {
    _endpoint = endpoint;
    _initCheckDroneAvailableProxy();
  }
  
  private void _initCheckDroneAvailableProxy() {
    try {
      checkDroneAvailable = (new iis.project.jpa.webservices.CheckDroneAvailableServiceLocator()).getCheckDroneAvailablePort();
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
  
  public iis.project.jpa.webservices.CheckDroneAvailable getCheckDroneAvailable() {
    if (checkDroneAvailable == null)
      _initCheckDroneAvailableProxy();
    return checkDroneAvailable;
  }
  
  public int getIdOfAvailableDrone() throws java.rmi.RemoteException{
    if (checkDroneAvailable == null)
      _initCheckDroneAvailableProxy();
    return checkDroneAvailable.getIdOfAvailableDrone();
  }
  
  
}