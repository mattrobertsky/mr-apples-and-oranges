package main.java.shop.products;

public class ProductFactory {

  /**
   * factory method to get a Product instance
   * 
   * @param productName
   *          name of the product
   * @return Product
   * @throws UnknownProductException
   *           exception thrown if productNamre is not handled
   */
  public Product get(String productName) throws UnknownProductException {
    if (productName.equals("Apple")) {
      return new Apple();
    } else if (productName.equals("Orange")) {
      return new Orange();
    } else {
      throw new UnknownProductException("we don't know anything about this product!");
    }
  }

}
