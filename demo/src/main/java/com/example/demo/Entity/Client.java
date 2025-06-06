package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Client {
    @Id
    private String email;
    private String password;
    @ManyToMany
    private List<Package1> pacekages;
      @OneToMany(mappedBy = "client")
      private List<Advertisement>advertisements;
}
