package org.example.account;
public class AccountManagerImpl implements AccountManager {
    private static final int MAX_CREDIT = 50;
    @Override
    public void deposit(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = (customer.getBalance() - amount)*-1;

        if (expectedBalance > 0) {
            if (!customer.isCreditAllowed()) {
                return "failed, insufficient account balance";
            } else if (expectedBalance > MAX_CREDIT && !customer.isVip()) {
                return "failed, customer has exceeded the maximum limit";
            }else if(customer.isCreditAllowed() && expectedBalance < MAX_CREDIT && !customer.isVip()){
                customer.setBalance(expectedBalance);
                return "success, customer is credit allowed";
            }else if(customer.isVip()){
                customer.setBalance(expectedBalance);
                return "success, customer is vip!";
            }
        }
        customer.setBalance(expectedBalance);
        return "success";
    }
}
