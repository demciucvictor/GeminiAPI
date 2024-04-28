package nl.gemini.geminiapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    private Long customerId;

    private String name;

    private String surname;

    private Double balance;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Account> transactions;

}
