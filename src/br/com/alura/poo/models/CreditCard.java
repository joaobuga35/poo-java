package br.com.alura.poo.models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> purchase;

    private CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchase = new ArrayList<>();
    }

    public boolean newPurchase(Purchase purchase) {
        if (this.balance > purchase.getValue()) {
            this.balance -= purchase.getValue();
            this.purchase.add(purchase);
            return true;
        }
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

}
