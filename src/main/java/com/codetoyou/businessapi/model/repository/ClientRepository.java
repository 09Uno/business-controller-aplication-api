package com.codetoyou.businessapi.model.repository;

import com.codetoyou.businessapi.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
  @Query(
    "SELECT c FROM ClientModel c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))"
  )
  Page<ClientModel> findByName(@Param("name") String name, Pageable pageable);
}
