/*
 * Author: Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Purpose: This controller handles HTTP requests for retrieving account information,
 * crediting, and debiting accounts in the Simple Banking system.
 */

 package com.eteration.simplebanking.controller;
 import com.eteration.simplebanking.dto.TransactionRequestDto;
 import com.eteration.simplebanking.controller.TransactionStatus;
 import com.eteration.simplebanking.model.Account;
 import com.eteration.simplebanking.model.DepositTransaction;
 import com.eteration.simplebanking.model.InsufficientBalanceException;
 import com.eteration.simplebanking.model.WithdrawalTransaction;
 import com.eteration.simplebanking.services.AccountService;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.http.HttpStatus;
 import jakarta.validation.Valid;

 @RestController
 @RequestMapping("/account/v1")
 public class AccountController {
 
     private final AccountService service;
 
     public AccountController(AccountService service) {
         this.service = service;
     }
 
     @PostMapping("/create")
     public ResponseEntity<Account> createAccount(@RequestParam String owner,
                                                  @RequestParam String accountNumber) {
         Account account = new Account(owner, accountNumber);
         service.addAccount(account);
         return new ResponseEntity<>(account, HttpStatus.CREATED);
     }
    

     @GetMapping("/{accountNumber}")
     public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
         Account account = service.findAccount(accountNumber);
         return ResponseEntity.ok(account);
     }
 
     @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber,
                                                    @Valid @RequestBody TransactionRequestDto request) {
        DepositTransaction transaction = new DepositTransaction(request.getAmount());
        Account account = service.findAccount(accountNumber);  
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionStatus("FAIL", "Account not found"));
        }
        TransactionStatus status = service.credit(accountNumber, transaction);
        return ResponseEntity.ok(status);
    }

     @PostMapping("/debit/{accountNumber}")
        public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber,
                                                    @Valid @RequestBody TransactionRequestDto request) {
            try {
                WithdrawalTransaction transaction = new WithdrawalTransaction(request.getAmount());
                Account account = service.findAccount(accountNumber);  
                if (account == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionStatus("FAIL", "Account not found"));
                }
                TransactionStatus status = service.debit(accountNumber, transaction);
                return new ResponseEntity<>(status, HttpStatus.OK);
            } catch (InsufficientBalanceException e) {
                return new ResponseEntity<>(new TransactionStatus("FAIL", "Yetersiz bakiye"), HttpStatus.BAD_REQUEST);
            }
        }
 }
 