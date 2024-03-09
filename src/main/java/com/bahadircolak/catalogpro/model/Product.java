package com.bahadircolak.catalogpro.model;

import com.bahadircolak.catalogpro.web.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private String photoUrl;
    private String skuCode;

    public ProductDto toDto() {
        ProductDto dto = new ProductDto();
        dto.setProductId(this.id);
        dto.setName(this.name);
        dto.setSize(this.size);
        dto.setPhotoUrl(this.photoUrl);
        dto.setSkuCode(this.skuCode);
        return dto;
    }

}
