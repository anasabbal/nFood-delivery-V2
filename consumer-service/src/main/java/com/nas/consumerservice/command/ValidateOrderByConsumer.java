package com.nas.consumerservice.command;


import io.eventuate.tram.commands.common.Command;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ValidateOrderByConsumer implements Command {

    private String consumerId;
    private String orderId;
    private Object orderTotal;

    public ValidateOrderByConsumer() {
    }

    public ValidateOrderByConsumer(String consumerId, String orderId, Object orderTotal) {
        this.consumerId = consumerId;
        this.orderId = orderId;
        this.orderTotal = orderTotal;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Object getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Object orderTotal) {
        this.orderTotal = orderTotal;
    }
}
