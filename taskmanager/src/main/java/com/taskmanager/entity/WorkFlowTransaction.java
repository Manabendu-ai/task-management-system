package com.taskmanager.entity;

import com.taskmanager.enums.IssueStatus;
import com.taskmanager.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workflow_transactions", indexes = {
    @Index(name="idx_workflows_from_to_issue_status", columnList = "workflow_id, fromIssueStatus, toIssueStatus")
}) 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkFlowTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workFlowTransactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", nullable = false)
    private WorkFlow workFlow;

    private IssueStatus fromIssueStatus;

    private IssueStatus toIssueStatus;

    private String workFlowName;

    private Role allowedRole;

}
