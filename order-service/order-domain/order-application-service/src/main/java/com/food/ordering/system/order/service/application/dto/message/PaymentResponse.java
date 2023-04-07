package com.food.ordering.system.order.service.application.dto.message;

import com.food.ordering.system.domain.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class PaymentResponse {
    private String id;
    private String sagaId;
    private String orderId;
    private String paymentId;
    private String customerId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentStatus paymentStatus;
    private List<String> failureMessage;

    public PaymentResponse(String id, String sagaId, String orderId, String paymentId, String customerId, BigDecimal price, Instant createdAt, PaymentStatus paymentStatus, List<String> failureMessage) {
        this.id = id;
        this.sagaId = sagaId;
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.price = price;
        this.createdAt = createdAt;
        this.paymentStatus = paymentStatus;
        this.failureMessage = failureMessage;
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

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public List<String> getFailureMessage() {
        return failureMessage;
    }

    private PaymentResponse(Builder builder) {
        id = builder.id;
        sagaId = builder.sagaId;
        orderId = builder.orderId;
        paymentId = builder.paymentId;
        customerId = builder.customerId;
        price = builder.price;
        createdAt = builder.createdAt;
        paymentStatus = builder.paymentStatus;
        failureMessage = builder.failureMessage;
    }
    public static final class Builder {
        private String id;
        private String sagaId;
        private String orderId;
        private String paymentId;
        private String customerId;
        private BigDecimal price;
        private Instant createdAt;
        private PaymentStatus paymentStatus;
        private List<String> failureMessage;

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

        public Builder paymentId(String val) {
            paymentId = val;
            return this;
        }

        public Builder customerId(String val) {
            customerId = val;
            return this;
        }

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder createdAt(Instant val) {
            createdAt = val;
            return this;
        }

        public Builder paymentStatus(PaymentStatus val) {
            paymentStatus = val;
            return this;
        }

        public Builder failureMessage(List<String> val) {
            failureMessage = val;
            return this;
        }

        public PaymentResponse build() {
            return new PaymentResponse(this);
        }
    }
}
