import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

  String[][] food = {{"Pasta", "Gelato", "Carne", "Pizza"},
  {"Spaghetti", "Limoncello", "Cotoletta", "Margherita"},
  {"Penne", "Chocolate", "Salame", "Focaccia"},
  {"Ravioli", "Stracciatella", "Prosciutto", "Calzone"},
  {"Conchiglie", "Fragola", "Sopressata", "ProsciuttoRucola"}};

    int[][] ratings = {{9, 10, 7, 8},
                     {10, 9, 8, 7},
                     {7, 5, 3, 8},
                     {3, 4, 10, 7},
                     {2, 7, 2, 8}};

  DataScene briana = new DataScene(food, ratings);

  briana.drawScene();

  Theater.playScenes(briana);
    

    
    
  }
}
