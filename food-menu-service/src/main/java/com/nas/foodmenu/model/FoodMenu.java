package com.nas.foodmenu.model;

import com.nas.core.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "FOOD_MENU")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodMenu extends BaseEntity {


    @Column(name = "MENU_NAME")
    private String menuName;

    @OneToMany
    private Set<Category> categories;


}
