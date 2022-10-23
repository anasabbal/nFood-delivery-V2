package com.nas.foodmenu.service;


import com.nas.foodmenu.command.CategoryCommand;
import com.nas.foodmenu.model.Category;
import com.nas.foodmenu.repository.CategoryRepository;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public ResultWithEvents<Category> create(CategoryCommand categoryCommand) {
        final ResultWithEvents<Category> categoryResultWithEvents = Category.create(categoryCommand);
        categoryRepository.save(categoryResultWithEvents.result);

        domainEventPublisher.publish(
                Category.class,
                categoryResultWithEvents.result.getId(),
                categoryResultWithEvents.events
        );
        return categoryResultWithEvents;
    }
}
