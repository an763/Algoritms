package com.practice.amazon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

public class CaptchaCreator {

    private final Map<String, String> captchaStore = new ConcurrentHashMap<>();
    
    
    public static void main(String args[]) throws Exception {
    	CaptchaCreator cp = new CaptchaCreator();
    	String image = cp.generateCaptcha();
    	System.out.print("Image ::"+image);
    }

    public String generateCaptcha() throws IOException {
        String captchaText = generateRandomText(6);
        String captchaId = UUID.randomUUID().toString();

        captchaStore.put(captchaId, captchaText);

        BufferedImage image = createCaptchaImage(captchaText);

        // Convert image to Base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        String base64Image = Base64.getEncoder().encodeToString(baos.toByteArray());
        
        String filePath = "c:\\Anurag\\captcha.png"; 
        File outputFile = new File(filePath);
        ImageIO.write(image, "png", outputFile);


        return base64Image;
       
    }

  
   

    private String generateRandomText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captchaText = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            captchaText.append(characters.charAt(random.nextInt(characters.length())));
        }
        return captchaText.toString();
    }

    private BufferedImage createCaptchaImage(String text) {
        int width = 200, height = 80;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, 20, 50);

        g2d.dispose();
        return image;
    }
}

