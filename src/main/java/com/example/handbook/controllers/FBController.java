package com.example.handbook.controllers;

import com.example.handbook.db.entities.Device;
import com.example.handbook.db.entities.FeedBack;
import com.example.handbook.db.entities.Manufacturer;
import com.example.handbook.service.DevService;
import com.example.handbook.service.FBService;
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
@RequestMapping("/feedbacks")
public class FBController {

    @Autowired
    private FBService fbService;

    @Autowired
    private DevService devService;

    // добавление
    @GetMapping("/newFB/{id}")
    public String showNewFBForm(@PathVariable("id")Integer id, Model model){
        Device dev = devService.getDevById(id);
        FeedBack fb = new FeedBack();
        model.addAttribute("feedback",fb);
        model.addAttribute("device", dev);
//        List<Manufacturer> manus = manuService.listAllManus();
//        model.addAttribute("manusList", manus);
        return "feedbacks/fb-form";
    }

    @PostMapping("/newFB/{id}")
    public String saveNewFB(FeedBack fb, RedirectAttributes ra, @PathVariable Integer id){
        fbService.addFB(fb);
        ra.addFlashAttribute("message", "Handbook has been updated: add new feedback");
        return "redirect:/devices/device-details/{id}";
    }

    @GetMapping("/update/{id}")
    public String showUpdateFBForm(@PathVariable("id") Integer id, Model model) {
        FeedBack fb = fbService.getFBById(id);
        model.addAttribute("feedback", fb);
        return "feedbacks/fb-update-form";
    }

    @PostMapping("/update")
    public String updateFB(FeedBack fb, RedirectAttributes ra) {
        fbService.addFB(fb);
        ra.addFlashAttribute("message", "Handbook has been updated: feedback updated");
        return "redirect:/devices/device-details/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteFB(@PathVariable("id") Integer id, RedirectAttributes ra) {
        fbService.deleteFB(id);
        ra.addFlashAttribute("message", "Handbook has been updated: feedback deleted");
        return "redirect:/devices/device-details/{id}";
    }


}
