package nl.gemini.geminiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long accountId;

    private Double initialCredit;

//    private long customerId;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString(){
        return "Account [accountId=" + accountId + ", initialCredit=" + initialCredit + ", " +
                "transactions=" + transactions.size();
    }

    public void addTransaction(Transaction transaction){
        if(transactions == null){
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
    }
}
