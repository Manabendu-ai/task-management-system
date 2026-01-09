package com.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.entity.Issue;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long> { 
    
    Issue findByIssueKey(String issueKey);

    List<Issue> findByAssignedByEmail(String assignedByEmail);

    List<Issue> findBySpringId(String sprintId);

    List<Issue> findByIssueStatus(String issueStatus);

}
