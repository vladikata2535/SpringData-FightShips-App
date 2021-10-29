package spring.fundamentals.exam.service;

import spring.fundamentals.exam.models.entity.CategoryEntity;
import spring.fundamentals.exam.models.entity.enums.CategoryEnum;

public interface CategoryService {
    void initializeCategories();

    CategoryEntity findCategoryByName(CategoryEnum categoryEnum);
}
