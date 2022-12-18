package com.example.handbook.db.repositories;


import com.example.handbook.db.entities.Device;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE device_t SET manu_id=NULL WHERE manu_id=?1", nativeQuery = true)
    int clearManuInDeviceByManu(int id);
}
