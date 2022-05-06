package kbe.aw.warehouse;

import kbe.aw.warehouse.csvimport.CSVImportController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarehouseApplication
{

   public static void main(String[] args)
   {
      CSVImportController csvImportController = new CSVImportController();
      csvImportController.readFromCSVFile("src/main/resources/initial_hardware_components.csv");
      SpringApplication.run(WarehouseApplication.class, args);
   }

}
