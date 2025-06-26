package com.project.smarttaskpro.repository;

import com.project.smarttaskpro.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
