package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Purchase {
    private String cardNumber;
    private String service;
    private String recipient;
    private double amount;
    private String status;
    private String purchase_date;
}
