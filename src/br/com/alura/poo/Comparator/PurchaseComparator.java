package br.com.alura.poo.Comparator;

import java.util.Comparator;

import br.com.alura.poo.models.Purchase;

public class PurchaseComparator implements Comparator<Purchase> {

    @Override
    public int compare(Purchase purchase, Purchase otherPurchase) {
        return purchase.getDescription().compareTo(otherPurchase.getDescription());
    }

}
