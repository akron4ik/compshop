package testthree.magggaz.service;

import testthree.magggaz.model.Part;

import java.util.List;

public interface PartService {
    List<Part> allParts(int page);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getById(int id);
    int countOfComp(int page);
    int partsCount();
}
