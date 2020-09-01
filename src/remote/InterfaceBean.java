package remote;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(EJBInterface.class)
public class InterfaceBean implements EJBInterface {

	public void message() throws RemoteException {
		System.out.println("Method has been invoked");	
	}

	public void multiply(int a, int b) throws RemoteException {
		
		int c = a*b;
		System.out.println("Result of multiply: " + c);
	}
	
}
