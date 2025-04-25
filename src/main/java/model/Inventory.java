package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventory {
    private int inventoryId;
    private int productId;
    private int quantityAdded;
    private String transactionType; // Stock In or Stock Out
    private Timestamp transactionDate;
}
