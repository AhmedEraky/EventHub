/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.user;

/**
 *
 * @author ibrahim
 */
public interface UserPasswordFacade {

    boolean updateUserPassword(String userId, String oldPassword, String newPassword);

    boolean resetPassword(String email);
}
