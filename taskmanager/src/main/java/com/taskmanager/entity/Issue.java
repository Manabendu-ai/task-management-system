package com.taskmanager.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.taskmanager.enums.IssuePriority;
import com.taskmanager.enums.IssueStatus;
import com.taskmanager.enums.IssueType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "issues") 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Issue {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @Column(nullable=false)
    private String issueTitle;

    @Column(nullable=false, unique=true) 
    private String issueKey;

    @Column(length=2000)
    private String issueDescription;

    @Enumerated(EnumType.STRING)
    private IssueType issueType;

    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Enumerated(EnumType.STRING)
    private IssuePriority issuePriority;

    private String assignedByEmail;

    private String reportToEmail;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt; 

    private LocalDateTime dueDate;

    private Long sprintId;

    private Long epicId;
    
}
