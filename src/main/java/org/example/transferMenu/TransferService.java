package org.example.transferMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.dto.Purchase;
import org.example.other.PayService;
import org.example.other.ScannerService;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final PayService payService;
    private final ScannerService scanner;
    private final ShowMenu showMenu;

    public void financialTransfer(AuthUser user) {
        Purchase purchase = new Purchase();
        int res = 0;
        do {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("|             << Financial Transfer >>               |");
            System.out.println("|  Peer-to-pear transaction  <----->  Commission 0%  |");
            System.out.println("|             --- Transfer money ---                 |");
            System.out.println(" ----------------------------------------------------");
            purchase.setRecipient(showMenu.checkCardNumber());
            purchase.setAmount(showMenu.checkAmount());
            purchase.setService("Financial Transfer");
            payService.pay(purchase, user);

            System.out.print("\n1.Again  <>  0.Back  : ");
            res = scanner.getScanner().nextInt();
        } while (res != 0);

    }

}
