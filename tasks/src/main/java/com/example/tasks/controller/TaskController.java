package com.example.tasks.controller;

import com.example.tasks.model.Task;
import com.example.tasks.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class TaskController {
    
    public final TaskService taskServ;

    public TaskController(TaskService taskServ){
        this.taskServ = taskServ;
    }

    @GetMapping("/task")
    public List<Task> getList() {
        return taskServ.ListTask();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskServ.FindTask(id);
    }
    
    @PostMapping("/task")
    public Task postTask(@Valid @RequestBody Task task) {
        //TODO: process POST request
        
        return taskServ.CreateTask(task);
    }

    @PutMapping("task/{id}")
    public Task putTask(@Valid @PathVariable Long id, @RequestBody Task task) {
        //TODO: process PUT request
        
        return taskServ.UpdateTask(id, task);
    }

    @DeleteMapping("task/{id}")
    public void deleteTask(@PathVariable Long id){
        taskServ.DeleteTask(id);
    }

}
