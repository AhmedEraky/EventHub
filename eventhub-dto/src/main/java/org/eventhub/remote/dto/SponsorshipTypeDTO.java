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
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */

public class SponsorshipTypeDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private List<SponsorDTO> sponsors;

    public SponsorshipTypeDTO() {
    }

    public SponsorshipTypeDTO(UUID uuid) {
        super(uuid);
    }

    public SponsorshipTypeDTO(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SponsorDTO> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<SponsorDTO> sponsors) {
        this.sponsors = sponsors;
    }
}
