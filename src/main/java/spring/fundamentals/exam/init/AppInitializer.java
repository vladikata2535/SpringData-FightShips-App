package spring.fundamentals.exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.fundamentals.exam.repository.CategoryRepository;
import spring.fundamentals.exam.service.CategoryService;
import spring.fundamentals.exam.service.ShipService;

@Component
public class AppInitializer implements CommandLineRunner {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public AppInitializer(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count() == 0){
            categoryService.initializeCategories();
        }
    }
}
