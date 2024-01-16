package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthUser;
import org.example.dto.Purchase;
import org.example.dto.UserCard;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthRepository {
    private final JdbcTemplate jdbcTemplate;

    public String currentDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        java.util.Date date = new Date();
        return format.format(date);
    }

    public String[] limit(int day) {
        String today = "", selectDay = "";
        switch (day) {
            case 1: {
                today = currentDateTime();
                selectDay = today.substring(0, 11) + "00:00:00";
                break;
            }
            case 7: {
                today = currentDateTime();
                int res = Integer.parseInt(today.substring(0, 2)) - 7;
                String dd = res < 10 ? "0" + res : String.valueOf(res);
                selectDay = dd + today.substring(2, 11) + "00:00:00";
                System.out.println("SELECT DAY: " + selectDay);
                break;
            }
            case 30: {
                today = currentDateTime();
                selectDay = "01" + today.substring(2, 11) + "00:00:00";
                break;
            }
        }
        return new String[]{today, selectDay};
    }

    public Optional<AuthUser> findByPhoneNumber(String phoneNumber) {
        String sql = "select * from authUser where phoneNumber = ?";
        try {
            AuthUser user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(AuthUser.class), phoneNumber);
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean save(AuthUser user) {
        String sql = "insert into authUser (username,phoneNumber,password) values (?,?,?)";
        int n = jdbcTemplate.update(sql, user.getUsername(), user.getPhoneNumber(), user.getPassword());
        return n == 1 ? true : false;
    }

    public boolean saveCard(UserCard card) {
        String sql = "insert into userCard (username,phoneNumber,cardNumber,cardName,cardBalance) values (?,?,?,?,?)";
        int n = jdbcTemplate.update(sql, card.getUsername(), card.getPhoneNumber(), card.getCardNumber(), card.getCardName(), card.getCardBalance());
        return n == 1 ? true : false;
    }

    public List<UserCard> getUserCards(String phoneNumber) {
        String sql = "select * from userCard where phoneNumber = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserCard.class), phoneNumber);
    }

    public boolean payment(double amount, UserCard card) {
        if (card.getCardBalance() < amount) {
            return false;
        }
        int sum = (int) (card.getCardBalance() - amount);
        String sql = "update userCard set cardBalance = ? where cardNumber = ?";
        int n = jdbcTemplate.update(sql, sum, card.getCardNumber());
        return true;
    }

    public void addBalance(double balance, UserCard card) {
        int sum = (int) (balance + card.getCardBalance());
        String sql = "update userCard set cardBalance = ?  where cardNumber = ?";
        jdbcTemplate.update(sql, sum, card.getCardNumber());
    }

    public void savePurchase(Purchase purchase, UserCard card) {
        String sql = "insert into purchase (recipient,status,cardNumber,service,amount,purchase_date) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, purchase.getRecipient(), purchase.getStatus(), card.getCardNumber(), purchase.getService(), purchase.getAmount(), currentDateTime());
    }


    public List<Purchase> getUserPurchases(int day, UserCard card) {
        String[] days = limit(day);
        String sql = "select * from purchase where cardNumber = ? and purchase_date >= ? and purchase_date <= ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Purchase.class), card.getCardNumber(), days[1], days[0]);
    }
}
