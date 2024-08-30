package bj.higfiveuniversity.datapulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.higfiveuniversity.datapulse.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>   {
    
}
