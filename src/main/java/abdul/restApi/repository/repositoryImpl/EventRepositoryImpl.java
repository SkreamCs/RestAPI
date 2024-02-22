package abdul.restApi.repository.repositoryImpl;

import abdul.restApi.model.Event;
import abdul.restApi.repository.EventRepository;
import org.hibernate.Session;

import java.util.List;

import static abdul.restApi.utils.HibernateUtil.getSessionFactory;

public class EventRepositoryImpl  implements EventRepository {
    @Override
    public Event save(Event object) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            int fileId = (int) session.save(object);
            object.setId(fileId);
            session.getTransaction().commit();
            return object;
        }
    }

    @Override
    public void delete(Integer id) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session
                    .createQuery("DELETE FROM Event WHERE id = :id")
                    .setParameter("id", id).executeUpdate();
            session.getTransaction().commit();

        }
    }

    @Override
    public Event update(Event objectUpdate) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(objectUpdate);
            session.getTransaction().commit();
            return objectUpdate;
        }
    }

    @Override
    public Event getById(Integer id) {
        try(Session session = getSessionFactory().openSession()) {
            return session.createQuery("FROM Event p LEFT JOIN fetch p.user, p.file WHERE p.id = :id", Event.class).setParameter("id", id)
                    .getSingleResult();
        }
    }
    public List<Event> getAll() {
        try(Session session = getSessionFactory().openSession()) {
            List<Event> list = session.createQuery("FROM Event").list();
            return list;
        }
    }
}
