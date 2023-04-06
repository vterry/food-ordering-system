package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;


/**
 *  STUDY NOTES: In this approach, the Domain Service doesnt need to know how to Fire Events. This will be
 *  delegate to the Application Service.
 *
 *  To put Firing Events logic in Domain Services, we will need to implement business logic
 *  as well, since our Domain Services must be able to handle the results of Fired Events.
 * */

public interface OrderDomainInterface {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);

}
