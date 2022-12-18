package com.example.handbook.service;


import com.example.handbook.db.entities.FeedBack;
import com.example.handbook.db.repositories.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FBService {

    @Autowired
    private FeedBackRepository fbRepo;

    // метод получения только тех отзывов, которые относятся к конкретному СИ


    // добавление отзыва
    public FeedBack addFB (FeedBack fb){
        return fbRepo.save(fb);
    }

    // получение отзыва по ID
    public FeedBack getFBById(Integer id){
        Optional<FeedBack> fb = fbRepo.findById(id);

        return fb.orElse(null);
    }

    public List<FeedBack> getFBsByDeviceId(Integer id){
        List<FeedBack> all = (List<FeedBack>) fbRepo.findAll();
        List<FeedBack> feedBackList = new ArrayList<>();
        for (FeedBack item : all
             ) { if(Objects.equals(item.getDevice().getId(), id))
                feedBackList.add(item);
        }
        return feedBackList;
    }

    public FeedBack updateFB (FeedBack fb){
        return fbRepo.save(fb);
    }

    public void deleteFB(Integer id){
        Optional<FeedBack> fb = fbRepo.findById(id);

        fb.ifPresent(feedback -> fbRepo.delete(feedback));
    }
}
