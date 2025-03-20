package shop.infra;

import shop.domain.*;
import shop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyViewViewHandler {

//<<< DDD / CQRS
    @Autowired
    private MyViewRepository myViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyView myView = new MyView();
            // view 객체에 이벤트의 Value 를 set 함
            myView.setId(orderPlaced.getId());
            myView.setCustomerId(orderPlaced.getCustomerId());
            myView.setProoductId(orderPlaced.getProductId());
            myView.setPrice(orderPlaced.getPrice());
            myView.setQty(orderPlaced.getQty());
            myView.setAddress(orderPlaced.getAddress());
            myView.setOrderStatus(ordered);
            // view 레파지 토리에 save
            myViewRepository.save(myView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회
            Optional<MyView> myViewOptional = myViewRepository.findById(Long.valueOf(deliveryStarted.getOrderId()));

            if( myViewOptional.isPresent()) {
                 MyView myView = myViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myView.setDeliveryStatus(delivery started);    
                // view 레파지 토리에 save
                 myViewRepository.save(myView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_2(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회
            Optional<MyView> myViewOptional = myViewRepository.findById(Long.valueOf(deliveryCanceled.getOrderId()));

            if( myViewOptional.isPresent()) {
                 MyView myView = myViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myView.setDeliveryStatus(delivery canceled);    
                // view 레파지 토리에 save
                 myViewRepository.save(myView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

