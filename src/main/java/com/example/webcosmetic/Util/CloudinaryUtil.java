package com.example.webcosmetic.Util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class CloudinaryUtil {

    public static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "drncbsuo5",
            "api_key", "419211626138128",
            "api_secret", "616HgUjVrYJSj7beZaauCwSTAig"));

    public static String uploadImageToCloudinary(String base64Image) {
        try {
            byte[] imageBytes = Base64ImageUtil.getBytesFromBase64(base64Image);
            String tempFilePath = "image.png";
            saveBytesToFile(imageBytes, tempFilePath);

            Map<String, Object> uploadResult = cloudinary.uploader().upload(tempFilePath, ObjectUtils.emptyMap());

            String imageUrl = (String) uploadResult.get("url");

            deleteTempFile(tempFilePath);

            return imageUrl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveBytesToFile(byte[] bytes, String filePath) throws IOException {
        Path tempPath = Paths.get(filePath);
        Files.write(tempPath, bytes);
    }

    private static void deleteTempFile(String filePath) throws IOException {
        Files.delete(Paths.get(filePath));
    }

}
