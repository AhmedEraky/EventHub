package org.eventhub.web.controller.session;

import org.eventhub.common.model.entity.Session;
import org.eventhub.facade.session.SessionManagementFacade;
import org.eventhub.facade.session.SessionRetrievalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SessionController {

    @Autowired
    private SessionManagementFacade sessionManagementFacade;
    @Autowired
    private SessionRetrievalFacade sessionRetrievalFacade;

    @GetMapping(path = "/addSession")
    public String addSession(Model model) {
        model.addAttribute("session", new Session());
        return "addSession";
    }

    @PostMapping(path = "addSession")
    public String onAdd(@Valid @ModelAttribute("session") Session session, BindingResult result) {
        if (result.hasErrors()) {
            return "addSession";
        } else {
            sessionManagementFacade.createSession(session);
            return "redirect:addSession?success&id=" + session.getUuid().toString();
        }
    }

    @GetMapping(path = "/editSession")
    public String editSession(Model model, @RequestParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("session", sessionRetrievalFacade.getSessionById(uuid));
        return "editSession";
    }

    @PostMapping(path = "")
    public String onEdit(@Valid @ModelAttribute("session") Session session, BindingResult result) {
        if (result.hasErrors()) {
            return "editSession";
        } else {
            sessionManagementFacade.updateSession(session);
            return "redirect:editSession?success&id" + session.getUuid().toString();
        }
    }
}
