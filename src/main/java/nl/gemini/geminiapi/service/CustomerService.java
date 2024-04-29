package nl.gemini.geminiapi.service;

import nl.gemini.geminiapi.dto.CustomerInfoDTO;
import nl.gemini.geminiapi.dto.TransactionInfoDto;
import nl.gemini.geminiapi.entity.Account;
import nl.gemini.geminiapi.entity.Customer;
import nl.gemini.geminiapi.entity.Transaction;
import nl.gemini.geminiapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<CustomerInfoDTO> getCustomerInfo(Long customerId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isEmpty()) {
            return Optional.empty();
        }

        Customer customer = customerOpt.get();

        return Optional.of(createCustomerInfoObject(customer));
    }

    private CustomerInfoDTO createCustomerInfoObject(Customer customer) {

        List<TransactionInfoDto> transactions = customer.getAccounts().stream()
                .map(Account::getTransactions)
                .flatMap(List::stream)
                .map(transaction -> TransactionInfoDto.builder()
                        .amount(transaction.getAmount())
                        .isSuccess(transaction.getIsSuccess())
                        .description(transaction.getDescription())
                        .accountId(transaction.getAccount().getAccountId())
                        .build())
                .toList();

        CustomerInfoDTO customerInfoDTO = CustomerInfoDTO.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .balance(customer.getBalance())
                .transactions(transactions)
                .build();

        return customerInfoDTO;
    }

}
