/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class JResponse {
    String status;
    Object dtoContent;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDtoContent() {
        return dtoContent;
    }

    public void setDtoContent(Object dtoContent) {
        this.dtoContent = dtoContent;
    }
    
}
