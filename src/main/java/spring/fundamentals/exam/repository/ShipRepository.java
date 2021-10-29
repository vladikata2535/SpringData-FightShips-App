package spring.fundamentals.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.fundamentals.exam.models.entity.ShipEntity;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {
    @Query("SELECT s FROM ShipEntity s ORDER BY s.id, s.health, s.power")
    List<ShipEntity> findAllOrderedByIdAndStatus();

    List<ShipEntity> findByUser_Id(Long userId);

}
