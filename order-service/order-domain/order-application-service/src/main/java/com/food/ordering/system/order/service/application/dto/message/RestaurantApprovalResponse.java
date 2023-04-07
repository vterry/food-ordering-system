package com.food.ordering.system.order.service.application.dto.message;

import com.food.ordering.system.domain.valueobject.OrderApprovalStatus;

import java.time.Instant;
import java.util.List;

public class RestaurantApprovalResponse {
    private String id;
    private String sagaId;
    private String orderId;
    private String restaurantId;
    private Instant createdAt;
    private OrderApprovalStatus orderApprovalStatus;
    private List<String> failureMessages;

    public RestaurantApprovalResponse(String id, String sagaId, String orderId, String restaurantId, Instant createdAt, OrderApprovalStatus orderApprovalStatus, List<String> failureMessages) {
        this.id = id;
        this.sagaId = sagaId;
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.createdAt = createdAt;
        this.orderApprovalStatus = orderApprovalStatus;
        this.failureMessages = failureMessages;
    }

    private RestaurantApprovalResponse(Builder builder) {
        id = builder.id;
        sagaId = builder.sagaId;
        orderId = builder.orderId;
        restaurantId = builder.restaurantId;
        createdAt = builder.createdAt;
        orderApprovalStatus = builder.orderApprovalStatus;
        failureMessages = builder.failureMessages;
    }

    public String getId() {
        return id;
    }

    public String getSagaId() {
        return sagaId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public OrderApprovalStatus getOrderApprovalStatus() {
        return orderApprovalStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }


    public static final class Builder {
        private String id;
        private String sagaId;
        private String orderId;
        private String restaurantId;
        private Instant createdAt;
        private OrderApprovalStatus orderApprovalStatus;
        private List<String> failureMessages;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder sagaId(String val) {
            sagaId = val;
            return this;
        }

        public Builder orderId(String val) {
            orderId = val;
            return this;
        }

        public Builder restaurantId(String val) {
            restaurantId = val;
            return this;
        }

        public Builder createdAt(Instant val) {
            createdAt = val;
            return this;
        }

        public Builder orderApprovalStatus(OrderApprovalStatus val) {
            orderApprovalStatus = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public RestaurantApprovalResponse build() {
            return new RestaurantApprovalResponse(this);
        }
    }
}
