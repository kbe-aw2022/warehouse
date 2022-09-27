package kbe.aw.warehouse;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import kbe.aw.warehouse.csvimport.CSVHardwareComponentImporter;
import kbe.aw.warehouse.csvimport.CSVProductImporter;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
   private final CSVHardwareComponentImporter csvHardwareComponentImporter;
   private final CSVProductImporter csvProductImporter;
   private static final Logger LOGGER = LoggerFactory.getLogger(StartupApplicationListener.class);

   @Override public void onApplicationEvent(ContextRefreshedEvent event)
   {
      try
      {
         csvHardwareComponentImporter.importHardwareComponents();
         csvProductImporter.importProducts();
         LOGGER.info("Warehouse started: componentCSV and productCSV loaded in database");
      }
      catch (IOException e)
      {
         LOGGER.error("Warehouse could not load componentCSV and productCSV");
         e.printStackTrace();
      }
   }

   public StartupApplicationListener(final CSVHardwareComponentImporter csvHardwareComponentImporter, final CSVProductImporter csvProductImporter)
   {
      this.csvHardwareComponentImporter = csvHardwareComponentImporter;
      this.csvProductImporter = csvProductImporter;
   }
}