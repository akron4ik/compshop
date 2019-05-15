package testthree.magggaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testthree.magggaz.dao.PartDAO;
import testthree.magggaz.dao.PartDAOImpl;
import testthree.magggaz.model.Part;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private PartDAO partDAO = new PartDAOImpl();

    @Autowired
    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @Transactional
    public List<Part> allParts(int page) {
        return partDAO.allParts(page);
    }

    @Transactional
    public void add(Part part) {
        partDAO.add(part);

    }

    @Transactional
    public void delete(Part part) {
        partDAO.delete(part);

    }

    @Transactional
    public void edit(Part part) {
        partDAO.edit(part);

    }

    @Transactional
    public Part getById(int id) {
        return partDAO.getById(id);
    }


    @Transactional
    public int countOfComp(int page){
        return partDAO.countOfComp(page);
    }

    @Transactional
    public int partsCount(){
        return partDAO.partsCount();
    }

}
