
package tgfe.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import tgfe.dao.CitizenDao;
import tgfe.models.Citizen;


public class CitizenService extends UnicastRemoteObject implements  ICitizenService{
    private CitizenDao dao;
    
    public CitizenService() throws RemoteException{
    }
    @Override
    public void saveCitizen(Citizen citizen) {
        dao = new CitizenDao();
        dao.saveCitizen(citizen);
    }

    @Override
    public List<Citizen> unvaccinatedCitizens(){
        dao = new CitizenDao();
        return dao.unvaccinated();
    }

    @Override
    public List<Citizen> vaccinatedCitizens(){
        dao= new CitizenDao();
        return dao.vaccinated();
    }
    
}
