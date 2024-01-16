package org.example.paymentMenu.mobile;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MobilePhoneController {
    private final ShowMenu showMenu;
    private final MobilePhoneService phoneService;

    public void toPhone(AuthUser user) {
        boolean status = true;
        while (status) {
            showMenu.mobileOperators();
            switch (showMenu.getAction()) {
                case 1: {
                    phoneService.payToPhone("Beeline", user);
                    break;
                }
                case 2: {
                    phoneService.payToPhone("Uzmobile", user);
                    break;
                }
                case 3: {
                    phoneService.payToPhone("Ucell", user);
                    break;
                }
                case 4: {
                    phoneService.payToPhone("Mobi Uz", user);
                    break;
                }
                case 0: {
                    status = false;
                }
            }
        }
    }
}
