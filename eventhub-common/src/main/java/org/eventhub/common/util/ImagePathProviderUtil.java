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
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eventhub.common.model.entity.SystemUser;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FARES-LAP
 */
public class ImagePathProviderUtil {

    public static final String SYSTEM_USERS_IMAGES_PATH = "/systemUsers/";

    public static String getUserImagePath(SystemUser systemUser) {
        String imagePath = SYSTEM_USERS_IMAGES_PATH
                + File.separator
                + systemUser.getUuid()
                + File.separator;
        return imagePath;
    }
}
