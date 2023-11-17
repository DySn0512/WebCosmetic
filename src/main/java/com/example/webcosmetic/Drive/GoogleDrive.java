package com.example.webcosmetic.Drive;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Collections;

public class GoogleDrive {

    public static File uploadImage(String base64Image) throws IOException, GeneralSecurityException {
        Drive service = GoogleDriveService.getDriveService();
        String base64String = base64Image.split(",")[1];
        byte[] imageBytes = Base64.getDecoder().decode(base64String);

        File fileMetadata = new File();
        fileMetadata.setName("MyImage.jpg");
        fileMetadata.setParents(Collections.singletonList("1EKGJgQD3EpzRPnsZMCz3J2DWAg5yN4P5"));
        ByteArrayContent mediaContent = new ByteArrayContent("image/jpeg", imageBytes);

        return service.files().create(fileMetadata, mediaContent)
                .setFields("id,webContentLink")
                .execute();
    }

    public static void removeImage(String id) throws GeneralSecurityException, IOException {
        Drive service = GoogleDriveService.getDriveService();
        service.files().delete(id).execute();
    }

}

