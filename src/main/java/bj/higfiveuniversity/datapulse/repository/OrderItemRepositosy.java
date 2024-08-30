package bj.higfiveuniversity.datapulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.higfiveuniversity.datapulse.model.OrderItem;

@Repository
public interface OrderItemRepositosy extends JpaRepository<OrderItem, Long> {
    
}
