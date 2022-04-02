package com.yener.customerservice.dto.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerRequestDTO {
    private CustomerDTO customerDTO;
}
