package org.eventhub.web.controller.organization;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.facade.organization.OrganizationManagementFacade;
import org.eventhub.facade.organization.OrganizationRetrivalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.FormParam;
import java.util.UUID;

@Controller
@RequestMapping("/org")
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
    public String addOrganization(@ModelAttribute("organization") Organization organization,
                                  @FormParam("logo") MultipartFile attachement,
                                  Model model) {
        organization.setLogo(null);
        Organization org = organizationManagementFacade.createOrganization(organization);
        return "redirect:/addOrgnaization?Done";
    }

    @PostMapping("/updateOrganization")
    public String updateOrganization(@ModelAttribute("organization") Organization organization,
                                  @FormParam("logo") MultipartFile attachement,
                                  Model model) {
        organization.setLogo(null);
        organizationManagementFacade.updateOrganization(organization);
        return "redirect:/updateOrgnaization?Done";
    }
}
