package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;
    private String customerId;
    private String productId;
    private String qty;
    private String status;
}
