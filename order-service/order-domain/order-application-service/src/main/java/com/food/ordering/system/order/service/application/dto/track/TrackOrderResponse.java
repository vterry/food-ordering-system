package com.food.ordering.system.order.service.application.dto.track;

import com.food.ordering.system.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class TrackOrderResponse {
    @NotNull
    private final UUID orderTrackingId;
    @NotNull
    private final OrderStatus orderStatus;

    private final List<String> failureMessages;

    public TrackOrderResponse(UUID orderTrackingId, OrderStatus orderStatus, List<String> failureMessages) {
        this.orderTrackingId = orderTrackingId;
        this.orderStatus = orderStatus;
        this.failureMessages = failureMessages;
    }

    public UUID getOrderTrackingId() {
        return orderTrackingId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
    public static Builder builder() {
        return new Builder();
    }

    private TrackOrderResponse(Builder builder) {
        orderTrackingId = builder.orderTrackingId;
        orderStatus = builder.orderStatus;
        failureMessages = builder.failureMessages;
    }

    public static final class Builder {
        private UUID orderTrackingId;
        private OrderStatus orderStatus;
        private List<String> failureMessages;

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

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public TrackOrderResponse build() {
            return new TrackOrderResponse(this);
        }
    }
}
