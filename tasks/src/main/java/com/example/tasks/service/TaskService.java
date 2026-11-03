package com.example.tasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tasks.exception.ResourceNotFoundException;
import com.example.tasks.model.Task;
import com.example.tasks.repository.TaskRepository;

@Service 
public class TaskService {

    private final TaskRepository taskRepo;


    public TaskService (TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    public List<Task> ListTask(){
        return taskRepo.findAll();
    }

    public Task FindTask(Long id){
        return taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task Not Found"));
    }

    public Task CreateTask(Task task){
        return taskRepo.save(task);
    }

    public void DeleteTask(Long id){
        taskRepo.deleteById(id);
    }

    public Task UpdateTask(Long id, Task task){
        
        Task taskone = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task Not Found!"));

        taskone.setTitle(task.getTitle());
        taskone.setDescription(task.getDescription());
        taskone.setStatus(task.getStatus());

        return taskRepo.save(taskone);
    }


    
}
