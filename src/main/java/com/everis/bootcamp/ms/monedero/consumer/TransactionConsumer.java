package com.everis.bootcamp.ms.monedero.consumer;

import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import com.everis.bootcamp.ms.monedero.domain.entity.MonederoTransaction;
import com.everis.bootcamp.ms.monedero.service.srv.MonederoTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionConsumer {

	@Autowired
	private MonederoTransactionService service;

	@KafkaListener(
			topics = "${custom.kafka.topic-name-monedero-account}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "monederoKafkaListenerContainerFactory")

	public void consumer(MonederoTransactionDto monederoTransactionDto) {
		try {
			System.out.println("Consumer init");
			log.info("Consumer [{}]", monederoTransactionDto);
			System.out.println("Consumer enviado");
			MonederoTransaction mt = service.getMonedero(monederoTransactionDto);
			service.create(mt).subscribe(c -> log.info(mt.toString()));
			log.info("Debe guardar en bd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
