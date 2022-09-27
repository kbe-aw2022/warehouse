package kbe.aw.warehouse.csvimport;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kbe.aw.warehouse.model.HardwareComponent;
import kbe.aw.warehouse.model.Product;

public interface CSVImportController
{
   @GetMapping("/hardwarecomponents")
   List<HardwareComponent> allHardwareComponents();

   @GetMapping("/hardwarecomponents/{id}")
   HardwareComponent oneHardwareComponent(@PathVariable Integer id);

   @GetMapping("/products")
   List<Product> allProducts();

   @GetMapping("/products/{id}")
   Product oneProduct(@PathVariable Integer id);
}
