package org.training.turkcell.msorder.order.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/change")
public class OrderChangeRestController {

    @PostMapping("/delivery/address")
    public String changeDeliveryAddress(){
        return "OK";
    }


}
