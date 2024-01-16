package org.example.mainMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.monitoringMenu.MonitoringController;
import org.example.myCardMenu.MyCardsController;
import org.example.other.ShowMenu;
import org.example.paymentMenu.PaymentController;
import org.example.other.AuthService;
import org.example.transferMenu.TransferService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ShowMenu showMenu;
    private final AuthService authService;
    private final TransferService transferService;
    private final MyCardsController myCardsController;
    private final PaymentController paymentController;
    private final MonitoringController monitoringController;


    public void start() {
        boolean status = true;
        while (status) {
            showMenu.auth();
            switch (showMenu.getAction()) {
                case 1: {
                    System.out.println("\n----------------");
                    System.out.println("|  << Login >>  |");
                    System.out.println(" ---------------");
                    AuthUser user = authService.login();
                    if (user != null) {
                        mainMenu(user);
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n-------------------");
                    System.out.println("|  << Register >>  |");
                    System.out.println(" ------------------");
                    authService.register();
                    break;
                }
                case 3: {
                    System.out.println("\n------------------------------------------------");
                    System.out.println("|  << Payments for mobile operator services >>  |");
                    System.out.println(" -----------------------------------------------");
                    showMenu.payOnline();
                    break;
                }
                case 0: {
                    System.out.println("\n--------------");
                    System.out.println("|  Good bye!  |");
                    System.out.println(" -------------");
                    status = false;
                }
            }
        }
    }

    private void mainMenu(AuthUser user) {
        boolean case1 = true;
        while (case1) {
            showMenu.menu();
            switch (showMenu.getAction()) {
                case 1: {
//                    << Financial Transfer >>
                    transferService.financialTransfer(user);
                    break;
                }
                case 2: {
//                    << Payment >>
                    paymentController.payment(user);
                    break;
                }
                case 3: {
//                    << Monitoring of payments >>
                    monitoringController.monitoring(user);
                    break;
                }
                case 4: {
//                    << My debit cards >>
                    myCardsController.debitCards(user);
                    break;
                }
                case 0: {
                    case1 = false;
                }
            }
        }
    }
}
