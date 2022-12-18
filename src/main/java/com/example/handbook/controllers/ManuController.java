package com.example.handbook.controllers;


import com.example.handbook.db.entities.Manufacturer;
import com.example.handbook.db.repositories.DeviceRepository;
import com.example.handbook.db.repositories.ManufacturerRepository;
import com.example.handbook.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/manus")
public class ManuController {

    @Autowired
    private DeviceRepository devRepo;

    @Autowired
    private ManufacturerService manuService;

    public ManuController(ManufacturerService manuService) {
        this.manuService = manuService;
    }

    @GetMapping
    public String showAllManus(Model model) {
        List<Manufacturer> listManus = manuService.listAllManus();
        model.addAttribute("listManus", listManus);
        return "manufacturers/manufacturers-list";
    }

    @GetMapping("/newManu")
    public String showNewManuForm(Model model) {
        model.addAttribute("manu", new Manufacturer());
        return "manufacturers/manufacturers-form";
    }

    @PostMapping("/newManu")
    public String saveNewManu(Manufacturer manu, RedirectAttributes ra) {
        manuService.saveManu(manu);
        ra.addFlashAttribute("message", "Handbook has been updated: " +
                " add new manufacturer");
        return "redirect:/manus";
    }

    @GetMapping("/update/{id}")
    public String showUpdateManuForm(@PathVariable("id") Integer id, Model model) {
        Manufacturer manu = manuService.getManuById(id);
        model.addAttribute("manu", manu);

        return "manufacturers/manufacturers-update-form";
    }

    @PostMapping("/update")
    public String updateManu(Manufacturer manu, RedirectAttributes ra) {
        manuService.updateManu(manu);
        ra.addFlashAttribute("message",
                "Handbook has been updated: manufacturer updated");
        return "redirect:/manus";
    }

    @GetMapping("delete/{id}")
    public String deleteManu(@PathVariable("id") Integer id, RedirectAttributes ra) {
        devRepo.clearManuInDeviceByManu(id);
        manuService.deleteManu(id);
        ra.addFlashAttribute("message",
                "Handbook has been updated: manufacturer and its products deleted");
        return "redirect:/manus";
    }

    @GetMapping("/details/{id}")
    public String showDetailsAboutManu(@PathVariable("id") Integer id, Model model) {
        Manufacturer manu = manuService.getManuById(id);
        model.addAttribute("manu", manu);
        return "manufacturers/manufacturers-details";
    }
}
