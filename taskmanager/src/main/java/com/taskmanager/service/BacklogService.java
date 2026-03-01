package com.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.entity.Issue;
import com.taskmanager.repository.IssueRepo;
import com.taskmanager.repository.SprintRepo;

@Service
public class BacklogService {

    @Autowired
    private SprintRepo sprintRepo;

    @Autowired
    private IssueRepo issueRepo;

    public List<Issue> getBacklog(Long projectId){
        return issueRepo.findByProjectIdAndSprintIdIsNullOrderByBacklogPosition(projectId);

    }

}
