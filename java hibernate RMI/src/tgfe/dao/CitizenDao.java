
package tgfe.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tgfe.models.Citizen;
import tgfe.models.Vaccination;
import tgfe.utils.NewHibernateUtil;


public class CitizenDao {
    private Session session=null;
    private Transaction tx=null;
    private String sql;
    
    
    public void saveCitizen(Citizen citizen){
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           session.save(citizen);
           tx.commit();
           JOptionPane.showMessageDialog(null, "New citizen has been inserted succesfully!");
        }catch(HibernateException ex){
            if(tx!=null){
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    
    public List<Citizen> unvaccinated(){
        List<Citizen> citizens=new ArrayList<>();
        sql="FROM Citizen c WHERE c.vaccine IS NULL";
         try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           citizens = session.createQuery(sql).list();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }       
        return citizens;
    }
    
    public List<Citizen> vaccinated(){
       List<Citizen> citizens=new ArrayList<>();
        sql="FROM Citizen c WHERE c.vaccine IS NOT NULL";
         try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           citizens = session.createQuery(sql).list();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }       
        return citizens;
    }
    
    public void registerVaccination(String citizenId, Vaccination vaccine){
         try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           Citizen citizen = (Citizen)session.createQuery("FROM Citizen c WHERE c.citizenId='" + citizenId + "'").list().get(0);
           long vcId = (long)session.save(vaccine);     
           tx.commit();           
           tx = session.beginTransaction();
           Vaccination vaccineReturned = (Vaccination)session.get(Vaccination.class, vcId);
           
           vaccineReturned.addCitizen(citizen);
           session.update(citizen);
           tx.commit();
           JOptionPane.showMessageDialog(null, "Vaccination has been registered");
        }catch(HibernateException ex){
            if(tx!=null){
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }finally{
            if(session!=null){
                session.close();
            }
        }       
    }
}
