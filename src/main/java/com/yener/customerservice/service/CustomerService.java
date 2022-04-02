package com.yener.customerservice.service;

import com.yener.customerservice.dto.customer.*;
import com.yener.customerservice.entity.Customer;
import com.yener.customerservice.exception.CustomerNotFoundException;
import com.yener.customerservice.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CreateCustomerResponseDTO createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer customer = modelMapper.map(createCustomerRequestDTO.getCustomerDTO(), Customer.class);
        customer = customerRepository.save(customer);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return CreateCustomerResponseDTO
                .builder()
                .customerDTO(customerDTO)
                .build();
    }

    public GetAllCustomerResponseDTO getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList =
                customerList
                        .stream()
                        .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                        .collect(Collectors.toList());
        return GetAllCustomerResponseDTO
                .builder()
                .customerDTOList(customerDTOList)
                .build();
    }

    public GetCustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: " + id));

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return GetCustomerResponseDTO
                .builder()
                .customerDTO(customerDTO)
                .build();
    }

    public DeleteCustomerResponseDTO deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return DeleteCustomerResponseDTO
                .builder()
                .build();
    }

}
