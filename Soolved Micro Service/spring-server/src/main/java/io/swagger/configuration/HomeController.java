package io.swagger.configuration;

import io.swagger.model.Soolution;
import io.swagger.model.SoolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private SoolutionRepository soolutionRepository;

    @RequestMapping("/")
    public ModelAndView index(Model model) {

        List<Soolution> allSolutions = soolutionRepository.findAll();
        model.addAttribute("listSoolutions", allSolutions);
        return new ModelAndView("index");
    }

    @RequestMapping("/new")
    public ModelAndView showNewForm(Model model) {
        Soolution soolution = new Soolution();
        model.addAttribute("soolution", soolution);

        return new ModelAndView("new_form");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("soolution") Soolution soolution) {
        soolutionRepository.save(soolution);

        return new ModelAndView("index");
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        Soolution soolution = soolutionRepository.findOne(id + "");
        mav.addObject("soolution", soolution);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("soolution") Soolution soolution) {
        Soolution registro = soolutionRepository.findOne(soolution.getId());
        registro.setDescription(soolution.getDescription());
        registro.setCausa(soolution.getCausa());
        registro.setSolution(soolution.getSolution());
        registro.setStatus(soolution.getStatus());
        Soolution updated = soolutionRepository.save(registro);

        return new ModelAndView("index");
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") int id) {
        soolutionRepository.delete(id + "");
        return new ModelAndView("index");
    }
}
