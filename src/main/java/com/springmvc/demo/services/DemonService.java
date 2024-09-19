package com.springmvc.demo.services;

import com.springmvc.demo.models.Demon;

import java.util.List;

public interface DemonService {
    //
    Demon saveDemon (Demon demon);
    List<Demon> getAllDemons();
    void updateDemon(Long id, Demon demonUpdated);
    Demon getDemonById(Long id);
    void deleteDemonById(Long id);
}
