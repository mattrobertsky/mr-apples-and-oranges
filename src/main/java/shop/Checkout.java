package main.java.shop;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

import main.java.shop.products.Apple;
import main.java.shop.products.Orange;

public class Checkout {
  
  public static final MathContext MC = new MathContext(2);

  /**
   * Adds the Apples and Oranges and applies offers to return cost
   * @param basket string array of items  
   * @return cost of items
   */
  public BigDecimal tally(String[] basket) {
    int numberOfApples = countItemsOfType(basket, Apple.NAME);
    int numberOfOranges = countItemsOfType(basket, Orange.NAME);
    return costOfItems(numberOfApples, Apple.OFFER_QUANTITY, Apple.OFFER_ACTUAL, Apple.COST)
        .add(costOfItems(numberOfOranges, Orange.OFFER_QUANTITY, Orange.OFFER_ACTUAL, Orange.COST));
  }

  private BigDecimal costOfItems(int quantity, int offerQuantity, int offerActual, BigDecimal cost) {
    int remainder = quantity % offerQuantity;
    int effectiveQuantity = (((quantity - remainder) / offerQuantity) * offerActual) + remainder;
    return cost.multiply(new BigDecimal(effectiveQuantity), MC).setScale(2, BigDecimal.ROUND_HALF_DOWN);
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
