package main.java.shop.products;

import java.math.BigDecimal;

import main.java.shop.offers.MultibuyOffer;
import main.java.shop.offers.TwoForOneOffer;

public class Apple {

  public static final String NAME = "Apple";
  public static final BigDecimal COST = new BigDecimal(0.6);
  public static final MultibuyOffer OFFER = TwoForOneOffer.getInstance();

}
