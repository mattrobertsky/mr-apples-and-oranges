package main.java.shop.offers;

import main.java.shop.products.Product;

public class OfferFactory {

  /**
   * @param product
   *          the product to get the offer for
   * @return {@link MultibuyOffer} the (single) offer applicable to the Product
   */
  public MultibuyOffer getOffer(Product product) {
    if (product.getName() == "Apple") {
      return TwoForOneOffer.getInstance();
    } else if (product.getName() == "Orange") {
      return ThreeForTwoOffer.getInstance();
    } else {
      return null;
    }
  }

}
