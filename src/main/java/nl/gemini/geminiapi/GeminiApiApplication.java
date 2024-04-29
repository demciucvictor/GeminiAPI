package nl.gemini.geminiapi;

import jakarta.annotation.PostConstruct;
import nl.gemini.geminiapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeminiApiApplication {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GeminiApiApplication.class, args);
    }

//    @PostConstruct
//    private void postInit(){
//        System.out.println(customerRepository.findAll());
//    }

}
