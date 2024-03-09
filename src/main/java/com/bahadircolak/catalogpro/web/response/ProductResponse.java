package com.bahadircolak.catalogpro.web.response;

import com.bahadircolak.catalogpro.web.dto.ProductDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private ProductDto product;
}
