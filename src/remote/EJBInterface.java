package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EJBInterface extends Remote {


	public void message() throws RemoteException;
	public void multiply(int a, int b) throws RemoteException;
	
	
}
