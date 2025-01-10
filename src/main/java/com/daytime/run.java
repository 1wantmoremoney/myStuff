package com.daytime;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2023/12/19/10:30
 */
public class run {
    public static void main(String[] args) throws IOException {
        // Load the source image
        BufferedImage sourceImage = ImageIO.read(new File("/Users/levine/Pictures/fire.jpg"));

        // Crop the image to a circle
        BufferedImage circularImage = cropCircle(sourceImage);

        // Write the image back out
        ImageIO.write(circularImage, "PNG", new File("/Users/levine/Pictures/fire1.jpg"));

    }


    public static BufferedImage cropCircle(BufferedImage source) {
        // Assuming the source image is square, get its size.
        int size = Math.min(source.getWidth(), source.getHeight());

        // Create a new buffered image for the destination image with transparency
        BufferedImage dest = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

        // Create a graphics object to draw on the destination image
        Graphics2D g2 = dest.createGraphics();

        // Set rendering hints for quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the circle
        Ellipse2D circle = new Ellipse2D.Float(0, 0, size, size);
        g2.setClip(circle);

        // Draw the source image in the circle
        g2.drawImage(source, 0, 0, size, size, null);

        // Dispose the graphics object
        g2.dispose();

        // Return the cropped image
        return dest;
    }
}


