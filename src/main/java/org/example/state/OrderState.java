package org.example.state;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.model.Order;
import org.example.state.impl.NewOrderState;
import org.example.state.impl.ProcessingOrderState;
import org.example.state.impl.ShippedOrderState;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewOrderState.class, name = "New"),
        @JsonSubTypes.Type(value = ProcessingOrderState.class, name = "Processing"),
        @JsonSubTypes.Type(value = ShippedOrderState.class, name = "Shipped")
})
public interface OrderState {
    void next(Order order);
    void prev(Order order);
    String getStatus();
}