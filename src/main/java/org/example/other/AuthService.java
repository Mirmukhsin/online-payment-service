package org.example.other;

import lombok.RequiredArgsConstructor;
import org.example.repository.AuthRepository;
import org.example.dto.AuthUser;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final ScannerService scanner;
    private final ShowMenu showMenu;

    public AuthUser login() {
        String phoneNumber = showMenu.checkPhoneNumber();
        System.out.print("Enter password: ");
        String password = scanner.getScanner().next();
        AuthUser user = authRepository.findByPhoneNumber(phoneNumber).orElse(null);
        if (user == null) {
            System.out.println("\n---------------------------------------------");
            System.out.println("|  >< THE PHONE NUMBER IS NOT REGISTERED ><  |");
            System.out.println(" --------------------------------------------");
        } else if (!user.getPassword().equals(password)) {
            System.out.println("\n------------------------------------");
            System.out.println("|  >< THE PASSWORD IS INCORRECT ><  |");
            System.out.println(" -----------------------------------");
        } else {
            System.out.println("\n----------------------------");
            System.out.println("|  Successfully logged in!  |");
            System.out.println(" ---------------------------");
            return user;
        }
        return null;
    }

    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.getScanner().next();
        String phoneNumber = showMenu.checkPhoneNumber();
        System.out.print("Enter password: ");
        String password = scanner.getScanner().next();

        AuthUser exists = authRepository.findByPhoneNumber(phoneNumber).orElse(null);
        if (exists != null) {
            System.out.println("\n--------------------------------------");
            System.out.println("|  >< PHONE NUMBER ALREADY EXISTS ><  |");
            System.out.println(" -------------------------------------");
            return;
        }
        AuthUser user = AuthUser.builder()
                .username(username)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
        boolean result = authRepository.save(user);
        if (result) {
            System.out.println("\n-----------------------------");
            System.out.println("|  Successfully registered!  |");
            System.out.println(" ----------------------------");
        } else {
            System.out.println("\n---------------------------");
            System.out.println("|  >< UNEXPECTED ERROR ><  |");
            System.out.println(" --------------------------");
        }
    }
}
