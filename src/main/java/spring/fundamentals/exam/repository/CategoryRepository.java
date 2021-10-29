package spring.fundamentals.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.exam.models.entity.CategoryEntity;
import spring.fundamentals.exam.models.entity.enums.CategoryEnum;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
   Optional<CategoryEntity> findByName(CategoryEnum name);
}
