/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class CountryDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private List<SystemUserDTO> systemUsers;

    public CountryDTO() {
    }

    public CountryDTO(UUID uuid) {
        super(uuid);
    }

    public CountryDTO(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<SystemUserDTO> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUserDTO> systemUsers) {
        this.systemUsers = systemUsers;
    }

}
