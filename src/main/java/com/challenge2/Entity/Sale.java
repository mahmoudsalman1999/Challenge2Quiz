package com.challenge2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "Client_Id")
    private Clients clients;
    @ManyToOne
    @JoinColumn(name ="Saller_Id")
    private User saller;
    @OneToMany( cascade = CascadeType.ALL)
    private List<Transaction> transactions =new ArrayList<>();
    @Column(nullable = false)
    private LocalDateTime creationDate;
}
