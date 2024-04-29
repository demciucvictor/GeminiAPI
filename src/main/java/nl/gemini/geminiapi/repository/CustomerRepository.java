package nl.gemini.geminiapi.repository;

import nl.gemini.geminiapi.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
