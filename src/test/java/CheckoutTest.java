package test.java;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.shop.Checkout;
import main.java.shop.products.Apple;
import main.java.shop.products.Orange;

public class CheckoutTest {

  @Test
  public void testTally() {
    Checkout testCheckout = new Checkout();
    String[] basket = new String[2];
    basket[0] = Apple.NAME;
    basket[1] = Orange.NAME;
    double actual = testCheckout.tally(basket);
    double expected = Apple.COST + Orange.COST;
    assertEquals(expected, actual, 0);
  }

}
