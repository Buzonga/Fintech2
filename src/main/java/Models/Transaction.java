package Models;
import java.util.Date;

public class Transaction {
    private String idTransaction;
    private int type;
    private Date creationDate;
    private int amount;
    private String userId;

    // region Getters

    public String getIdTransaction() {
        return idTransaction;
    }

    public int getType() {
        return type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }

    // endregion
}

