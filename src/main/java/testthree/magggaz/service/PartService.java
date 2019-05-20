package testthree.magggaz.service;

import testthree.magggaz.model.Part;

import java.util.List;

public interface PartService {
    List<Part> allParts(int page);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getById(int id);
    Part getByName(List<Part> list,String name);
    int countOfComp();
    int partsCount(int flag);
    List<Part> sorting(List<Part> partsOnPage, int flag);
    List<Part> absolutAllParts(int page, int flag);
    List<Part> allDetails();


}
