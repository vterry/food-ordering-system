package com.food.ordering.system.order.service.application;

import com.food.ordering.system.order.service.application.dto.message.RestaurantApprovalResponse;
import com.food.ordering.system.order.service.application.ports.input.message.listener.restaurantapproval.RestauranteApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestauranteApprovalResponseMessageListener {
    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
