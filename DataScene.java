import org.code.theater.*;
import org.code.media.*;
public class DataScene extends Scene {

  // 2D array of types of food/ratings
  private String[][] food;  
  private int[][] ratings;
  
 /** Constructor */
  public DataScene(String[][] food, int[][] ratings) {
    this.food = food;
    this.ratings = ratings;
  }

  /** Accessor Method for food and ratings */
  public String[][] getFood() {
    return food;
  }

  public int[][] getRatings() {
    return ratings;
  }

  // Calls all the parts of your animation, in order
  public void drawScene() {
    drawIntroScene();
    drawPastaScene();
    drawGelatoScene();
    drawCarneScene();
    drawPizzaScene();
    drawEnd();
  }

  // Sets up the intro Scene Image
  public void drawIntroScene() {
    playSound("15_Second-2021-05-12_-_The_Little_Cafe_-_www.FesliyanStudios.com.wav");
    drawImage("intro.png",0,0,400);	
    String test = new String ("benvenuto!");
    drawText(test.toUpperCase(), 10, 380);
    String tester = new String ("(TRANSLATION) - HELLO");
    drawText(tester.toLowerCase(), 10, 330);
    pause(5.0);
    clear("white");
  }

  // Sets up the pasta images, text, and filter
  public void drawPastaScene() {
    setTextHeight(50);
    for (int row = 0; row < food.length; row++) {
      fixBackground(row,0);
      ImagePlus img = new ImagePlus(food[row][0]+".png");
      drawImage(img,50,0,300);
      drawText(food[row][0],10,380);
      drawRatings(row,0);
      pause(1.0);
      img.makeNegative();
      drawImage(img,50,0,300);
      pause(1.0);
      clear("white");
    }
  }

  public void drawGelatoScene() {
    playSound("15_Second-2021-05-07_-_Italian_Fun_-_www.FesliyanStudios.com.wav");
    setTextHeight(50);
    for (int row = 0; row < food.length; row++) {
      fixBackground(row,1);
      ImagePlus image = new ImagePlus(food[row][1]+".png");
      drawImage(image,50,0,300);
      drawText(food[row][1], 10, 380);
      drawRatings(row,1);
      pause(1.0);
      image.adjustContrast(2);
      drawImage(image,50,0,300);
      pause(1.0);
      clear("white");
    }
  }

  public void drawCarneScene() {
    setTextHeight(50);
    playSound("15_Second-2021-05-10_-_Riviera_Walk_-_www.FesliyanStudios.com.wav");
    for (int row = 0; row < food.length; row++) {
      fixBackground(row,2);
      ImagePlus im = new ImagePlus(food[row][2]+".png");
      drawImage(im,50,0,300);
      drawText(food[row][2], 10, 380);
      drawRatings(row,2);
      pause(1.0);
      im.pixelate(5);
      drawImage(im,50,0,300);
      pause(1.0);
      clear("white");
    }
  }

  public void drawPizzaScene() {
    setTextHeight(50);
    playSound("15_Second-2021-05-07_-_Tarantella_-_www.FesliyanStudios.com.wav");
    for (int row = 0; row < food.length; row++) {
      fixBackground(row,3);
      ImagePlus imag = new ImagePlus(food[row][3]+".png");
      drawImage(imag,50,0,300);
      drawText(food[row][3], 10, 380);
      drawRatings(row,3);
      pause(1.0);
      imag.makeBlackAndWhite();
      drawImage(imag,50,0,300);
      pause(1.0);
      clear("white");
    }
  }

  public void drawEnd() {
    drawImage("Screenshot-2025-02-02-12.02.35-PM.png",0,50,400);
  }

  public void drawRatings(int row, int col) {
    drawText("Rating:" + ratings[row][col],10, 330);
  }

  public void fixBackground(int row, int col) {
    drawBackground(ratings[row][col]);
  }

  public void drawBackground(int ratings) {
    if (ratings >= 7){
      int ranRed = (int) (Math.random() * 256);
      int ranGreen = (int) (Math.random() * 256);
      int ranBlue = (int) (Math.random() * 256);
      Color c = new Color(ranRed,ranGreen,ranBlue);
      clear(c);
    } else if (ratings > 4){
        clear("yellow");
    } else {
        clear ("red");
    }
}
}
