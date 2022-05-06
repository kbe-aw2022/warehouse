package kbe.aw.warehouse.csvimport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import kbe.aw.warehouse.HardwareComponent;
import org.springframework.stereotype.Controller;

@Controller
public class CSVImportController {
   List<List<String>> records = new ArrayList<List<String>>();
   List<HardwareComponent> hardwareComponentList = new ArrayList<>();


   CSVReader csvReader;


   private HardwareComponent createHardwareComponent(String name, String vendor, Double price, String description, String location, String manufacturer, String productGroup, int weight, String status, String eanNumber){
      HardwareComponent hardwareComponent = new HardwareComponent();
      hardwareComponent.setName(name);
      hardwareComponent.setVendor(vendor);
      hardwareComponent.setPrice(price);
      hardwareComponent.setDescpription(description);
      hardwareComponent.setLocation(location);
      hardwareComponent.setManufacture(manufacturer);
      hardwareComponent.setProductGroup(productGroup);
      hardwareComponent.setWeightInGramm(weight);
      //hardwareComponent.setStatus(status);
      hardwareComponent.setEanNumber(eanNumber);

      return hardwareComponent;

   }

   public List readFromCSVFile(String CSVName)
      {
         try {
            csvReader = new CSVReader(new FileReader(CSVName));


            String[] values = null;

            while ((values = csvReader.readNext()) != null) {

            HardwareComponent hardwareComponent = createHardwareComponent(values[0],values[1],Double.valueOf(values[2]),values[3],values[4],values[5] ,values[6],1,values[7],values[9]);
            hardwareComponentList.add(hardwareComponent);


            }
         } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
         } catch (CsvValidationException e) {
            throw new RuntimeException(e);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }

         for(HardwareComponent hardwareComponent : hardwareComponentList){
            System.out.println(hardwareComponent);
         }

         return hardwareComponentList;

      }




}
