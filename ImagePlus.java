import org.code.theater.*;
import org.code.media.*;

/*
 * Represents an image that can be modified with filters and effects
 */
public class ImagePlus extends Image {

  private Pixel[][] pixels;    // The 2D array of pixels

  /*
   * Sets the superclass filename to the specified filename
   * and calls the getPixelsFromImage() method to initialize
   * the 2D array of Pixel objects that make up the image
   */
  public ImagePlus(String filename) {
    super(filename);   // Calls the Image class constructor

    // Initialize the pixels array by getting the pixels from the image
    pixels = getPixelsFromImage();
  }

  /*
   * Returns the 2D array of pixels
   */
  public Pixel[][] getImagePixels() {
    return pixels;
  }

  /*
   * Returns the pixels in the image as a 2D array of Pixel objects
   */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];
    
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        tempPixels[row][col] = getPixel(col, row);
      }
    }

    return tempPixels;
  }


  /*
   * Inverts the colors in the image by setting the red,
   * green, and blue color values of each Pixel object to
   * the result of 255 minus their current values
   */
  public void makeNegative() {
    
    Pixel[][] pixels = getImagePixels();

    for (Pixel[] row : pixels) {
      for (Pixel pixel : row) {
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();
        
        pixel.setRed(255 - red);
        pixel.setGreen(255 - green);
        pixel.setBlue(255 - blue);
      }
    }
    
  }



  /*
   * Applies a pixelate filter to each Pixel object by dividing the image into a grid
   * of equal-sized rectangular regions and setting the color of each Pixel object in
   * a region to the color of the first Pixel object in the region
   */
  public void pixelate(int gridSize) {

    Pixel[][] pixels = getImagePixels(); 
    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
            int redValue = 0;
            int blueValue = 0;
            int greenValue = 0;
            int endRow = Math.min(row + gridSize, pixels.length);
            int endCol = Math.min(col + gridSize, pixels[0].length);
        for (int gridRow = row; gridRow < endRow; gridRow++) {
          for (int gridCol = col; gridCol < endCol; gridCol++) {
                // 1 add the red value to the green and blue value to total
                redValue += pixels[gridRow][gridCol].getRed();
                greenValue += pixels[gridRow][gridCol].getGreen();
                blueValue += pixels[gridRow][gridCol].getBlue();
              }
            }

            // 2 take given values and divide by how many pixels you added up
                int pixelsInGrid = (endRow - row) * (endCol - col);
            //3 use average value and apply it to all color values
                redValue /= pixelsInGrid;
                blueValue /= pixelsInGrid;
                greenValue /= pixelsInGrid;
        
            for (int gridRow = row; gridRow < endRow; gridRow++) {
              for (int gridCol = col; gridCol < endCol; gridCol++) {
                // 1 add the red value to the green and blue value to total
                pixels[gridRow][gridCol].setRed(redValue);
                pixels[gridRow][gridCol].setGreen(greenValue);
                pixels[gridRow][gridCol].setBlue(blueValue);
              }
            }
          }
      }

    
  }


  /*
   * Adjusts the contrast of the image by multiplying the
   * red, green, and blue values by the multiplier
   */
  public void adjustContrast(int multiplier) {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, and traverse the 2D array of Pixel objects.
     * Multiply the red, green, and blue values of each Pixel by the multiplier,
     * and set the color values to the result.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();

    for (Pixel[] row : pixels) {
      for (Pixel currentPixel : row) {
        int newRed = currentPixel.getRed() * multiplier;
        int newGreen = currentPixel.getGreen() * multiplier;
        int newBlue = currentPixel.getBlue() * multiplier;

        if (newRed > 255) {
          newRed = 255;
        }

        if (newGreen > 255) {
          newGreen = 255;
        }

        if (newBlue > 255) {
          newBlue = 255;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

  public void makeBlackAndWhite() {
    Pixel[][] pixel = getImagePixels();
    for (Pixel[] row : pixel) {
      for (Pixel currentPixel : row) {
      int x = currentPixel.getX();
      int y = currentPixel.getY();
      int grayScale = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;
      if (grayScale > 127) {
        Color testerColor = new Color(255, 255, 255);
        currentPixel.setColor(testerColor);
      } else {
        Color testColor = new Color(0, 0, 0);
        currentPixel.setColor(testColor);
      }
    }
  }
}


}
