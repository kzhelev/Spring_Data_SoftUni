package com.example.firstspringproject.repositories;

import com.example.firstspringproject.models.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountNumberRepository extends JpaRepository<AccountNumber, Integer> {
    AccountNumber findByNumber(Integer number);
}
