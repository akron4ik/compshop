package testthree.magggaz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testthree.magggaz.model.Part;

import java.util.*;


@Repository
public class PartDAOImpl implements PartDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Part> allParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part").setFirstResult(10*(page-1)).setMaxResults(10).list();
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
    @Override
    public Part getByName(List<Part> list, String name){
        Part part = null;
        for (Part p: list) {
            if(p.getName().equals(name)) part = p;
        }
        return part;
    }

    @Override
    public int countOfComp(){
        Session session = sessionFactory.getCurrentSession();

        List<Part> list = session.createQuery("from Part").list();

        List<Integer> allTrueCount = new ArrayList<>();
        int countNull = 0;
        int count = 0;

        for (Part p: list) {
            if (p.isNeed() && p.getCount() == 0) {
                countNull++;
            }
            else if(p.isNeed() && p.getCount() > 0){
                allTrueCount.add(p.getCount());
            }
        }
        if(countNull > 0) return 0;
        else {
            count = Collections.min(allTrueCount);
            return count;
        }
    }

    public int partsCount(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Part", Number.class).getSingleResult().intValue();
    }

    public List<Part> sorting(List<Part> partsOnPage, int flag){
        List<Part> listTrue = new ArrayList<>();
        for (Part p: partsOnPage) {
            if(flag == 2) {
                if(p.isNeed())listTrue.add(p);
            }
            else if(flag == 3){
                if(!p.isNeed())listTrue.add(p);
            }
            else listTrue.add(p);
        }
        return listTrue;

    }

}
