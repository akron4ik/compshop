package testthree.magggaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testthree.magggaz.model.Part;
import testthree.magggaz.service.PartService;
import testthree.magggaz.service.PartServiceImpl;

import java.util.*;

@Controller
public class ShopController {

    private PartService partService = new PartServiceImpl();
    private int page;//номера страниц
    private int sort;//вариант сортировки


    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDetails(@RequestParam(defaultValue = "1") int page){
        this.page = page;
        List<Part> AllPartsOnPage = partService.absolutAllParts(page, 1);//список всех запчастей на странице
        int countOfComps = partService.countOfComp();//количество компов, которые можно собрать
        int partsCount = partService.partsCount(1);//количество всех запчастей
        int pageCount = (partsCount + 9)/10;//количесто страниц
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");//название страницы
        modelAndView.addObject("page",page);
        modelAndView.addObject("countOf", countOfComps);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pageCount);
        modelAndView.addObject("AllPartsOnPage", AllPartsOnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ModelAndView sortDetails(@RequestParam(defaultValue = "1") int page, @RequestParam(name = "sort") int sort){
        this.sort = sort;
        List<Part> all = partService.absolutAllParts(page, this.sort);
        int partCount = partService.partsCount(this.sort);
        int pageCount = (partCount + 9)/10;
        int countOfcomps = partService.countOfComp();
        List<Part> sortingParts = partService.sorting(all,this.sort);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sorting");
        modelAndView.addObject("sort",this.sort);
        modelAndView.addObject("pages", page);
        modelAndView.addObject("partCount", partCount);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("sortingParts", sortingParts);
        modelAndView.addObject("countOfcomps", countOfcomps);
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
