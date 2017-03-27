package main.java.shop;

import java.util.Arrays;
import java.util.List;

import main.java.shop.products.Apple;
import main.java.shop.products.Orange;

public class Checkout {

  /**
   * 
   * @param basket string array of items  
   * @return cost of items
   */
  public double tally(String[] basket) {
    int numberOfApples = countItemsOfType(basket, Apple.NAME);
    int numberOfOranges = countItemsOfType(basket, Orange.NAME);
    return (Apple.COST * numberOfApples) + (Orange.COST * numberOfOranges);
  }
  
  private int countItemsOfType(String[] basket, String type) {
    List<String> basketList = Arrays.asList(basket);
    return (int) basketList.stream().filter(p -> p.equals(type)).count();
  }

  public static void main(String[] args) {
    Checkout checkout = new Checkout();
    System.out.println("Cost of basket is " + checkout.tally(args));
  }
  
}
