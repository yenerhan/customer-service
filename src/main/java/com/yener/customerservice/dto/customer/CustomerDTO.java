package com.yener.customerservice.dto.customer;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CustomerDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
}
