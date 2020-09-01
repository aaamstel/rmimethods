package client;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import remote.EJBInterface;

//import remote.EJBInterface;

public class EJBRClient {
	
	@EJB
	static EJBInterface ejbi;

	public static void main(String args[]) {
	
		 Properties props = new Properties();
         props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
         props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
         props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
      
		
		try {
			InitialContext ct = new InitialContext(props);
			
			ejbi = (EJBInterface) ct.lookup("java:global/rmi-method/InterfaceBean!remote.EJBInterface");
			ejbi.message();
			System.out.println("Method has been invoked, see glassfish logs");
			ejbi.multiply(32, 2222);
		} catch (NamingException | RemoteException e) {
		
			e.printStackTrace();
		}
	
	}
}
