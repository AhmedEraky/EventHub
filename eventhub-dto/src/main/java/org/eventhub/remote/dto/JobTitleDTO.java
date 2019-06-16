/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */

public class JobTitleDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private List<SystemUserDTO> systemUsers;
    private List<VipDTO> vips;

    public JobTitleDTO() {
    }

    public JobTitleDTO(UUID uuid) {
        super(uuid);
    }

    public JobTitleDTO(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SystemUserDTO> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUserDTO> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<VipDTO> getVips() {
        return vips;
    }

    public void setVips(List<VipDTO> vips) {
        this.vips = vips;
    }
}
