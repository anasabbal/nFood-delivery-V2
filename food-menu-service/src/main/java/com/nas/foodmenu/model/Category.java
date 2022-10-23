package com.nas.foodmenu.model;

import com.nas.core.BaseEntity;
import com.nas.fooditem.model.FoodItem;
import com.nas.foodmenu.command.CategoryCommand;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "CATEGORIES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Column(name = "CATEGORY_NAME")
    private String name;

    @OneToMany
    private Set<FoodItem> foodItems;

    public static Category createCategory(final CategoryCommand command){
        final Category category = new Category();

        category.name = command.getCategoryName();
        return category;
    }

    public static ResultWithEvents<Category> create(final CategoryCommand command){
        return new ResultWithEvents<>(Category.createCategory(command), new CategoryCreated());
    }
}
