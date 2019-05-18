package testthree.magggaz.dao;

import testthree.magggaz.model.Part;

import java.util.List;

public interface PartDAO {
    List<Part> allParts(int page);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getById(int id);
    Part getByName(List<Part> list, String name);
    int countOfComp();
    int partsCount();
    List<Part>sorting(List<Part> partsOnPage, int flag);


}
