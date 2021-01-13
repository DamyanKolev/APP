package net.javaguides.springboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long productId;
    private String productName;
    private String description;
    private String category;
    private String color;
    private Double quantityPerUnit;
    private Double unitPrice;
    private Double unitWeight;
    private Integer unitInStock;
}
