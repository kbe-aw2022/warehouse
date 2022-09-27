package kbe.aw.warehouse.csvimport;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import kbe.aw.warehouse.model.HardwareComponent;
import kbe.aw.warehouse.repository.HardwareComponentRepository;

@Service
public class CSVHardwareComponentImporter
{
   private final HardwareComponentRepository hardwareComponentRepository;

   Resource resource  = new ClassPathResource("initial_hardware_components.csv");

   @Autowired
   public CSVHardwareComponentImporter(final HardwareComponentRepository hardwareComponentRepository)
   {
      this.hardwareComponentRepository = hardwareComponentRepository;
   }

   public void importHardwareComponents() throws IOException
   {
      InputStream inputStream = resource.getInputStream();
      Reader reader = new InputStreamReader(inputStream, "UTF-8");

         List<HardwareComponent> beans = new CsvToBeanBuilder(reader)
               .withType(HardwareComponent.class).build().parse();

         hardwareComponentRepository.saveAll(beans);
   }

   @PostConstruct
   public void deleteAllHardwareComponents()
   {
      hardwareComponentRepository.deleteAll();
   }
}
