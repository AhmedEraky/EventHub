package org.eventhub.web.controller.organization;

import java.io.IOException;
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

    @PostMapping("/addOrganization")
    public String addOrganization(@Valid @ModelAttribute("organization") Organization organization,
                                  @FormParam("logo_image") MultipartFile attachement,
                                  BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors())
            return "addOrgnaization?error";
        else {
           
              //  organization.setLogo(attachement.getBytes());
            Organization org = organizationManagementFacade.createOrganization(organization);
            return "redirect:/success?id="+org.getUuid();
        }
    }
    
     @GetMapping(value = "/updateOrganization",params = "id")
    public String getUpdateOrganizationForm(@RequestParam("id") String id, Model model)
    {
        UUID uuid = UUID.fromString(id);
        model.addAttribute(organizationRetrivalFacade.getOrganizationByUUID(uuid));
        return "updateOrganization";
    }

    @PostMapping("/updateOrganization")
    public String updateOrganization(@Valid @ModelAttribute("organization") Organization updatedOrganization,
                                  @FormParam("logo_image") MultipartFile attachement,
                                  @RequestParam("id") String id,
                                  BindingResult bindingResult,
                                  Model model) throws IOException {
        if (bindingResult.hasErrors())
            return "updateOrgnaization?error";
        else {
            
//            organization.setLogo(attachement.getBytes());
            updatedOrganization.setUuid(UUID.fromString(id));
            organizationManagementFacade.updateOrganization(updatedOrganization);
            return "redirect:/success?Done";
        }
    }
}
