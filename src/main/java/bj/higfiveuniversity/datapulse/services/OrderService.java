package bj.higfiveuniversity.datapulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.higfiveuniversity.datapulse.controller.Order;
import bj.higfiveuniversity.datapulse.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    public Order getOrderById(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order non trouvé"));

        return order;
    }

    public Order createdOrder(Order order) {
        Order newOrder = orderRepository.save(order);

        return newOrder;
    }

    public Order updatedOder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User avec l'id " + id + "non trouvé"));

        orderToUpdate.setOrderItem(order.getOrderItem());
        orderToUpdate.setStatus(order.getStatus());
        orderToUpdate.setTotalAmont(order.getTotalAmont());

        return orderToUpdate;
    }

    public void deleteOder(Long id) {

        orderRepository.deleteById(id);

    }

}
