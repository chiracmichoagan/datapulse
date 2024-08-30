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
import org.springframework.web.bind.annotation.RestController;

import bj.higfiveuniversity.datapulse.model.User;
import bj.higfiveuniversity.datapulse.repository.OrderRepository;
import bj.higfiveuniversity.datapulse.repository.UserRepository;
import bj.higfiveuniversity.datapulse.services.OrderService;


import org.springframework.web.bind.annotation.RestController;

import bj.higfiveuniversity.datapulse.model.Product;
import bj.higfiveuniversity.datapulse.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/order")
public class Order {
    
     @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();

    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrderById(id);

        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createdOrder(@RequestBody Order order){

        Order newOrder = orderService.createdOrder(order);

        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updatedOder(@PathVariable Long id, @RequestBody Order order){
        Order orderToUpdate = orderService.updatedOder(id,order);

        return ResponseEntity.ok(orderToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOder(@PathVariable Long id){

        orderService.deleteOder(id);
        return ResponseEntity.noContent().build();

    }
  
}
