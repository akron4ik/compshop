package testthree.magggaz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testthree.magggaz.model.Part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PartDAOImpl implements PartDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Part> allParts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part").list();
    }

    @Override
    public void add(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(part);

    }

    @Override
    public void delete(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);

    }

    @Override
    public void edit(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.update(part);

    }

    @Override
    public Part getById(int id) {
       Session session = sessionFactory.getCurrentSession();
       return session.get(Part.class, id);
    }
}
