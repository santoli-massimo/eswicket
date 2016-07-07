package it.engim;

import it.engim.*;
import it.engim.beans.Voci;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class VociDAO {
   //fa solo update
    public static void salva(Voci l) {
        EntityManager em
                = PM.getEM();
        EntityTransaction et
                = em.getTransaction();
        try {
            et.begin();
            em.merge(l);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }

    public static List<Voci> elenco() {
        EntityManager em = PM.getEM();
        try {
            Query q = em.createNamedQuery("Voci.findAll");
            List res = q.getResultList();
            return res;
        } finally {
            em.close();
        }
    }

    public static void elimina(Voci l) {
        EntityManager em = PM.getEM();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            l = em.find(Voci.class, l.getId());
            em.remove(l);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
