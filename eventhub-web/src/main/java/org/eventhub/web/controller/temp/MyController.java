package org.eventhub.web.controller.temp;

import org.eventhub.web.controller.temp.entity.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalTime;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model) {

        return "common";
    }

    @GetMapping("/goBody")
    public String getBody(Model model) {
        model.addAttribute("user", new Entity());
        addCommonAttributes(model);
        return "defBody";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("time", LocalTime.now());
    }

    @RequestMapping( value = "/persist.htm" ,method = RequestMethod.POST)
    public String insertUser(@Valid @ModelAttribute("entity") Entity entity,
            BindingResult result) {
//        try {
        if (result.hasErrors()) {
            return "common";
        }

//        System.out.println("Amer Tessssssssssssst....");
//            entity.setAttachment(attachment.getBytes());
//            entity.setCustomFile(customFile.getBytes());
        System.out.println(entity.getEmail());
        System.out.println(entity.getPassword());
//            System.out.println(entity.getAttachment().length);
        System.out.println(entity.getCheckbox());
//            System.out.println(entity.getCustomFile().length);
        System.out.println(entity.getCustomSelect());
        System.out.println(entity.getDisabledInput());
        System.out.println(entity.getInvalidInput());
        System.out.println(entity.getLargeInput());
        System.out.println(entity.getListMultipleSelect());
        System.out.println(entity.getRadio());
        System.out.println(entity.getReadOnlyInput());
        System.out.println(entity.getSmallInput());
        System.out.println(entity.isIsSelected());
        System.out.println(entity.getTextArea());
        System.out.println(entity.getValidInput());
        System.out.println(entity.getEvent_startDate());
        System.out.println(entity.getEvent_endDate());
        System.out.println(entity.getSession_startDate());
        System.out.println(entity.getSession_endDate());
//        } catch (IOException ex) {
//            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return "success";
    }

}
