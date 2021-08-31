package com.everis.bootcamp.ms.monedero.producer;


import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    @Value("${custom.kafka.topic-name-transaction}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, MonederoTransactionDto> tallerKafkaTemplate;

    public void sendMessage(MonederoTransactionDto monederoTransactionDtoMessage) {
        tallerKafkaTemplate.send(topicName, monederoTransactionDtoMessage);
    }
}
