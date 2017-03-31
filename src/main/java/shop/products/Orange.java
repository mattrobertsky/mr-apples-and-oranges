package main.java.shop.products;

import java.math.BigDecimal;

import main.java.shop.offers.MultibuyOffer;
import main.java.shop.offers.ThreeForTwoOffer;

public class Orange {

  public static final String NAME = "Orange";
  public static final BigDecimal COST = new BigDecimal(.25);
  public static final MultibuyOffer OFFER = ThreeForTwoOffer.getInstance();

}
