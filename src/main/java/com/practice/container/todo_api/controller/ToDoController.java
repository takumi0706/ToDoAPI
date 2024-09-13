package com.practice.container.todo_api.controller;

import com.practice.container.todo_api.entity.ToDo;
import com.practice.container.todo_api.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable int id) {
        return toDoService.getToDoById(id);
    }

    @PostMapping
    public void createToDo(@RequestBody ToDo todo) {
        toDoService.createToDo(todo);
    }

    @PutMapping("/{id}")
    public void updateToDoById(@PathVariable int id, @RequestBody ToDo todo) {
        todo.setId(id);
        toDoService.updateToDoById(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable int id) {
        toDoService.deleteToDoById(id);
    }
}
