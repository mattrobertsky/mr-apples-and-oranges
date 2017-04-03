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

  private static class BillPughThreadsafeSingletonHelper {
    private static final ThreeForTwoOffer INSTANCE = new ThreeForTwoOffer();
  }

  private ThreeForTwoOffer() {
  }

  /**
   * gets the singleton instance of this class
   * 
   * @return ThreeForTwoOffer
   */
  public static ThreeForTwoOffer getInstance() {
    return BillPughThreadsafeSingletonHelper.INSTANCE;
  }

}
