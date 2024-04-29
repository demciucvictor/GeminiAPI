package nl.gemini.geminiapi.repository;

import nl.gemini.geminiapi.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
