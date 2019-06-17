/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class VipSpeaksInSessionDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private SessionDTO session;
    private VipDTO vip;

    public VipSpeaksInSessionDTO() {
    }

    public VipSpeaksInSessionDTO(UUID uuid) {
        super(uuid);
    }

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }

    public VipDTO getVip() {
        return vip;
    }

    public void setVip(VipDTO vip) {
        this.vip = vip;
    }
}
