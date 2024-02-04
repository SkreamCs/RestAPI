package abdul.restApi.repository.repositoryImpl;

import abdul.restApi.model.File;
import abdul.restApi.repository.FileRepository;

import org.hibernate.Session;


import java.util.List;

import static abdul.restApi.Utils.HibernateUtil.getSessionFactory;

public class FileRepositoryImpl implements FileRepository {
    @Override
    public File save(File object) {
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
                   .createQuery("DELETE FROM File WHERE id = :id")
                   .setParameter("id", id).executeUpdate();
           session.getTransaction().commit();

       }
    }

    @Override
    public File update(File objectUpdate) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(objectUpdate);
            session.getTransaction().commit();
            return objectUpdate;
        }
    }

    @Override
    public File getById(Integer id) {
        try(Session session = getSessionFactory().openSession()) {
            return session.get(File.class, id);
        }
    }
    public List<File> getAll() {
        try(Session session = getSessionFactory().openSession()) {
            List<File> list = session.createQuery("FROM File").list();
            return list;
        }
    }
}
