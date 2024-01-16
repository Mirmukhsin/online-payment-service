package org.example.paymentMenu.internet;

import lombok.RequiredArgsConstructor;
import org.example.dto.Purchase;
import org.example.other.PayService;
import org.example.dto.AuthUser;
import org.example.other.ScannerService;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternetService {
    private final PayService payService;
    private final ScannerService scanner;
    private final ShowMenu showMenu;

    public void payToInternet(String providers, AuthUser user) {
        Purchase purchase = new Purchase();
        switch (providers) {
            case "Uzonline": {
                System.out.println("\n-------------------");
                System.out.println("|  << Uzonline >>  |");
                System.out.println(" ------------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Uzonline");
                payService.pay(purchase, user);
                break;
            }
            case "TPS": {
                System.out.println("\n--------------");
                System.out.println("|  << TPS >>  |");
                System.out.println(" -------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("TPS");
                payService.pay(purchase, user);
                break;
            }
            case "Comnet": {
                System.out.println("\n-----------------");
                System.out.println("|  << Comnet >>  |");
                System.out.println(" ----------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Comnet");
                payService.pay(purchase, user);
                break;
            }
            case "Sarkor": {
                System.out.println("\n-----------------");
                System.out.println("|  << Sarkor >>  |");
                System.out.println(" ----------------");
                System.out.print("Account number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Sarkor");
                payService.pay(purchase, user);
                break;
            }
        }
    }
}
