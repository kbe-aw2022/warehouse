package kbe.aw.warehouse.exception;

public class HardwareComponentNotFoundException extends RuntimeException
{
   public HardwareComponentNotFoundException(final Integer id)
   {
      super("Could not find hardware component with  " + id + " id");
   }
}
