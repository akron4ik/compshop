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
    private int sort;


    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDetails(@RequestParam(defaultValue = "1") int page){
        this.page = page;
        List<Part> absolAllParts = partService.absolutAllParts(page, 1);
        int count = partService.countOfComp();
        int partsCount = partService.partsCount(1);
        int pageCount = (partsCount + 9)/10;
        List<Part> sortParts = partService.sorting(absolAllParts, 1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("page",page);
        modelAndView.addObject("countOf", count);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pageCount);
        modelAndView.addObject("sortParts", sortParts);
        return modelAndView;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ModelAndView sortDetails(@RequestParam(defaultValue = "1") int page, @RequestParam(name = "sort") int sort){
        this.sort = sort;
        ModelAndView modelAndView = new ModelAndView();
        List<Part> all = partService.absolutAllParts(page, this.sort);
        int partCount = partService.partsCount(this.sort);
        int pagCount = (partCount + 9)/10;
        List<Part> soPa = partService.sorting(all,this.sort);
        modelAndView.setViewName("sorting");
        modelAndView.addObject("sort",this.sort);
        modelAndView.addObject("pages", page);
        modelAndView.addObject("partCount", partCount);
        modelAndView.addObject("pagCount", pagCount);
        modelAndView.addObject("soPa", soPa);
        return modelAndView;
    }

    @RequestMapping(value = "/check-part")
    public ModelAndView checkPart(@ModelAttribute("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        List<Part> list = partService.allDetails();
        Part part = partService.getByName(list, name);
        modelAndView.setViewName("search");
        modelAndView.addObject("name", name);
        modelAndView.addObject("part", part);
        return modelAndView;
    }
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
