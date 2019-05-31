/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.controller.jobtitle;

import java.util.UUID;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.facade.jobtitle.JobTitleManagementFacade;
import org.eventhub.facade.jobtitle.JobTitleRetrivalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 * @author Mohamed Elhosany (mohamed.elhosany1995@gmail.
 */
@Controller
public class JobTitleController {

    @Autowired
    JobTitleManagementFacade jobTitleManagementFacade;

    @Autowired
    JobTitleRetrivalFacade jobTitleRetrivailFacade;

    @GetMapping("/addJobTitle")
    public String getBody(Model model) {
        model.addAttribute("jobtitle", new JobTitle());
        return "addJobtitle";
    }

    @PostMapping("/addJobTitle")
    public String addJobTitle(@Valid @ModelAttribute("jobtitle") JobTitle jobTitle,
            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "addJobtitle";
        } else {
            jobTitleManagementFacade.creatJobTitle(jobTitle);
            return "redirect:/addJobtitle?Done+id=" + jobTitle.getUuid();
        }
    }

    @GetMapping("/editJobTitle")
    public String editJobTitle(Model model, @RequestParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        JobTitle jobTitle = jobTitleRetrivailFacade.getJobTitleById(uuid);
        model.addAttribute(jobTitle);
        return "editJobTitle";
    }

    @PostMapping("/editJobTitle")
    public String onEditJobTitle(@Valid @ModelAttribute JobTitle jobTitle,
            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "editJobTitle";
        } else {
            jobTitleManagementFacade.updateJobTitle(jobTitle);
            return "redirect:/editJobTitle?Done+id=" + jobTitle.getUuid();
        }
    }
}
