package org.example.myCardMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MyCardsController {
    private final ShowMenu showMenu;
    private final MyCardsService myCardsService;

    public void debitCards(AuthUser user) {
        boolean case2 = true;
        while (case2) {
            showMenu.debitCardMenu();
            switch (showMenu.getAction()) {
                case 1: {
                    System.out.println("\n---------------------");
                    System.out.println("|  << Your cards >>  |");
                    System.out.println(" --------------------");
                    myCardsService.cardList(user);
                    break;
                }
                case 2: {
                    System.out.println("\n-------------------------");
                    System.out.println("|  << Add debit card >>  |");
                    System.out.println(" ------------------------");
                    myCardsService.addCard(user);
                    break;
                }
                case 3: {
                    System.out.println("\n----------------------");
                    System.out.println("|  << Add Balance >>  |");
                    System.out.println(" ---------------------");
                    myCardsService.addBalance(user);
                    break;
                }
                case 0: {
                    case2 = false;
                }
            }
        }
    }
}
