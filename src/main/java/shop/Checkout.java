package main.java.shop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import main.java.shop.offers.MultibuyOffer;
import main.java.shop.products.Apple;
import main.java.shop.products.Orange;

public class Checkout {

  /**
   * Adds the Apples and Oranges and applies offers to return cost
   * 
   * @param basket
   *          string array of items
   * @return cost of items
   */
  public BigDecimal tally(String[] basket) {
    // TODO you could abstract the product by using the factory pattern here
    int numberOfApples = countItemsOfType(basket, Apple.NAME);
    int numberOfOranges = countItemsOfType(basket, Orange.NAME);
    return costOfItems(numberOfApples, Apple.COST, Apple.OFFER)
        .add(costOfItems(numberOfOranges, Orange.COST, Orange.OFFER));
  }

  private BigDecimal costOfItems(int quantity, BigDecimal cost, MultibuyOffer offer) {
    int offerQuantity = offer.getOfferQuantity();
    int billedQuantity = offer.getBilledQuantity();
    int remainder = quantity % offerQuantity;
    int effectiveQuantity = (((quantity - remainder) / offerQuantity) * billedQuantity) + remainder;
    return cost.multiply(new BigDecimal(effectiveQuantity)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
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
