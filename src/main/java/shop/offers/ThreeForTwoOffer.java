package main.java.shop.offers;

public class ThreeForTwoOffer implements MultibuyOffer {

  @Override
  public int getOfferQuantity() {
    return 3;
  }

  @Override
  public int getBilledQuantity() {
    return 2;
  }

  private static ThreeForTwoOffer singleton;
  
  private ThreeForTwoOffer() {
    
  }
  
  /**
   * gets the singleton instance of this class
   * 
   * @return ThreeForTwoOffer
   */
  public static ThreeForTwoOffer getInstance() {
    if (singleton == null) {
      return new ThreeForTwoOffer();
    } else {
      return singleton;
    }
  }

}
