package it.epicode.dao;

import it.epicode.GenereConcertoEnum;
import it.epicode.entity.Concerto;
import it.epicode.entity.Evento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em){this.em = em;}

    public void save (Evento e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Evento getById(Long id){
        return em.find(Evento.class, id);
    }

    public void delete(Long id){
        Evento evento = getById(id);
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }

    public void insertAll(List<Evento> lista) {
        em.getTransaction().begin();
        for (Evento e : lista) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming){
        return em.createNamedQuery("Trova_concerti_in_streaming", Concerto.class)
                .setParameter("inStreaming", inStreaming)
                .getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcertoEnum genere){
        return em.createNamedQuery("Trova_concerti_per_genere", Concerto.class)
                .setParameter("genere",genere)
                .getResultList();
    }

}
