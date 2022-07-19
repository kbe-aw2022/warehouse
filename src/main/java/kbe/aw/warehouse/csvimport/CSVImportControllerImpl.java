package kbe.aw.warehouse.csvimport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kbe.aw.warehouse.exception.HardwareComponentNotFoundException;
import kbe.aw.warehouse.exception.ProductNotFoundException;
import kbe.aw.warehouse.model.HardwareComponent;
import kbe.aw.warehouse.model.Product;
import kbe.aw.warehouse.repository.HardwareComponentRepository;
import kbe.aw.warehouse.repository.ProductRepository;

@RestController
public final class CSVImportControllerImpl implements CSVImportController
{
   private final HardwareComponentRepository hardwareComponentRepository;
   private final ProductRepository productRepository;

   @Autowired
   CSVImportControllerImpl(HardwareComponentRepository hardwareComponentRepository, final ProductRepository productRepository)
   {
      this.hardwareComponentRepository = hardwareComponentRepository;
      this.productRepository = productRepository;
   }

   @Override
   public List<HardwareComponent> allHardwareComponents()
   {
      return (List<HardwareComponent>) hardwareComponentRepository.findAll();
   }

   @Override
   public HardwareComponent oneHardwareComponent(final Integer id)
   {
      return hardwareComponentRepository.findById(id).orElseThrow(() -> new HardwareComponentNotFoundException(id));
   }

   @Override
   public List<Product> allProducts()
   {
      return (List<Product>) productRepository.findAll();
   }

   @Override
   public Product oneProduct(final Integer id)
   {
      return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
   }
}
