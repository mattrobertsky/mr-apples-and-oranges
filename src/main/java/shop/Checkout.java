package main.java.shop;

import main.java.shop.products.Apple;
import main.java.shop.products.Orange;

public class Checkout {

  /**
   * 
   * @param basket string array of items  
   * @return cost of items
   */
  public double tally(String[] basket) {
    double tally = 0;
    for (String item: basket) {
      if (Apple.NAME.equals(item)) {
        tally += Apple.COST;
      } else if (Orange.NAME.equals(item)) {
        tally += Orange.COST;
      }
    }
    return tally;
  }

  public static void main(String[] args) {
    Checkout checkout = new Checkout();
    System.out.println("Cost of basket is " + checkout.tally(args));
  }
  
}
