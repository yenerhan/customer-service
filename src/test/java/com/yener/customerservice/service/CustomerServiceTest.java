package com.yener.customerservice.service;

import com.yener.customerservice.dto.customer.CustomerDTO;
import com.yener.customerservice.dto.customer.GetCustomerResponseDTO;
import com.yener.customerservice.entity.Customer;
import com.yener.customerservice.exception.CustomerNotFoundException;
import com.yener.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        modelMapper = mock(ModelMapper.class);
        customerService = new CustomerService(customerRepository, modelMapper);
    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer(0L, "name", "surname");
        Mockito.when(customerRepository.findById(0L)).thenReturn(Optional.of(customer));
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .build();
        Mockito.when(modelMapper.map(customer, CustomerDTO.class)).thenReturn(customerDTO);
        GetCustomerResponseDTO getCustomerResponseDTO = GetCustomerResponseDTO
                .builder()
                .customerDTO(customerDTO)
                .build();
        GetCustomerResponseDTO result = customerService.getCustomerById(0L);
        assertEquals(result, getCustomerResponseDTO);
    }


    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {
        Mockito.when(customerRepository.findById(0L)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () ->
                customerService.getCustomerById(0L));
        Mockito.verifyNoInteractions(modelMapper);
    }
}