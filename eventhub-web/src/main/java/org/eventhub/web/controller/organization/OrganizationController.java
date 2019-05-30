package org.eventhub.web.controller.organization;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.facade.organization.OrganizationManagementFacade;
import org.eventhub.facade.organization.OrganizationRetrivalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.ws.rs.FormParam;
import java.util.UUID;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
@Controller
public class OrganizationController
{
    @Autowired
    OrganizationManagementFacade organizationManagementFacade;

    @Autowired
    OrganizationRetrivalFacade organizationRetrivalFacade;

    @GetMapping("/addOrganization")
    public String getOrganizationForm(Model model)
    {
        model.addAttribute(new Organization());
        return "addOrganization";
    }

    @GetMapping(value = "/updateOrganization")
    public String getUpdateOrganizationForm(@RequestParam("id") String id, Model model)
    {
        UUID uuid = UUID.fromString(id);
        model.addAttribute(organizationRetrivalFacade.getOrganizationByUUID(uuid));
        return "updateOrganization";
    }

    @PostMapping("/addOrganization")
    public String addOrganization(@Valid @ModelAttribute("organization") Organization organization,
                                  @FormParam("logo") MultipartFile attachement,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors())
            return "addOrgnaization";
        else {
            organization.setLogo(null);
            Organization org = organizationManagementFacade.createOrganization(organization);
            return "redirect:/addOrgnaization?Done+id="+org.getUuid();
        }
    }

    @PostMapping("/updateOrganization")
    public String updateOrganization(@Valid @ModelAttribute("organization") Organization organization,
                                  @FormParam("logo") MultipartFile attachement,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors())
            return "updateOrgnaization";
        else {
            organization.setLogo(null);
            organizationManagementFacade.updateOrganization(organization);
            return "redirect:/updateOrgnaization?Done";
        }
    }
}
