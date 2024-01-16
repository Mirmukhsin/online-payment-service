package org.example.other;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.dto.Purchase;
import org.example.dto.UserCard;
import org.example.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayService {
    private final AuthRepository authRepository;
    private final ShowMenu showMenu;
    private final ScannerService scanner;

    public void pay(Purchase purchase, AuthUser user) {
        List<UserCard> userCards = authRepository.getUserCards(user.getPhoneNumber());
        if (showMenu.checkCards(userCards)) {
            int i = 1;
            for (UserCard card : userCards) {
                if (card.getCardBalance() >= purchase.getAmount()) {
                    System.out.println("\n><><><><><><><><><><><><><><");
                    System.out.println("№: " + (i++));
                    showMenu.cardDetails(card);
                    System.out.println("><><><><><><><><><><><><><><><");
                } else {
                    System.out.println("\n><><><><><><><><><><><><><><");
                    System.out.println("№: " + (i++));
                    System.out.println(">< INSUFFICIENT FUNDS ON THE CARD ><");
                    showMenu.cardDetails(card);
                    System.out.println("><><><><><><><><><><><><><><><");
                }
            }
            System.out.print("Select a card: ");
            int currentCard = scanner.getScanner().nextInt() - 1;
            if (0 <= currentCard && currentCard < userCards.size()) {
                boolean result = authRepository.payment(purchase.getAmount(), userCards.get(currentCard));
                if (result) {
                    System.out.println("\n----------------------------");
                    System.out.println("|  Payment was successful!  |");
                    System.out.println(" ---------------------------");
                    purchase.setStatus("PAID");
                    authRepository.savePurchase(purchase, userCards.get(currentCard));
                } else {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|  >< INSUFFICIENT FUNDS ON THE CARD ><  |");
                    System.out.println(" ----------------------------------------");
                    purchase.setStatus("UNPAID");
                    authRepository.savePurchase(purchase, userCards.get(currentCard));
                }
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        }
    }
}
