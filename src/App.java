import java.util.Collections;
import java.util.Scanner;

import br.com.alura.poo.Comparator.PurchaseComparator;
import br.com.alura.poo.models.CreditCard;
import br.com.alura.poo.models.Purchase;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = read.nextDouble();
        CreditCard card = new CreditCard(limit);

        int out = 1;
        while (out != 0) {
            System.out.println("Digite a descrição da compra:");
            String description = read.next();

            System.out.println("Digite o valor da compra:");
            double value = read.nextDouble();

            Purchase purchase = new Purchase(description, value);
            boolean purchaseSucessful = card.newPurchase(purchase);

            if (purchaseSucessful) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                out = read.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                out = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        PurchaseComparator comparator = new PurchaseComparator();

        Collections.sort(card.getPurchase(), comparator);

        for (Purchase c : card.getPurchase()) {
            System.out.println(c.getDescription() + " - " + c.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " + card.getBalance());
    }
}
