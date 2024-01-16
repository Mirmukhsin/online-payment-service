package org.example.other;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Getter
public class ScannerService {
    private final Scanner scanner;

    public ScannerService() {
        scanner = new Scanner(System.in);
    }
}
