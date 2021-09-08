
package tgfe.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="citizens")
public class Citizen implements Serializable{
    
    @Id
    @Column(name="citizen_id", nullable=false, length=16)
    private String citizenId;
    
    @Column(name="full_name", length=80, nullable=false)
    private String fullName;
    
    @Column(name="phone_number", length=13, nullable=false)
    private String phoneNumber;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vaccine")
    private Vaccination vaccine;

    public Citizen() {
    }

    @Override
    public String toString() {
        return "Citizen{" + "citizenId=" + citizenId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", vaccine=" + vaccine + '}';
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Vaccination getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccination vaccine) {
        this.vaccine = vaccine;
    }
    
    
}
