package test.java;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import main.java.shop.Checkout;

public class CheckoutTest {

  @Test
  public void testTallyRemainderBoth() {
    Checkout testCheckout = new Checkout();
    String[] basket = {"Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange"}; 
    BigDecimal actual = testCheckout.tally(basket);
    BigDecimal expected = new BigDecimal(1.95);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    assertEquals(expected, actual);
  }
  
  @Test
  public void testTallyRemainderOranges() {
    Checkout testCheckout = new Checkout();
    String[] basket = {"Apple", "Apple", "Orange", "Orange", "Orange", "Orange"}; 
    BigDecimal actual = testCheckout.tally(basket);
    BigDecimal expected = new BigDecimal(1.35);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    assertEquals(expected, actual);
  }
  
  @Test
  public void testTallyRemainderApple() {
    Checkout testCheckout = new Checkout();
    String[] basket = {"Apple", "Apple", "Apple", "Orange", "Orange", "Orange"}; 
    BigDecimal actual = testCheckout.tally(basket);
    BigDecimal expected = new BigDecimal(1.70);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    assertEquals(expected, actual);
  }
  
  @Test
  public void testTallyRemainderShuffledItems() {
    Checkout testCheckout = new Checkout();
    String[] basket = {"Apple", "Orange", "Apple", "Apple", "Orange", "Orange"}; 
    BigDecimal actual = testCheckout.tally(basket);
    BigDecimal expected = new BigDecimal(1.70);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    assertEquals(expected, actual);
  }
  
  @Test
  public void testTallyRemainderShuffledItemsAndUnknownItems() {
    Checkout testCheckout = new Checkout();
    String[] basket = {"Apple", "Orange", "Apple", "Apple", "Banana", "Orange", "Pear", "Orange"}; 
    BigDecimal actual = testCheckout.tally(basket);
    BigDecimal expected = new BigDecimal(1.70);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    assertEquals(expected, actual);
  }


}
