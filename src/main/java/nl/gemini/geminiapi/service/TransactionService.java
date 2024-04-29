package nl.gemini.geminiapi.service;

import nl.gemini.geminiapi.entity.Account;
import nl.gemini.geminiapi.entity.Customer;
import nl.gemini.geminiapi.entity.Transaction;
import nl.gemini.geminiapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void executeTransaction(Transaction transaction) {
        Account account = transaction.getAccount();
        Customer customer = account.getCustomer();
        if(customer.getBalance() >= transaction.getAmount()) {
            customer.setBalance(customer.getBalance() - transaction.getAmount());
            account.setInitialCredit(transaction.getAmount());
            transaction.setIsSuccess(true);
        } else {
            transaction.setIsSuccess(false);
            transaction.setDescription("Transaction failed due to amount exceeding customer's balance");
        }
    }

    public Transaction createTransaction(Account account, Double amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        executeTransaction(transaction);
//        transactionRepository.save(transaction);
        return transaction;
    }
}
