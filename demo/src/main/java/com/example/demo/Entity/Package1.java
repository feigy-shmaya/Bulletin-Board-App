package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Package1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int enteries;
    private int days;
    @OneToMany(mappedBy = "package1")
    private List<Advertisement>advertisements;
}
