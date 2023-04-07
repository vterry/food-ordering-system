package com.food.ordering.system.order.service.application.dto.create;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class OrderAddress {
    @NotNull
    @Max(value= 50)
    private final String street;
    @NotNull
    @Max(value = 10)
    private final String postalCode;
    @NotNull
    @Max(value = 25)
    private final String city;

    public OrderAddress(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    private OrderAddress(Builder builder) {
        street = builder.street;
        postalCode = builder.postalCode;
        city = builder.city;
    }
    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String street;
        private String postalCode;
        private String city;

        private Builder() {
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public OrderAddress build() {
            return new OrderAddress(this);
        }
    }
}
