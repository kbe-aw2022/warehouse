package kbe.aw.warehouse.exception;

public class ProductNotFoundException extends RuntimeException
{
   public ProductNotFoundException(final Integer id)
   {
      super("Could not find product " + id);
   }
}
