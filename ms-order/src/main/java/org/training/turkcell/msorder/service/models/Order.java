package org.training.turkcell.msorder.service.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private String orderId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String meal;
    private Integer amount;
    private int status;
    private LocalDateTime orderCreationTime;
    private Long customerId;
}
