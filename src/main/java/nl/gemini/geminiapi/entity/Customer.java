package nl.gemini.geminiapi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    private Long customerId;

    private String name;

    private String surname;

    private Double balance;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public void addAccount(Account account) {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    @Override
    public String toString() {
        return customerId + "\t" + name + "\t" + surname + "\t" + balance + "\t" + accounts.size();
    }

}
