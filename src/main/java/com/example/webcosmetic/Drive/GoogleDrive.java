package com.example.webcosmetic.Drive;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Collections;

public class GoogleDrive {

    public static File uploadImage(String base64Image)  {
        Drive service = null;
        try {
            service = GoogleDriveService.getDriveService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        String base64String = base64Image.split(",")[1];
        byte[] imageBytes = Base64.getDecoder().decode(base64String);

        File fileMetadata = new File();
        fileMetadata.setName("MyImage.jpg");
        fileMetadata.setParents(Collections.singletonList("1EKGJgQD3EpzRPnsZMCz3J2DWAg5yN4P5"));
        ByteArrayContent mediaContent = new ByteArrayContent("image/jpeg", imageBytes);

        try {
            return service.files().create(fileMetadata, mediaContent)
                    .setFields("id,webContentLink")
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeImage(String id) throws IOException {
        Drive service = null;
        try {
            service = GoogleDriveService.getDriveService();
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        service.files().delete(id).execute();
    }

    public static void removeListImage(String[] ids) throws IOException {
        for (var item : ids) {
            removeImage(item);
        }
    }

}

