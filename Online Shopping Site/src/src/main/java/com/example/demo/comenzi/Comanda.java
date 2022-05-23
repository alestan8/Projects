package com.example.demo.comenzi;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comenzi")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idclient",nullable = false)
    private int idClient;

    @Column(name = "date", nullable = false)
    private Date data;

    @Column(name = "totalValue", nullable = false)
    private int totalValue;


    // getters and setters are not shown

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}