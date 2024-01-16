package org.example.myCardMenu;

import lombok.RequiredArgsConstructor;
import org.example.other.ScannerService;
import org.example.repository.AuthRepository;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.example.dto.UserCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyCardsService {
    private final ShowMenu showMenu;
    private final AuthRepository authRepository;
    private final ScannerService scanner;

    public void cardList(AuthUser user) {
        List<UserCard> userCards = authRepository.getUserCards(user.getPhoneNumber());
        if (showMenu.checkCards(userCards)) {
            int i = 1;
            for (UserCard card : userCards) {
                System.out.println("\n><><><><><><><><><><><><><><");
                System.out.println("№: " + (i++));
                showMenu.cardDetails(card);
                System.out.println("><><><><><><><><><><><><><><><");
            }
        }
    }

    public void addCard(AuthUser user) {
        UserCard card = new UserCard();
        int res = 0;
        do {
            card.setCardNumber(showMenu.checkCardNumber());
            System.out.print("Debit card name: ");
            card.setCardName(scanner.getScanner().next());
            card.setUsername(user.getUsername());
            card.setPhoneNumber(user.getPhoneNumber());
            boolean result = authRepository.saveCard(card);
            if (result) {
                System.out.println("\n-----------------------------");
                System.out.println("|  Card added successfully!  |");
                System.out.println(" ----------------------------");
            } else {
                System.out.println("\n---------------------------");
                System.out.println("|  >< UNEXPECTED ERROR ><  |");
                System.out.println(" --------------------------");
            }

            System.out.print("\n1.Again  <>  0.Back  : ");
            res = scanner.getScanner().nextInt();
        } while (res != 0);
    }

    public void addBalance(AuthUser user) {
        int res = 0;
        do {
            List<UserCard> userCards = authRepository.getUserCards(user.getPhoneNumber());
            if (showMenu.checkCards(userCards)) {
                int i = 1;
                for (UserCard card : userCards) {
                    System.out.println("\n><><><><><><><><><><><><><><");
                    System.out.println("№: " + (i++));
                    showMenu.cardDetails(card);
                    System.out.println("><><><><><><><><><><><><><><><");
                }
                System.out.print("Select a card: ");
                int currentCard = scanner.getScanner().nextInt() - 1;
                if (0 <= currentCard && currentCard < userCards.size()) {
                    double sum = showMenu.checkBalance();
                    authRepository.addBalance(sum, userCards.get(currentCard));
                    System.out.println("\n------------------------------------------");
                    System.out.println("|  Balance was successfully replenished!  |");
                    System.out.println(" -----------------------------------------");
                } else {
                    System.out.println("\n---------------------------------------");
                    System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                    System.out.println(" --------------------------------------");
                }
            }
            System.out.print("\n1.Again  <>  0.Back  : ");
            res = scanner.getScanner().nextInt();
        } while (res != 0);
    }
}
