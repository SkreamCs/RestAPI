package abdul.restApi.repository.repositoryImpl;

import abdul.restApi.model.User;
import abdul.restApi.repository.UserRepository;
import org.hibernate.Session;

import java.util.List;

import static abdul.restApi.Utils.HibernateUtil.getSessionFactory;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User object) {
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
                    .createQuery("DELETE FROM User WHERE id = :id")
                    .setParameter("id", id).executeUpdate();
            session.getTransaction().commit();

        }
    }

    @Override
    public User update(User objectUpdate) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(objectUpdate);
            session.getTransaction().commit();
            return objectUpdate;
        }
    }

    @Override
    public User getById(Integer id) {
        try(Session session = getSessionFactory().openSession()) {
            return session.createQuery("FROM User p LEFT JOIN FETCH p.events WHERE p.id = :id", User.class).setParameter("id", id)
                     .getSingleResult();
        }
    }
    public List<User> getAll() {
        try(Session session = getSessionFactory().openSession()) {
            List<User> list = session.createQuery("FROM User").list();
            return list;
        }
    }
}
