package org.example.monitoringMenu;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.other.ShowMenu;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MonitoringController {
    private final ShowMenu showMenu;
    private final MonitoringService monitoringService;

    public void monitoring(AuthUser user) {
        boolean status = true;
        while (status) {
            showMenu.monitoringMenu();
            switch (showMenu.getAction()) {
                case 1: {
                    System.out.println("\n----------");
                    System.out.println("|  Today  |");
                    System.out.println(" ---------");
                    monitoringService.filter(1, user);
                    break;
                }
                case 2: {
                    System.out.println("\n--------------");
                    System.out.println("|  Last week  |");
                    System.out.println(" -------------");
                    monitoringService.filter(7, user);
                    break;
                }
                case 3: {
                    System.out.println("\n---------------");
                    System.out.println("|  Last month  |");
                    System.out.println(" --------------");
                    monitoringService.filter(30, user);
                    break;
                }
                case 0: {
                    status = false;
                    break;
                }
            }
        }
    }
}
