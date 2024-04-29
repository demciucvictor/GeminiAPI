package nl.gemini.geminiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private Long transactionId;

    private Double amount;

    private Boolean isSuccess;

    private String description;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;
}
