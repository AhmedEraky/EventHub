/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */

public class VipDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String bio;
    private String name;
    private byte[] image;
    private List<VipSpeaksInSessionDTO> vipSpeaksInSessions;
    private JobTitleDTO jobTitle;
    private OrganizationDTO organization;

    public VipDTO() {
    }

    public VipDTO(UUID uuid) {
        super(uuid);
    }

    public VipDTO(UUID uuid, String bio, String name) {
        super(uuid);
        this.bio = bio;
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<VipSpeaksInSessionDTO> getVipSpeaksInSessions() {
        return vipSpeaksInSessions;
    }

    public void setVipSpeaksInSessions(List<VipSpeaksInSessionDTO> vipSpeaksInSessions) {
        this.vipSpeaksInSessions = vipSpeaksInSessions;
    }

    public JobTitleDTO getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitleDTO jobTitle) {
        this.jobTitle = jobTitle;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }
}
