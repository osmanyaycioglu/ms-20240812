package org.training.turkcell.msorder.order.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.turkcell.msorder.order.rest.models.OrderDto;

@RequestMapping("/api/v1/order/management")
public interface IOrderManagementRestController {

    @PostMapping("/place")
    @Operation(description = "Order verme yeri",summary = "order deneme")
    public String placeOrder(@RequestBody @Valid OrderDto orderDtoParam) ;

    @PostMapping("/place2")
    @Operation(description = "Order verme yeri",summary = "order deneme")
    public String placeOrder2(@RequestBody @Valid OrderDto orderDtoParam) ;

    @PostMapping("/place3")
    @Operation(description = "Order verme yeri",summary = "order deneme")
    public String placeOrder3(@RequestBody @Valid OrderDto orderDtoParam) ;


    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam String orderId) ;

}
