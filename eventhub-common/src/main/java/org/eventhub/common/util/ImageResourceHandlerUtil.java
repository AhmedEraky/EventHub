/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eventhub.common.model.entity.SystemUser;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FARES-LAP
 */
public class ImageResourceHandlerUtil {

    public static void saveSystemUserImageResource(SystemUser systemUser, MultipartFile imageResource) {
        OutputStream out = null;
        InputStream imageContent = null;
        String profileImagePath = systemUser.getProfileImage();

        try {
            File imageSaveDirectory = new File(profileImagePath);
            if (!imageSaveDirectory.exists()) {
                imageSaveDirectory.mkdir();
            }
            out = new FileOutputStream(new File(profileImagePath + "profile.jpg"));
            imageContent = imageResource.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[10000];

            while ((read = imageContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImagePathProviderUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImagePathProviderUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ImagePathProviderUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (imageContent != null) {
                try {
                    imageContent.close();
                } catch (IOException ex) {
                    Logger.getLogger(ImagePathProviderUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
