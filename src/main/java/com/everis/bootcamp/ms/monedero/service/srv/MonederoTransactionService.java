package com.everis.bootcamp.ms.monedero.service.srv;

import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import com.everis.bootcamp.ms.monedero.domain.entity.MonederoTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonederoTransactionService {

    Flux<MonederoTransactionDto> findAll();

    Mono<MonederoTransactionDto> findById(String id);

    Mono<MonederoTransactionDto> create(MonederoTransaction monederoTransaction);

    MonederoTransactionDto getMonederoDto(MonederoTransaction monederoTransaction);

    MonederoTransaction getMonedero(MonederoTransactionDto monederoTransactionDto);

}
