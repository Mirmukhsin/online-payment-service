package org.example.paymentMenu.publicServices;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PublicServicesController {
    private final ShowMenu showMenu;
    private final PublicServices_Service publicServices;

    public void toPublicServices(AuthUser user) {
        boolean status = true;
        while (status) {
            showMenu.publicServices();
            switch (showMenu.getAction()) {
                case 1: {
                    publicServices.payToPublicServices("Notary", user);
                    break;
                }
                case 2: {
                    publicServices.payToPublicServices("State traffic police fines", user);
                    break;
                }
                case 3: {
                    publicServices.payToPublicServices("State tax service", user);
                    break;
                }
                case 4: {
                    publicServices.payToPublicServices("Repayment of bank loans", user);
                    break;
                }
                case 0: {
                    status = false;
                }
            }
        }
    }
}
