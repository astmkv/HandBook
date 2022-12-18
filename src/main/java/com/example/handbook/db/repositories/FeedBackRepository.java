package com.example.handbook.db.repositories;

import com.example.handbook.db.entities.FeedBack;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface FeedBackRepository extends CrudRepository<FeedBack, Integer> {

//    @Transactional
//    @Modifying
//    @Query(value = "SELECT rating, text FROM feedback_t WHERE device_id=?", nativeQuery = true)
//    List<FeedBack> getFeedBacksByDevice_Id(int id);
}
