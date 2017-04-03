package main.java.shop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.shop.offers.MultibuyOffer;
import main.java.shop.offers.OfferFactory;
import main.java.shop.products.Product;
import main.java.shop.products.ProductFactory;
import main.java.shop.products.UnknownProductException;

public class Checkout {

  /**
   * Adds the Apples and Oranges and applies offers to return cost
   * 
   * @param basket
   *          string array of items
   * @return cost of items
   */
  public BigDecimal tally(String[] basket) {
    // using factory pattern here to be agnostic of product
    // not using abstract factory as we need conditional logic to map the product name to the Product class
    Set<String> products = new HashSet<String>();
    products.addAll(Arrays.asList(basket));
    ProductFactory productFactory = new ProductFactory();
    BigDecimal cost = new BigDecimal(0);
    // n.b. for loops are more efficient (and readable) than streams
    for (String name : products) {
      Product product;
      try {
        product = productFactory.get(name);
        int quantity = countItemsOfType(basket, name);
        cost = cost.add(costOfItems(quantity, product));
      } catch (UnknownProductException e) {
        // for now we ignore unknown products
        continue;
      }
    }
    return cost;
  }

  private BigDecimal costOfItems(int quantity, Product product) {
    // for the moment we assume that only one offer is applicable per product
    // using a factory for now but could consider a visitor to address more complexity e.g. offers of different types 
    // like any three for, cheapest item free etc. 
    MultibuyOffer offer = new OfferFactory().getOffer(product);
    if (!(offer == null)) {
      return costOfItems(quantity, product.getCost(), offer);
    }
    return costForQuantity(quantity, product.getCost());
  }

  private BigDecimal costOfItems(int quantity, BigDecimal cost, MultibuyOffer offer) {
    int offerQuantity = offer.getOfferQuantity();
    int billedQuantity = offer.getBilledQuantity();
    int remainder = quantity % offerQuantity;
    int effectiveQuantity = (((quantity - remainder) / offerQuantity) * billedQuantity) + remainder;
    return costForQuantity(effectiveQuantity, cost);
  }

  private BigDecimal costForQuantity(int quantity, BigDecimal cost) {
    return cost.multiply(new BigDecimal(quantity)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
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
