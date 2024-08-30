package bj.higfiveuniversity.datapulse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bj.higfiveuniversity.datapulse.model.Order;
import bj.higfiveuniversity.datapulse.model.OrderItem;

import org.springframework.web.bind.annotation.RestController;

import bj.higfiveuniversity.datapulse.model.Product;
import bj.higfiveuniversity.datapulse.repository.ProductRepository;
import bj.higfiveuniversity.datapulse.services.OrderItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/order_Item")
public class OrderItemController {
    
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItem() {
        return orderItemService.getAllOrderItem();

    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id){
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItem);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createdOrderItem(@RequestBody OrderItem orderItem){
        OrderItem newOrderItem = orderItemService.createdOrderItem(orderItem);

        return ResponseEntity.ok(newOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updatedOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem){
        OrderItem OrderItemToUpdate = orderItemService.updatedOrderItem(id,orderItem);

        return ResponseEntity.ok(OrderItemToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id){

        orderItemService.deleteOrderItem(id);
        
        return ResponseEntity.noContent().build();

    }
  
}
