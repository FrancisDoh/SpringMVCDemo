package com.springmvc.demo.services;

import com.springmvc.demo.SpringAppMvcApplication;
import com.springmvc.demo.models.Demon;
import com.springmvc.demo.repositories.DemonRepository;
import jakarta.el.MethodNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemonServiceImpl implements DemonService{
    //
    @Autowired
    private DemonRepository _demonRepository;

    Logger logger = LoggerFactory.getLogger(DemonServiceImpl.class);

    // Cstor here is optional but good for Java convention
    @Autowired
    public DemonServiceImpl(DemonRepository _demonRepository){
        this._demonRepository = _demonRepository;
    }

    //
    @Override
    public Demon saveDemon(Demon demon) {
        return _demonRepository.save(demon); // .save(EntityObject) => Create
//        try{
//            throw new MethodNotFoundException("Exception Error");
//        }catch(MethodNotFoundException e){
//            logger.error("Line 33: Exception caught: " + e.getMessage());
////            logger.error
//        }
    }

    @Override
    public List<Demon> getAllDemons() {
        return _demonRepository.findAll(); // .findAll() => Read all
    }

    @Override
    public void updateDemon(Long id, Demon demonUpdated) {
        // If id doesn't exist throw the exception
//        if(!_demonRepository.existsById(id)){
//            throw new EntityNotFoundException("Demon with id of " + id + "doesn't exist!");
//        }
        // If id of the demon to update doesn't exist, then throw the exception
        Demon demon = _demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + "doesn't exist!"));
        demon = demonUpdated;
        _demonRepository.save(demon); // .save() => PUT - Update
    }

    @Override
    public Demon getDemonById(Long id) {
        return _demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + "doesn't exist!")); // .findById(id) => Get one
    }

    @Override
    public void deleteDemonById(Long id) {
        // In case the demon id we want doesn't exist.
        Demon demon = _demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + "doesn't exist!"));
        // If the demon object is found in the DB, then delete it.
        _demonRepository.delete(demon); // .delete(EntityObject) => Delete one
    }
}
