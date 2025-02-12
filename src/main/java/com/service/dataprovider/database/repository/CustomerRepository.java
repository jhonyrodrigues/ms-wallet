package com.service.dataprovider.database.repository;

import com.service.dataprovider.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    CustomerEntity findByCpf(String cpf);

}
