package nl.gemini.geminiapi.controller;

import nl.gemini.geminiapi.dto.CustomerInfoDTO;
import nl.gemini.geminiapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerinfo")
    public ResponseEntity<CustomerInfoDTO> getCustomerInfo(@RequestParam Long customerId) {
        Optional<CustomerInfoDTO> customerInfoDTO = customerService.getCustomerInfo(customerId);
        if (customerInfoDTO.isPresent()) {
            return ResponseEntity.ok(customerInfoDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
