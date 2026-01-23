package com.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.taskmanager.dto.StoredFileDto;
import com.taskmanager.entity.Attachment;
import com.taskmanager.repository.AttachmentRepo;
import com.taskmanager.storage.StorageService;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepo attachmentRepo;

    @Autowired
    private StorageService storageService;

    @Transactional
    public Attachment upload(Long issueId, MultipartFile file, String uploadedBy){

        StoredFileDto storedFileDto = storageService.store(file, "issues/"+issueId);

        Attachment attachment = new Attachment();

        attachment.setIssueId(issueId);
        attachment.setFileName(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setFileSize(file.getSize());

        attachment.setStoragePath(storedFileDto.getLocalPath());
        attachment.setCloudUrl(storedFileDto.getCloudUrl());
        attachment.setCloudPublicId(storedFileDto.getPublicId());

        attachment.setUploadedBy(uploadedBy);

        return attachmentRepo.save(attachment);

    }

}
