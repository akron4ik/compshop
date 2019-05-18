package testthree.magggaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testthree.magggaz.model.Part;
import testthree.magggaz.service.PartService;
import testthree.magggaz.service.PartServiceImpl;

import java.util.*;

@Controller
public class ShopController {

    private PartService partService = new PartServiceImpl();
    private int page;


    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDetails(@RequestParam(defaultValue = "1") int page){
        this.page = page;
        List<Part> parts = partService.allParts(page);
        List<Part> parttrue = partService.sortTrue(parts);
        List<Part> partFalse = partService.sortFalse(parts);
        int count = partService.countOfComp();
        int partsCount = partService.partsCount();
        int pageCount = (partsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("page",page);
        modelAndView.addObject("partsList", parts);
        modelAndView.addObject("countOf", count);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pageCount);
        modelAndView.addObject("partsTrue", parttrue);
        modelAndView.addObject("partsFalse", partFalse);
        return modelAndView;
    }
    @RequestMapping(value = "/check-part")
    public ModelAndView checkPart(@ModelAttribute("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        List<Part> list = partService.allParts(page);
        Part part = partService.getByName(list, name);
        //Part part = partService.getById(id);
        modelAndView.setViewName("search");
        //modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);
        modelAndView.addObject("part", part);
        return modelAndView;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView sortPage(@RequestParam("sort") int sort){
        this.sort = sort;
        List<Part> parts = partService.allParts(page);
        if(sort == 1) parts = partService.allParts(page);
        else if( sort == 2) parts = partService.sortTrue(parts);
        else parts = partService.sortFalse(parts);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("sortPart", parts);
        return modelAndView;
    }*/



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id")int id){
        Part part = partService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("part",part);
        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page="+ this.page);
        partService.edit(part);
        return modelAndView;
    }
    @RequestMapping(value= "/add", method = RequestMethod.GET)
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPart(@ModelAttribute("part") Part part){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page);
        partService.add(part);
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePart(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page="+ this.page);
        Part part = partService.getById(id);
        partService.delete(part);
        return modelAndView;
    }

}
