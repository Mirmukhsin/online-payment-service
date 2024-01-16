package org.example.paymentMenu.publicUtilities;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PublicUtilitiesController {
    private final ShowMenu showMenu;
    private final PublicUtilitiesService internetService;

    public void toPublicUtilities(AuthUser user) {
        boolean status = true;
        while (status) {
            showMenu.publicUtilities();
            switch (showMenu.getAction()) {
                case 1: {
                    internetService.payToPublicUtilities("Electricity", user);
                    break;
                }
                case 2: {
                    internetService.payToPublicUtilities("Gas", user);
                    break;
                }
                case 3: {
                    internetService.payToPublicUtilities("Water", user);
                    break;
                }
                case 4: {
                    internetService.payToPublicUtilities("Trash", user);
                    break;
                }
                case 0: {
                    status = false;
                }
            }
        }
    }
}
