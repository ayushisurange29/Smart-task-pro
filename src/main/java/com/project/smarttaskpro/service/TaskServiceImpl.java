package com.project.smarttaskpro.service;

import com.project.smarttaskpro.model.Task;
import com.project.smarttaskpro.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);

    }




    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id:" +id));

    }

    @Override
    public Task updateTask(Long id,Task taskDetails){
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());

        task.setDescription(taskDetails.getDescription());

        task.setCompleted(taskDetails.isCompleted());

        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id){
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }


}
