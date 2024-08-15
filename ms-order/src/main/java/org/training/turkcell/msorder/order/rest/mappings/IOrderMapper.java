package org.training.turkcell.msorder.order.rest.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.training.turkcell.msorder.order.rest.models.OrderDto;
import org.training.turkcell.msorder.service.models.Order;

@Mapper()
public interface IOrderMapper {
    IOrderMapper MAPPER = Mappers.getMapper(IOrderMapper.class);

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto order);

}
