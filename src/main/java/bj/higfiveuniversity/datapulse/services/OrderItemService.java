package bj.higfiveuniversity.datapulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import bj.higfiveuniversity.datapulse.model.Order;
import bj.higfiveuniversity.datapulse.model.OrderItem;
import bj.higfiveuniversity.datapulse.repository.OrderItemRepositosy;

@Service
public class OrderItemService {
     @Autowired
    private OrderItemRepositosy orderItemRepository;

     public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.findAll();

    }

    public OrderItem getOrderItemById(Long id){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(()-> new RuntimeException("Order non trouvé"));

        return orderItem;
    }

     public OrderItem createdOrderItem(OrderItem OrderItem){
        OrderItem newOrder = orderItemRepository.save(OrderItem);
        return newOrder;
    }

     public OrderItem updatedOrderItem(Long id,OrderItem orderItem){
        OrderItem OrderItemToUpdate = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Order avec l'id " + id + "non trouvé"));

        OrderItemToUpdate.setOrder(orderItem.getOrder());
        OrderItemToUpdate.setPrice(orderItem.getPrice());
        OrderItemToUpdate.setProduct(orderItem.getProduct());
        OrderItemToUpdate.setQuantity(orderItem.getQuantity());

        return OrderItemToUpdate;
    }

    public void deleteOrderItem(Long id){

        orderItemRepository.deleteById(id);
    }
    
}
