package com.example.demo.Service;
import com.example.demo.Dao.JpaClient;
import com.example.demo.Dao.jpaPackage1;
import com.example.demo.Entity.Client;
import com.example.demo.Entity.Package1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements IClientServic{
    JpaClient _jpa;
    jpaPackage1 packageRepository;
    @Autowired
    public ClientService(JpaClient jpa, jpaPackage1 packageRepository){
        this.packageRepository = packageRepository;
        this._jpa=jpa;
    }

    public ResponseEntity<Client> add(Client a) {
        System.out.println("i come to client");
        if(_jpa.findById(a.getEmail()).orElse(null)==null)
              _jpa.save(a);
        return ResponseEntity.ok(a);
    }
    public Client getById(String email){
        return _jpa.findById(email).orElse(null);
    }

    public ArrayList<Client> get(){

        return (ArrayList<Client>) _jpa.findAll();
    }
    @Override
    public void updateClientWithAdvertisement(String email, int adId) {
        Client client = _jpa.findById(email).orElse(null);
        if (client != null) {
            System.out.println("Updating client: " + email + " with ad id: " + adId);
        }
    }
    @Override
    public ResponseEntity<String> updatePackage(String email, List<Integer> packageIds) {
        Client client = getById(email);
        if (client != null) {
            List<Package1> packages = new ArrayList<>();
            packageRepository.findAllById(packageIds).forEach(packages::add);
            client.setPacekages(packages);
            _jpa.save(client);
            return ResponseEntity.ok("client");
        }
        return ResponseEntity.notFound().build();
    }

}
