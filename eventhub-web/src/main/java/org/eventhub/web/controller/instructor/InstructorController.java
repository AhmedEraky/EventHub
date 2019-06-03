package org.eventhub.web.controller.instructor;

import org.eventhub.common.model.entity.Instructor;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.instructor.CreateInstructorFacade;
import org.eventhub.facade.instructor.RetrieveInstructorFacade;
import org.eventhub.facade.user.CreateUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Menna Helmy
 */
@Controller
@RequestMapping
public class InstructorController {

    @Autowired
    CreateInstructorFacade createInstructorFacade;
    @Autowired
    RetrieveInstructorFacade retrieveInstructorFacade;
    @Autowired
    CreateUserFacade createUserFacade;
//    /**
//     *
//     * get method to display the persistence form
//     * @param model
//     * @return
//     */

    @RequestMapping(method = RequestMethod.GET, path = "/addInstructor")
    public String getBody(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor/addInstructor";
    }

//    /**
//     *
//     * method to fill the System User data
//     * @param model
//     */
   /* @ModelAttribute
    public void setSystemUsers(Model model){
        model.addAttribute("users",retrieveUserFacade.getAllUsers());
    }*/

    //    /**
//     *
//     * @param user
//     * @param result
//     * @return
//     */
    @RequestMapping(method = RequestMethod.POST, path = "/addInstructor")
    protected String onSubmit(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result) {
        if (result.hasErrors()) {
            return "instructor/addInstructor";
        } else {
            SystemUser user = instructor.getSystemUser();
            createUserFacade.createUser(user, null);
            createInstructorFacade.createInstructor(instructor);
            return "redirect:/createEvent";
        }
    }

    //    /**
//     * Get method to Display Update Instructor Form
//     * @param  model
//     * @param httpSession
//     * @return String
//     * @author Menna Ahmed (menna4a.helmi@gmail.com)
//     */
    @RequestMapping(method = RequestMethod.GET, path = "/updateinstruct")
    public String getUpdateForm(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            model.addAttribute("instructor", httpSession.getAttribute("instructor"));
            return "updateInstructor";
        } else {
            return "redirect:/login";
        }
    }

    //    /**
//     * post method to update the instructor Data
//     * @param instructor
//     * @param result
//     * @param httpSession
//     * @return String
//     * @author Menna Ahmed (menna4a.helmi@gmail.com)
//     */
//    
    @RequestMapping(method = RequestMethod.POST, path = "/updateinstruct")
    public String onSubmit(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "updateInstructor";
        } else {
            Instructor instructorToUpdate = (Instructor) httpSession.getAttribute("instructor");
            if (instructor.getUuid().equals(instructorToUpdate.getUuid())) {
                createInstructorFacade.updateInstructor(instructor);
                return "redirect:/success";
            } else {
                return "redirect:/login";
            }
        }
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
