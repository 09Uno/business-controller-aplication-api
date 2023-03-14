package com.codetoyou.businessapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codetoyou.businessapi.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long>   {
    
}
