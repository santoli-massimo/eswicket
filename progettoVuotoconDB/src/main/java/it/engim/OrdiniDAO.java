package it.engim;


import it.engim.*;
import it.engim.beans.Ordini;
import it.engim.beans.Voci;
import it.engim.beans.Articoli;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class OrdiniDAO {
   //fa solo update
    public static void salva(Ordini c) {
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

    public static List<Ordini> elenco() {
        EntityManager em = PM.getEM();
        try {
            Query q = em.createNamedQuery("Ordini.findAll");
            List res = q.getResultList();
            return res;
        } finally {
            em.close();
        }
    }

    public static void elimina(Ordini c) {
        EntityManager em = PM.getEM();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            c = em.find(Ordini.class, c.getId());
            em.remove(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
    
    public static Double calcolaPeso(Ordini o, EntityManager em)
    {
        o = em.find(o.getClass(), o.getId());
        Collection<Voci> olist = 
                o.getVociCollection();
        
        double pesoTotale = 0.0;
        for (Voci v: olist)
        {
            Articoli a = v.getIdArticoli();
            pesoTotale += a.getPeso() * v.getQuantita();
        }
        
        return pesoTotale;
    }
}
