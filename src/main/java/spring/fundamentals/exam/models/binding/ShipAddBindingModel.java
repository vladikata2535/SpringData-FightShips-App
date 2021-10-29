package spring.fundamentals.exam.models.binding;

import org.springframework.format.annotation.DateTimeFormat;
import spring.fundamentals.exam.models.entity.CategoryEntity;
import spring.fundamentals.exam.models.entity.enums.CategoryEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryEnum category;

    public ShipAddBindingModel() {
    }

    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    public Integer getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    @Positive
    public Integer getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull
    public CategoryEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
