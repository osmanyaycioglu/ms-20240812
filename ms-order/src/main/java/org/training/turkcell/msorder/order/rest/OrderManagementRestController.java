package org.training.turkcell.msorder.order.rest;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.training.turkcell.msorder.order.rest.models.OrderDto;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementRestController {

    @PostMapping("/place")
    public String placeOrder(@RequestBody @Valid OrderDto orderDtoParam){
        return "OK";
    }

    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam String orderId){
        return "OK";
    }



}
