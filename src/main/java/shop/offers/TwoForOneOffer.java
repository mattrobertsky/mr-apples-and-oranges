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

  private TwoForOneOffer() {
  }

  private static class BillPughSingletonHelper {
    private static final TwoForOneOffer INSTANCE = new TwoForOneOffer();
  }

  /**
   * gets the singleton instance of this class
   * 
   * @return TwoForOneOffer
   */
  public static TwoForOneOffer getInstance() {
    return BillPughSingletonHelper.INSTANCE;
  }

}
