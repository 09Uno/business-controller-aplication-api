package com.codetoyou.businessapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.annotation.Persistent;

@Table(name = "clients" )
@Entity //indica que é uma entidade
public class ClientModel {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "birthdate" )
    private LocalDate birthDate;

    @Column(name = "cpf" )
    private String cpf;

    @Column(name = "name" )
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone" )
    private String phone;

    @Column(name = "email" )
    private String email;

    @Column(name = "createdat", updatable = false )
    private LocalDate createdAt;
    
    @PrePersist //indica que o método será executado antes de persistir
    public void prePersist() {
        createdAt = LocalDate.now();
    }
    
    public ClientModel() {
        super();
    }

    public ClientModel(LocalDate birthDate, String cpf, String name, String address, String phone, String email) {
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    public ClientModel(Long id, LocalDate birthDate, String cpf, String name, String address, String phone, String email,
            LocalDate createdAt) {
        this.id = id;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.createdAt = createdAt;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "Client [id=" + id + ", birthDate=" + birthDate + ", cpf=" + cpf + ", name=" + name + ", address="
                + address + ", phone=" + phone + ", email=" + email + ", createdAt=" + createdAt + "]";
    }
    
}



