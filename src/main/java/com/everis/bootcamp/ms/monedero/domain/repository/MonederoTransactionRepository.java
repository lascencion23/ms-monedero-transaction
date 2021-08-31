package com.everis.bootcamp.ms.monedero.domain.repository;

import com.everis.bootcamp.ms.monedero.domain.entity.MonederoTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MonederoTransactionRepository extends ReactiveMongoRepository<MonederoTransaction, String> {
}
