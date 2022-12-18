package com.example.handbook.controllers;

import com.example.handbook.db.entities.Device;
import com.example.handbook.db.entities.FeedBack;
import com.example.handbook.db.entities.Manufacturer;
import com.example.handbook.db.repositories.FeedBackRepository;
import com.example.handbook.service.DevService;
import com.example.handbook.service.FBService;
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
@RequestMapping(value = "/devices")
public class DevController {

    @Autowired
    private DevService devService;

    @Autowired
    private ManufacturerService manuService;

    @Autowired
    private FeedBackRepository fbRepo;

    @Autowired
    private FBService fbService;

    @GetMapping()
    public String showAllDevs(Model model) {
        List<Device> listDevices = devService.getAllDev();
        model.addAttribute("devicesList", listDevices);

        return "/devices/device-list";
    }

    // добавление
    @GetMapping("/new")
    public String showNewDevForm(Model model){
        model.addAttribute("device", new Device());
        List<Manufacturer> manus = manuService.listAllManus();
        model.addAttribute("manusList", manus);
        return "devices/device-form";
    }

    @PostMapping("/new")
    public String saveNewDev(Device dev, RedirectAttributes ra){
        devService.addDev(dev);
        ra.addFlashAttribute("message", "Handbook has been updated: add new device");
        return "redirect:/devices";
    }

    // изменение/обновление
    @GetMapping("/update/{id}")
    public String showUpdateDevForm(@PathVariable("id") Integer id, Model model) {
        Device dev = devService.getDevById(id);
        model.addAttribute("device", dev);
        List<Manufacturer> manus = manuService.listAllManus();
        model.addAttribute("manusList", manus);
        // ВАЖНО: при возврате представления указывается имя представления
        return "devices/device-update-form";
    }

    @PostMapping("/update")
    public String updateDev(Device dev, RedirectAttributes ra) {
        devService.addDev(dev);
        ra.addFlashAttribute("message", "Handbook has been updated: device updated");
        return "redirect:/devices";
    }

    @GetMapping("/delete/{id}")
    public String deleteDev(@PathVariable("id") Integer id, RedirectAttributes ra) {
        devService.deleteDev(id);
        ra.addFlashAttribute("message", "Handbook has been updated: device deleted");
        return "redirect:/devices";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") Integer id, Model model){
        Device dev = devService.getDevById(id);
        model.addAttribute("device", dev);
        List<FeedBack> feedBackList = fbService.getFBsByDeviceId(id);
        model.addAttribute("feedBackList", feedBackList);
        return "devices/device-details";
    }
}
