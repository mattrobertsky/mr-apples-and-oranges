package main.java.shop.offers;

public class TwoForOneOffer implements MultibuyOffer {

  @Override
  public int getOfferQuantity() {
    return 2;
  }

  @Override
  public int getBilledQuantity() {
    return 1;
  }

  private static TwoForOneOffer singleton;

  private TwoForOneOffer() {

  }

  /**
   * gets the singleton instance of this class
   * 
   * @return TwoForOneOffer
   */
  public static TwoForOneOffer getInstance() {
    if (singleton == null) {
      return new TwoForOneOffer();
    } else {
      return singleton;
    }
  }

}
