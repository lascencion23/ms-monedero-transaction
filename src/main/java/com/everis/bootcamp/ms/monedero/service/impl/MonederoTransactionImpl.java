package com.everis.bootcamp.ms.monedero.service.impl;

import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import com.everis.bootcamp.ms.monedero.domain.entity.MonederoTransaction;
import com.everis.bootcamp.ms.monedero.domain.repository.MonederoTransactionRepository;
import com.everis.bootcamp.ms.monedero.service.srv.MonederoTransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonederoTransactionImpl implements MonederoTransactionService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MonederoTransactionRepository repository;

    @Override
    public Flux<MonederoTransactionDto> findAll() {
        return repository.findAll().flatMap(this::getMonederoTransactionDto);
    }

    @Override
    public Mono<MonederoTransactionDto> findById(String id) {
        return repository.findById(id).flatMap(this::getMonederoTransactionDto);
    }

    @Override
    public Mono<MonederoTransactionDto> create(MonederoTransaction monederoTransaction) {
        return repository.save(monederoTransaction).flatMap(this::getMonederoTransactionDto);
    }

    private Mono<MonederoTransactionDto> getMonederoTransactionDto(MonederoTransaction monederoTransaction) {
        return Mono.just(objectMapper.convertValue(monederoTransaction, MonederoTransactionDto.class));
    }

    @Override
    public MonederoTransactionDto getMonederoDto(MonederoTransaction monederoTransaction) {
        return objectMapper.convertValue(monederoTransaction, MonederoTransactionDto.class);
    }

    @Override
    public MonederoTransaction getMonedero(MonederoTransactionDto monederoTransactionDto) {
        return objectMapper.convertValue(monederoTransactionDto, MonederoTransaction.class);
    }

}
