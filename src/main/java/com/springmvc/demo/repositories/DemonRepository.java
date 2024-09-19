package com.springmvc.demo.repositories;

import com.springmvc.demo.models.Demon;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemonRepository extends ListCrudRepository<Demon, Long> {
    //
    // ListCrudRepository is good for returning the getAll into list right away
    // ListCrudRepository is also possible to perform Join statement SQL w/o writing the query.
    // ListCrudRepository is a built-in class that does the CRUD functionality for us.
    // JpARopository works with a db to get the CRUD query done.
}
