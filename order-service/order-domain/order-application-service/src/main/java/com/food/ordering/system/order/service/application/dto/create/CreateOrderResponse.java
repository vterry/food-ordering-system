package com.food.ordering.system.order.service.application.dto.create;

import com.food.ordering.system.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateOrderResponse {

    @NotNull
    private final UUID orderTrackingId;
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;

    public CreateOrderResponse(UUID orderTrackingId, OrderStatus orderStatus, String message) {
        this.orderTrackingId = orderTrackingId;
        this.orderStatus = orderStatus;
        this.message = message;
    }

    public UUID getOrderTrackingId() {
        return orderTrackingId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getMessage() {
        return message;
    }

    private CreateOrderResponse(Builder builder) {
        orderTrackingId = builder.orderTrackingId;
        orderStatus = builder.orderStatus;
        message = builder.message;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID orderTrackingId;
        private OrderStatus orderStatus;
        private String message;

        private Builder() {
        }

        public Builder orderTrackingId(UUID val) {
            orderTrackingId = val;
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public CreateOrderResponse build() {
            return new CreateOrderResponse(this);
        }
    }
}
