package org.training.turkcell.msorder.order.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.turkcell.msorder.order.rest.models.Response;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/insert")
    public Response<String> insertOrder(){
        return null;
    }

    @PostMapping("/update")
    public Response<String> updateOrder(){
        return null;
    }

    @PostMapping("/delete")
    public Response<String> deleteOrder(){
        return null;
    }

}
