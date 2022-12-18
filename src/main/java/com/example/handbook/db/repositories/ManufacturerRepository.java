package com.example.handbook.db.repositories;

import com.example.handbook.db.entities.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
}
