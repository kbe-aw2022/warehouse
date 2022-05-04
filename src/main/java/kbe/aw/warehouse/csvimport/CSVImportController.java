package kbe.aw.warehouse.csvimport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import kbe.aw.warehouse.HardwareComponent;

public class CSVImportController
{
   List<List<String>> records = new ArrayList<List<String>>();
   List<HardwareComponent> hardwareComponentList = new ArrayList<>();


   CSVReader csvReader;


   private List readFromCSVFile(String CSVName)
   {
      {
         try
         {
            csvReader = new CSVReader(new FileReader("inital_hardware_components.csv"));


            String[] values = null;

            while((values = csvReader.readNext()) != null)
            {
               HardwareComponent hardwareComponent = new HardwareComponent(
                     values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7] );



            }
         }
         catch (FileNotFoundException e)
         {
            throw new RuntimeException(e);
         }
         catch (CsvValidationException e)
         {
            throw new RuntimeException(e);
         }
         catch (IOException e)
         {
            throw new RuntimeException(e);
         }
      }
   }


}
