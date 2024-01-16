package org.example.paymentMenu.internet;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InternetController {
    private final ShowMenu showMenu;
    private final InternetService internetService;

    public void toInternet(AuthUser user) {
        boolean status = true;
        while (status) {
            showMenu.internetProviders();
            switch (showMenu.getAction()) {
                case 1: {
                    internetService.payToInternet("Uzonline", user);
                    break;
                }
                case 2: {
                    internetService.payToInternet("TPS", user);
                    break;
                }
                case 3: {
                    internetService.payToInternet("Comnet", user);
                    break;
                }
                case 4: {
                    internetService.payToInternet("Sarkor", user);
                    break;
                }
                case 0: {
                    status = false;
                }
            }
        }
    }
}
