package com.yener.customerservice.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CustomerDTO {
    @NotNull
    private Long id;
    @NotNull(message = "Null olamaz")
    @NotBlank(message = "Null olamaz")
    private String name;
    @NotNull(message = "Null olamaz")
    @NotBlank(message = "Null olamaz")
    private String surname;
}
