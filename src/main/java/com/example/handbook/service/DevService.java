package com.example.handbook.service;


import com.example.handbook.db.entities.Device;
import com.example.handbook.db.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevService {

    @Autowired
    private DeviceRepository devRepo;

    public List<Device> getAllDev(){
        return (List<Device>) devRepo.findAll();
    }

    // добавление СИ
    public Device addDev(Device dev){
        return devRepo.save(dev);
    }

    public Device getDevById(Integer id){
        Optional<Device> dev = devRepo.findById(id);

        return dev.orElse(null);
    }

    public Device updateDev (Device dev){
        return devRepo.save(dev);
    }

    public void deleteDev(Integer id){
        Optional<Device> dev = devRepo.findById(id);

        dev.ifPresent(device -> devRepo.delete(device));
    }



}
