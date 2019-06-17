package org.eventhub.web.rest.remote;

import org.eventhub.common.model.entity.Event;
import org.eventhub.web.rest.remote.dto.EventDTO;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.user.impl.CreateUserFacadeImpl;
import org.eventhub.service.user.RetrieveUserService;
import org.eventhub.web.rest.remote.adapter.SystemUserAdapter;
import org.eventhub.web.rest.remote.dto.SystemUserDTO;

@RestController
@RequestMapping("/api")
public class UserRest {
    @Autowired
    RetrieveUserService userService;
    @Autowired
    SystemUserAdapter userAdapter;
    @Autowired
    CreateUserFacadeImpl createUserFacadeImpl;
    
//    @GetMapping("/user")
//    public String getUser(){
//        return "Ahmed";
//    }

//    @GetMapping("/user")
//    public JResponse<List<SystemUserDTO>> getUsers(){
//        List<SystemUser> users=userService.getAllUsers();
//        List<SystemUserDTO> userDTOS=new ArrayList<>();
//        for (SystemUser user:users){
//            userDTOS.add(userAdapter.toSystemUserDTO(user));
//        }
//        JResponse jResponse = new JResponse();
//        jResponse.setDtoContent(userDTOS);
//        jResponse.setStatus("success");
//        return jResponse;
//    }

    @PostMapping("/user")
    public JResponse<SystemUserDTO> addUser(@RequestBody SystemUserDTO SystemUserDTO){
        JResponse<SystemUserDTO> userResponse=new JResponse<>();
        SystemUser systemUser = userAdapter.fromSystemUserDTO(SystemUserDTO);
        try {
            createUserFacadeImpl.createUser(systemUser, null);
            userResponse.setDtoContent(SystemUserDTO);
            userResponse.setStatus("Success");
        }catch (Exception e){
            userResponse.setStatus("Fail");
            userResponse.setDtoContent(new SystemUserDTO());
        }
        return userResponse;
    }

}
