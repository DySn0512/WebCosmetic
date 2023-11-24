package com.example.webcosmetic.Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Base64ImageUtil {

    public static byte[] getBytesFromBase64(String base64Image) {
        String base64String = base64Image.split(",")[1];
        return Base64.getDecoder().decode(base64String);
    }
}
