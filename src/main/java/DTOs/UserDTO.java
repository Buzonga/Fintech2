package DTOs;

import Models.Transaction;
import Models.User;

import java.util.Date;
import java.util.List;

public class UserDTO {
    public String idUser;
    public String email;
    public String username;
    public String psw;
    public String picture;
    public Date createDate;
    public double balance;
    public List<Transaction> transactions;

    public static UserDTO Parse(User user) {
        UserDTO dto = new UserDTO();

        dto.balance = user.getBalance();
        dto.email = user.getEmail();
        dto.username = user.getUsername();
        dto.picture = user.getPicture();
        dto.createDate = user.getCreateDate();
        dto.transactions = user.getTransactions();
        dto.idUser = user.getId();

        return dto;
    }
}
