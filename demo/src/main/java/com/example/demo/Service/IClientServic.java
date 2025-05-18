package com.example.demo.Service;

import com.example.demo.Entity.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface IClientServic {
    public ResponseEntity<Client> add(Client a);
    public Client getById(String email);
    public ArrayList<Client> get();

    void updateClientWithAdvertisement(String email, int adId);



    public ResponseEntity<String> updatePackage(String email, List<Integer> packageIds);
}
