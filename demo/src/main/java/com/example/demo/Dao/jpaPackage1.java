package com.example.demo.Dao;

import com.example.demo.Entity.Package1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jpaPackage1 extends CrudRepository<Package1,Integer> {

}
