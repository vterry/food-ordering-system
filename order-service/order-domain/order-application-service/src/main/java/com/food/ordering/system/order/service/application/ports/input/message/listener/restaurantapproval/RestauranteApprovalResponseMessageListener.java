package com.food.ordering.system.order.service.application.ports.input.message.listener.restaurantapproval;

import com.food.ordering.system.order.service.application.dto.message.RestaurantApprovalResponse;

public interface RestauranteApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);

}
