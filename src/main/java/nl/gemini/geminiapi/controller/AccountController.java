package nl.gemini.geminiapi.controller;

import nl.gemini.geminiapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/newaccount")
    public void createNewAccount(@RequestParam Long customerId, @RequestParam Double initialCredit) {
        accountService.createNewAccount(customerId, initialCredit);
    }

}
