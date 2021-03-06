package org.eventhub.web.controller.vip;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.Vip;
import org.eventhub.dal.dao.JobTitleRepository;
import org.eventhub.dal.dao.OrganizationRepository;
import org.eventhub.facade.vip.CreateVipFacade;
import org.eventhub.facade.vip.RetrieveVipFacade;
import org.eventhub.service.organization.RetrieveOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping
public class VipController {

    @Autowired
    CreateVipFacade createVipFacade;
    @Autowired
    RetrieveVipFacade retrieveVipFacade;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    RetrieveOrganizationService retrieveOrganizationService;


    /**
     *
     * @param model mvc model
     * @param jobTitleId UUID of {@link org.eventhub.common.model.entity.JobTitle}
     * @param organizationId UUID of {@link org.eventhub.common.model.entity.Organization}
     * @return  String represents the logical view name
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/addVip",params={"jobTitleId","organizationId"})
    public String getBody(Model model ,@RequestParam("jobTitleId") UUID jobTitleId, @RequestParam("organizationId") UUID organizationId) {
        model.addAttribute("vip", new Vip());
        return "addVip";
    }


    /**
     *
     * @param vip entity of {@link org.eventhub.common.model.entity.Vip}
     * @param jobTitleId UUID of {@link org.eventhub.common.model.entity.JobTitle}
     * @param organizationId UUID of {@link org.eventhub.common.model.entity.Organization}
     * @param result  binding result
     * @return  String represents the logical view name
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */


    @RequestMapping(method = RequestMethod.POST, path = "/addVip",params={"jobTitleId","organizationId"})
    public String  addingVip( @Valid @ModelAttribute("vip") Vip vip,@RequestParam("jobTitleId") UUID jobTitleId, @RequestParam("organizationId") UUID organizationId,
                              @RequestParam("vipImage") MultipartFile vipImage,BindingResult result){
        if(result.hasErrors()){
            return "addVip?error";
        }
        else {

            JobTitle jobTitle = jobTitleRepository.findById(jobTitleId).get();
            if(jobTitle ==null){
                vip.setJobTitle(new JobTitle());
                vip.getJobTitle().setUuid(jobTitleId);
            }
            else {
                vip.setJobTitle(jobTitle);
            }
            //add method in organisation service to return object by UUID
            Organization organization = retrieveOrganizationService.getOrganizationByUUID(organizationId);
            if(organization ==null){
                vip.setOrganization(new Organization());
                vip.getOrganization().setUuid(organizationId);
            }
            else {
                vip.setOrganization(organization);
            }
            /**add image **/
            try {
                vip.setImage(vipImage.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            createVipFacade.createVip(vip);
            return "redirect:/success?id=" + vip.getUuid();
        }

    }


    /**
     *
     * @param uuidVip  UUID of {@link org.eventhub.common.model.entity.Vip}
     * @param model mvc model
     * @return String logical view name
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET,path = "/updateVip",params="vipId")
    public String getUpdateVipForm(@RequestParam("vipId")UUID uuidVip, Model model) {
        Vip vip=retrieveVipFacade.getVipById(uuidVip);
            model.addAttribute("vip",vip);
            return "updateVip";
    }

    /**
     *
     * @param uuidVip UUID of {@link org.eventhub.common.model.entity.Vip}
     * @param updatedVip entity of  {@link org.eventhub.common.model.entity.Vip}
     * @param result binding result
     * @return String represents logical view name
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/updateVip",params="vipId")
    public String onSubmit(@RequestParam("vipId")String uuidVip,@Valid @ModelAttribute("vip") Vip updatedVip,
                           @RequestParam("vipImage") MultipartFile vipImage,BindingResult result) {
        if (result.hasErrors()) {
            return "updateVip?error";
        }
        else {
            UUID uuid= UUID.fromString(uuidVip);
            Vip vip=retrieveVipFacade.getVipById(uuid);
            if(vip !=null) {
                updatedVip.setOrganization(vip.getOrganization());
                updatedVip.setJobTitle(vip.getJobTitle());
                try {
                    updatedVip.setImage(vipImage.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                createVipFacade.updateVip(updatedVip);
                return "redirect:/success?id="+vip.getUuid();
            }
            else{
                return "redirect:/updateVip?errorInvipId";
            }
            }

    }

}
