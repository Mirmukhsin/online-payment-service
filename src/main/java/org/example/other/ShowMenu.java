package org.example.other;

import lombok.RequiredArgsConstructor;
import org.example.dto.Purchase;
import org.example.dto.UserCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ShowMenu {
    private final ScannerService scanner;

    public void auth() {
        System.out.println("\n------------------------------------");
        System.out.println("|  << Panda Payment Service >>      |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  1. Login.                        |");
        System.out.println("|  2. Register.                     |");
        System.out.println("|  3. Payment without registration. |");
        System.out.println("|  0. Exit.                         |");
        System.out.println(" -----------------------------------");
    }

    public int getAction() {
        System.out.print("Select: ");
        return scanner.getScanner().nextInt();
    }

    public void payOnline() {
        System.out.print("Phone number: +998 ");
        scanner.getScanner().next();
        System.out.print("Amount of payment: $ ");
        scanner.getScanner().next();
        System.out.println("\n----------------------------");
        System.out.println("|  Payment was successful!  |");
        System.out.println(" ---------------------------");
    }

    public void menu() {
        System.out.println("\n------------------------------");
        System.out.println("|  << Main >>                 |");
        System.out.println("|-----------------------------|");
        System.out.println("|  1. Financial Transfer.     |");
        System.out.println("|  2. Payment.                |");
        System.out.println("|  3. Monitoring of payments. |");
        System.out.println("|  4. My debit cards.         |");
        System.out.println("|  0. Back.                   |");
        System.out.println(" -----------------------------");
    }

    public void cardDetails(UserCard card) {
        System.out.println("Name: " + card.getCardName());
        System.out.println("Balance: $ " + card.getCardBalance());
        System.out.println("User: " + card.getUsername());
        System.out.println("Card Number: " + card.getCardNumber());
    }

    public void debitCardMenu() {
        System.out.println("\n-------------------------------");
        System.out.println("|  << My debit cards >>        |");
        System.out.println("|  -- Debit card settings --   |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Cards List.              |");
        System.out.println("|  2. Add debit card.          |");
        System.out.println("|  3. Add Balance.             |");
        System.out.println("|  0. Back.                    |");
        System.out.println(" -----------------------------");
    }

    public void paymentMenu() {
        System.out.println("\n-------------------------------");
        System.out.println("|  << Payment >>               |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Mobile operators.        |");
        System.out.println("|  2. Internet providers.      |");
        System.out.println("|  3. Public utilities.        |");
        System.out.println("|  4. Public services.         |");
        System.out.println("|  0. Back.                    |");
        System.out.println(" ------------------------------");
    }

    public void mobileOperators() {
        System.out.println("\n-------------------------------");
        System.out.println("|  << Mobile operators >>      |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Beeline.                 |");
        System.out.println("|  2. Uzmobile.                |");
        System.out.println("|  3. Ucell.                   |");
        System.out.println("|  4. Mobi Uz.                 |");
        System.out.println("|  0. Back.                    |");
        System.out.println(" ------------------------------");
    }

    public void internetProviders() {
        System.out.println("\n-------------------------------");
        System.out.println("|  << Internet Providers >>    |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Uzonline.                |");
        System.out.println("|  2. TPS.                     |");
        System.out.println("|  3. Comnet.                  |");
        System.out.println("|  4. Sarkor.                  |");
        System.out.println("|  0. Back.                    |");
        System.out.println(" ------------------------------");
    }

    public void publicUtilities() {
        System.out.println("\n-------------------------------");
        System.out.println("|  << Public utilities >>      |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Electricity.             |");
        System.out.println("|  2. Gas.                     |");
        System.out.println("|  3. Water.                   |");
        System.out.println("|  4. Trash.                   |");
        System.out.println("|  0. Back.                    |");
        System.out.println(" ------------------------------");
    }

    public String region() {
        System.out.println("\n---------------------");
        System.out.println("|  1. Tashkent.      |");
        System.out.println("|  2. Samarkand.     |");
        System.out.println("|  3. Qumqo'rg'on.   |");
        System.out.println("|  4. Bukhara.       |");
        System.out.println(" --------------------");
        System.out.print("Select a region: ");
        return switch (scanner.getScanner().nextInt()) {
            case 1 -> "Tashkent";
            case 2 -> "Samarkand";
            case 3 -> "Qumqo'rg'on";
            case 4 -> "Bukhara";
            default -> null;
        };
    }

    public String bank() {
        System.out.println("\n---------------------");
        System.out.println("|  1. Ipoteka Bank.  |");
        System.out.println("|  2. Anorbank.      |");
        System.out.println("|  3. Kapitalbank.   |");
        System.out.println("|  4. Asakabank.     |");
        System.out.println(" --------------------");
        System.out.print("Select a bank: ");
        return switch (scanner.getScanner().nextInt()) {
            case 1 -> "Ipoteka Bank";
            case 2 -> "Anorbank";
            case 3 -> "Kapitalbank";
            case 4 -> "Asakabank";
            default -> null;
        };
    }

    public void publicServices() {
        System.out.println("\n----------------------------------");
        System.out.println("|  << Public Services >>          |");
        System.out.println("|---------------------------------|");
        System.out.println("|  1. Notary.                     |");
        System.out.println("|  2. State traffic police fines. |");
        System.out.println("|  3. State tax service.          |");
        System.out.println("|  4. Repayment of bank loans.    |");
        System.out.println("|  0. Back.                       |");
        System.out.println(" ---------------------------------");
    }

    public void monitoringMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("|  << Monitoring of payments >> |");
        System.out.println("|-------------------------------|");
        System.out.println("|  1. Today.                    |");
        System.out.println("|  2. Last week.                |");
        System.out.println("|  3. Last month.               |");
        System.out.println("|  0. Back.                     |");
        System.out.println(" -------------------------------");
    }

    public void purchaseDetails(Purchase purchase) {
        System.out.println("Service: " + purchase.getService());
        System.out.println("Recipient: " + purchase.getRecipient());
        System.out.println("Your Card: " + purchase.getCardNumber());
        System.out.println("Status: " + purchase.getStatus());
        System.out.println("Date: " + purchase.getPurchase_date());
        System.out.println("Amount: $ " + purchase.getAmount());
    }

    public boolean checkCards(List<UserCard> userCards) {
        if (userCards.isEmpty()) {
            System.out.println("\n---------------------------------");
            System.out.println("|  >< YOU DO NOT HAVE A CARD ><  |");
            System.out.println(" --------------------------------");
            return false;
        }
        return true;
    }

    public String checkPhoneNumber() {
        String phoneNumber;
        boolean res = true;
        do {
            System.out.print("\nPhone number: +998 ");
            phoneNumber = scanner.getScanner().next();
            if (Pattern.matches("^9[01345789][0-9]{7}$", phoneNumber)) {
                res = false;
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        } while (res);
        return phoneNumber;
    }

    public String checkBeeline() {
        String phoneNumber;
        boolean res = true;
        do {
            System.out.print("\nPhone number: +998 ");
            phoneNumber = scanner.getScanner().next();
            if (Pattern.matches("^(90|91)[0-9]{7}$", phoneNumber)) {
                res = false;
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        } while (res);
        return phoneNumber;
    }

    public String checkUzmobile() {
        String phoneNumber;
        boolean res = true;
        do {
            System.out.print("\nPhone number: +998 ");
            phoneNumber = scanner.getScanner().next();
            if (Pattern.matches("^(99|95|77)[0-9]{7}$", phoneNumber)) {
                res = false;
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        } while (res);
        return phoneNumber;
    }

    public String checkUcell() {
        String phoneNumber;
        boolean res = true;
        do {
            System.out.print("\nPhone number: +998 ");
            phoneNumber = scanner.getScanner().next();
            if (Pattern.matches("^(93|94|50)[0-9]{7}$", phoneNumber)) {
                res = false;
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        } while (res);
        return phoneNumber;
    }

    public String checkMobi() {
        String phoneNumber;
        boolean res = true;
        do {
            System.out.print("\nPhone number: +998 ");
            phoneNumber = scanner.getScanner().next();
            if (Pattern.matches("^(97|88)[0-9]{7}$", phoneNumber)) {
                res = false;
            } else {
                System.out.println("\n---------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG NUMBER ><  |");
                System.out.println(" --------------------------------------");
            }
        } while (res);
        return phoneNumber;
    }

    public double checkAmount() {
        double amount;
        do {
            System.out.print("Amount of payment: $ ");
            amount = scanner.getScanner().nextDouble();
        } while (amount < 0);
        return amount;
    }

    public double checkBalance() {
        double balance;
        do {
            System.out.print("Amount: $ ");
            balance = scanner.getScanner().nextDouble();
        } while (balance < 0);
        return balance;
    }

    public String checkCardNumber() {
        String cardNumber;
        boolean res = true;
        do {
            System.out.print("\nDebit card number: ");
            cardNumber = scanner.getScanner().next();
            if (Pattern.matches("^(8600|9860|5614)[0-9]{12}$", cardNumber)) {
                res = false;
            } else {
                System.out.println("\n--------------------------------------------");
                System.out.println("|  >< YOU ENTERED THE WRONG CARD NUMBER ><  |");
                System.out.println(" -------------------------------------------");
            }
        } while (res);
        return cardNumber;
    }

}
