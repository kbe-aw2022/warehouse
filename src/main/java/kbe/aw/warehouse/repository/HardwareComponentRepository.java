package kbe.aw.warehouse.repository;

import org.springframework.data.repository.CrudRepository;

import kbe.aw.warehouse.model.HardwareComponent;

public interface HardwareComponentRepository extends CrudRepository<HardwareComponent, Integer>
{
}
