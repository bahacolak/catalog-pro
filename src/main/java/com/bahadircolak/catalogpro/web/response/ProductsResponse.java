package com.bahadircolak.catalogpro.web.response;

import com.bahadircolak.catalogpro.web.dto.ProductDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {

    private List<ProductDto> products;
}
