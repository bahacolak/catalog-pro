package com.bahadircolak.catalogpro.web.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Size cannot be blank")
    private String size;
    @NotBlank(message = "Photo cannot be blank")
    private String photoUrl;
    @NotBlank(message = "SkuCode cannot be blank")
    private String skuCode;
}
