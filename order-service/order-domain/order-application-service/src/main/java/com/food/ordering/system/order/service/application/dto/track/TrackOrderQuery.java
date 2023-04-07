package com.food.ordering.system.order.service.application.dto.track;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class TrackOrderQuery {
    @NotNull
    private final UUID orderTrackingId;

    public TrackOrderQuery(UUID orderTrackingId) {
        this.orderTrackingId = orderTrackingId;
    }

    public UUID getOrderTrackingId() {
        return orderTrackingId;
    }

    private TrackOrderQuery(Builder builder) {
        orderTrackingId = builder.orderTrackingId;
    }

    public static final class Builder {
        private UUID orderTrackingId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderTrackingId(UUID val) {
            orderTrackingId = val;
            return this;
        }

        public TrackOrderQuery build() {
            return new TrackOrderQuery(this);
        }
    }
}
