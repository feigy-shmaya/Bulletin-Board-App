package com.example.demo.Controller;

import com.example.demo.Dao.jpaPackage1;
import com.example.demo.Entity.*;
import com.example.demo.Service.IClientServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/board/client")
public class ClientController {
    private IClientServic clientServic;
    private jpaPackage1 packageRepository;

    @Autowired
    public ClientController(IClientServic clientServic,jpaPackage1 packageRepository) {
        this.clientServic = clientServic;
        this.packageRepository = packageRepository;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getById(@PathVariable String email) {
        Client c = clientServic.getById(email);
        System.out.println(c);
        if (c == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(c);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> get() {
        ArrayList<Client> c = clientServic.get();
        System.out.println(c);
        if (c == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping("/")
    public ResponseEntity<Client> add(@RequestBody ClientDto clientDTO) {
        Client client = new Client();
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());
        Client savedClient = clientServic.add(client).getBody();
        return ResponseEntity.ok(savedClient);
    }

    @PutMapping("/{email}/{packages}")
    public ResponseEntity<String> updateClientPackage(@PathVariable String email, @PathVariable List<Integer> packages) {
        System.out.println("i in client con" + packages);
        ResponseEntity<String> response = clientServic.updatePackage(email, packages);
        if (response.getStatusCode() == HttpStatus.OK) {
            String updatedClient = response.getBody();
            return ResponseEntity.ok("updatedClient");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}



