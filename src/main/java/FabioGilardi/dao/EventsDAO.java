package FabioGilardi.dao;

import FabioGilardi.entities.ConcertType;
import FabioGilardi.entities.Concerto;
import FabioGilardi.entities.Event;
import FabioGilardi.entities.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean yn) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :yn", Concerto.class);
        query.setParameter("yn", yn);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(ConcertType concertType) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :concertType", Concerto.class);
        query.setParameter("concertType", concertType);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
