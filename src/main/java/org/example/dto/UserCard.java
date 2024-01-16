package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCard {
    private String username;
    private String phoneNumber;
    private String cardNumber;
    private String cardName;
    private double cardBalance;
}
