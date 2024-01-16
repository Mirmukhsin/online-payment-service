package org.example.monitoringMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.dto.Purchase;
import org.example.dto.UserCard;
import org.example.other.ScannerService;
import org.example.other.ShowMenu;
import org.example.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoringService {
    private final AuthRepository authRepository;
    private final ShowMenu showMenu;
    private final ScannerService scanner;

    public void filter(int day, AuthUser user) {
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
                List<Purchase> purchases = authRepository.getUserPurchases(day, userCards.get(currentCard));
                if (purchases.isEmpty()) {
                    System.out.println("\n-------------------");
                    System.out.println("|  No transaction  |");
                    System.out.println(" ------------------");
                } else {
                    System.out.println("\n------------------------------------------------------");
                    System.out.println("|  << History of payments, transfers and receipts >>  |");
                    System.out.println(" -----------------------------------------------------");
                    int n = 1;
                    for (Purchase purchase : purchases) {
                        System.out.println("\n><><><><><><><><><><><><><><");
                        System.out.println("№: " + (n++));
                        showMenu.purchaseDetails(purchase);
                        System.out.println("><><><><><><><><><><><><><><><");
                    }
                }
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        }
    }
}
