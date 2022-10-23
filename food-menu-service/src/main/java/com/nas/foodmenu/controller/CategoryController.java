package com.nas.foodmenu.controller;


import com.nas.foodmenu.command.CategoryCommand;
import com.nas.foodmenu.dto.CategoryDTO;
import com.nas.foodmenu.dto.mapper.CategoryMapper;
import com.nas.foodmenu.model.Category;
import com.nas.foodmenu.service.CategoryService;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.nas.core.ResourcePaths.CATEGORIES;
import static com.nas.core.ResourcePaths.V2;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(V2 + CATEGORIES)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;



    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody final CategoryCommand categoryCommand){
        final ResultWithEvents<Category> categoryResultWithEvents = categoryService.create(categoryCommand);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(categoryResultWithEvents.result.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryMapper.toDto(categoryResultWithEvents.result));
    }
}
