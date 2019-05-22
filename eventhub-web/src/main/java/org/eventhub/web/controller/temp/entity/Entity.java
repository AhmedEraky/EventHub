/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.controller.temp.entity;

import java.util.*;

/**
 *
 * @author FARES-LAP
 */
public class Entity {

    String email;
    String password;
    Integer number;
    String listSelectOne;
    Set<String> listMultipleSelect = new HashSet<>();
    String textArea;
    byte[] attachment;
    String radio;
    List<String> checkbox = new ArrayList<>();
    String disabledInput;
    String readOnlyInput;
    String validInput;
    String invalidInput;
    String largeInput;
    String smallInput;
    boolean isSelected;
    String customSelect;
    byte[] customFile;

    Date event_startDate;
    Date event_endDate;
    Date session_startDate;
    Date session_endDate;
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getListSelectOne() {
        return listSelectOne;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setListSelectOne(String listSelectOne) {
        this.listSelectOne = listSelectOne;
    }

    public Set<String> getListMultipleSelect() {
        return listMultipleSelect;
    }

    public void setListMultipleSelect(Set<String> listMultipleSelect) {
        this.listMultipleSelect = listMultipleSelect;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public List<String> getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(List<String> checkbox) {
        this.checkbox = checkbox;
    }

    public String getDisabledInput() {
        return disabledInput;
    }

    public void setDisabledInput(String disabledInput) {
        this.disabledInput = disabledInput;
    }

    public String getReadOnlyInput() {
        return readOnlyInput;
    }

    public void setReadOnlyInput(String readOnlyInput) {
        this.readOnlyInput = readOnlyInput;
    }

    public String getValidInput() {
        return validInput;
    }

    public void setValidInput(String validInput) {
        this.validInput = validInput;
    }

    public String getInvalidInput() {
        return invalidInput;
    }

    public void setInvalidInput(String invalidInput) {
        this.invalidInput = invalidInput;
    }

    public String getLargeInput() {
        return largeInput;
    }

    public void setLargeInput(String largeInput) {
        this.largeInput = largeInput;
    }

    public String getSmallInput() {
        return smallInput;
    }

    public void setSmallInput(String smallInput) {
        this.smallInput = smallInput;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getCustomSelect() {
        return customSelect;
    }

    public void setCustomSelect(String customSelect) {
        this.customSelect = customSelect;
    }

    public byte[] getCustomFile() {
        return customFile;
    }

    public void setCustomFile(byte[] customFile) {
        this.customFile = customFile;
    }

    public Date getEvent_startDate() {
        return event_startDate;
    }

    public void setEvent_startDate(Date event_startDate) {
        this.event_startDate = event_startDate;
    }

    public Date getEvent_endDate() {
        return event_endDate;
    }

    public void setEvent_endDate(Date event_endDate) {
        this.event_endDate = event_endDate;
    }

    public Date getSession_startDate() {
        return session_startDate;
    }

    public void setSession_startDate(Date session_startDate) {
        this.session_startDate = session_startDate;
    }

    public Date getSession_endDate() {
        return session_endDate;
    }

    public void setSession_endDate(Date session_endDate) {
        this.session_endDate = session_endDate;
    }
    
}
