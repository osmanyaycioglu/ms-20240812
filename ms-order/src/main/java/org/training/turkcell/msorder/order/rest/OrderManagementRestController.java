package org.training.turkcell.msorder.order.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.training.turkcell.msorder.order.rest.mappings.IOrderMapper;
import org.training.turkcell.msorder.order.rest.models.OrderDto;
import org.training.turkcell.msorder.service.OrderManagementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class OrderManagementRestController implements IOrderManagementRestController{
    private final OrderManagementService orderManagementService;

    public String placeOrder(@RequestBody @Valid OrderDto orderDtoParam) {
        return orderManagementService.place(IOrderMapper.MAPPER.toOrder(orderDtoParam));
    }

    @Override
    public String placeOrder2(final OrderDto orderDtoParam) {
        return orderManagementService.place2(IOrderMapper.MAPPER.toOrder(orderDtoParam));
    }

    @Override
    public String placeOrder3(final OrderDto orderDtoParam) {
        return orderManagementService.place3(IOrderMapper.MAPPER.toOrder(orderDtoParam));
    }

    public String cancelOrder(@RequestParam String orderId) {
        return "OK";
    }


}
