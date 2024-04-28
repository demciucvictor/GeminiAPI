package nl.gemini.geminiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long accountId;

    private Double initialCredit;

//    private long customerId;

    @OneToMany
    private List<Transaction> transactions;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
