package org.example.paymentMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.example.paymentMenu.internet.InternetController;
import org.example.paymentMenu.mobile.MobilePhoneController;
import org.example.paymentMenu.publicServices.PublicServicesController;
import org.example.paymentMenu.publicUtilities.PublicUtilitiesController;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final ShowMenu showMenu;
    private final MobilePhoneController phone;
    private final InternetController internet;
    private final PublicUtilitiesController publicUtilities;
    private final PublicServicesController publicServices;

    public void payment(AuthUser user) {
        boolean case3 = true;
        while (case3) {
            showMenu.paymentMenu();
            switch (showMenu.getAction()) {
                case 1: {
//                    << Mobile operators >>
                    phone.toPhone(user);
                    break;
                }
                case 2: {
//                    << Internet providers >>
                    internet.toInternet(user);
                    break;
                }
                case 3: {
//                    << Public utilities >>
                    publicUtilities.toPublicUtilities(user);
                    break;
                }
                case 4: {
//                    << Public services >>
                    publicServices.toPublicServices(user);
                    break;
                }
                case 0: {
                    case3 = false;
                }
            }
        }
    }
}
