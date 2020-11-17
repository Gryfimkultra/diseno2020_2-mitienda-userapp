package co.edu.eam.disenosoftware.mitienda.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Image utils class
 */
public class ImageUtil {

  /**
   * Method to load an image from url
   *
   * @param url url
   * @return imagicon
   */
  public static ImageIcon loadFromURL(String url) {
    Image image = null;
    try {
      return new ImageIcon(ImageIO.read(new URL(url)));
    } catch (IOException e) {
      return new ImageIcon(ImageUtil.class.getClassLoader().getResource("images/notfound.png"));
    }
  }

  /**
   * Load image from url scaling the image.
   *
   * @param url    url
   * @param width  withd
   * @param height heigh
   * @return scaled image
   */
  public static ImageIcon loadFromURL(String url, int width, int height) {
    ImageIcon imageIcon = loadFromURL(url);
    Image image = imageIcon.getImage(); // transform it
    Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // scale it the smooth way
    imageIcon = new ImageIcon(newimg);  // transform it back
    return imageIcon;
  }
}
