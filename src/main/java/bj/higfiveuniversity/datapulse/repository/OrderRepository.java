package bj.higfiveuniversity.datapulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.higfiveuniversity.datapulse.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
