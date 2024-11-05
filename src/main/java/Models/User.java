package Models;

import java.util.Date;
import java.util.List;

public class User {
    private String idUser;
    private String email;
    private String username;
    private String psw;
    private String picture;
    private Date createDate;
    private double balance;
    private List<Transaction> transactions;

    public User() {}

    // region Getters

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.idUser;
    }

    public String getPicture() {
        return this.picture;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public String getPsw() { return this.psw; }

    // endregion

    // region Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // endregion
}
