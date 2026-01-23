package com.taskmanager.entity;

import jakarta.persistence.Entity;
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
@Table(name = "attachments") 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Attachment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    private Long issueId;

    private String fileName;

    private Long fileSize;

    private String contentType;

    private String storagePath;

    private Long cloudId;

    private String uploadedBy;

    private String cloudUrl;    
    
    private String cloudPublicId;   

}
