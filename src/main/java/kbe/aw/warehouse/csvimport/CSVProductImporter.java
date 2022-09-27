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

import kbe.aw.warehouse.model.Product;
import kbe.aw.warehouse.repository.ProductRepository;

@Service
public class CSVProductImporter
{
   private final ProductRepository productRepository;
   Resource resource  = new ClassPathResource("initial_products.csv");

   @Autowired
   public CSVProductImporter(final ProductRepository productRepository)
   {
      this.productRepository = productRepository;
   }

   public void importProducts() throws IOException
   {
      InputStream inputStream = resource.getInputStream();
      Reader reader = new InputStreamReader(inputStream, "UTF-8");

         List<Product> beans = new CsvToBeanBuilder(reader)
               .withType(Product.class).build().parse();

         productRepository.saveAll(beans);
   }

   @PostConstruct
   public void deleteAllProducts()
   {
      productRepository.deleteAll();
   }
}
