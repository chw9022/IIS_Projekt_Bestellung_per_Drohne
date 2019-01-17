package iis.project.jpa.webservices;

public class UpdateStockAmountProxy implements iis.project.jpa.webservices.UpdateStockAmount {
  private String _endpoint = null;
  private iis.project.jpa.webservices.UpdateStockAmount updateStockAmount = null;
  
  public UpdateStockAmountProxy() {
    _initUpdateStockAmountProxy();
  }
  
  public UpdateStockAmountProxy(String endpoint) {
    _endpoint = endpoint;
    _initUpdateStockAmountProxy();
  }
  
  private void _initUpdateStockAmountProxy() {
    try {
      updateStockAmount = (new iis.project.jpa.webservices.UpdateStockAmountServiceLocator()).getUpdateStockAmountPort();
      if (updateStockAmount != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)updateStockAmount)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)updateStockAmount)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (updateStockAmount != null)
      ((javax.xml.rpc.Stub)updateStockAmount)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public iis.project.jpa.webservices.UpdateStockAmount getUpdateStockAmount() {
    if (updateStockAmount == null)
      _initUpdateStockAmountProxy();
    return updateStockAmount;
  }
  
  public void updateStockAmount(int arg0, int arg1) throws java.rmi.RemoteException{
    if (updateStockAmount == null)
      _initUpdateStockAmountProxy();
    updateStockAmount.updateStockAmount(arg0, arg1);
  }
  
  
}