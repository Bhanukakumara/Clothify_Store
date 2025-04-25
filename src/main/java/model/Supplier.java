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
public class Supplier {
    private int supplierId;
    private String name;
    private String companyName;
    private String email;
    private String itemSupplied;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
