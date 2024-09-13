package com.practice.container.todo_api.controller;

import com.practice.container.todo_api.entity.ToDo;
import com.practice.container.todo_api.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = toDoService.getAllToDos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable int id) {
        ToDo todo = toDoService.getToDoById(id);
        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo) {
        toDoService.createToDo(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDoById(@PathVariable int id, @RequestBody ToDo todoDetails) {
        ToDo existingToDo = toDoService.getToDoById(id);
        if(existingToDo != null) {
            todoDetails.setId(id);
            toDoService.updateToDoById(todoDetails);
            return new ResponseEntity<>(todoDetails, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable int id) {
        ToDo existingToDo = toDoService.getToDoById(id);
        if (existingToDo != null){
            toDoService.deleteToDoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
