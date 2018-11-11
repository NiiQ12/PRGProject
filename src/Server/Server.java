/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Nicky
 */
public class Server
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        System.out.println("***** SERVER STARTED *****\n");
        
        Registry r = LocateRegistry.createRegistry(420);
        
        ImpAddress ia = new ImpAddress();
        r.bind("Address", ia);        
        System.out.println("Registry Bound To IAddress");
        
        ImpCategory ic = new ImpCategory();
        r.bind("Category", ic);
        System.out.println("Registry Bound To ICategory");
        
        ImpDepartment id = new ImpDepartment();
        r.bind("Department", id);
        System.out.println("Registry Bound To IDepartment");
        
        ImpLogin il = new ImpLogin();
        r.bind("Login", il);
        System.out.println("Registry Bound To ILogin");
        
        ImpManufacturer im = new ImpManufacturer();
        r.bind("Manufacturer", im);
        System.out.println("Registry Bound To IManufacturer");
        
        ImpOrder io = new ImpOrder();
        r.bind("Order", io);
        System.out.println("Registry Bound To IOrder");
        
        ImpReport irep = new ImpReport();
        r.bind("Report", irep);
        System.out.println("Registry Bound To IReport");
        
        ImpRequest ireq = new ImpRequest();
        r.bind("Request", ireq);
        System.out.println("Registry Bound To IRequest");
        
        ImpStaff istaff = new ImpStaff();
        r.bind("Staff", istaff);
        System.out.println("Registry Bound To IStaff");
        
        ImpStationery istat = new ImpStationery();
        r.bind("Stationery", istat);
        System.out.println("Registry Bound To IStationery");
    }
    
}
