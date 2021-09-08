
package tgfe.utils;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import tgfe.services.CitizenService;
import tgfe.services.VaccinationService;


public class Server {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(Config.PORT);
            registry.rebind("CitizenService", new CitizenService());
            registry.rebind("VaccinationService", new VaccinationService());
            System.out.println("[SERVER] has started...");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
