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
public class Order {
    private int orderId;
    private Timestamp orderDate;
    private int employeeId;
    private double totalCost;
    private String paymentType;
    private String customerEmail;
    private String orderStatus;
}
