package it.engim;

import it.engim.*;
import it.engim.beans.Articoli;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ArticoliDAO {
   //fa solo update
    public static void salva(Articoli c) {
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

    public static List<Articoli> elenco() {
        EntityManager em = PM.getEM();
        try {
            Query q = em.createNamedQuery("Articoli.findAll");
            List res = q.getResultList();
            return res;
        } finally {
            em.close();
        }
    }

    public static void elimina(Articoli c) {
        EntityManager em = PM.getEM();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            c = em.find(Articoli.class, c.getId());
            em.remove(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
