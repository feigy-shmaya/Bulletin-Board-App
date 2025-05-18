package com.example.demo.Dao;

import com.example.demo.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClient extends CrudRepository<Client,String> {
}
