package kbe.aw.warehouse.repository;

import org.springframework.data.repository.CrudRepository;

import kbe.aw.warehouse.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
}
