package kbe.aw.warehouse.csvimport;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import kbe.aw.warehouse.repository.HardwareComponentRepository;
import kbe.aw.warehouse.model.HardwareComponent;

@Service
public class CSVHardwareComponentImporter
{
   private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/initial_hardware_components.csv";

   private final HardwareComponentRepository hardwareComponentRepository;

   @Autowired
   public CSVHardwareComponentImporter(final HardwareComponentRepository hardwareComponentRepository)
   {
      this.hardwareComponentRepository = hardwareComponentRepository;
   }

   public void importHardwareComponents() throws IOException
   {
         List<HardwareComponent> beans = new CsvToBeanBuilder(new FileReader(SAMPLE_CSV_FILE_PATH))
               .withType(HardwareComponent.class).build().parse();

         hardwareComponentRepository.saveAll(beans);
   }

   @PostConstruct
   public void deleteAllHardwareComponents()
   {
      hardwareComponentRepository.deleteAll();
   }
}
