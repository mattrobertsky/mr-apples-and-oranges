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
    String[] basket = {"Apple", "Apple", "Orange", "Orange", "Orange"}; 
    double actual = testCheckout.tally(basket);
    double expected = (Apple.COST * 2) + (Orange.COST * 3);
    assertEquals(expected, actual, 0);
  }

}
