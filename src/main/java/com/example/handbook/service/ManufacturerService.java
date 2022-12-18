package com.example.handbook.service;


import com.example.handbook.db.entities.Manufacturer;
import com.example.handbook.db.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manuRepo;

    public List<Manufacturer> listAllManus(){
        return (List<Manufacturer>) manuRepo.findAll();
    }

    // добавление
    public Manufacturer saveManu(Manufacturer manu){
        return manuRepo.save(manu);
    }

    public Manufacturer getManuById(Integer id) {
        Optional<Manufacturer> manu = manuRepo.findById(id);
        return manu.orElse(null);
    }

    public Manufacturer updateManu (Manufacturer manu){
        return manuRepo.save(manu);
    }

    public void deleteManu(Integer id){
        Optional<Manufacturer> manu = manuRepo.findById(id);

        manu.ifPresent(manufacturer -> manuRepo.delete(manufacturer));
    }


}
