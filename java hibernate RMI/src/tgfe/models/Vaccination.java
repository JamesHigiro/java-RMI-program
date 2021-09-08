
package tgfe.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="vaccinations")
public class Vaccination implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="vaccination_id", nullable=false)
    private long vaccinationId;
    
    @Column(name="vaccination_date", nullable=false)
    private  LocalDate vaccinationDate=LocalDate.now();

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }
    
    @Column(name="vaccine_brand", nullable=false, length=20)
    private String vaccineBrand;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="vaccine")
    private List<Citizen> citizens = new ArrayList<>();

    public Vaccination() {
    }

    @Override
    public String toString() {
        return "Vaccination{" + "vaccinationId=" + vaccinationId + ", vaccinationDate=" + vaccinationDate + ", vaccineBrand=" + vaccineBrand + ", citizens=" + citizens + '}';
    }

    public void addCitizen(Citizen citizen){
        this.citizens.add(citizen);
        citizen.setVaccine(this);
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
    
    public long getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(long vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getVaccineBrand() {
        return vaccineBrand;
    }

    public void setVaccineBrand(String vaccineBrand) {
        this.vaccineBrand = vaccineBrand;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
    
    
}
