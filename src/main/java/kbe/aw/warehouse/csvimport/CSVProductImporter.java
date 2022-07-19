package kbe.aw.warehouse.csvimport;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import kbe.aw.warehouse.model.Product;
import kbe.aw.warehouse.repository.ProductRepository;

@Service
public class CSVProductImporter
{
   private final ProductRepository productRepository;

   private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/initial_products.csv";

   @Autowired
   public CSVProductImporter(final ProductRepository productRepository)
   {
      this.productRepository = productRepository;
   }

   public void importProducts() throws IOException
   {
         List<Product> beans = new CsvToBeanBuilder(new FileReader(SAMPLE_CSV_FILE_PATH))
               .withType(Product.class).build().parse();
         productRepository.saveAll(beans);
   }

   @PostConstruct
   public void deleteAllProducts()
   {
      productRepository.deleteAll();
   }
}
