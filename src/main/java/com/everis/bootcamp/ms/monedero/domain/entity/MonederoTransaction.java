package com.everis.bootcamp.ms.monedero.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document("MonederoTransaction")
public class MonederoTransaction {

    @Id
    private String id;

    @NotNull
    private int originNumber;

    @NotNull
    private int destinationNumber;

    @NotNull
    private Double amount;

    private Status status;

    private LocalDateTime createAt;

    public enum Status {
        PENDING,
        REJECTED,
        SUCCESSFUL
    }

}
