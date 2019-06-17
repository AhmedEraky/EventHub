package org.eventhub.web.rest.remote;

import org.eventhub.facade.user.UserPasswordFacade;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.dto.UpdatePasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ibrahim
 */
@RestController
@RequestMapping("/api")
public class PasswordRest {

    @Autowired
    UserPasswordFacade userPasswordFacade;

    @PatchMapping("/users/{id}")
    public JResponse<String> updatePassword(@PathVariable("id") String userId,
            UpdatePasswordDto updatePasswordDto) {
        JResponse<String> response = new JResponse<>();
        if (userPasswordFacade.updateUserPassword(userId, updatePasswordDto.getOldPassword(),
                updatePasswordDto.getNewPassword())) {
            response.setStatus("Success");
            response.setDtoContent("PasswordUpdated");
        } else {
            response.setStatus("Fail");
            response.setDtoContent("Failed to update password");
        }
        return response;
    }

    @PostMapping("/users/resetpassword/{email}")
    public JResponse<String> resetPassword(@PathVariable("email") String email) {
        JResponse<String> response = new JResponse<>();
        if (userPasswordFacade.resetPassword(email)) {
            response.setStatus("success");
            response.setDtoContent("Please check your email");
        } else {
            response.setStatus("Fail");
            response.setDtoContent("Failed to reset password");
        }
        return response;
    }
}
