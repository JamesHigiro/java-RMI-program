
package tgfe.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import tgfe.models.Vaccination;

public interface IVaccinationService extends Remote{
    public void registrVaccination(String citzenId, Vaccination vacc) throws RemoteException;
}
