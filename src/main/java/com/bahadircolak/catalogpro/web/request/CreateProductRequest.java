package com.bahadircolak.catalogpro.web.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequest {

    private String name;
    private String size;
    private String photoUrl;
    private String skuCode;
}
