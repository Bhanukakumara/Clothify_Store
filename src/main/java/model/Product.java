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
public class Product {
    private int productId;
    private String name;
    private String category; // Ladies, Gents, Kids
    private String size;
    private double price;
    private int quantity;
    private String imageUrl;
    private int supplierId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
