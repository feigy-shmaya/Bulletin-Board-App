package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @UpdateTimestamp
    private LocalDate time;

    private boolean isActive;
    private int numEnteries;
    private String image;
    private int numPlace;

    @ManyToOne
    @JoinColumn(name = "client_email")
    private Client client;

    @ManyToOne
    @JoinColumn(name="Package1_id")
    private Package1 package1;

    public Advertisement(){
        this.isActive = true;
        this.numEnteries = 0;
    }
}
