package remote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RMIServer extends InterfaceBean {
	

		static Registry reg;
		static InitialContext ct;
		
		public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {

			InterfaceBean ri = new InterfaceBean();
			EJBInterface stub = (EJBInterface) UnicastRemoteObject.exportObject(ri, 0);
			
			reg = LocateRegistry.createRegistry(1099);		
			
		// System.setProperty("java.rmi.server.hostname","localhost");


			final Properties pr = new Properties();
			pr.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
			pr.put(Context.PROVIDER_URL, "rmi://localhost");
			
				try {
					ct = new InitialContext(pr);
					
					Naming.bind("RIInterface", stub);
					//ct.bind("RIInterface", stub);
				} catch (NamingException e1) {
			
					e1.printStackTrace();
				}
				System.out.println("Server is ready!");

		
					/*
			try {
					reg.bind("RIInterface", stub);		
					
					System.out.println("Server is ready 2!");
				} catch (RemoteException | AlreadyBoundException e) {
					
					e.printStackTrace();
				}
			*/
		}
	}

