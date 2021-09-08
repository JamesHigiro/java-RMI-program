
package tgfe.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import tgfe.dao.CitizenDao;
import tgfe.models.Vaccination;


public class VaccinationService extends UnicastRemoteObject implements IVaccinationService{
    private CitizenDao dao;
    
    public VaccinationService() throws RemoteException{
    }
    @Override
    public void registrVaccination(String c, Vaccination vacc){
        dao = new CitizenDao();
        dao.registerVaccination(c,vacc);
    }
    
}
