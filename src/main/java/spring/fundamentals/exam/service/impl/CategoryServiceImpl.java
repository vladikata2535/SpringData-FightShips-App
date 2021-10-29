package spring.fundamentals.exam.service.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.exam.models.entity.CategoryEntity;
import spring.fundamentals.exam.models.entity.enums.CategoryEnum;
import spring.fundamentals.exam.repository.CategoryRepository;
import spring.fundamentals.exam.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryEnum);
                    category.setDescription(String.format("Description about %s", categoryEnum.name()));

                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findCategoryByName(CategoryEnum categoryEnum) {
        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
