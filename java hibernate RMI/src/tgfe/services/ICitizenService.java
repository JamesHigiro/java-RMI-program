
package tgfe.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import tgfe.models.Citizen;


public interface ICitizenService extends Remote{
    public void saveCitizen(Citizen citizen) throws RemoteException;
    public List<Citizen> unvaccinatedCitizens() throws RemoteException;
    public List<Citizen> vaccinatedCitizens() throws RemoteException;
}
