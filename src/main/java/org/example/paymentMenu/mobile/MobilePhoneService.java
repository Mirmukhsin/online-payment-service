package org.example.paymentMenu.mobile;

import lombok.RequiredArgsConstructor;
import org.example.dto.Purchase;
import org.example.other.PayService;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MobilePhoneService {

    private final PayService payService;
    private final ShowMenu showMenu;

    public void payToPhone(String operator, AuthUser user) {
        Purchase purchase = new Purchase();
        switch (operator) {
            case "Beeline": {
                System.out.println("\n------------------");
                System.out.println("|  << Beeline >>  |");
                System.out.println(" -----------------");
                purchase.setRecipient(showMenu.checkBeeline());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Beeline");
                payService.pay(purchase, user);
                break;
            }
            case "Uzmobile": {
                System.out.println("\n-------------------");
                System.out.println("|  << Uzmobile >>  |");
                System.out.println(" ------------------");
                purchase.setRecipient(showMenu.checkUzmobile());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Uzmobile");
                payService.pay(purchase, user);
                break;
            }
            case "Ucell": {
                System.out.println("\n----------------");
                System.out.println("|  << Ucell >>  |");
                System.out.println(" ---------------");
                purchase.setRecipient(showMenu.checkUcell());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Ucell");
                payService.pay(purchase, user);
                break;
            }
            case "Mobi Uz": {
                System.out.println("\n------------------");
                System.out.println("|  << Mobi Uz >>  |");
                System.out.println(" -----------------");
                purchase.setRecipient(showMenu.checkMobi());
                purchase.setAmount(showMenu.checkAmount());
                purchase.setService("Mobi Uz");
                payService.pay(purchase, user);
                break;
            }
        }
    }
}
