package com.yener.customerservice.dto.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllCustomerResponseDTO {
    private List<CustomerDTO> customerDTOList;
}
