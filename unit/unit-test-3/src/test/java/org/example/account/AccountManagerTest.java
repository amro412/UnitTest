package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    AccountManager accountManager = new AccountManagerImpl();


    @Test
    void customer() {
    
        int amount = 70;
        Customer customer = new Customer();
        customer.setBalance(80);
        customer.setCreditAllowed(false);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals("success", result);
    }

    @Test
    void CustomerExceeded() {
        
        int amount = 200;
        Customer customer = new Customer();
        customer.setBalance(80);
        customer.setCreditAllowed(false);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals("failed, insufficient account balance", result);  
    }

    @Test
    void vip() {

        int amount = 200;
        Customer customer = new Customer();
        customer.setBalance(80);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals("success, customer is vip!", result);
    }

    @Test
    void CreditAllowedExceeded() {

        int amount = 200;
        Customer customer = new Customer();
        customer.setBalance(80);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals("failed, customer has exceeded the maximum limit", result);
    }

    @Test
    void CreditAllowed() {
        
        int amount = 90;
        Customer customer = new Customer();
        customer.setBalance(80);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals("success, customer is credit allowed", result);
    }

}
