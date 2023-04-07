package com.food.ordering.system.order.service.application;

import com.food.ordering.system.order.service.application.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.application.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.application.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.application.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.service.application.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.application.ports.output.repository.RestaurantRepository;
import com.food.ordering.system.order.service.domain.OrderDomainService;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderDomainService orderDomainService;

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final RestaurantRepository restaurantRepository;

    private final OrderDataMapper orderDataMapper;

    public OrderCreateCommandHandler(OrderDomainService orderDomainService,
                                     OrderRepository orderRepository,
                                     CustomerRepository customerRepository,
                                     RestaurantRepository restaurantRepository,
                                     OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.orderDataMapper = orderDataMapper;
    }

    //TODO setup fire events triggers

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand){
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        Order orderResult = saveOrder(order);
        log.info("Order is created with id: {}", orderResult.getId());
        return orderDataMapper.orderToCreateOrderResponse(order);
    }

    private void checkCustomer(UUID cusetomerId){
        Optional<Customer> customer = customerRepository.findCustomer(cusetomerId);
        if (customer.isEmpty()){
            log.warn("Could not find customer with id {}", cusetomerId);
            throw new OrderDomainException("\"Could not find customer with id: " + cusetomerId);
        }
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand){
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if(optionalRestaurant.isEmpty()){
            log.warn("Could not find restaurant with id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with id: " + createOrderCommand.getRestaurantId());
        }
        return optionalRestaurant.get();
    }

    private Order saveOrder(Order order){
        Order orderResult = orderRepository.save(order);
        if(orderResult == null){
            log.error("Could not find restaurant with id: {}", orderResult.getId());
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId());
        return orderResult;
    }

}