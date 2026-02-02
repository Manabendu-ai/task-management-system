package com.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskmanager.entity.WorkFlow;
import com.taskmanager.entity.WorkFlowTransaction;
import com.taskmanager.repository.WorkFlowRepo;
import com.taskmanager.repository.WorkFlowTransactionRepo;

@Service
public class WorkFlowService {
    
    @Autowired
    private WorkFlowRepo workFlowRepo;

    @Autowired
    private WorkFlowTransactionRepo workFlowTransactionRepo;

    @Transactional
    public WorkFlow createWorkFlow(WorkFlow workFlow){

        if (workFlow.getWorkFlowTransaction() != null) {
            workFlow.getWorkFlowTransaction()
                .forEach(tx -> tx.setWorkFlow(workFlow));
        }

        return workFlowRepo.save(workFlow);
    }

    @Transactional
    public WorkFlow updateWorkFlow(Long workFlowId, WorkFlow updatedWorkFlow){

        WorkFlow workFlow = workFlowRepo.findById(workFlowId)
            .orElseThrow(() -> new RuntimeException("WorkFlow not found"));

        
        workFlow.setWorkFlowName(updatedWorkFlow.getWorkFlowName()); 

        workFlow.setWorkFlowDescription(updatedWorkFlow.getWorkFlowDescription()); 

        workFlow.setCreatedAt(updatedWorkFlow.getCreatedAt()); 

        if (updatedWorkFlow.getWorkFlowTransaction() != null) {
            
            for(WorkFlowTransaction wtf: updatedWorkFlow.getWorkFlowTransaction()){
                wtf.setWorkFlow(workFlow);
                workFlow.getWorkFlowTransaction().add(wtf);
            }

        }

        return workFlowRepo.save(workFlow);


    }

}
