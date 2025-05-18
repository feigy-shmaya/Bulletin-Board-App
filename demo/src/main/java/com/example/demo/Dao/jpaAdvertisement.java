package com.example.demo.Dao;

import com.example.demo.Entity.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jpaAdvertisement extends CrudRepository<Advertisement,Integer> {

}
