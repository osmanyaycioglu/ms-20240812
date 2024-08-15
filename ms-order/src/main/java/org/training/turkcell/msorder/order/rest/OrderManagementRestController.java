package org.training.turkcell.msorder.order.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.training.turkcell.msorder.order.rest.mappings.IOrderMapper;
import org.training.turkcell.msorder.order.rest.models.OrderDto;
import org.training.turkcell.msorder.service.OrderManagementService;

@RestController
@RequestMapping("/api/v1/order/management")
@RequiredArgsConstructor
public class OrderManagementRestController {
    private final OrderManagementService orderManagementService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody @Valid OrderDto orderDtoParam) {
        orderManagementService.place(IOrderMapper.MAPPER.toOrder(orderDtoParam));
        return "OK";
    }

    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam String orderId) {
        return "OK";
    }


}
