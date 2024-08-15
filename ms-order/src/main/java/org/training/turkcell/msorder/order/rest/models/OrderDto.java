package org.training.turkcell.msorder.order.rest.models;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrderDto {
    @NotBlank
    private String name;
    @NotEmpty
    private String surname;
    @Size(min = 10,max = 11,message = "telefon numarası {min} ile {max} olmalı")
    private String phoneNumber;
    @NotNull
    private String address;
    @NotBlank
    private String meal;
    @Positive
    private Integer amount;

}
