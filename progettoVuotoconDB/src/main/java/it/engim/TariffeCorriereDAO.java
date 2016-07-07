package it.engim;

import it.engim.*;
import it.engim.beans.TariffeCorriere;
import it.engim.beans.Ordini;
import static it.engim.OrdiniDAO.calcolaPeso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class TariffeCorriereDAO {
   //fa solo update
    public static void salva(TariffeCorriere c) {
        EntityManager em
                = PM.getEM();
        EntityTransaction et
                = em.getTransaction();
        try {
            et.begin();
            em.merge(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }

    public static List<TariffeCorriere> elenco() {
        EntityManager em = PM.getEM();
        try {
            Query q = em.createNamedQuery("TariffeCorriere.findAll");
            List res = q.getResultList();
            return res;
        } finally {
            em.close();
        }
    }

    public static void elimina(TariffeCorriere c) {
        EntityManager em = PM.getEM();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            c = em.find(TariffeCorriere.class, c.getId());
            em.remove(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
    
    public static TariffeCorriere calcolaTariffaMigliore(Ordini o)
    {
        EntityManager em = PM.db();
        try
        {
            Query q = em.createNamedQuery ("TariffeCorriere.findBest");
            
            double peso = calcolaPeso(o,em);
            q.setParameter("peso",peso);
            q.setMaxResults(1);
            List<TariffeCorriere> result = q.getResultList();
            return result.get(0);
        }
        finally
        {
            em.close();
        }
    }   
}
