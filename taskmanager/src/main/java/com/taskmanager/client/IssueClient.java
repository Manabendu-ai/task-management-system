package com.taskmanager.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskmanager.enums.IssueStatus;

@FeignClient(name="issue-service",url="${issue_service.url}") 
public interface IssueClient {
    
    @PutMapping("/{id}/status")
	void updateStatus(
        @PathVariable Long id,
        @RequestParam IssueStatus status,
        @RequestParam String performedBy
    );
	
	@PostMapping("/{id}/commit")
	void addCommit(
        @PathVariable Long id,
        @RequestParam String author,
        @RequestParam String body
    );

}
