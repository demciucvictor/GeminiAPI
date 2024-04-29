package nl.gemini.geminiapi.controller;

import nl.gemini.geminiapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/newaccount")
    public ResponseEntity<Void> createNewAccount(@RequestParam Long customerId, @RequestParam Double initialCredit) {
        Boolean accountCreated = accountService.createNewAccount(customerId, initialCredit);
        if (accountCreated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
