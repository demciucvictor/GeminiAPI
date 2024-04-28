package nl.gemini.geminiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    private Long transactionId;

    private Double amount;

    private Boolean isSuccess;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
}
