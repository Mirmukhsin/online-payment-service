package org.example.paymentMenu.publicUtilities;

import lombok.RequiredArgsConstructor;
import org.example.dto.Purchase;
import org.example.other.PayService;
import org.example.dto.AuthUser;
import org.example.other.ScannerService;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PublicUtilitiesService {
    private final ShowMenu showMenu;
    private final PayService payService;
    private final ScannerService scanner;

    public void payToPublicUtilities(String publicUtilities, AuthUser user) {
        Purchase purchase = new Purchase();
        switch (publicUtilities) {
            case "Electricity": {
                System.out.println("\n----------------------");
                System.out.println("|  << Electricity >>  |");
                System.out.println(" ---------------------");
                String region = showMenu.region();
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Electricity: " + region);
                payService.pay(purchase, user);
                break;
            }
            case "Gas": {
                System.out.println("\n--------------");
                System.out.println("|  << Gas >>  |");
                System.out.println(" -------------");
                String region = showMenu.region();
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Gas: " + region);
                payService.pay(purchase, user);
                break;
            }
            case "Water": {
                System.out.println("\n----------------");
                System.out.println("|  << Water >>  |");
                System.out.println(" ---------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Water");
                payService.pay(purchase, user);
                break;
            }
            case "Trash": {
                System.out.println("\n----------------");
                System.out.println("|  << Trash >>  |");
                System.out.println(" ---------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Trash");
                payService.pay(purchase, user);
                break;
            }
        }
    }
}
