package nl.gemini.geminiapi.service;

import nl.gemini.geminiapi.entity.Account;
import nl.gemini.geminiapi.entity.Customer;
import nl.gemini.geminiapi.entity.Transaction;
import nl.gemini.geminiapi.repository.AccountRepository;
import nl.gemini.geminiapi.repository.CustomerRepository;
import nl.gemini.geminiapi.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionService transactionService;

    public Boolean createNewAccount(Long customerId, Double initialCredit) {
        Account accountToCreate = new Account();
        Customer customer;
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isPresent()) {
           customer = customerOpt.get();
        } else {
            log.error("Invalid customer id: {}", customerId);
            return false;
        }
        accountToCreate.setCustomer(customer);

        setInitialAccountCredit(accountToCreate, initialCredit);

        customer.addAccount(accountToCreate);
        customerRepository.save(customer);
        return true;
    }

    private void setInitialAccountCredit(Account account, Double initialCredit) {
        if (initialCredit == 0) {
            account.setInitialCredit(0.0);
        } else if (initialCredit > 0) {
            Transaction transaction = transactionService.createTransaction(account, initialCredit);
            account.addTransaction(transaction);
        } else if (initialCredit < 0) {
            log.error("Initial Credit of a new account cannot be below 0: {}", initialCredit);
        }
    }
}
