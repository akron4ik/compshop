package testthree.magggaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testthree.magggaz.model.Part;
import testthree.magggaz.service.PartService;
import testthree.magggaz.service.PartServiceImpl;

import java.util.List;

@Controller
public class ShopController {

    private PartService partService = new PartServiceImpl();

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDetails(){
        List<Part> parts = partService.allParts();
        int count = partService.countOfComp();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("partsList", parts);
        modelAndView.addObject("countOf", count);
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
        modelAndView.setViewName("redirect:/");
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
        modelAndView.setViewName("redirect:/");
        partService.add(part);
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePart(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getById(id);
        partService.delete(part);
        return modelAndView;
    }

}
