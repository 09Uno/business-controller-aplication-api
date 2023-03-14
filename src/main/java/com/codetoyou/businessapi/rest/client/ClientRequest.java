package com.codetoyou.businessapi.rest.client;

import java.time.LocalDate;

import com.codetoyou.businessapi.model.ClientModel;



public class ClientRequest {
    

    private Long id;
    private LocalDate birthDate;
    private String name;
    private String cpf;
    private String address;
    private String phone;
    private String email;
    private LocalDate createdAt;

    public ClientRequest() {
        super();
    }

    public ClientRequest(Long id, LocalDate birthDate, String name, String cpf, String address, String phone, String email, LocalDate createdAt) {
        super();
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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


    public ClientModel toModel() {
        return new ClientModel(id, birthDate, name, cpf, address, phone, email, createdAt);
    } 
    
    public static ClientRequest fromModel(ClientModel clientModel) {
        return new ClientRequest(
                clientModel.getId(), 
                clientModel.getBirthDate(), 
                clientModel.getName(), 
                clientModel.getCpf(), 
                clientModel.getAddress(), 
                clientModel.getPhone(), 
                clientModel.getEmail(), 
                clientModel.getCreatedAt()
        );
    }
    

    @Override
    public String toString() {
        return "ClientRequest [id=" + id + ", birthDate=" + birthDate + ", name=" + name + ", cpf=" + cpf + ", address="
                + address + ", phone=" + phone + ", email=" + email + ", createdAt=" + createdAt + "]";
    }


}
