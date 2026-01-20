package com.taskmanager.dto;

import java.time.LocalDateTime;

import com.taskmanager.enums.IssuePriority;
import com.taskmanager.enums.IssueStatus;
import com.taskmanager.enums.IssueType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueDto {

    public Long issueId;

    public String issueTitle;

    public String issueKey;

    public String issueDescription;

    public IssueType issueType;

    public IssueStatus issueStatus;

    public IssuePriority issuePriority;

    public String assignedByEmail;

    public String reportToEmail;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt; 

    public LocalDateTime dueDate;

    public Long sprintId;

    public Long epicId;
    
}
