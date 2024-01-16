package org.example.paymentMenu.publicServices;

import lombok.RequiredArgsConstructor;
import org.example.dto.Purchase;
import org.example.other.PayService;
import org.example.dto.AuthUser;
import org.example.other.ScannerService;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicServices_Service {
    private final ShowMenu showMenu;
    private final PayService payService;
    private final ScannerService scanner;

    public void payToPublicServices(String publicServices, AuthUser user) {
        Purchase purchase = new Purchase();
        switch (publicServices) {
            case "Notary": {
                System.out.println("\n-----------------");
                System.out.println("|  << Notary >>  |");
                System.out.println(" ----------------");
                System.out.print("Payer invoice number: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Notary");
                payService.pay(purchase, user);
                break;
            }
            case "State traffic police fines": {
                System.out.println("\n-------------------------------------");
                System.out.println("|  << State traffic police fines >>  |");
                System.out.println(" ------------------------------------");
                System.out.print("Series and number of the resolution: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("State traffic police fines");
                payService.pay(purchase, user);
                break;
            }
            case "State tax service": {
                System.out.println("\n----------------------------");
                System.out.println("|  << State tax service >>  |");
                System.out.println(" ---------------------------");
                System.out.print("Personal identification number of an individual: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("State tax service");
                payService.pay(purchase, user);
                break;
            }
            case "Repayment of bank loans": {
                System.out.println("\n----------------------------------");
                System.out.println("|  << Repayment of bank loans >>  |");
                System.out.println(" ---------------------------------");
                String bank = showMenu.bank();
                System.out.print("Credit code: ");
                purchase.setRecipient(scanner.getScanner().next());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Repayment of bank loans: " + bank);
                payService.pay(purchase, user);
                break;
            }
        }
    }
}
