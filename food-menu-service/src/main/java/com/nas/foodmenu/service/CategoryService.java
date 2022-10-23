package com.nas.foodmenu.service;

import com.nas.foodmenu.command.CategoryCommand;
import com.nas.foodmenu.model.Category;
import io.eventuate.tram.events.publisher.ResultWithEvents;

public interface CategoryService {
    ResultWithEvents<Category> create(final CategoryCommand categoryCommand);
}
