package com.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.entity.Sprint;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Long> {
    
}
