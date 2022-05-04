package kbe.aw.warehouse;

public class HardwareComponent
{
   String name;

   String vendor;

   String descpription;

   double price;

   String location;

   String manufacture;

   String productGroup;

   int weightInGramm;

   Status status;

   String eanNumber;

   public HardwareComponent(final String name, final String vendor, final String descpription, final double price, final String location, final String manufacture, final String productGroup,
         final int weightInGramm, final Status status, final String eanNumber)
   {
      this.name = name;
      this.vendor = vendor;
      this.descpription = descpription;
      this.price = price;
      this.location = location;
      this.manufacture = manufacture;
      this.productGroup = productGroup;
      this.weightInGramm = weightInGramm;
      this.status = status;
      this.eanNumber = eanNumber;
   }

   public HardwareComponent()
   {

   }

   public String getName()
   {
      return name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public String getVendor()
   {
      return vendor;
   }

   public void setVendor(final String vendor)
   {
      this.vendor = vendor;
   }

   public String getDescpription()
   {
      return descpription;
   }

   public void setDescpription(final String descpription)
   {
      this.descpription = descpription;
   }

   public double getPrice()
   {
      return price;
   }

   public void setPrice(final double price)
   {
      this.price = price;
   }

   public String getLocation()
   {
      return location;
   }

   public void setLocation(final String location)
   {
      this.location = location;
   }

   public String getManufacture()
   {
      return manufacture;
   }

   public void setManufacture(final String manufacture)
   {
      this.manufacture = manufacture;
   }

   public String getProductGroup()
   {
      return productGroup;
   }

   public void setProductGroup(final String productGroup)
   {
      this.productGroup = productGroup;
   }

   public int getWeightInGramm()
   {
      return weightInGramm;
   }

   public void setWeightInGramm(final int weightInGramm)
   {
      this.weightInGramm = weightInGramm;
   }

   public Status getStatus()
   {
      return status;
   }

   public void setStatus(final Status status)
   {
      this.status = status;
   }

   public String getEanNumber()
   {
      return eanNumber;
   }

   public void setEanNumber(final String eanNumber)
   {
      this.eanNumber = eanNumber;
   }

}
