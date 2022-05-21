package com.yener.customerservice.controller;

import com.yener.customerservice.repository.CustomerRepository;
import com.yener.customerservice.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"server-port=0", "command.line.runner.enabled=false"})
@RunWith(SpringRunner.class)
@DirtiesContext
public class CustomerControllerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private CustomerService customerService = new CustomerService(customerRepository, modelMapper);

    @BeforeEach
    void setUp() {
    }
}